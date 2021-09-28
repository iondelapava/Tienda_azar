package com.Controlador.Tienda_Azar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_Azar.Conexion;

@SpringBootApplication
public class TiendaAzarApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaAzarApplication.class, args);
		
		//Conexion conn = new Conexion();
		//conn.getCon();
		
	}

}
