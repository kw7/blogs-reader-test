package testmaven.bandesal.gob.sv.service;

import java.util.List;

import javax.ejb.Local;

import testmaven.bandesal.gob.sv.models.Blogs;

//@Local

public interface BlogsService {

	public List<Blogs> getAll();

	public void save(Blogs model);

	public void update(Blogs model);

	public void delete(Blogs model);
	
	public Blogs findBlog(Long id);
}
