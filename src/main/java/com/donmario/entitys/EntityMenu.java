package com.donmario.entitys;

public class EntityMenu {
private String menu_id;
private String empleado_id;
private String nombre;
private double costo;
public EntityMenu() {}
public String getMenu_id() {
	return menu_id;
}
public void setMenu_id(String menu_id) {
	this.menu_id = menu_id;
}
public String getEmpleado_id() {
	return empleado_id;
}
public void setEmpleado_id(String empleado_id) {
	this.empleado_id = empleado_id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getCosto() {
	return costo;
}
public void setCosto(double costo) {
	this.costo = costo;
}


}
