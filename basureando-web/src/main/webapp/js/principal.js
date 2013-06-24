$(function() {
	$('#divMenuPrincipal').load('estatico/plantilla/menuIzquierdo.jsp');
    $('#contenidoPrincipal').load('estatico/entradas/catalogo.jsp');
});



function consultaJson(url, method, params) {
    var json = null;
    $.ajax({
        async: false,
        data: params,
        dataType: 'json',
        type: method,
        timeout: 3000,
        url: url,
        success: function (data) {
            json = data;
        },
        error: function (request, status, error) {
            json  = {
                hasError: true,
                responseMessage: status + ': ' + error
            }
        }
    });

    return json;
}



function setNotification(message) {
    $('#notificationArea').html(message);
}



function FormValidator(form) {
    this.form = form;
    this.callback = null;
    this.behavior = null;

}



FormValidator.prototype.addFormValidationBehavior = function(callback) {

    this.callback = callback;

    this.behavior = function() {

        if(this.form.onsubmit) {

            var json = consultaJson(
                this.form.action,
                this.form.method,
                $("#" + this.form.id).serialize());

            if(json.hasError) {
                setNotification(json.responseMessage);
                if(json.validationErrors != undefined) {
                    for(var errorIndex = 0; errorIndex < json.validationErrors.length; errorIndex++) {
                        var validationMessageNode = document.getElementById(this.form.id + '_' + json.validationErrors[errorIndex].field + '_message');

                        deleteValidationMessages(validationMessageNode);
                        createValidationMessage(validationMessageNode, createTextSpan(json.validationErrors[errorIndex].errorMessage), true);
                    }
                } else {
                    alert(json.responseMessage);
                }
            } else if(json != null && !json.hasError) {
                this.call();
            }
        }
    };

}


FormValidator.prototype.call = function() {
    this.callback();
}







function FormDefiniton(init, defineValidationRules) {
    this.defineValidationRules = defineValidationRules;
    this.init = init;
    this.formValidator = null;

    this.fields = [];
}



FormDefiniton.prototype.init = function () {
    this.init();
}



FormDefiniton.prototype.defineValidationRules = function() {
    this.defineValidationRules();
}