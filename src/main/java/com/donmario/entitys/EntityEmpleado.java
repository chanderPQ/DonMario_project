package com.donmario.entitys;

public class EntityEmpleado {
private int empleado_id;
private int distrito_id;
private String nombre;
private String apellido;
private String rol;
private String correo;
private String clave;
public EntityEmpleado() {}
public int getEmpleado_id() {
	return empleado_id;
}
public void setEmpleado_id(int empleado_id) {
	this.empleado_id = empleado_id;
}
public int getDistrito_id() {
	return distrito_id;
}
public void setDistrito_id(int distrito_id) {
	this.distrito_id = distrito_id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getRol() {
	return rol;
}
public void setRol(String rol) {
	this.rol = rol;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}

}
