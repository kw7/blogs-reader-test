package testmaven.bandesal.gob.sv.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.repository.BlogsDao;

//@Stateless
@Service
public class BlogsServiceImpl implements BlogsService {

	//@EJB
	@Autowired
	BlogsDao dao;

	@Override
	public List<Blogs> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public void save(Blogs model) {
		dao.save(model);

	}

	@Override
	public void update(Blogs model) {
		dao.update(model);

	}

	@Override
	public void delete(Blogs model) {
		dao.delete(model);

	}

	@Override
	public Blogs findBlog(Long id) {
		// TODO Auto-generated method stub
		return dao.findBlog(id);
	}

}
