package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_CARRERA"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_CARRERA_DUPLICADA", columnNames={"KAN_CARRERANOMBRE","KAN_ENFASIS"})        
 }
)

@View(members="carreraNombre;enfasis")
@Tab(properties="carreraNombre,enfasis")
public class Carreras extends SuperClaseFeliz  {
	
	@Required
	@Column(length=60,nullable=false,name="KAN_CARRERANOMBRE")
	private String carreraNombre;
	
	@Required
	@Column(length=60,nullable=false,name="KAN_ENFASIS")
	private String enfasis;
	
	public String getCarreraNombre() {
		return carreraNombre;
	}

	public void setCarreraNombre(String carreraNombre) {
		this.carreraNombre = carreraNombre.toUpperCase().trim();
	}
	
	public String getEnfasis() {
		return enfasis;
	}

	public void setEnfasis(String enfasis) {
		this.enfasis = enfasis.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		

}
