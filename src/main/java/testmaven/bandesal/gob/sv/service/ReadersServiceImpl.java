package testmaven.bandesal.gob.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testmaven.bandesal.gob.sv.models.Readers;
import testmaven.bandesal.gob.sv.repository.ReadersDao;

//@Stateless
@Service
public class ReadersServiceImpl implements ReadersService {
	
	@Autowired
	private ReadersDao dao;

	@Override
	public List<Readers> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public void save(Readers model) {
		// TODO Auto-generated method stub
		dao.save(model);
		
	}

	@Transactional
	@Override
	public void update(Readers model) {
		// TODO Auto-generated method stub
		dao.update(model);
	}

	@Override
	public void delete(Readers model) {
		dao.delete(model);
		
	}

}
