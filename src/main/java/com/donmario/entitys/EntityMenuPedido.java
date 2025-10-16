package com.donmario.entitys;

public class EntityMenuPedido 
{
	private String menu_id;
	private String pedido_id;
	private int cantidad;
	public EntityMenuPedido() 
	{
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(String pedido_id) {
		this.pedido_id = pedido_id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
