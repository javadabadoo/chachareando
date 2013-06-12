function muestraVentana(div, titulo) {
    $('#' + div).dialog({
        autoOpen: false,
        closeOnEscape : true,
        close: function( event, ui ) {
            alert('Se cierra ventanita');
        },
        height: 300,
        width: 450,
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
    $('#' + div).load('estatico/usuario/perfilUsuario.jsp');
}



function muestraMiPerfil() {
    var json = consultaJson('consulta/json/usuario/javadabadoo', 'GET');
    $('#informacionPerfil').html(json.alias);
    $('#usuario-perfil-foto').css('background-image', 'url(consulta/imagen/usuario/perfil/' + json.id + ')');
    $('#usuario-perfil-nombre').html(json.nombre + ' ' + json.apellidos);
    $('#usuario-perfil-alias').html(json.alias);
    $('#usuario-perfil-miembroDesde').html(json.fechaDeRegistro);
    $('#usuario-perfil-correo').html(json.correo);
}