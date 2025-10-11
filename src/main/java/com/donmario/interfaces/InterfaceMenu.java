package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityMenu;

public interface InterfaceMenu {
public void crearMenu(EntityMenu em);
public ArrayList<EntityMenu> recuperarMenu();
public EntityMenu editarMenu(String id);
public void actualizarMenu(EntityMenu em);
public void eliminarMenu(String id);
}
