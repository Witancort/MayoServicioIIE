package com.idat.MayoServicioPrueba.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Productos")
@Entity
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	
//	cuando es  una relacion de uno a uno se utiliza el
	// el mappedby en cualquiera de las clases
	
	@OneToOne(mappedBy =  "producto")
	private Proveedor proveedor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "productos_clientes",
			joinColumns = @JoinColumn(
					name = "id_producto", 
					nullable = false, 
					unique =true, 
					foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references Productos(id_producto)")					
			),
			inverseJoinColumns = @JoinColumn(
					name = "id_Cliente", 
					nullable = false, 
					unique =true, 
					foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(id_Cliente) references cliente(id_cliente)")					
			
	))
			
	private List<Cliente> cliente = new ArrayList<>();
	
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
