package com.donmario.entitys;

public class EntityDistrito {
private int distrito_id;
private String nombre;
public EntityDistrito() {}
public int getDistrito_id() {
	return this.distrito_id;
			}
public String getNombre() {
	return this.nombre;
}
public void setDistrito(int distrito_id) {
	this.distrito_id = distrito_id;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
}
