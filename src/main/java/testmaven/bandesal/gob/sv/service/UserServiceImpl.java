package testmaven.bandesal.gob.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testmaven.bandesal.gob.sv.models.Usuario;
import testmaven.bandesal.gob.sv.repository.UserDao;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public Usuario getUserByName(String usuario) {
		// TODO Auto-generated method stub
		return dao.getUserByName(usuario);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Usuario login(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.login(usuario);
	}

}
