package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_ESTADOPASANTIA"
 , uniqueConstraints={
         @UniqueConstraint(name="KAN_ESTADO_DUPLICADO", columnNames={"KAN_NOMBREESTADO"})        
 }
)

public class EstadosPasantia extends SuperClaseFeliz {

	@Required
	@Column(length=40,nullable=false,name="KAN_NOMBREESTADO")
	private String nombreEstado;
		
	
	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
