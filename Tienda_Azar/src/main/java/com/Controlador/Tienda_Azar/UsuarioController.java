package com.Controlador.Tienda_Azar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.DAO.Tienda_Azar.UsuarioDAO;
import com.DTO.Tienda_Azar.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioVO> listarUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();
		
		return Dao.listaUsuarios();
	}
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioVO persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(persona);
	}
	
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(documento);
	}

}
