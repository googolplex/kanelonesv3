package biz.lcompras.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Direcciones {

	@Required 
	@Column(length=80,nullable=true,name="KAN_DIRECCION")
	private String direccion;

	@Required
	@DescriptionsList(descriptionProperties="nombreCiudad")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCIUDAD_ID", referencedColumnName="ID")
	private Ciudades ciudad ;
	
	@Stereotype("TELEPHONE")
	@Column(length=40,nullable=true,name="KAN_NROCELULAR1")
	private String nroCelular1;


	@Stereotype("TELEPHONE")
	@Column(length=80,nullable=true,name="KAN_TELEFONO")
	private String telefono;

	@Stereotype("EMAIL")
	@Column(length=80,nullable=true,name="KAN_EMAIL")
	private String email;
	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion.toUpperCase().trim();
	}

	public Ciudades getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}

	public String getNroCelular1() {
		return nroCelular1;
	}

	public void setNroCelular1(String nroCelular1) {
		this.nroCelular1 = nroCelular1.toUpperCase().trim();
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono.toUpperCase().trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toUpperCase().trim();
	}

	
	
}
