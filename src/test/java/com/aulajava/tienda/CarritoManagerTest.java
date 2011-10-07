package com.aulajava.tienda;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CarritoManagerTest {
	@Mock private Map<Producto,Item> items;
	private Item item;
	private Producto producto;
	private CarritoManager manager;
	
	@Before
	public void init(){
	//	items = mock(Map.class);
		MockitoAnnotations.initMocks(this);
		producto = mock(Producto.class);
		item = mock(Item.class);
		manager = new CarritoManager(items);
	}
	
	@Test
	public void testAgregaProductoNuevo(){	
		when(items.get(producto)).thenReturn(null);
		manager.agregar(producto);
		verify(items).put((Producto)anyObject(), (Item)anyObject());
	}
	
	@Test
	public void testAgregaProductoRepetitivo(){
		when(items.get(any())).thenReturn(item);
		manager.agregar(producto);
		verify(item,times(1)).incrementaCantidad();
	}
	
	@Test
	public void testAgregagProductosEnOrden(){
		Producto prod1 = mock(Producto.class);
		Producto prod2 = mock(Producto.class);
		Producto prod3 = mock(Producto.class);
		Producto prod4 = mock(Producto.class);
		
		prod2.setDescripcion("1er producto");
		prod1.setDescripcion("2do producto");
		prod3.setDescripcion("3er producto");

		
		InOrder inOrder = inOrder(prod2,prod1,prod3);
		inOrder.verify(prod2).setDescripcion("1er producto");
		inOrder.verify(prod1).setDescripcion("2do producto");
	
		Item itemx = spy(new Item(mock(Producto.class)));
					
		when(items.get(prod1)).thenReturn(null);
		when(items.get(prod2)).thenReturn(itemx);
		when(items.get(prod3)).thenReturn(itemx);
		
		manager.agregar(prod1);
		manager.agregar(prod2);
		manager.agregar(prod3);
		
	    Assert.assertEquals(3, itemx.getCantidad());
	    verifyZeroInteractions(prod4);
	    
	}
	
	
	
	
	
}
