package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_EMPRESA"
 , uniqueConstraints={
        @UniqueConstraint(name="KAN_EMPRESA_DUPLICADA", columnNames={"KAN_NOMBREEMPRESA"})        
 }
)
public class Empresas extends SuperClaseFeliz {

@Column(length=80,nullable=false,name="KAN_NOMBREEMPRESA")
@Required
private String nombreEmpresa;

@Embedded
private Direcciones direccion ;

public String getNombreEmpresa() {
	return nombreEmpresa;
}


public void setNombreEmpresa(String nombreEmpresa) {
	this.nombreEmpresa = nombreEmpresa.toUpperCase().trim();
}


public Direcciones getDireccion() {
	return direccion;
}


public void setDireccion(Direcciones direccion) {
	this.direccion = direccion;
}


@PreUpdate
private void ultimoPaso() {
		Date mifechora = new java.util.Date() ;
		super.setModificadoPor(Users.getCurrent()) ;
		super.setFchUltMod(mifechora)  ;
}		

	
}
