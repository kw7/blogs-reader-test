package testmaven.bandesal.gob.sv.repository;

import java.util.List;

import javax.ejb.Local;

import testmaven.bandesal.gob.sv.models.Readers;

//@Local
public interface ReadersDao {

	public List<Readers> getAll();

	public void save(Readers model);

	public void update(Readers model);

	public void delete(Readers model);
}
