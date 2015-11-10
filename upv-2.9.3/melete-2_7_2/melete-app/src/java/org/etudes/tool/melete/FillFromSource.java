/**********************************************************************************
*
* $Header:
*
***********************************************************************************
*
* Copyright (c) 2004, 2005, 2006, 2007 Foothill College, ETUDES Project
*
* Licensed under the Apache License, Version 2.0 (the "License"); you
* may not use this file except in compliance with the License. You may
* obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
* implied. See the License for the specific language governing
* permissions and limitations under the License.
*
**********************************************************************************/
package org.etudes.tool.melete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.etudes.api.app.melete.ModuleService;
import org.etudes.api.app.melete.SectionService;
import org.etudes.component.app.melete.Module;
import org.etudes.component.app.melete.ModuleShdates;
import org.etudes.component.app.melete.Section;
import org.sakaiproject.db.cover.SqlService;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.cover.SiteService;
import org.sakaiproject.tool.cover.ToolManager;
import org.sakaiproject.util.ResourceLoader;


/**
* <p>
* Functionality for import structure from a Database
* </p>
*
* @author Universidad Politecnica de Valencia
* Diego del Blanco 23/07/2007
*
*/
public class FillFromSource {

	/** Dependency: The logging service. */
	protected Log logger = LogFactory.getLog(FillFromSource.class);
	//private ModuleDB moduledb new ModuleDB();
	protected MeleteSiteAndUserInfo meleteSiteAndUserInfo;

	/** Dependency: The module service. */
	ModuleService moduleService ;
	SectionService sectionService;
//	ModuleServiceImpl moduleServiceImpl= new ModuleServiceImpl();


	/**
	 * constructor
	 */
	public FillFromSource() {
	}

