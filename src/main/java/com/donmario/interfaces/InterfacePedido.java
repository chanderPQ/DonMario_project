package com.donmario.interfaces;

import java.util.ArrayList;

import com.donmario.entitys.EntityPedido;

public interface InterfacePedido {
public void crearPedido(EntityPedido ep);
public ArrayList<EntityPedido> leerPedido();
public void actualizarPedido(EntityPedido ep);
public void eliminarPedido(String pedido_id);
public EntityPedido editarPedido(String pedido_id);
}
