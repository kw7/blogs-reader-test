package testmaven.bandesal.gob.sv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.models.Readers;
import testmaven.bandesal.gob.sv.service.BlogsService;
import testmaven.bandesal.gob.sv.service.ReadersService;

@Named(value = "readerPerBlogBean")
@ViewScoped
public class ReaderPerBlogManageBean {

	// @EJB
	@Autowired
	private BlogsService service;
	
	@Autowired
	private ReadersService serviceReaders;

	private List<Blogs> listBlogs;
	
	private List<Readers> readersList;
	private List<Readers> readersListPerBlog=new ArrayList<Readers>();
	
	
	
	public ReaderPerBlogManageBean() {		
	}



	public List<Blogs> getAll() {
		return service.getAll();
	}
	
//	public List<Readers> getAllReaders() {
//		readersList=serviceReaders.getAll();
//		listBlogs.forEach(b->{
//			readersList.forEach(r->{
//				r.getBlogs().forEach(rb->{
//					if(rb.equals(b)) {
//						readersListPerBlog.add(r);
//					}
//				});
//			});
//		});
//		
//		
//		return readersList;
//	}
}
