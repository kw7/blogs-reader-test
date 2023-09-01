package testmaven.bandesal.gob.sv.repository;

import java.util.List;

import testmaven.bandesal.gob.sv.models.Blogs;
import javax.ejb.Local;


//@Local
public interface BlogsDao {

	
	public List<Blogs> getAll();

	public void save(Blogs model);

	public void update(Blogs model);

	public void delete(Blogs model);
	
	public Blogs findBlog(Long id);
}
