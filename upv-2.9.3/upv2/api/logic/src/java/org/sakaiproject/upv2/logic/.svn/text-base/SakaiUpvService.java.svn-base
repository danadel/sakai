package org.sakaiproject.upv2.logic;

import org.sakaiproject.upv2.model.Asignatura;
import org.sakaiproject.upv2.model.Sitio;
import org.sakaiproject.upv2.model.Telde;
import org.hibernate.HibernateException;
import java.util.List;
import java.util.Vector;
import java.sql.SQLException;

public interface SakaiUpvService {
	public Asignatura getAsignatura(String id) throws Exception;
	public List       getAllAsignaturas() throws Exception;
	public List       getAsignaturas(final String propietario,final String codigo,final String nombre) throws Exception;
	//
	public Sitio getSitio(String id) throws Exception;
	public List  getSitiosByAsi(final String asignatura) throws Exception;
	public List  getSitiosByProfPropietario(final String userid,final String propietario) throws Exception;
	public void  saveSitio(Sitio site) throws Exception;
	//
	public List getTeldesByAsi(final String asignatura) throws Exception;
	public void saveTelde(Telde telde) throws Exception;
	public void delTelde(Telde telde)  throws Exception;
	//
	public List getComposicionesByProp(final String propietario);
	public List executeSql(final String sql) throws Exception;
	//
	public String sincronizarSitio(Sitio site);
//	Encuestas
	public List loadEncuestasByCodigoSite(String codigo_site) throws Exception;
	public List loadEncuestasByCodigoSites(Vector sites) throws Exception;
	public boolean insertEncuesta(int idPase, String codigo_site_sakai, String codigo_sakai, String codigo_grupo_sakai) throws Exception;
	public List loadSitiosBySakaiCodigo(String codigo_site_sakai) throws Exception;
}