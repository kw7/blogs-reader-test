package testmaven.bandesal.gob.sv.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import testmaven.bandesal.gob.sv.models.Usuario;


@ManagedBean(name = "sesionUsuario")
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UserSession() {

		FacesContext context = FacesContext.getCurrentInstance();
		usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
