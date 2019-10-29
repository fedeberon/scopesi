/**
 * Created by federicoberon on 29/10/2019.
 */
function pagSiguiente(form){
    document.forms[form].page.value=document.forms[0].page.value*1+1;
    document.forms[form].submit();
}
function pagAnterior(form){
    document.forms[form].page.value=document.forms[0].page.value*1-1;
    document.forms[form].submit();
}
