package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityMenu;

public interface InterfaceMenu {
public void crearMenu(EntityMenu em);
public ArrayList<EntityMenu> recuperarMenu();
public EntityMenu editarMenu(int id);
public void actualizarMenu();
public void eliminarMenu();
}
