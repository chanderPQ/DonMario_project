package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityMesa;

public interface InterfaceMesa {
public void crearMesa(EntityMesa em);
public ArrayList<EntityMesa> leerMesa();
public void actualizarMesa(EntityMesa em);
public void eliminarMesa(int mesa_id);
public EntityMesa editarMesa(int mesa_id);
}
