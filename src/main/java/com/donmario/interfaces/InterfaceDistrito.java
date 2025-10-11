package com.donmario.interfaces;
import java.util.ArrayList;

import com.donmario.entitys.EntityDistrito;
public interface InterfaceDistrito {
public void crearDistrito(EntityDistrito ed);
public ArrayList<EntityDistrito> recuperarDistrito();
public void actualizarDistrito(EntityDistrito ed);
public void eliminarDistrito(String distrito_id);
public EntityDistrito editarDistrito(String distrito_id);
}
