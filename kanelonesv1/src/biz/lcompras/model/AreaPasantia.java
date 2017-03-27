package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_AREAPASANTIAS"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_AREA_DUPLICADO", columnNames={"KAN_NOMBREAREA"})        
 }
)

public class AreaPasantia extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBREAREA")
	private String nombreArea;
	
	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea.toUpperCase().trim();
	}


	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
	
}