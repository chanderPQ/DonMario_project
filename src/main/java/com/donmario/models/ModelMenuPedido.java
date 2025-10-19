package com.donmario.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.donmario.dao.DaoDatabase;
import com.donmario.entitys.EntityMenuPedido;
import com.donmario.interfaces.InterfaceMenuPedido;

public class ModelMenuPedido extends DaoDatabase implements InterfaceMenuPedido {
	private int database;
	public ModelMenuPedido(int db) {
	this.database = db;
	}
	@Override
	public void crearMenuPedido(EntityMenuPedido emp) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "insert into menu_pedido values(?,?,?)";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, emp.getMenu_id());
			ps.setString(2, emp.getPedido_id());
			ps.setInt(3, emp.getCantidad());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMenuPedido.crearMenuPedido()");
		}
	}
	@Override
	public ArrayList<EntityMenuPedido> leerMenuPedido(String pedido_id) {
		// TODO Auto-generated method stub
		ArrayList<EntityMenuPedido> lmp = new ArrayList<>();
		try {
			String sentencia = "select pedido_id , menu.menu_id , nombre, cantidad from menu_pedido inner join menu on menu_pedido.menu_id=menu.menu_id where pedido_id = ? ";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, pedido_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EntityMenuPedido emp = new EntityMenuPedido();
				emp.setMenu_id(rs.getString("menu.menu_id"));
				emp.setPedido_id(rs.getString("pedido_id"));
				emp.setCantidad(rs.getInt("cantidad"));
				emp.setNombre(rs.getString("nombre"));
				lmp.add(emp);
			}
		}
		catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelMenuPedido.leerMenuPedido()");
		}
		return lmp;
	}
	@Override
	public void actualizarMenuPedido(EntityMenuPedido emp) {
		// TODO Auto-generated method stub
	try {
		String sentencia = "update menu_pedido set cantidad=? where menu_id=? and pedido_id=?";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setInt(1, emp.getCantidad());
		ps.setString(2, emp.getMenu_id());
		ps.setString(3, emp.getPedido_id());
		ps.executeUpdate();
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelMenuPedido.actualizarMenuPedido()");
	}
	}
	@Override
	public void eliminarMenuPedido(String menu_id, String pedido_id) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "delete from menu_pedido where menu_id=? and pedido_id=?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, menu_id);
			ps.setString(2, pedido_id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMenuPedido.eliminarMenuPedido()");
		}
	}
	@Override
	public EntityMenuPedido editarMenuPedido(String menu_id, String pedido_id) {
		// TODO Auto-generated method stub
		EntityMenuPedido emp = new EntityMenuPedido();
		try {
		String sentencia ="	select pedido_id , menu.menu_id , nombre, cantidad from menu_pedido inner join menu on menu_pedido.menu_id=menu.menu_id where menu_pedido.menu_id=? and menu_pedido.pedido_id=?"; 
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, menu_id);
			ps.setString(2, pedido_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp.setMenu_id(rs.getString("menu_id"));
				emp.setPedido_id(rs.getString("pedido_id"));
				emp.setCantidad(rs.getInt("cantidad"));
				emp.setNombre(rs.getString("nombre"));
			}
		}
		catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelMenuPedido.leerMenuPedido()");
		}
		return emp;
	}
}
