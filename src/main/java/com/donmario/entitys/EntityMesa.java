package com.donmario.entitys;

public class EntityMesa {
private int mesa_id;
private int capacidad;
private String estado;
private int empleado_id;
public EntityMesa() {
	
}
public int getMesa_id() {
	return mesa_id;
}
public void setMesa_id(int mesa_id) {
	this.mesa_id = mesa_id;
}
public int getCapacidad() {
	return capacidad;
}
public void setCapacidad(int capacidad) {
	this.capacidad = capacidad;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public int getEmpleado_id() {
	return empleado_id;
}
public void setEmpleado_id(int empleado_id) {
	this.empleado_id = empleado_id;
}

}
