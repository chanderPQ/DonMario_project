package com.donmario.dao;

import com.donmario.interfaces.InterfaceDistrito;
import com.donmario.interfaces.InterfaceEmpleado;
import com.donmario.interfaces.InterfaceMenu;
import com.donmario.models.ModelDistrito;
import com.donmario.models.ModelEmpleado;
import com.donmario.models.ModelMenu;

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

}
