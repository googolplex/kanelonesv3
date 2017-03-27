package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_ACTIVIDADES"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_ACTIVIDAD_DUPLICADA", columnNames={"KAN_NOMBREACTIVIDAD"})        
 }
)
public class Actividades extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBREACTIVIDAD")
	private String nombreActividad;

	
	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
