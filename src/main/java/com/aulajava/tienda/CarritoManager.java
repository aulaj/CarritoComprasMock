package com.aulajava.tienda;

import java.util.Map;

public class CarritoManager {
	
	Map<Producto, Item> items;
	
	
	public CarritoManager(Map<Producto, Item> items) {
		this.items = items;
	}

	public void agregar(Producto producto){
		Item item = items.get(producto);
		if(item != null){
			item.incrementaCantidad();
		}else{
			items.put(producto, new Item(producto));
		}
	}
	
}
