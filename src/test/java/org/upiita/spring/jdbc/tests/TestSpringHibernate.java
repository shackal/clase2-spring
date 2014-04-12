package org.upiita.spring.jdbc.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.upiita.spring.jdbc.daos.UsuarioDAO;
import org.upiita.spring.jdbc.entidades.Usuario;

public class TestSpringHibernate {

	public static void main(String[] args) {
		//creamos el contexto de Spring
	ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
		
	UsuarioDAO usuarioDAO=	(UsuarioDAO)contexto.getBean("usuarioDAO");
	
	Usuario usuarioNvo= new Usuario();
	
	//definiendo renglon para la tabla 
	usuarioNvo.setUsuaarioId(3);
	usuarioNvo.setNombre("paco");
	usuarioNvo.setPassword("123");
	usuarioNvo.setEmail("paco@mail.com");
	//se cuarda en la tabla
	usuarioDAO.creaUsuario(usuarioNvo);
	//Usuario usuario=usuarioDAO.buscaUsuarioPorId(3);
	//System.out.println("usuario:"+usuario);
	
	Usuario ususarioPorMail= usuarioDAO.buscaPorEmail("juan@email.com");
	System.out.println("Usuario por email"+ususarioPorMail);
	
	
	List<Usuario> usuarios=usuarioDAO.obtenPorNombre("a");
	System.out.println("U(suarios: "+usuarios);
	
	
    
	}

}
