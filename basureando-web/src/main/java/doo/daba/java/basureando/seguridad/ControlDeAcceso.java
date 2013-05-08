package doo.daba.java.basureando.seguridad;

import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.persistencia.UsuarioInterfaceDao;
import doo.daba.java.util.Propiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 29/04/13
 * Time: 09:59 AM
 */
public class  ControlDeAcceso implements AuthenticationManager {


	@Autowired
	private UsuarioInterfaceDao usuarioDao;

    /**
     * Metodo de verificacion de sesion con los datos proporcionados por las credenciales.
     * Crea la sesion en caso de encontrar validos los datos de las credenciales proporcionadas,
     * en caso contrario retorna una excepcion que indica el fallo en la validacion de la
     * informacion del usuario que intenta accesar por el firltro
     *
     * @param auth  Encapsula la informacion de la solicitud de autenticacion
     *
     * @return      Sesion creada con los roles correspondientes del usuario que se autentico
     *
     * @throws      AuthenticationException  Lanzada cuando exista un error en la validacion de
     *              la informacion del usuario
     */
	@Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        UsernamePasswordAuthenticationToken tokenDeAutenticacion;
        UsuarioBean usuario = this.obtenerInformacionDeUsuario(auth.getPrincipal().toString());
		
        if(usuario == null || !usuario.getContrasena().equals(auth.getCredentials().toString())){
            throw new BadCredentialsException(Propiedades.obtener("seguridad.acceso.mensaje.informacionDeAccesoIncorrecta"));
        }


		Collection<GrantedAuthority> roles = this.autorizar(usuario.getListaDeRoles());


        tokenDeAutenticacion = new UsernamePasswordAuthenticationToken(
                usuario.getNombre(),
                usuario.getContrasena(),
				roles);
		

        return tokenDeAutenticacion;

    }
	
	
	
	/**
	 * Invoca a {@code UsuarioInterfaceDao} para obtener la informacion del
	 * usuario y sus roles asignados
	 * 
	 * @param usuario	Alias del usuario del cual se obtiene la informacion
	 * 
	 * @return	Informacion del usuario encapsulada en el objeto {@code UsuarioBean}
	 * 
	 * @see UsuarioBean
	 * @see UsuarioInterfaceDao#select(java.lang.String)
	 * @see UsuarioInterfaceDao#obtenerListaDeRoles(int)
	 */
    private UsuarioBean obtenerInformacionDeUsuario(String usuario) {
        
		UsuarioBean usuarioBean = this.usuarioDao.select(usuario);
		usuarioBean.setListaDeRoles(this.usuarioDao.obtenerListaDeRoles(usuarioBean.getId()));
		
		return usuarioBean;
		
    }



    /**
     *
     *
     * @param roles
     * @return
     */
    private Collection<GrantedAuthority> autorizar(List<String> roles) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

        for (String rol : roles) {

            if (rol.equals(rol)) {

                authList.add(new SimpleGrantedAuthority(rol));

            }
        }

        return authList;
    }
}
