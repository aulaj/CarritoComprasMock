package com.aulajava.tienda;

public class Item {

	private int cantidad;
	private Producto producto;

	public Item(Producto producto) {
		this.producto = producto;
		cantidad = 1;
	}

	public void incrementaCantidad() {
		cantidad++;
	}

	public double precioTotalItem(){
		return cantidad * producto.getPrecio();
	}

	public int getCantidad() {
		return cantidad;
	}

	

	
	
	
}