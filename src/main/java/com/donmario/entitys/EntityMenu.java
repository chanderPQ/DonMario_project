package com.donmario.entitys;

public class EntityMenu {
private int menu_id;
private int empleado_id;
private String nombre;
private double costo;
public EntityMenu() {}
public int getMenu_id() {
	return menu_id;
}
public void setMenu_id(int menu_id) {
	this.menu_id = menu_id;
}
public int getEmpleado_id() {
	return empleado_id;
}
public void setEmpleado_id(int empleado_id) {
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
