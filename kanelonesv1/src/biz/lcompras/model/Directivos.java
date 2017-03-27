package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_DIRECTIVO"
 , uniqueConstraints={
		 @UniqueConstraint(name="DIR_NOMBRE_DUPLICADO", columnNames={"KAN_DIRECTIVONOMBRE"})        
 }
)


public class Directivos extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_DIRECTIVONOMBRE")
	private String directivoNombre ;
	
	
	public String getDirectivoNombre() {
		return directivoNombre;
	}


	public void setDirectivoNombre(String directivoNombre) {
		this.directivoNombre = directivoNombre.toUpperCase().trim();
	}


	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

	
}
