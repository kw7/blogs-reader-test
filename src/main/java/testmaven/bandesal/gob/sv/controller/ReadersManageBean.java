package testmaven.bandesal.gob.sv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.models.Readers;
import testmaven.bandesal.gob.sv.service.BlogsService;
import testmaven.bandesal.gob.sv.service.ReadersService;
import testmaven.bandesal.gob.sv.util.MessagesUtil;

@Log
@Named(value = "readerBean")
@ViewScoped
public class ReadersManageBean {
	// @EJB
	@Autowired
	private BlogsService serviceBlog;

	// @EJB
	@Autowired
	private ReadersService service;
	private Readers readers;
	private Readers slcReaders;

	private boolean editar = false;
	private List<Blogs> listBlogs;
	private List<Blogs> selectedListBlogs;

	private List<Readers> readersList;

	public ReadersManageBean() {
		// selectedListBlogs= new ArrayList<>();
	}

	@PostConstruct
	public void inicio() {

		readers = new Readers();
		slcReaders = new Readers();
		
		listBlogs = serviceBlog.getAll();

	}

	public void save() {

		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (!editar) {
			try {
				

				readers.setBlogs(selectedListBlogs);
				service.save(readers);
				this.cancelar();
				MessagesUtil.msgInfo("Exito!", "Lector guardado correctamente.");
				requestContext.execute("PF('dlg_nuevo_reader').hide();");
			} catch (Exception e) {

			}
		} else {
			try {
				//slcReaders.setBlogs(selectedListBlogs);
				service.update(slcReaders);
				this.cancelar();
				MessagesUtil.msgInfo("Advertencia!", "Lector actualizado.");
				requestContext.execute("PF('dlg_editar_reader').hide();");
			} catch (Exception e) {
			}
		}

	}

	public void eliminar() {

		try {
			service.delete(slcReaders);
			MessagesUtil.msgError("Error!", "Lector eliminado correctamente.");
		} catch (Exception e) {
		}

	}

	public void cancelar() {
		readers = new Readers();
		slcReaders = new Readers();
		editar = false;
		selectedListBlogs = new ArrayList<>();
	}

	public List<Readers> getAllReaders() {
		readersList=service.getAll();
		log.info("lector 1 ".concat( String.valueOf(readersList.get(0).getBlogs().size())));
		log.info("lector 2 ".concat( String.valueOf(readersList.get(1).getBlogs().size())));
		log.info("lector 3 ".concat( String.valueOf(readersList.get(2).getBlogs().size())));
		
		return readersList;
	}

	public void showReader(Readers readers) {

		this.slcReaders = readers;
		editar = true;
		
		
	}

	public List<Blogs> getAllBlogs() {

		return serviceBlog.getAll();
	}

	public Readers getReaders() {
		return readers;
	}

	public void setReaders(Readers readers) {
		this.readers = readers;
	}

	public Readers getSlcReaders() {
		return slcReaders;
	}

	public void setSlcReaders(Readers slcReaders) {
		this.slcReaders = slcReaders;
	}

	public List<Blogs> getListBlogs() {
		return listBlogs;
	}

	public void setListBlogs(List<Blogs> listBlogs) {
		this.listBlogs = listBlogs;
	}

	public List<Blogs> getSelectedListBlogs() {
		return selectedListBlogs;
	}

	public void setSelectedListBlogs(List<Blogs> selectedListBlogs) {
		this.selectedListBlogs = selectedListBlogs;
	}

	public List<Readers> getReadersList() {
		return readersList;
	}

	public void setReadersList(List<Readers> readersList) {
		this.readersList = readersList;
	}


}
