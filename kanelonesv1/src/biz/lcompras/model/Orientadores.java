package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_ORIENTADORES"
 , uniqueConstraints={
        @UniqueConstraint(name="ORI_NOMBRE_DUPLICADO", columnNames={"KAN_NOMBREORIENTADOR"})        
 }
)

public class Orientadores extends SuperClaseFeliz {

	@Required
	@Column(length=80,nullable=false,name="KAN_NOMBREORIENTADOR")
	private String nombreOrientador;

	@Required
	@DescriptionsList(descriptionProperties="nombreMateria")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDMATERIA_ID", referencedColumnName="ID")	
	private Materias materia ;

	@Embedded
	private Direcciones direccion ;	
	
	public String getNombreOrientador() {
		return nombreOrientador;
	}


	public void setNombreOrientador(String nombreOrientador) {
		this.nombreOrientador = nombreOrientador.toUpperCase().trim();
	}


	public Materias getMateria() {
		return materia;
	}


	public void setMateria(Materias materia) {
		this.materia = materia;
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
