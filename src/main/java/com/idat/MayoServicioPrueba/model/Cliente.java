package com.idat.MayoServicioPrueba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idCliente;
	private String cliente; 
	private String celular;
	
	@ManyToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Productos> productos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Item>items = new ArrayList<>();
	
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

}
