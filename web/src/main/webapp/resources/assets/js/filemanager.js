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

function uploadSingleFile(file) {
    var formData = new FormData();
    formData.append("file", file);
    formData.append("idEmpresa", document.querySelector("#idEmpresa").value);
    formData.append("idUbicacion", document.querySelector("#idUbicacion").value);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = "";
        if(xhr.status === 200) {
            response = JSON.parse(xhr.responseText);
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p><i class='far fa-check-circle' style='color:green'></i> Archivo subido exitosamente.</p><p>Descargar : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            console.log(response);
            singleFileUploadError.innerHTML = "<p><i class='far fa-times-circle' style='color:darkred'></i> Hubo un error.</p>";
        }
    };

    xhr.send(formData);
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