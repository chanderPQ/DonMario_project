package com.donmario.models;
import com.donmario.dao.DaoDatabase;
import com.donmario.dao.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.donmario.entitys.EntityMenu;
import com.donmario.interfaces.InterfaceMenu;

public class ModelMenu extends DaoDatabase  implements InterfaceMenu{
	public int database;
	public ModelMenu(int db) {
		this.database = db;
	}
	@Override
	public void crearMenu(EntityMenu em) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "insert into menu(empleado_id,nombre,costo) values(?,?,?)";
			System.out.print("la base de datos es :"+database);
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setInt(1, em.getEmpleado_id());
		ps.setString(2, em.getNombre());
		ps.setDouble(3, em.getCosto());
		ps.executeUpdate();
		System.out.print("Menu creado");
		}
		catch(Exception e) {
			System.out.print("hubo un probelma con ModelMenu.crearMenu()");
		}
	}

	@Override
	public ArrayList<EntityMenu> recuperarMenu() {
		// TODO Auto-generated method stub
		ArrayList<EntityMenu> menus = new ArrayList<>();
		try {
			String sentencia = "select * from menu";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EntityMenu em = new EntityMenu();
				em.setEmpleado_id(rs.getInt("empleado_id"));
				em.setMenu_id(rs.getInt("menu_id"));
				em.setNombre(rs.getString("nombre"));
				em.setCosto(rs.getDouble("costo"));
				menus.add(em);
			}
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelMenu.recuperarMenu()");
		}
		return menus;
	}

	@Override
	public EntityMenu editarMenu(int id) {
		// TODO Auto-generated method stub
		EntityMenu em = new EntityMenu();
		try {
			String sentencia = "select * from menu where menu_id = ? ";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				em.setEmpleado_id(rs.getInt("empleado_id"));
				em.setMenu_id(rs.getInt("menu_id"));
				em.setNombre(rs.getString("nombre"));
				em.setCosto(rs.getDouble("costo"));
			}
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelMenu.editarMenu()");
		}
		return em;
	}

	@Override
	public void actualizarMenu(EntityMenu em) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "update menu set nombre=?, costo=? where menu_id=?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, em.getNombre());
			ps.setDouble(2, em.getCosto());
			ps.setInt(3, em.getMenu_id());
			ps.executeUpdate();	
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelMenu.actualizarMenu()");
		}
	}

	@Override
	public void eliminarMenu(int id) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "delete from menu where menu_id = ? ";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelMenu.eliminarMenu()");
		}
	}

}
