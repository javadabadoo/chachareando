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
    $('#' + div).load('static/user/profile.jsp');
}



function muestraMiPerfil() {
    var json = consultaJson('consulta/json/usuario/javadabadoo', 'GET');
    $('#informacionPerfil').html(json.alias);
    $('#usuario-perfil-foto').css('background-image', 'url(consulta/imagen/usuario/perfil/' + json.id + ')');
    $('#usuario-perfil-nombre').html(json.name + ' ' + json.lastName);
    $('#usuario-perfil-alias').html(json.userAlias);
    $('#usuario-perfil-miembroDesde').html(json.memberFrom);
    $('#usuario-perfil-correo').html(json.emailAddress);
}