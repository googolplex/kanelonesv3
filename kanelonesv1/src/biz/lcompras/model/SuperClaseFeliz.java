package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


// version con UUID
// CHau secuencias porque son dependientes del motor de la base de gatos

@MappedSuperclass
public class SuperClaseFeliz {
	@Hidden
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	
	@Column(name="ID",length=32)
	private String id ;

	@Version
	@Column(name="VERSION")
	private Long miVersion ;	
	
	@Hidden
	@Column(name="LASTUPDATED")
	private Date	fchUltMod = new java.util.Date() ; // carga solo cuando se crea

	@Hidden	
	@Column(name="DATECREATED")
	@DefaultValueCalculator(CurrentDateCalculator.class)	// no funciona cuando es un campo oculto
	private Date	fchAlta = new java.util.Date() ; // carga solo cuando se crea

	@Hidden
	@DefaultValueCalculator(CurrentUserCalculator.class)
	@Column(length=50,name="USUARIO")	
	private String	creadoPor = Users.getCurrent() ;

	@Hidden
	@DefaultValueCalculator(CurrentUserCalculator.class)	
	@Column(length=50,name="MODIFICADOPOR")	
	private String	modificadoPor = Users.getCurrent() ; // porque es un campo oculto

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMiVersion() {
		return miVersion;
	}

	public void setMiVersion(Long miVersion) {
		this.miVersion = miVersion;
	}

	public Date getFchUltMod() {
		return fchUltMod;
	}

	public void setFchUltMod(Date fchUltMod) {
		this.fchUltMod = fchUltMod;
	}

	public Date getFchAlta() {
		return fchAlta;
	}

	public void setFchAlta(Date fchAlta) {
		this.fchAlta = fchAlta;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	
}	