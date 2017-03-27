package biz.lcompras.model;

import java.util.*;
import java.util.Date;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Anomes {

	@ReadOnly
	@Column(length=6,nullable=true,name="KAN_YYYYMM")
	private Long yyyymm ;

	public Long getYyyymm() {
		return yyyymm;
	}

	
	public void setYyyymm(Long yyyymm) {
		this.yyyymm = yyyymm;
	}
	
	
	public Long obtenerAnoMes (Date mifecha) {
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(mifecha);
	    int anofeliz = cal.get(Calendar.YEAR); 
	    int mesfeliz = cal.get(Calendar.MONTH) + 1;
	    
	    this.yyyymm = (long) (anofeliz * 100 + mesfeliz) ;
		return yyyymm ;
	}
}
