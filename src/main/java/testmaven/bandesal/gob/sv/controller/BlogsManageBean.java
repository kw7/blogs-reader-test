package testmaven.bandesal.gob.sv.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.service.BlogsService;
import testmaven.bandesal.gob.sv.util.MessagesUtil;

@Named(value = "blogsBean")
@ViewScoped
public class BlogsManageBean {
	//@EJB
	@Autowired
	private BlogsService service;

	private Blogs blogs;
	private Blogs slcBlog;
	private boolean editar = false;
	private List<Blogs> listBlogs;

	public BlogsManageBean() {
	}

	@PostConstruct
	public void inicio() {

		blogs = new Blogs();
		slcBlog = new Blogs();
		

	}

	public void guardar() {

		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (!editar) {
			try {
				service.save(blogs);
				this.cancelar();
				MessagesUtil.msgInfo("Exito!", "Usuario guardado correctamente.");
				requestContext.execute("PF('dlg_nuevo_blogs').hide();");
			} catch (Exception e) {

			}
		} else {
			try {
				service.update(slcBlog);
				this.cancelar();
				MessagesUtil.msgInfo("Advertencia!", "Usuario actualizado.");
				requestContext.execute("PF('dlg_editar_blogs').hide();");
			} catch (Exception e) {
			}
		}

	}

	public void actualizar() {
		blogs = slcBlog;
		editar = true;
	}

	public void eliminar() {

		try {
			service.delete(slcBlog);
			MessagesUtil.msgError("Error!", "Usuario eliminado correctamente.");
		} catch (Exception e) {
		}

	}

	public void cancelar() {
		blogs = new Blogs();
		slcBlog = new Blogs();
		editar = false;
	}

	public List<Blogs> getAllBlogs() {
		return service.getAll();
	}

	public void showBlogs(Blogs blogs) {

		this.slcBlog = blogs;
		editar = true;
	}

	// ----get and set
	public Blogs getBlogs() {
		return blogs;
	}

	public void setBlogs(Blogs blogs) {
		this.blogs = blogs;
	}

	public Blogs getSlcBlog() {
		return slcBlog;
	}

	public void setSlcBlog(Blogs slcBlog) {
		this.slcBlog = slcBlog;
	}

	public List<Blogs> getListBlogs() {
		return listBlogs;
	}

	public void setListBlogs(List<Blogs> listBlogs) {
		this.listBlogs = listBlogs;
	}

}
