package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_MATERIA"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_MATERIA_DUPLICADA", columnNames={"KAN_NOMBREMATERIA"})        
 }
)

public class Materias extends SuperClaseFeliz {

	
	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBREMATERIA")
	private String nombreMateria;

	
	
	public String getNombreMateria() {
		return nombreMateria;
	}



	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria.toUpperCase().trim();
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