	/**
	 * exports the modules according to imsglobal content packaging specs 1.1.4
	 *
	 * @return navigation page
	 */
	public String fillFromSource() {
		logger.info("Starting fillFromSource....");

		FacesContext context = FacesContext.getCurrentInstance();
		ResourceLoader bundle = new ResourceLoader("org.etudes.tool.melete.bundle.Messages");
		boolean continuar=true;
		boolean siteupv=false;
		try {
			logger.info("Entrando en getCourseTypeId()....");
			String typeId = getCourseTypeId();
			logger.info("Saliendo de getCourseTypeId() con typeId=" + typeId);
			if (typeId.equals("siteupv")){
				siteupv=true;
			}
			logger.info("antes de ex: siteupv=" + siteupv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("siteupv=" + siteupv);

		if (siteupv){
			try {
				//Aqui metere todo lo que necesito para craear los modulos.

				// 1. Comprobar que el site esta vacio
						//Si no esta vacio mensaje de error y nos vamos.

				String instr_id = getMeleteSiteAndUserInfo().getCurrentUser().getId();
				String courseId = getMeleteSiteAndUserInfo().getCurrentSiteId();
				String propietario = null ;
				String asiupv=null;
				String caca=null;
				try {
				propietario=getSiteProperties().getProperty("propietario");
				logger.info("propietario=" + propietario);
				} catch (Exception e) {
							e.printStackTrace();
				}
				try {
								caca=getSiteProperties().getProperty("term");
								logger.info("caca=" + caca);
								} catch (Exception e) {
											e.printStackTrace();
				}
				try {
				asiupv=getSiteProperties().getProperty("asiupv");
				logger.info("asiupv=" + asiupv);
				} catch (Exception e) {
											e.printStackTrace();
				}
				if (!(asiupv==null) && !(caca==null)){

					List modList = getModuleService().getModules(courseId);
					logger.info("Actualizando desde Guia Docente el curso: " + courseId + " por el usuario " + instr_id + " con asiupv: " + asiupv + "y propietario: " + propietario);
					if (modList != null && modList.size() > 0) {
						logger.info("El numero de modulos es > que 0 y modList no es null. No continuamos");
						continuar=false;
					}

					// 2. Meter en un resultSet la estructura de la guia docente que corresponde al site.
								// Tendremos que saber el site y su correspondencia en la tabla de la guia docente
					if (continuar) {
						logger.info("El site esta vacio y ahora deberiamos hacer todo lo demas");
					//---------------------------------------------------------

						ModuleShdates moduleShdates = new ModuleShdates();
						GregorianCalendar cal = new GregorianCalendar();
						cal.set(Calendar.HOUR,8);
						cal.set(Calendar.MINUTE,0);
						cal.set(Calendar.SECOND,0);
						cal.set(Calendar.AM_PM,Calendar.AM);
						moduleShdates.setStartDate(cal.getTime());
						cal.add(Calendar.YEAR, 1);
						cal.set(Calendar.HOUR,11);
						cal.set(Calendar.MINUTE,59);
						cal.set(Calendar.SECOND,0);
						cal.set(Calendar.AM_PM,Calendar.PM);
						moduleShdates.setEndDate(cal.getTime());


						Map sessionMap = context.getExternalContext().getSessionMap();
						String fName=(String)sessionMap.get("firstName");
	      				String lName=(String)sessionMap.get("lastName");
						int id=0;

						Connection dbConnection = null;
						try {

							dbConnection = SqlService.borrowConnection();
					    	Statement stmt = dbConnection.createStatement();
					    	ResultSet rs = null;

					    	String sql = "SELECT * FROM GDC_TEMARIOS WHERE ASI="+ asiupv + " AND caca="+ caca + " AND ID_PADRE IS NULL ORDER BY ORDEN";
	    					rs = stmt.executeQuery(sql);
	    					if (rs != null)	{
	    						while (rs.next()){
	    							//LO QUE HAYA QUE HACER
	    							logger.info("Titulo modulo= " + rs.getString("TITULO_CAS"));
	    							String titulo="";
	    							if (rs.getString("TITULO_CAS").length() > 50){
	    								titulo=rs.getString("TITULO_CAS").substring(0,46) + "...";
	    							}else{
	    								titulo=rs.getString("TITULO_CAS");
									}
	    							Module moduletempo=new Module(titulo,null,null,titulo,fName,lName,instr_id,null,null,null,null,cal.getTime(),null,null);
	    							getModuleService().insertProperties(moduletempo,moduleShdates,instr_id,courseId);

	    							//Ahora las secciones:
	    							id=rs.getInt("ID");
	    							String sql2 = "SELECT * FROM GDC_TEMARIOS WHERE ASI="+ asiupv + " AND caca="+ caca + " AND ID_PADRE=" + id + " ORDER BY ORDEN";
	    							Statement stmt2 = dbConnection.createStatement();
	    							ResultSet rs2 = null;
	    							rs2 = stmt2.executeQuery(sql2);
	    							if (rs2 != null)	{
	    								while (rs2.next()){

	    							logger.info("Titulo seccion= " + rs2.getString("TITULO_CAS"));
	    							String titulo2="";
									if (rs2.getString("TITULO_CAS").length() > 50){
	    								titulo2=rs2.getString("TITULO_CAS").substring(0,46) + "...";
									}else{
	    								titulo2=rs2.getString("TITULO_CAS");
									}
	    							//public Section(String title, String createdByFname, String createdByLname, String contentType,
	    							//Date creationDate, Date modificationDate) {
	    							Section sectiontempo=new Section(titulo2,fName,lName,"notype",cal.getTime(),cal.getTime());
	    							getSectionService().insertSection(moduletempo,sectiontempo);
	    								}
									rs2.close();
	    							stmt2.close();
									}
	    						}
	    					rs.close();
	    					stmt.close();
	    			    	}
						} catch (Exception e) {
							String errMsg = bundle.getString("error_mientras_filling");
							context.addMessage (null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error_mientras_filling",errMsg));
							e.printStackTrace();
							return "error_fill";

						} finally{
							try{
								if (dbConnection != null)
									SqlService.returnConnection(dbConnection);
							}catch (Exception e1){
								if (logger.isErrorEnabled()) logger.error(e1);
									e1.printStackTrace();
							}
						}

							//---------------------------------------------------------


					//Pruebas para meter modulos.


					// public Module(String title, String learnObj, String description, String keywords, String createdByFname,
					//String createdByLname, String userId, String modifiedByFname, String modifiedByLname, String institute,
					//String whatsNext, Date creationDate, Date modificationDate, String seqXml) {
					//Module moduleprueba=new Module("Hola",null,null,"Keywords","Diego","del Blanco",instr_id,null,null,null,null,cal.getTime(),null,null);

					//if (moduleService==null) moduleService=getModuleService();
					//getModuleService().insertProperties(moduleprueba,moduleShdates,instr_id,courseId);
					//moduledb.addModule(moduleprueba,moduleShdates,instr_id,courseId);



					String successMsg = bundle.getString("fill_con_exito");
					context.addMessage (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Set_prefs_success",successMsg));

					}else{
						String errMsg = bundle.getString("no_vacio");
						context.addMessage (null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"no_vacio",errMsg));
						return "error_fill";
					}
				}else{ //{f ((asiupv!="") && (propietario!=""))
				String errMsg = bundle.getString("no_asiupv");
					context.addMessage (null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"no_asiupv",errMsg));
					return "error_fill";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{ //siteupv=false
			String errMsg = bundle.getString("no_upv");
					context.addMessage (null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"no_upv",errMsg));
			return "error_fill";
		}

		logger.info("Exiting fillFromSource....");
		//Esto no creo que sea asi. Tendre que hacer otra cosa para sacar por pantalla un mensaje.
		return "fillfromsource";
	}


	/**
	 * get MeleteSiteAndUserInfo
	 *
	 * @return
	 */
	private MeleteSiteAndUserInfo getMeleteSiteAndUserInfo() {
		if (meleteSiteAndUserInfo == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			ValueBinding binding = Util.getBinding("#{meleteSiteAndUserInfo}");
			meleteSiteAndUserInfo = (MeleteSiteAndUserInfo) binding
					.getValue(context);

			return meleteSiteAndUserInfo;
		} else
			return meleteSiteAndUserInfo;
	}

	/**
	 * @return Returns the moduleService.
	 */
	public ModuleService getModuleService() {
		return moduleService;
	}

	/**
	 * @param moduleService
	 *            The moduleService to set.
	 */
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	/**
	 * @return Returns the sectionService.
	 */
	public SectionService getSectionService() {
		return sectionService;
	}

	/**
	 * @param sectionService
	 *            The sectionService to set.
	 */
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}


	/**
	 * @param logger
	 *            The logger to set.
	 */
	public void setLogger(Log logger) {
		this.logger = logger;
	}


	/**
	 * gets the title of the course
	 * @return Returns the course title
	 */
	public String getCourseTypeId()throws Exception{
		try {
			return SiteService.getSite(ToolManager.getCurrentPlacement().getContext()).getType();
			// return ToolManager.getCurrentPlacement().getTitle();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}



	/**
	 * to get site properties like term(PROP_SITE_TERM), contactemail etc
	 * @return
	 */
	private ResourceProperties getSiteProperties()throws Exception{
		ResourceProperties siteProperties;
		try {
			Site site = SiteService.getSite(ToolManager.getCurrentPlacement().getContext());
			siteProperties = site.getProperties();

			return siteProperties;
		} catch (IdUnusedException e) {
			throw new Exception(e);
		}
	}



}

