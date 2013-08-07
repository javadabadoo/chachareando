package doo.daba.java.basureando.security;

import doo.daba.java.beans.User;
import doo.daba.java.persistence.UserDao;
import doo.daba.java.util.PropertiesContainer;
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
 */
public class AccessControl implements AuthenticationManager {


	@Autowired
	private UserDao userDao;

    /**
     * Metodo de verificacion de sesion con los datos proporcionados por las credenciales.
     * Crea la sesion en caso de encontrar validos los datos de las credenciales proporcionadas,
     * en caso contrario retorna una excepcion que indica el fallo en la validacion de la
     * informacion del userAlias que intenta accesar por el firltro
     *
     * @param auth  Encapsula la informacion de la solicitud de autenticacion
     *
     * @return      Sesion creada con los roles correspondientes del userAlias que se autentico
     *
     * @throws      AuthenticationException  Lanzada cuando exista un error en la validacion de
     *              la informacion del userAlias
     */
	@Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authenticationToken;
        User user = this.getUserInformation(auth.getPrincipal().toString());
		
        if(user == null || !user.getPassword().equals(auth.getCredentials().toString())){
            throw new BadCredentialsException(PropertiesContainer.get("seguridad.acceso.mensaje.informacionDeAccesoIncorrecta"));
        }

		Collection<GrantedAuthority> userRoles = this.authorize(user.getRolesList());

        authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getName(),
                user.getPassword(),
				userRoles);

        return authenticationToken;

    }
	
	
	
	/**
	 * Invoca a {@code UserDao} para get la informacion del
	 * userAlias y sus roles asignados
	 * 
	 * @param userAlias	Alias del userAlias del cual se obtiene la informacion
	 * 
	 * @return	Informacion del userAlias encapsulada en el objeto {@code User}
	 * 
	 * @see doo.daba.java.beans.User
	 * @see doo.daba.java.persistence.UserDao#select(java.lang.String)
	 * @see doo.daba.java.persistence.UserDao#selectUserRoles(int)
	 */
    private User getUserInformation(String userAlias) {
        
		User user = this.userDao.select(userAlias);

        if(user != null){
            user.setRolesList(this.userDao.selectUserRoles(user.getId()));
        }
		
		return user;
		
    }


    /**
     * @param roles Lista de roles del userAlias que se está autenticando
     *
     * @return  Colección con los roles definidos al userAlias que se está autenticando
     */
    private Collection<GrantedAuthority> authorize(List<String> roles) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

        for (String rol : roles) {
            authList.add(new SimpleGrantedAuthority(rol));
        }

        return authList;
    }
}
