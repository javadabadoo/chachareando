function muestraVentana(div, titulo) {
    $('#' + div).dialog({
        autoOpen: false,
        closeOnEscape : true,
        close: function( event, ui ) {
            alert('Se cierra ventanita');
        },
        height: 300,
        width: 350,
        modal: true,
        title: titulo,
        buttons: {
            "Editar Información": function() {
            },
            Cancel: function() {
                $(this).dialog( "destroy" );
                $('#' + div).html('');
            }
        },
        close: function() {
        }
    });

    $('#' + div).dialog('open');
    actualizaContenidoDiv('consulta/json/usuario/javadabadoo', div);
}


function actualizaContenidoDiv(url, div) {
    $('#' + div).html('contenido: <br /><strong>usuario: ' + consultaJson(url).alias + '</strong>');
}


function consultaJson(url) {
    var json = null;
    $.ajax({
        url: url,
        type: 'GET',
        async:false,
        dataType: 'json',
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