package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_LUGARESDEATENCION"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_LUGAR_DUPLICADO", columnNames={"KAN_LUGAR"})        
 }
)
public class LugaresDeAtencion extends SuperClaseFeliz {

	
	@Required
	@Column(length=80,nullable=false,name="KAN_LUGAR")
	private String lugar ;
	
	
	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar.toUpperCase().trim();
	}


	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
