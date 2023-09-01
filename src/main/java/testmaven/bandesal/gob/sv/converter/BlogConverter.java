package testmaven.bandesal.gob.sv.converter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import testmaven.bandesal.gob.sv.controller.ReadersManageBean;
import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.service.BlogsService;


@Log
@Named
public class BlogConverter implements Converter {

	@Autowired
	private BlogsService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		log.info(value);
		System.out.println(value);
		try {

			Blogs blog = service.findBlog(Long.valueOf(value));
			log.info(blog.getTitle());
			return blog;

		} catch (Exception e) {
			log.info(e.getMessage());
			FacesMessage msg = new FacesMessage("Error!", "blog no válido");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);

		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Blogs) value).getId());
		} else {
			return null;
		}
	}

}
