package com.DAO.Tienda_Azar;

import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_Azar.UsuarioVO;

// Permite acceso a la base de datos
public class UsuarioDAO {
	
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_USUARIOS");
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				miLista.add(persona);
				
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error Usuario No Encontrado: "+ e);
		}
		return miLista;
	}
	
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_USUARIOS WHERE Cedula_Usu = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				miLista.add(persona);
				
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error Usuario No Encontrado: "+ e);
		}
		return miLista;
	}
	
	public ArrayList<UsuarioVO> registrarUsuario(UsuarioVO persona)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios Values('"+persona.getCedula()+"','"+
					persona.getNombre()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"+
					persona.getClave()+"')");
			System.out.println("El usuario ha sido adicionado");
			stmt.close();
			con.desconectar();
		
		}
		catch(Exception e)
		{
			System.out.println("Error de conexion: "+ e);
		}
		return miLista;
	}
	
	
	//Eliminar
	public ArrayList<UsuarioVO> eliminarUsuario(int documento)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_USUARIOS WHERE Cedula_Usu = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				miLista.add(persona);
				
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error Usuario No Encontrado: "+ e);
		}
		return miLista;
	}

}
