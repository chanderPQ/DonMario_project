package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityEmpleado;

public interface InterfaceEmpleado {
public void crearEmpleado(EntityEmpleado ee);
public ArrayList<EntityEmpleado> recuperarEmpleado();
public void actualizarEmpleado(EntityEmpleado ee);
public void eliminarEmpleado(int empleado_id);
public EntityEmpleado editarEmpleado(int empleado_id);
}
