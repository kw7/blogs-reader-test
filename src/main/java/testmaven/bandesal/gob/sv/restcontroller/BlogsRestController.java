package testmaven.bandesal.gob.sv.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import testmaven.bandesal.gob.sv.dto.BlogsDTO;
import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.service.BlogsService;



@Path("/blogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogsRestController {
	
	@Autowired
	public BlogsService service;
	
	@GET
	@Path("/getAll")
	public List<BlogsDTO> getAllBlogs() {
		List<BlogsDTO> dtos=service.getAll().stream().map(b->{
			BlogsDTO bl=new BlogsDTO();
			bl.setId(b.getId());
			bl.setTitle(b.getTitle());
			bl.setDescription(b.getDescription());
			return bl;
		}).collect(Collectors.toList());
		return dtos;
	}
	@POST
    @Path("/add")
	public BlogsDTO add(BlogsDTO b) {
		Blogs bl=new Blogs();
		bl.setTitle(b.getTitle());
		bl.setDescription(b.getDescription());
		service.save(bl);
		return b;
		
	}
	
	@PUT
    @Path("/update")
	public BlogsDTO update(BlogsDTO b) {
		Blogs bl=new Blogs();
		bl.setId(b.getId());
		bl.setTitle(b.getTitle());
		bl.setDescription(b.getDescription());
		service.update(bl);
		return b;
		
	}
	@DELETE
    @Path("/delete/{id}")
	public String delete(@PathParam("id") Long id) {
		Blogs bl=new Blogs();
		bl.setId(id);
		service.delete(bl);
		return "Eliminado correcto";
		
	}

}
