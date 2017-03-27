package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_CARGO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_CARGO_DUPLICADO", columnNames={"KAN_NOMBRECARGO"})        
 }
)

public class Cargos extends SuperClaseFeliz {

	
	@Required
	@Column(length=40,nullable=false,name="KAN_NOMBRECARGO")
	private String nombreCargo ;
	
	public String getNombreCargo() {
		return nombreCargo;
	}


	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo.toUpperCase().trim();
	}


	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
