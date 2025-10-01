package com.donmario.dao;
import com.donmario.connection.*;
import java.sql.Connection;

public class DaoDatabase{
	public static  final int MYSQL = 1;
	public static final int SQLSERVER = 2;
public static Connection getDaoConnection(int db) {
	switch(db) {
	case MYSQL : return ConnectionMySql.getConnection();
	default : return null;
	}
}
}
