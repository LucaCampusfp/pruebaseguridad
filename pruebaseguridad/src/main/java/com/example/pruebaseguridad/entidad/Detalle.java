package com.example.pruebaseguridad.entidad;

import jakarta.persistence.*;



@Entity
public class Detalle {

	@Id
	private int id;

	private float precio;

	private int unidades;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="NUMERO")
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="CODIGO")
	private Producto producto;

	public Detalle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return this.unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}