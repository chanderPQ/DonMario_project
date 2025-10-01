package com.donmario.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.donmario.dao.DaoDatabase;
import com.donmario.entitys.EntityDistrito;
import com.donmario.interfaces.InterfaceDistrito;

public class ModelDistrito extends DaoDatabase implements InterfaceDistrito{
private int database;
public ModelDistrito(int database) {
	this.database = database;
}
	@Override
	public void crearDistrito(EntityDistrito ed) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "insert into distrito(nombre) values(?)";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, ed.getNombre());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelDistrito.crearDistrito()");
		}
	}

	@Override
	public ArrayList<EntityDistrito> recuperarDistrito() {
		// TODO Auto-generated method stub
		ArrayList<EntityDistrito> ld = new ArrayList<>();
		try {
			String sentencia = "select * from distrito";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	EntityDistrito ed = new EntityDistrito();
		    	ed.setDistrito(rs.getInt(1));
		    	ed.setNombre(rs.getString(2));
		    	ld.add(ed);
		    }
		}
		catch(Exception e) {
			System.out.print("Hubo un problema con ModelDistrito.recuperarDistrito()");
		}
		return ld;
	}

	@Override
	public void actualizarDistrito(EntityDistrito ed) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "update distrito set nombre=? where distrito_id = ?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, ed.getNombre());
			ps.setInt(2,ed.getDistrito_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelDistrito.actualizarDistrito()");
		}
	}

	@Override
	public void eliminarDistrito(int distrito_id) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "delete from distrito where distrito_id = ?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, distrito_id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelDistrito.eliminarDistrito()");
		}
	}

	@Override
	public EntityDistrito editarDistrito(int distrito_id) {
		// TODO Auto-generated method stub
		EntityDistrito ed = new EntityDistrito();
		try {
			String sentencia = "select * from distrito where distrito_id=?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, distrito_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ed.setDistrito(rs.getInt(1));
				ed.setNombre(rs.getString(2));
			}
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelDistrito.editarDistrito()");
		}
		return ed;
	}

}
