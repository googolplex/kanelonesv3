package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_CONTACTO"
 , uniqueConstraints={
     @UniqueConstraint(name="CON_NOMBRE_DUPLICADO", columnNames={"KAN_NOMBRECONTACTO"})        
 }
)

public class Contactos extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBRECONTACTO")	
	private String nombreContacto ;	

	@Embedded
	private Direcciones direccion ;	
	
	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto.toUpperCase().trim();
	}



	public Direcciones getDireccion() {
		return direccion;
	}

	public void setDireccion(Direcciones direccion) {
		this.direccion = direccion;
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
