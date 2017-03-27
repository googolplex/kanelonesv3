package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_ATENCIONINFORME"
 , uniqueConstraints={
     @UniqueConstraint(name="KAN_YYYY_DUPLICADO", columnNames={"KAN_YYYY"})        
 }
)
public class AtencionInforme extends SuperClaseFeliz {

	@Required
	@Range(min=0)	
	@Column(length=4,nullable=false,name="KAN_YYYY",scale=0)
	@DefaultValueCalculator(CurrentYearCalculator.class)	
	private Long yyyy ;

	@Column(length=60,nullable=true,name="KAN_NOMBRECORTO")
	private String nombreCorto;
	
	@Required
	@Stereotype("MEMO")
	@Column(length=500,nullable=false,name="KAN_NARRATIVA")
	private String attn;
		

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto.toUpperCase().trim();
	}


	public Long getYyyy() {
		return yyyy;
	}



	public void setYyyy(Long yyyy) {
		this.yyyy = yyyy;
	}



	public String getAttn() {
		return attn;
	}



	public void setAttn(String attn) {
		this.attn = attn.toUpperCase().trim();
	}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
	
}
