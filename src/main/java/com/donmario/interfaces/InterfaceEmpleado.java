package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityEmpleado;

public interface InterfaceEmpleado {
public void crearEmpleado(EntityEmpleado ee);
public ArrayList<EntityEmpleado> recuperarEmpleado();
public void actualizarEmpleado(EntityEmpleado ee);
public void eliminarEmpleado(String empleado_id);
public EntityEmpleado editarEmpleado(String empleado_id);
}
