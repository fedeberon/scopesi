/**
 * Created by federicoberon on 30/11/2019.
 */
'use strict';

var singleUploadForm = document.querySelector('#singleUploadForm') || document.querySelector('#singleUploadFormMap') ;
var singleFileUploadInput = document.querySelector('#singleFileUploadInput') || document.querySelector('#singleFileUploadInputMap');
var singleFileUploadError = document.querySelector('#singleFileUploadError') ||  document.querySelector('#singleFileUploadErrorMap');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess') || document.querySelector('#singleFileUploadSuccessMap');

var multipleUploadForm = document.querySelector('#multipleUploadForm') || document.querySelector('#multipleUploadFormMap');
var multipleFileUploadInput = document.querySelector('#multipleFileUploadInput') || document.querySelector('#multipleFileUploadInputMap');
var multipleFileUploadError = document.querySelector('#multipleFileUploadError') || document.querySelector('#multipleFileUploadErrorMap');
var multipleFileUploadSuccess = document.querySelector('#multipleFileUploadSuccess') || document.querySelector('#multipleFileUploadSuccessMap');

function uploadSingleFile(file){

    var url = 'http://geoplanningmas.com/ar/v2/apifiles/file';
    var idEmpresa = document.querySelector("#idEmpresa").value;
    var idUbicacion = document.querySelector("#idUbicacion").value;
    var extension = file.name.split('.').pop();
    var fileName;
    var pathsArray = getAllFilesPathOfEmpresa(url , idEmpresa);

    if(pathsArray.length !== 0){
        pathsArray = filterFilesPath(pathsArray, idUbicacion);

        if(pathsArray.length !== 0){
            var fileNameArray = getFileNames(pathsArray);
            var numbersDuplicateArray = resolveFileName(fileNameArray);

            var number = numbersDuplicateArray.reduce(function (accumulator, current) {
                return accumulator > parseInt(current) ? accumulator : parseInt(current);
            }, 0);

            if(number === 0){
                fileName = idUbicacion + "(1)." + extension;
            }else{
                fileName = idUbicacion + '(' + (number + 1) + ').' + extension;
            }
        }else{
            fileName = idUbicacion + '.' + extension;
        }

    }else{
        fileName = idUbicacion + '.' + extension;
    }

    var formData = new FormData();
    formData.append("archivo", file , fileName);

    var xhr = new XMLHttpRequest();

    xhr.open("POST", url + '/' + idEmpresa + '/' + fileName);

    xhr.onload = function() {
        console.log(xhr.responseText);

        if(xhr.status === 200 || xhr.status === 201 ) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p><i class='far fa-check-circle' style='color:green'></i> Archivo subido exitosamente.</p>";
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = "<p><i class='far fa-times-circle' style='color:darkred'></i> Hubo un error.</p>";
        }
    };

    xhr.send(formData);
}

function resolveFileName(fileNameArray){
    /* The group on this regex matches the number found between two parentheses in case the file name already exists*/
    var regexGetDuplicateNumber = /[1-9]+[\s]{0,2}[(]{0,1}(\w*)[)]{0,1}/;

    /* Return number found if exists else return zero*/
    return fileNameArray.map(function (name) {
        return name.match(regexGetDuplicateNumber)[1] ? name.match(regexGetDuplicateNumber)[1] : 0;
    });
}

function uploadMultipleFiles(files) {
    var formData = new FormData();
    for(var index = 0; index < files.length; index++) {
        formData.append("files", files[index]);
    }

    formData.append("idEmpresa", document.querySelector("#idEmpresa").value);
    formData.append("idUbicacion", document.querySelector("#idUbicacion").value);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../uploadMultipleFiles");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status === 200) {
            multipleFileUploadError.style.display = "none";
            var content = "<p><i class='far fa-check-circle' style='color:green'></i> Todos los archivos subidos exitosamente.</p>";
            for(var i = 0; i < response.length; i++) {
                content += "<p>" + response[i].fileName + " se subio con exito!!</p>";
            }
            multipleFileUploadSuccess.innerHTML = content;
            multipleFileUploadSuccess.style.display = "block";
        } else {
            multipleFileUploadSuccess.style.display = "none";
            multipleFileUploadError.innerHTML = "<p><i class='far fa-times-circle' style='color:darkred'></i> Hubo un error.</p>";
        }
    };

    xhr.send(formData);
}

function clearResponseLabel(){
    singleFileUploadSuccess.style.display = "none";
    singleFileUploadError.style.display = "none";
}

singleUploadForm.addEventListener('submit', function(event){
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Por favor seleccione un archivo";
        singleFileUploadError.style.display = "block";
    }
    uploadSingleFile(files[0]);
    event.preventDefault();
}, true);


multipleUploadForm.addEventListener('submit', function(event){
    var files = multipleFileUploadInput.files;
    if(files.length === 0) {
        multipleFileUploadError.innerHTML = "Seleccione al menos un archivo";
        multipleFileUploadError.style.display = "block";
    }
    uploadMultipleFiles(files);
    event.preventDefault();
}, true);