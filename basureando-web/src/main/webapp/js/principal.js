$(function() {
	$('#divMenuPrincipal').load('estatico/plantilla/menuIzquierdo.jsp');
    $('#contenidoPrincipal').load('estatico/entradas/catalogo.jsp');
});



function consultaJson(url, method, params) {
    var json = null;
    $.ajax({
        url: url,
        type: method,
        async: false,
        dataType: 'json',
        data: params,
        success: function (data) {
            json = data;
        },
        error: function (request, status, error) {
            alert("REQUEST:\t" + request + "\nSTATUS:\t" + status +
                "\nERROR:\t" + error);
        }
    });

    return json;
}