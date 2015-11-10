package org.sakaiproject.upv2.dao.impl;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.hibernate.Transaction;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.sakaiproject.upv2.model.Asignatura;
import org.sakaiproject.upv2.model.Encuestas;
import org.sakaiproject.upv2.model.Sitio;
import org.sakaiproject.upv2.model.Telde;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Vector;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import org.sakaiproject.upv2.logic.SakaiUpvService;

public class SakaiUpvServiceHibernateImpl extends HibernateDaoSupport implements SakaiUpvService {

	public Sitio getSitio(String id) throws Exception {
		return (Sitio) this.getHibernateTemplate().load(Sitio.class,new Long(id));
	}	

	public Asignatura getAsignatura(String id) throws Exception {
		return (Asignatura) this.getHibernateTemplate().load(Asignatura.class,new Long(id));
	}	
	
	public List getAllAsignaturas() throws Exception {
		List l = null;
		try {
		HibernateTemplate p = this.getHibernateTemplate();		
		l = (List) p.loadAll(Asignatura.class);
		//l = (List) getAsignaturaByCodigo2("2");
		}
		catch (Exception e) {
			e.printStackTrace();
		};
		return l;		
	};
    
	public List getAsignaturas(final String propietario,final String codigo,final String nombre) {
	    if (codigo == null && nombre==null)
	    {
	      //throw new IllegalArgumentException("Null Argument");
	      return null;
	    }
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	    	if (codigo!=null) {   
	           Query q = session.getNamedQuery("findAsignaturaByCodigo");                
	           q.setParameter("codigo",codigo, Hibernate.STRING);              
	           q.setParameter("propietario",propietario, Hibernate.STRING);
	           return q.list();
	    	};
	    	if (nombre!=null) {   
		           Query q = session.getNamedQuery("findAsignaturaByNombre");
		           q.setParameter("propietario",propietario, Hibernate.STRING);
		           q.setParameter("nombre",nombre, Hibernate.STRING);                   
		           return q.list();
		    	};
		   return null; 	
	      }
	    };
	        
	    return (List) getHibernateTemplate().execute(hcb);
    }

	  public List getSitiosByAsi(final String asignatura)
	  {
	    if (asignatura == null)
	    {
	      throw new IllegalArgumentException("Null Argument");
	    }
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	        Query q = session.getNamedQuery("findSitiosByAsi");                
	        q.setParameter("asignatura",asignatura, Hibernate.STRING);                   
	        return q.list();
	      }
	    };
	        
	    return (List) getHibernateTemplate().execute(hcb);
	  }

	  public List getSitiosByProfPropietario(final String userid,final String propietario)
	  {
	    if (userid == null || propietario==null)
	    {
	      throw new IllegalArgumentException("Null Argument");
	    }
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	        Query q = session.getNamedQuery("findSitiosByProfPropietario");        
	        q.setParameter("propietario",propietario, Hibernate.STRING);	        
	        q.setParameter("userid",userid, Hibernate.STRING);                   
	        return q.list();
	      }
	    };
	        
	    return (List) getHibernateTemplate().execute(hcb);
	  }	  
	
	  public List getAsignaturaByCodigo(final String codigo)
	  {
	    if (codigo == null)
	    {
	      throw new IllegalArgumentException("Null Argument");
	    }
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	        Query q = session.getNamedQuery("findAsignaturaByCodigo");                
	        q.setParameter("codigo",codigo, Hibernate.STRING);                   
	        return q.list();
	      }
	    };
	        
	    return (List) getHibernateTemplate().execute(hcb);
	  }
	  
	  public List getAsignaturaByCodigo2(final String codigo) throws Exception
	  {
	    if (codigo == null)
	    {
	      throw new IllegalArgumentException("Null Argument");
	    }      	    
	        Query q = this.getSession().getNamedQuery("findAsignaturaByCodigo");                
	        q.setParameter("codigo",codigo, Hibernate.STRING);                   
	        return (List) q.list();
	  }		  

	  public List getComposicionesByProp(final String propietario)
	  {
	    if (propietario == null)
	    {
	      throw new IllegalArgumentException("Null Argument");
	    }
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	        Query q = session.getNamedQuery("findComposicionesByProp");                
	        q.setParameter("propietario",propietario, Hibernate.STRING);                   
	        return q.list();
	      }
	    };
	    return (List) getHibernateTemplate().execute(hcb);
	  }	  
	  
	  public List getTeldesByAsi(final String asignatura)
	  {
	    if (asignatura == null)
	    {
	      throw new IllegalArgumentException("Null Argument");
	    }
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	        Query q = session.getNamedQuery("findTeldesByAsi");                
	        q.setParameter("asignatura",asignatura, Hibernate.STRING);                   
	        return q.list();
	      }
	    };
	    return (List) getHibernateTemplate().execute(hcb);
	  }
	  
	  public void saveTelde(Telde telde) {
		  this.getHibernateTemplate().saveOrUpdate(telde);		  
		  try {		      
			  this.getSession().flush();
			  this.getSession().connection().commit();
		  }
		  catch (Exception e) {e.printStackTrace();};
	  }
	  
	  public String sincronizarSitio(Sitio site) {
		 String resultado="";
		 try {
			 //Sitio ss=this.getSitio(site.getCodigo().toString());
			 // System.out.println("ss:"+ss.getBiblio()+"site:"+site.getBiblio());
			 this.getSession().beginTransaction();
			 this.getHibernateTemplate().saveOrUpdate(site);
			 //Obtenemos la conexi�n de Hibernate 
		     Connection con=this.getSession().connection();
		     //Preparamos la ejecuci�n (OJO: el call debe estar en min�sculas)
		     CallableStatement cs;
		     cs=con.prepareCall("{?=call SAK_SINCRO_PCK.UPDATE_SITE(?)}");
		     cs.registerOutParameter(1, Types.VARCHAR);
		     cs.setString(2,site.getCodigo().toString());		     
		     //Ejecutamos la funci�n
		     cs.execute();
		     resultado = cs.getString(1);
		     //Analizamos lo que nos viene
			 if (resultado.equals("OK"))
			    {this.getSession().flush();
			     con.commit();
				 return resultado;} 
			 else {//this.saveSitio(ss);
			       //site=ss;
		               //   this.getSession().flush();		   
			       //con.commit();
                               con.rollback();
				   System.out.println("UPVERROR Ejecutando SAK_SINCRO_PCK.UPDATE_SITE."+resultado);
				   return "UPVERROR Ejecutando SAK_SINCRO_PCK.UPDATE_SITE "+resultado;
			      }		 		     
		 }catch (Exception e) {	 
		  System.out.println("UPVERROR: Error Ejecutando Procedimineto de Sincronizaci�n."+resultado);
		  e.printStackTrace();
		  return "UPVERROR Ejecutando SAK_SINCRO_PCK.SITE_DESDE_SAKAI";
		 }
	  }	  
	  
	  public void saveSitio(Sitio site) {
		  this.getHibernateTemplate().saveOrUpdate(site);		  
	  }	  

	  public void delTelde(Telde telde) {
		  this.getHibernateTemplate().delete(telde);
	  }
	  
	  public List executeSql(final String sql)
	  {
	          
	    HibernateCallback hcb = new HibernateCallback()
	    {
	      public Object doInHibernate(Session session) throws HibernateException,SQLException
	      {
	        Query q = session.createQuery(sql);                
	        return q.list();
	      }
	    };
	        
	    return (List) getHibernateTemplate().execute(hcb);
	  }
	  
