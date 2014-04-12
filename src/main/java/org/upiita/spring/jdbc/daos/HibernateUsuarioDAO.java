package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Usuario;

@Component("usuarioDAO")
public class HibernateUsuarioDAO implements UsuarioDAO {
	//clase de utileria hibernate
	
	@Autowired
   private SessionFactory sessionFactory;
	
	public Usuario buscaUsuarioPorId(Integer usuarioId) {
	
       Session session= sessionFactory.openSession();
       
       session.beginTransaction();
   
        Usuario usuario=  (Usuario)session.get(Usuario.class, usuarioId);
   
       //sessionFactory.getCurrentSession().getTransaction().commit();
       
   //termina la transaccion
   session.getTransaction().commit();
  // cerramos session de hibernate
   session.close();
        
		return usuario;
	}

	
	public void creaUsuario(Usuario usuario) {
		  Session session= sessionFactory.openSession();
	     
	       session.beginTransaction();
	      
	        session.save(usuario);
	       
	   //termina la transaccion
	   session.getTransaction().commit();
	  // cerramos session de hibernate
	   session.close();
		

	}
	
	
	public Usuario buscaPorEmail(String email){
		 Session session= sessionFactory.openSession();
	       
	       session.beginTransaction();
	     //inicia transaccion
	       Criteria criterio = session.createCriteria(Usuario.class);
	       criterio.add(Restrictions.eq("email", email));
	       
	       //si se regresa un solo entidad
	      Usuario usuario= (Usuario) criterio.uniqueResult();
	       
	       
	   session.getTransaction().commit();
	  // cerramos session de hibernate
	   session.close();
		
		return usuario;
	}
	
	
	public List<Usuario> obtenPorNombre(String nombre){
		Session session= sessionFactory.openSession();
	       
	       session.beginTransaction();
	     //inicia transaccion
	       Criteria criterio = session.createCriteria(Usuario.class);
	      
	       criterio.add(Restrictions.not( Restrictions.like("nombre","%"+nombre+"%")));
	      
	       List<Usuario> usuarios= criterio.list();
	       
	       
	   session.getTransaction().commit();
	  // cerramos session de hibernate
	   session.close();
	
		return usuarios;
	}
	
	
	
    
}
