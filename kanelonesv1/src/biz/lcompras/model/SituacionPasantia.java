package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

@Entity
@Table(name="KAN_SITUACIONPASANTIA"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_SITUACION_DUPLICADA", columnNames={"IDPASANTIAS1_ID","KAN_FECHASITUACION","IDESTADO_ID"})        
 }
)
@Tab(properties="cabecero1.yyyy,cabecero1.alumno.nroCedula,cabecero1.alumno.nombreApellido,cabecero1.fechaInicio,fechaSituacion,cabecero1.empresa.nombreEmpresa,estado.nombreEstado")
public class SituacionPasantia extends SuperClaseFeliz {

	@ManyToOne
	@JoinColumn(name="IDPASANTIAS1_ID")
	private Pasantias cabecero1 ;	
	
	@Embedded
	private Anomes yyyymm ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="KAN_FECHASITUACION")
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fechaSituacion ;

	@Required
	@DescriptionsList(descriptionProperties="nombreEstado")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDESTADO_ID", referencedColumnName="ID")
	private EstadosPasantia estado ; 
	


	public Anomes getYyyymm() {
		return yyyymm;
	}



	public void setYyyymm(Anomes yyyymm) {
		this.yyyymm = yyyymm;
	}



	public Pasantias getCabecero1() {
		return cabecero1;
	}



	public void setCabecero1(Pasantias cabecero1) {
		this.cabecero1 = cabecero1;
	}



	public Date getFechaSituacion() {
		return fechaSituacion;
	}



	public void setFechaSituacion(Date fechaSituacion) {
		this.fechaSituacion = fechaSituacion;
	}



	public EstadosPasantia getEstado() {
		return estado;
	}



	public void setEstado(EstadosPasantia estado) {
		this.estado = estado;
	}

	private void camposCalculados() {
		System.out.println("chaufecha  " + this.getFechaSituacion().toString());
		this.yyyymm.obtenerAnoMes(this.getFechaSituacion());
	}
	
	@PrePersist
	private void antesDeGrabar() {
		this.camposCalculados();
	}


	@PreUpdate
	private void ultimoPaso() {
		this.camposCalculados();
		Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
}
