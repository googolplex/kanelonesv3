package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_CIUDADES"
 , uniqueConstraints={
         @UniqueConstraint(name="KAN_CIUDAD_DUPLICADA", columnNames={"KAN_NOMBRECIUDAD"})        
 }
)

public class Ciudades extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBRECIUDAD")
	private String nombreCiudad;

	
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}



	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad.toUpperCase().trim();
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
