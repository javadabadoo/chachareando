package doo.daba.java.basureando.doo.daba.java.basureando.validadores;

import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.util.Propiedades;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * @author Gerardo Aquino
 * @since 09/03/2011
 * To change this template use File | Settings | File Templates.
 */
public class UsuarioValidador implements Validator {

    private UsuarioBean usuario;

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioBean.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        this.usuario = (UsuarioBean) target;
    }


    /**
     * Verifica que el ID no sea menor a 1 que debe ser el valor inferior de los
     * identificadores de la tabla de usuario
     *
     * @param id    Identificador en base de datos del usuario
     *
     * @return  {@code null}: Si cumple con las validaciones. En caso contrario retorna
     *          el mensaje de error resultado de la validación
     */
    private String validaId(int id){
        String mensajeDeError = null;

        if(id < 1) {
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.usuario.id.negativo");
        }

        return mensajeDeError;
    }


    /**
     * Verifica que el alias no venga vacio y que el formato del alias pueda ser alfanumérico con
     * punto.
     *
     * @param alias Nombre "ALIAS" del usuario
     *
     * @return  {@code null}: Si cumple con las validaciones. En caso contrario retorna
     *          el mensaje de error resultado de la validación
     */
    private String alias(String alias) {
        String
                mensajeDeError = null,
                formatoDeTextoDelAlias = "^[a-zA-Z0-9].*$";

        if(alias == null || alias.trim().isEmpty()) {
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.campoVacio", "Alias");
        }

        if(!alias.matches(formatoDeTextoDelAlias)) {
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.usuario.alias.formatoIncorrecto");
        }

        return mensajeDeError;

    }


    /**
     * Verifica que el nombre y apellidos no sean nulos o vengan vacios. El formato de texto
     * debe ser alfabetico y únicamente se permite el uso de punto en caso de nombres
     * abreviados.
     *
     * @param nombre    Nombre del usuario
     * @param apellidos Apellidos del usuario
     *
     * @return  {@code null}: Si cumple con las validaciones. En caso contrario retorna
     *          el mensaje de error resultado de la validación
     */
    private String validaNombreCompleto(String nombre, String apellidos){
        String
                mensajeDeError = null,
                formatoDeTexto = "^[a-zA-Z].*$";

        if(nombre == null || nombre.trim().isEmpty()){
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.campoVacio", "ID");
        }

        if(apellidos == null || apellidos.trim().isEmpty()){
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.campoVacio", "Apellidos");
        }

        if(!nombre.matches(formatoDeTexto)) {
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.usuario.nombre.formatoIncorrecto");
        }

        if(!apellidos.matches(formatoDeTexto)) {
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.usuario.apellidos.formatoIncorrecto");
        }

        return mensajeDeError;

    }


    /**
     * Verifica que el correo no venga vacio y que cumpla con el formato de texto de una
     * dirección de correo electrónico
     *
     * @param correo    Correo electrónico del usuario
     *
     * @return  {@code null}: Si cumple con las validaciones. En caso contrario retorna
     *          el mensaje de error resultado de la validación
     */
    private String validaCorreo(String correo) {
        String
                mensajeDeError = null,
                formatoDeTexto = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";

        if(correo == null || correo.trim().isEmpty()){
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.campoVacio", "Correo");
        }

        if(!correo.matches(formatoDeTexto)) {
            mensajeDeError = Propiedades.obtener("validaor.mensajes.error.usuario.correo.formatoIncorrecto");
        }

        return mensajeDeError;

    }


}