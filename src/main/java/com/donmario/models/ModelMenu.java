package com.donmario.models;
import com.donmario.dao.DaoDatabase;
import com.donmario.dao.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		return null;
	}

	@Override
	public EntityMenu editarMenu(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarMenu() {
		// TODO Auto-generated method stub
		
	}

}
