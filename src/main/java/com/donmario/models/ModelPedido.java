package com.donmario.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.donmario.dao.DaoDatabase;
import com.donmario.entitys.EntityPedido;
import com.donmario.interfaces.InterfacePedido;

public class ModelPedido extends DaoDatabase implements InterfacePedido {
private int database;
public ModelPedido(int db) {
	this.database = db;
}
@Override
public void crearPedido(EntityPedido ep) {
	// TODO Auto-generated method stub
	try {
		String sentencia = "insert into pedido values(?,?,?,?)";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setString(1, ep.getPedido_id());
		ps.setString(2, ep.getEstado());
		ps.setString(3, ep.getEmpleado_id());
		ps.setString(4, ep.getMesa_id());
		ps.executeUpdate();
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelPedido.crearPedido()");
	}
}
@Override
public ArrayList<EntityPedido> leerPedido() {
	// TODO Auto-generated method stub
	ArrayList<EntityPedido> lp = new ArrayList();
	try {
		String sentencia = "select * from pedido";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		EntityPedido ep = new EntityPedido();
		ep.setEmpleado_id(rs.getString("empleado_id"));
		ep.setMesa_id(rs.getString("mesa_id"));
		ep.setPedido_id(rs.getString("pedido_id"));
		ep.setEstado(rs.getString("estado"));
		lp.add(ep);
		}
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelPedido.leerPedido()");
	}
	return lp;
}
@Override
public void actualizarPedido(EntityPedido ep) {
	// TODO Auto-generated method stub
	try {
		String sentencia = "update pedido set empleado_id=?, mesa_id=?, estado=? where pedido_id=? ";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setString(1, ep.getEmpleado_id());
		ps.setString(2, ep.getMesa_id());
		ps.setString(3, ep.getEstado());
		ps.setString(4, ep.getPedido_id());
		ps.executeUpdate();
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelPedido.actualizarPedido()");
	}
}
@Override
public void eliminarPedido(String pedido_id) {
	// TODO Auto-generated method stub
	try {
		String sentencia = "delete from pedido where pedido_id=?";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setString(1, pedido_id);
		ps.executeUpdate();
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelPedido.eliminarPedido()");
	}
}
@Override
public EntityPedido editarPedido(String pedido_id) {
	// TODO Auto-generated method stub
	EntityPedido ep = new EntityPedido();
	try {
		String sentencia = "select * from pedido where pedido_id=?";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setString(1, pedido_id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		ep.setEmpleado_id(rs.getString("empleado_id"));
		ep.setMesa_id(rs.getString("mesa_id"));
		ep.setPedido_id(rs.getString("pedido_id"));
		ep.setEstado(rs.getString("estado"));
		}
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelPedido.editarPedido()");
	}
	return ep;
}

}
