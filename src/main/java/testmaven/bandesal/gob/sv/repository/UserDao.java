package testmaven.bandesal.gob.sv.repository;

import java.util.List;

import testmaven.bandesal.gob.sv.models.Usuario;

public interface UserDao {

	// Usuario

	public Usuario getUserByName(String usuario);

	public List<Usuario> getAll();

	public Usuario login(Usuario usuario);
}
