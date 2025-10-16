package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityMenuPedido;

public interface InterfaceMenuPedido {
public void crearMenuPedido(EntityMenuPedido emp);
public ArrayList<EntityMenuPedido> leerMenuPedido(String pedido_id);
public void actualizarMenuPedido(EntityMenuPedido emp);
public void eliminarMenuPedido(String menu_id, String pedido_id);
public EntityMenuPedido editarMenuPedido(String menu_id, String pedido_id);
}
