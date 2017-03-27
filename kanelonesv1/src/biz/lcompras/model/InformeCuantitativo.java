package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="KAN_INFORMECUANTITATIVO"
 , uniqueConstraints={
		 @UniqueConstraint(name="KAN_INFORME_DUPLICADA", columnNames={"IDINFORMEMENSUAL_ID","IDACTIVIDAD_ID"})        
 }
)
@Tab(properties="cabecero.orientador.nombreOrientador,actividad.nombreActividad,tarea")
public class InformeCuantitativo extends SuperClaseFeliz {
	
	@ManyToOne
	@JoinColumn(name="IDINFORMEMENSUAL_ID")
	private InformesMensuales cabecero ;
	
	@Required
	@DescriptionsList(descriptionProperties="nombreActividad")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDACTIVIDAD_ID", referencedColumnName="ID")
	private Actividades actividad;
	
	@Required
	@Column(length=60,nullable=false,name="KAN_TAREA")
	private String tarea;
	
	@Required
	@Column(length=80,nullable=false,name="KAN_ORGANIZADOR")
	private String organizador;	

	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(length=4,name="CANTIDAD",nullable=false)
	private Long cantidad;

	@Required
	@DescriptionsList(descriptionProperties="lugar")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDLUGAR_ID", referencedColumnName="ID")
	private LugaresDeAtencion lugar;
	
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_EJECUTORVARON",nullable=false,length=4)
	private Long ejecutorVaron;

	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_EJECUTORMUJER",nullable=false,length=4)
	private Long ejecutorMujer;


	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_QINSTITUCIONES",nullable=false,length=4)
	private Long cantidadInstitucionesBeneficiadas;

	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_QBENEFICIARIOSVARON",nullable=false,length=4)
	private Long cantidadBeneficiariosVaron;

	@Range(min=0)
	@DefaultValueCalculator(CeroFelizLong.class)
	@Column(name="KAN_QBENEFICIARIOSMUJER",nullable=false,length=4)
	private Long cantidadBeneficiariosMujer;

	@Stereotype("MEMO")
	@Column(length=500,nullable=true,name="KAN_OBSERVACION")
	private String observacion;
	

	public InformesMensuales getCabecero() {
		return cabecero;
	}


	public void setCabecero(InformesMensuales cabecero) {
		this.cabecero = cabecero;
	}


	public Actividades getActividad() {
		return actividad;
	}


	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}


	public String getTarea() {
		return tarea;
	}


	public void setTarea(String tarea) {
		this.tarea = tarea.toUpperCase().trim();
	}


	
	public String getOrganizador() {
		return organizador;
	}


	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}


	public Long getCantidad() {
		return cantidad;
	}


	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public LugaresDeAtencion getLugar() {
		return lugar;
	}


	public void setLugar(LugaresDeAtencion lugar) {
		this.lugar = lugar;
	}


	public Long getEjecutorVaron() {
		return ejecutorVaron;
	}


	public void setEjecutorVaron(Long ejecutorVaron) {
		this.ejecutorVaron = ejecutorVaron;
	}


	public Long getEjecutorMujer() {
		return ejecutorMujer;
	}


	public void setEjecutorMujer(Long ejecutorMujer) {
		this.ejecutorMujer = ejecutorMujer;
	}


	public Long getCantidadInstitucionesBeneficiadas() {
		return cantidadInstitucionesBeneficiadas;
	}


	public void setCantidadInstitucionesBeneficiadas(Long cantidadInstitucionesBeneficiadas) {
		this.cantidadInstitucionesBeneficiadas = cantidadInstitucionesBeneficiadas;
	}


	public Long getCantidadBeneficiariosVaron() {
		return cantidadBeneficiariosVaron;
	}


	public void setCantidadBeneficiariosVaron(Long cantidadBeneficiariosVaron) {
		this.cantidadBeneficiariosVaron = cantidadBeneficiariosVaron;
	}


	public Long getCantidadBeneficiariosMujer() {
		return cantidadBeneficiariosMujer;
	}


	public void setCantidadBeneficiariosMujer(Long cantidadBeneficiariosMujer) {
		this.cantidadBeneficiariosMujer = cantidadBeneficiariosMujer;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
	
	
	@PreUpdate
	private void ultimoPaso() {	
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		


}
