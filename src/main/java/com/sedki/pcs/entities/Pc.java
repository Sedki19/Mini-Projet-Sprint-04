package com.sedki.pcs.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Pc {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPc;
	
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomPc;
	
	@Min(value = 10)
    @Max(value = 10000)
	private Double prixPc;
	
	
	private String Specs;
	
	
	@ManyToOne
	private Marque Marque;



	public Pc() {
		super();
	}
	
	
	public Pc(String nomPc, Double prixPc, String Spces) {
		super();
		this.nomPc = nomPc;
		this.prixPc = prixPc;
		this.Specs = Specs;
	}


	public Long getIdPc() {
		return idPc;
	}
	public void setIdPc(Long idPc) {
		this.idPc = idPc;
	}
	public String getNomPc() {
		return nomPc;
	}
	public void setNomPc(String nomPc) {
		this.nomPc = nomPc;
	}
	public Double getPrixPc() {
		return prixPc;
	}
	public void setPrixPc(Double prixPc) {
		this.prixPc = prixPc;
	}
	public String getSpecs() {
		return Specs;
	}
	public void setSpecs(String Specs) {
		this.Specs = Specs;
	}

	

	public Marque getMarque() {
		return Marque;
	}


	public void setMarque(Marque Marque) {
		this.Marque = Marque;
	}


	@Override
	public String toString() {
		return "Pc [idPc=" + idPc + ", nomPc=" + nomPc + ", prixPc=" + prixPc
				+ ", Specs=" + Specs + "]";
	}
	
	

}
