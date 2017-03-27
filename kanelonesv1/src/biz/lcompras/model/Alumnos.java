package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


@Entity
@Table(name="KAN_ALUMNO"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_CEDULA_DUPLICADA", columnNames={"KAN_NROCEDULA"})
        , @UniqueConstraint(name="KAN_NOMBRE_DUPLICADO", columnNames={"KAN_NOMBREAPELLIDO"})        
 }
)

public class Alumnos extends SuperClaseFeliz {

@Required
@Column(length=20,nullable=false,name="KAN_NROCEDULA")
@Pattern(regexp="^[0-9]+$",message="No es un numero")
private String nroCedula ;
@Required
@Column(length=80,nullable=false,name="KAN_NOMBREAPELLIDO")
private String nombreApellido ;

@Embedded
private Direcciones direccion;

@Required
@Column(nullable=true	,name="KAN_YYYY")
@DefaultValueCalculator(CurrentYearCalculator.class)
private Long yyyy;

	
	
	public String getNroCedula() {
	return nroCedula;
}



public void setNroCedula(String nroCedula) {
	this.nroCedula = nroCedula.toUpperCase().trim();
}



public String getNombreApellido() {
	return nombreApellido;
}


public void setNombreApellido(String nombreApellido) {
	this.nombreApellido = nombreApellido.toUpperCase().trim();
}



	public Direcciones getDireccion() {
	return direccion;
}



public void setDireccion(Direcciones direccion) {
	this.direccion = direccion;
}



	public Long getYyyy() {
	return yyyy;
}



public void setYyyy(Long yyyy) {
	this.yyyy = yyyy;
}



	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
