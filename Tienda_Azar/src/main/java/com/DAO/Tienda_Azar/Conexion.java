package com.DAO.Tienda_Azar;

import java.sql.*;

public class Conexion {
	
	// Parametros de conexión
	String bd = "BD_Tienda_Azar";
	String Login = "root";
	String password = "Admin_2021*";
	String url ="jdbc:mysql://localhost/"+bd;
	
	Connection con = null;
	
	//Constructor de conexión
	
	public Conexion()
	{
		try
		{
			//Obtener el driver para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexión
			con = DriverManager.getConnection(url,Login,password);
			if(con != null)
			{
				System.out.println("Conexion a la Base de Datos: "+ bd + "Exitosa");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion: "+ e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error clase no encontrada: "+ e);
		}
		catch(Exception e)
		{
			System.out.println("Error de conexion: "+ e);
		}
	}
	
	// Metodo para retornar la conexion
	public Connection getCon()
	{
		return con;
	}
	
	// Metodo para desconectar
	public void desconectar()
	{
		con = null;
	}

}
