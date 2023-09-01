package testmaven.bandesal.gob.sv.service;

import java.util.List;

import testmaven.bandesal.gob.sv.models.Usuario;

public interface UserService {
	// Usuario

	public Usuario getUserByName(String usuario);

	public List<Usuario> getAll();

	public Usuario login(Usuario usuario);
}