//	Encuestas
	  public List loadEncuestasByCodigoSite(final String codigo_site) throws Exception {
		       if (codigo_site == null)
			    {
			      throw new IllegalArgumentException("Null Argument");
			    }
			          
			    HibernateCallback hcb = new HibernateCallback()
			    {
			      public Object doInHibernate(Session session) throws HibernateException,SQLException
			      {
			        Query q = session.getNamedQuery("findEncuestasByCodigoSiteSakai");                
			        q.setParameter("codigoSiteSakai",codigo_site, Hibernate.STRING);                   
			        return q.list();
			      }
			    };
			    return (List) getHibernateTemplate().execute(hcb);
    	}
		public List loadEncuestasByCodigoSites(Vector sites) throws Exception {
			String[] ssites = new String[sites.size()];
			Type[] tipos = new Type[sites.size()];
			String parametros = "?";
			for(int i=0;i<sites.size();i++) {
				ssites[i] = (String) sites.get(i);
				tipos[i] = Hibernate.STRING;
				if(i!=0) {
					parametros = parametros + ",?";
				}			
	 		}
			parametros = parametros + ")";
			//List l = (List) this.getHibernateTemplate().find("from org.sakaiproject.upv.bean.Encuestas as pase where pase.codigoSiteSakai in ("+parametros,ssites,tipos);
			List l = null;
			return l;
		}
		
		public boolean insertEncuesta(int idPase, String codigo_site_sakai, String codigo_sakai, String codigo_grupo_sakai) throws Exception {
			if(idPase>0 && codigo_site_sakai!=null && codigo_sakai!=null) {
				Encuestas enc = new Encuestas();
				enc.setIdPase(idPase);
				enc.setCodigoSiteSakai(codigo_site_sakai);
				enc.setLoginCreador(codigo_sakai);
				if(codigo_grupo_sakai!=null) enc.setCodigoGrupoSakai(codigo_grupo_sakai);
				//Modificacion por peticion de Raul, se ve que habia un bloqueo en la base de datos.
				try {		      
					Session session = this.getSession();
					Transaction tx = session.beginTransaction();
					session.saveOrUpdate(enc);
					session.flush(); 
					session.connection().commit();
					tx.commit();
				}catch (Exception e) {
					e.printStackTrace();
				};
				
				return true;
			}				
			return false;
		}
		
