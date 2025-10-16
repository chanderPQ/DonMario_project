package com.donmario.entitys;

public class EntityPedido {
private String pedido_id;
private String empleado_id;
private String mesa_id;
private String estado;
public EntityPedido() {}
public String getPedido_id() {
	return pedido_id;
}
public void setPedido_id(String pedido_id) {
	this.pedido_id = pedido_id;
}
public String getEmpleado_id() {
	return empleado_id;
}
public void setEmpleado_id(String empleado_id) {
	this.empleado_id = empleado_id;
}
public String getMesa_id() {
	return mesa_id;
}
public void setMesa_id(String mesa_id) {
	this.mesa_id = mesa_id;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}

}
