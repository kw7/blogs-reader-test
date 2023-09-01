package testmaven.bandesal.gob.sv.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import testmaven.bandesal.gob.sv.models.Usuario;
import testmaven.bandesal.gob.sv.repository.UserDao;



@Service("loginService")
public class LoginService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String alias) throws UsernameNotFoundException {

		Usuario usuario = userDao
				.getUserByName(alias);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		List<SimpleGrantedAuthority> simpleGrantedAuthorities = buildSimpleGrantedAuthorities(usuario);
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(usuario.getUsuario(),
				usuario.getContrasenia(), true, true, true, true, simpleGrantedAuthorities);

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("usuario", usuario);

		return userDetails;

	}

	private List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(Usuario usuario) {
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
                System.out.println(usuario.getRol().getDescripcion());
		simpleGrantedAuthorities.add(new SimpleGrantedAuthority(usuario.getRol().getDescripcion()));

		return simpleGrantedAuthorities;
	}
}
