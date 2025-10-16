package com.donmario.dao;

import com.donmario.interfaces.InterfaceDistrito;
import com.donmario.interfaces.InterfaceEmpleado;
import com.donmario.interfaces.InterfaceMenu;
import com.donmario.interfaces.InterfaceMenuPedido;
import com.donmario.interfaces.InterfaceMesa;
import com.donmario.interfaces.InterfacePedido;
import com.donmario.models.ModelDistrito;
import com.donmario.models.ModelEmpleado;
import com.donmario.models.ModelMenu;
import com.donmario.models.ModelMenuPedido;
import com.donmario.models.ModelMesa;
import com.donmario.models.ModelPedido;

public class DaoMySql extends DaoFactory {

@Override
public InterfaceMenu getMenu() {
	// TODO Auto-generated method stub
	return new ModelMenu(DaoFactory.MYSQL);
}

@Override
public InterfaceDistrito getDistrito() {
	// TODO Auto-generated method stub
	return new ModelDistrito(DaoFactory.MYSQL);
}

@Override
public InterfaceEmpleado getEmpleado() {
	// TODO Auto-generated method stub
	return new ModelEmpleado(DaoFactory.MYSQL);
}

@Override
public InterfaceMesa getMesa() {
	// TODO Auto-generated method stub
	return new ModelMesa(DaoFactory.MYSQL);
}

@Override
public InterfacePedido getPedido() {
	// TODO Auto-generated method stub
	return new ModelPedido(DaoFactory.MYSQL);
}

@Override
public InterfaceMenuPedido getMenuPedido() {
	// TODO Auto-generated method stub
	return new ModelMenuPedido(DaoFactory.MYSQL);
}
}
