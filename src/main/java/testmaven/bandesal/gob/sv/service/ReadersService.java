package testmaven.bandesal.gob.sv.service;

import java.util.List;

import testmaven.bandesal.gob.sv.models.Readers;

//@Local
public interface ReadersService {

	public List<Readers> getAll();

	public void save(Readers model);

	public void update(Readers model);

	public void delete(Readers model);
}