/*		public boolean insertEncuesta(int idPase, String codigo_site_sakai, String codigo_sakai, String codigo_grupo_sakai) throws Exception {
				 String resultado="";
				 Encuestas enc = new Encuestas();
				if(idPase>0 && codigo_site_sakai!=null && codigo_sakai!=null) {
					enc.setIdPase(idPase);
					enc.setCodigoSiteSakai(codigo_site_sakai);
					enc.setLoginCreador(codigo_sakai);
					if(codigo_grupo_sakai!=null) enc.setCodigoGrupoSakai(codigo_grupo_sakai);					 
					 try {
						 //Sitio ss=this.getSitio(site.getCodigo().toString());
						 // System.out.println("ss:"+ss.getBiblio()+"site:"+site.getBiblio());
						 this.getSession().beginTransaction();
						 this.getHibernateTemplate().saveOrUpdate(enc);
						 //Obtenemos la conexi�n de Hibernate 
					     Connection con=this.getSession().connection();
					     resultado = "OK";
					     //Preparamos la ejecuci�n (OJO: el call debe estar en min�sculas)
					     CallableStatement cs;
					     cs=con.prepareCall("{?=call SAK_SINCRO_PCK.INSERTAR_ENCUESTA(?,?,?,?)}");
					     cs.registerOutParameter(1, Types.VARCHAR);
					     cs.setString(2, new Integer(idPase).toString());		     
					     cs.setString(3,codigo_site_sakai);		     
					     cs.setString(4,codigo_sakai);		     
					     cs.setString(5,codigo_grupo_sakai);		     
					     //Ejecutamos la funci�n
					     cs.execute();
					     resultado = cs.getString(1);
					     
					     //Analizamos lo que nos viene
						 if (resultado.equals("OK"))
						    {
							 this.getSession().flush();
						     con.commit();
							 return true;
							 } 
						 else {//this.saveSitio(ss);
						       //site=ss;
					               //   this.getSession().flush();		   
						       //con.commit();
			                               con.rollback();
							   System.out.println("UPVERROR Ejecutando SAK_SINCRO_PCK.INSERTAR_ENCUESTA."+resultado);
							   return false;
						      }
					 }catch (Exception e) {	 
					  System.out.println("UPVERROR: Error Ejecutando Procedimineto de Sincronizaci�n."+resultado);
					  e.printStackTrace();
					  return false;
					 }
				}
				return false;
			 }			
		
*/		
		public List loadSitiosBySakaiCodigo(final String codigo_site_sakai) throws Exception {
			/*List l = (List) this.getHibernateTemplate().find("from org.sakaiproject.upv.bean.Sitio as sitio where sitio.sakCodigo = ?",codigo_site_sakai,Hibernate.STRING);
			return l;*/
			if (codigo_site_sakai == null)
		    {
		      throw new IllegalArgumentException("Null Argument");
		    }
		          
		    HibernateCallback hcb = new HibernateCallback()
		    {
		      public Object doInHibernate(Session session) throws HibernateException,SQLException
		      {
		        Query q = session.getNamedQuery("findSitioBySakCodigo");                
		        q.setParameter("sakCodigo",codigo_site_sakai, Hibernate.STRING);                   
		        return q.list();
		      }
		    };
		    return (List) getHibernateTemplate().execute(hcb);
		}
}
