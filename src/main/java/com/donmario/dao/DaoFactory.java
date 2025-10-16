package com.donmario.dao;
import java.sql.Connection;

import com.donmario.interfaces.InterfaceDistrito;
import com.donmario.interfaces.InterfaceEmpleado;
import com.donmario.interfaces.InterfaceMenu;
import com.donmario.interfaces.InterfaceMenuPedido;
import com.donmario.interfaces.InterfaceMesa;
import com.donmario.interfaces.InterfacePedido;
public abstract class DaoFactory {
public static  final int MYSQL = 1;
public static final int SQLSERVER = 2;
public abstract InterfaceMenu getMenu();
public abstract InterfaceDistrito getDistrito();
public abstract InterfaceEmpleado getEmpleado();
public abstract InterfaceMesa getMesa();
public abstract InterfacePedido getPedido();
public abstract InterfaceMenuPedido getMenuPedido();
public static DaoFactory getDaoFactory(int tipo) {
	switch(tipo) {
	case MYSQL : return new DaoMySql();
	default : return null;
	}
}
}
