/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/course-management/branches/sakai_2-4-x/cm-impl/hibernate-impl/impl/src/java/org/sakaiproject/coursemanagement/impl/CourseManagementServiceUpvChainImpl.java $
 * $Id: CourseManagementServiceSampleChainImpl.java 21050 2007-02-06 16:12:06Z jholtzman@berkeley.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2006 The Sakai Foundation.
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/
package org.sakaiproject.coursemanagement.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.sakaiproject.coursemanagement.api.AcademicSession;
import org.sakaiproject.coursemanagement.api.CanonicalCourse;
import org.sakaiproject.coursemanagement.api.CourseManagementService;
import org.sakaiproject.coursemanagement.api.CourseOffering;
import org.sakaiproject.coursemanagement.api.CourseSet;
import org.sakaiproject.coursemanagement.api.Enrollment;
import org.sakaiproject.coursemanagement.api.EnrollmentSet;
import org.sakaiproject.coursemanagement.api.Section;
import org.sakaiproject.coursemanagement.api.exception.IdNotFoundException;

import java.util.HashSet;
import org.sakaiproject.coursemanagement.api.Membership;
import org.sakaiproject.coursemanagement.impl.CourseOfferingCmImpl;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/////
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.coursemanagement.api.SectionCategory;


/*********************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.sakaiproject.authz.cover.AuthzGroupService;
//import org.sakaiproject.db.cover.SqlService;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.event.cover.UsageSessionService;
import org.sakaiproject.tool.cover.SessionManager;
import org.sakaiproject.tool.cover.ToolManager;

import org.sakaiproject.db.api.SqlService;



/**
 * A template to use when implementing CourseManagementService to provide
 * course and enrollment data in a federated CM configuration.  Extending this class
 * should be useful for institutions intending to federate external datasources
 * (via webservices, SIS APIs, etc) with Sakai's hibernate-based
 * CourseManagementService.
 *
 * @author <a href="mailto:jholtzman@berkeley.edu">Josh Holtzman</a>
 *
 */
public class CourseManagementServiceUpvChainImpl extends HibernateDaoSupport implements CourseManagementService {


	/*JuanJE*/
	/*SqlService sqlService;
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	String sql = null;
	String vendor;*/

	/*public boolean endDatabaseConection(){
		try {
			if(result != null) result.close();
			if(statement != null) statement.close();
			if(conn != null) sqlService.returnConnection(conn);
			return true;
		}
		catch (SQLException e) {
			System.out.println("SQLException in finally block: "+e);
		}
		return false;
	}*/

	/*Fin JuanJE*/

        boolean debug = false;
        //boolean debug = true;

	public Set findCourseOfferings(String courseSetEid, String academicSessionEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>findCourseOfferings");};
         if (debug) {System.out.println("		 @>courseSetEid:"+courseSetEid);};
         if (debug) {System.out.println("		 @>academicSessionEid:"+academicSessionEid);};

		throw new IdNotFoundException(courseSetEid, CourseSet.class.getName());
	}

	public List findCourseSets(String category) {
         if (debug) {System.out.println("*********>findCourseSets");};
         if (debug) {System.out.println("		 @>category:"+category);};
		return null;
	}

	public Set findCurrentlyEnrolledEnrollmentSets(String userId) {
         if (debug) {System.out.println("*********>findCurrentlyEnrolledEnrollmentSets");};
         if (debug) {System.out.println("		 @>userId:"+userId);};
		return null;
	}

	public Set findCurrentlyInstructingEnrollmentSets(String userId) {
         if (debug) {System.out.println("*********>findCurrentlyInstructingEnrollmentSets");};
         if (debug) {System.out.println("		 @>userId:"+userId);};
		return null;
	}

	public Enrollment findEnrollment(String userId, String eid) {
         if (debug) {System.out.println("*********>findEnrollment");};
         if (debug) {System.out.println("		 @>userId:"+userId);};
         if (debug) {System.out.println("		 @>eid:"+eid);};
		return null;
	}

	public Set findInstructingSections(String userId) {
         if (debug) {System.out.println("*********>findInstructingSections");};
         if (debug) {System.out.println("		 @>userId:"+userId);};

		return null;
	}

	public Set findInstructingSections(String userId, String academicSessionEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>findInstructingSections");};
         if (debug) {System.out.println("		 @>userId:"+userId);};
         if (debug) {System.out.println("		 @>academicSessionEid:"+academicSessionEid);};

		throw new IdNotFoundException(academicSessionEid, AcademicSession.class.getName());
	}

	public AcademicSession getAcademicSession(String academicSessionEid) throws IdNotFoundException {
        if (debug) {System.out.println("*********>getAcademicSession");};
        if (debug) {System.out.println("		@>academicSessionEid:"+academicSessionEid);};

		/*Real*/
		//En este caso, existe una conexion previa que no se ha cerrado por razones de control
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();

		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();
			sql = "SELECT curso,nombre,descripcion,fecha_ini,fecha_fin " +
				  "FROM sak_cursos c " +
				  "WHERE c.curso=?";
			statement = conn.prepareStatement(sql);
                        statement.setString(1,academicSessionEid);
			result = statement.executeQuery();
			AcademicSession ac = new AcademicSessionCmImpl();
			while(result.next()) {
				//System.out.println("		@>getAcademicSession: CONEXION Y RESULTADO: " + result.getString("curso"));
                //AcademicSessionCmImpl(String eid, String title, String description, Date startDate, Date endDate)
				ac = new AcademicSessionCmImpl(result.getString("curso"),result.getString("nombre"),result.getString("descripcion"),result.getDate("fecha_ini"),result.getDate("fecha_fin"));
			}
			return ac;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException AC: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/

		throw new IdNotFoundException(academicSessionEid, AcademicSession.class.getName());
	}

	public List getAcademicSessions() {
         if (debug) {System.out.println("*********>getAcademicSessions");};
		/*Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT curso,nombre,descripcion,fecha_ini,fecha_fin " +
				  "FROM sak_cursos c";

			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			ArrayList<AcademicSession> acList= new ArrayList<AcademicSession>();
			while(result.next()) {
				 //System.out.println("		@>getAcademicSessions CONEXION Y RESULTADO: " + result.getString("curso"));
				 AcademicSession ac = new AcademicSessionCmImpl(result.getString("curso"),result.getString("nombre"),result.getString("descripcion"),result.getDate("fecha_ini"),result.getDate("fecha_fin"));
				 acList.add(ac);
			}
			return acList;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
		 		if(statement != null) statement.close();
		 		if(conn != null) sqlService.returnConnection(conn);
		 	}
		 	catch (SQLException e) {
		 		System.out.println("SQLException in finally block: "+e);
		 	}
		 }

		/*Fin Real*/
		return null;
	}

	public CanonicalCourse getCanonicalCourse(String canonicalCourseEid) throws IdNotFoundException {
		if (debug) {System.out.println("*********>getCanonicalCourse");};
		if (debug) {System.out.println("		@>canonicalCourseEid: >> "+ canonicalCourseEid + " <<");};

		/*Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();

			conn = sqlService.borrowConnection();

			sql = "SELECT a.sak_codigo, nombre " +
				  "FROM sak_asignaturas a " +
				  "WHERE a.sak_codigo=?";
			statement = conn.prepareStatement(sql);
                        statement.setString(1, canonicalCourseEid);
			result = statement.executeQuery();
			while(result.next()) {
				//System.out.println("		@>getCanonicalCourse: CONEXION Y RESULTADO: " + result.getString("a.sak_codigo")+" ->"+result.getString("nombre"));
                                //CanonicalCourseCmImpl(String eid, String title, String description)
				CanonicalCourse Cano = new CanonicalCourseCmImpl(result.getString("sak_codigo"), result.getString("nombre"), result.getString("nombre"));
				//endDatabaseConection();
				return Cano;
			}
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/

		throw new IdNotFoundException(canonicalCourseEid, CanonicalCourse.class.getName());
	}

	public Set getCanonicalCourses(String courseSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getCanonicalCourses");};
         if (debug) {System.out.println("		 @>courseSetEid:"+courseSetEid);};
		throw new IdNotFoundException(courseSetEid, CourseSet.class.getName());
	}

	public Set getChildCourseSets(String parentCourseSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getChildCourseSets");};
         if (debug) {System.out.println("		 @>parentCourseSetEid:"+parentCourseSetEid);};
		throw new IdNotFoundException(parentCourseSetEid, CourseSet.class.getName());
	}

	public Set getChildSections(String parentSectionEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getChildSections");};
         if (debug) {System.out.println("		 @>parentSectionEid:"+parentSectionEid);};
		throw new IdNotFoundException(parentSectionEid, Section.class.getName());
	}

	public CourseOffering getCourseOffering(String courseOfferingEid) throws IdNotFoundException {

		if (debug) {System.out.println("*********>getCourseOffering");};
		if (debug) {System.out.println("		@>courseOfferingEid: >> "+ courseOfferingEid + " <<");};
		CourseOffering SectEq= new CourseOfferingCmImpl();
		/* Real */

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			//sql = "SELECT s.sak_codigo,a.sak_codigo codigo_canonical,a.nombre, s.fecha_inicio, s.fecha_fin, s.nombre nombre_s, s.curso " +
			//	  "FROM sak_sites s, sak_asignaturas a " +
			//	  "WHERE s.asi_codigo=a.codigo and s.sak_codigo=?";
			sql = "SELECT d.sak_codigo sak_codigo,a.sak_codigo codigo_canonical,a.nombre, s.fecha_inicio, s.fecha_fin, nvl(d.nombre,s.nombre) nombre_s, s.curso " +
				  "FROM sak_sites s, sak_asignaturas a, sak_sites_desglose d " +
				  "WHERE s.asi_codigo=a.codigo and s.sak_codigo=? and s.codigo=d.site_codigo";

			statement = conn.prepareStatement(sql);
                        statement.setString(1, courseOfferingEid);
			result = statement.executeQuery();
			CourseOffering Sect= new CourseOfferingCmImpl();
			while(result.next()) {
				//System.out.println("		@>getCourseOffering: CONEXION Y RESULTADO: " + result.getString("CODIGO_CANONICAL") + " & " + result.getString("NOMBRE") + " & " + result.getDate("FECHA_INICIO") + " & " + result.getDate("FECHA_FIN"));
				//AcademicSessionCmImpl(String eid, String title, String description, Date startDate, Date endDate)
		        AcademicSession acadses = getAcademicSession(result.getString("CURSO"));
		        //CanonicalCourse canonicalCourse = getCanonicalCourse(result.getString("codigo_Canonical"));
		        //Creamos el CourseOffering
		        //CourseOfferingCmImpl(String eid, String title, String description,String status, AcademicSession academicSession, CanonicalCourse canonicalCourse, Date startDate, Date endDate)
				//CourseOffering offer = new CourseOfferingCmImpl(result.getString("SAK_CODIGO"),result.getString("NOMBRE_S"),result.getString("NOMBRE_S"), "enrolled",acadses,canonicalCourse, result.getDate("FECHA_INICIO"), result.getDate("FECHA_FIN"));
		        CourseOffering offer = new CourseOfferingCmImpl(result.getString("SAK_CODIGO"),result.getString("NOMBRE_S"),result.getString("NOMBRE_S"), "enrolled",acadses,null, result.getDate("FECHA_INICIO"), result.getDate("FECHA_FIN"));
				//endDatabaseConection();
				return offer;
			}
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException CO: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/

		return SectEq;

		//throw new IdNotFoundException(courseOfferingEid, CourseOffering.class.getName());
	}

	public Set getCourseOfferingMemberships(String courseOfferingEid) throws IdNotFoundException {

		if (debug) {System.out.println("*********>getCourseOfferingMemberships");};
		if (debug) {System.out.println("		@>courseOfferingEid: >> "+ courseOfferingEid + " <<");};


		HashSet<Membership> SectMem= new HashSet<Membership>();
		return SectMem;

	}
	/*DESCONECTADO RAUL OCT 2007
          public Set getCourseOfferingMemberships(String courseOfferingEid) throws IdNotFoundException {

		if (debug) {System.out.println("*********>getCourseOfferingMemberships");};
		if (debug) {System.out.println("		@>courseOfferingEid: >> "+ courseOfferingEid + " <<");};

		HashSet<Membership> SetPEPE= new HashSet<Membership>();

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();
			sql = "SELECT s.sak_codigo,lower(us.usu_userid) usu_userid,us.per_perfil " +
				  "FROM sak_sites s, sak_ususite us " +
                         "WHERE us.site_codigo=s.codigo and per_perfil<>'alumno' and s.sak_codigo='" + courseOfferingEid + "' and us.fecha_baja IS NULL";

			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			HashSet<Membership> SectMem= new HashSet<Membership>();
			while(result.next()) {
				//System.out.println("		@>getCourseOfferingMemberships: CONEXION Y RESULTADO: " + result.getString("usu_userid"));
				//MembershipCmImpl(String userId, String role, AbstractMembershipContainerCmImpl memberContainer, String status)
				Membership unUsuario = new MembershipCmImpl(result.getString("usu_userid"), result.getString("per_perfil"), null, null);
				SectMem.add(unUsuario);
			}
			//endDatabaseConection();
			return SectMem;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		throw new IdNotFoundException(courseOfferingEid, CourseOffering.class.getName());
	}*/

	public Set getCourseOfferingsInCourseSet(String courseSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getCourseOfferingsInCourseSet");};
         if (debug) {System.out.println("		 @>courseSetEid:"+courseSetEid);};
		throw new IdNotFoundException(courseSetEid, CourseSet.class.getName());
	}

	public CourseSet getCourseSet(String courseSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getCourseSet");};
         if (debug) {System.out.println("	     @>courseSetEid:"+courseSetEid);};
		throw new IdNotFoundException(courseSetEid, CourseSet.class.getName());
	}

	public Set getCourseSetMemberships(String courseSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getCourseSetMemberships");};
         if (debug) {System.out.println("		 @>courseSetEid:"+courseSetEid);};
		throw new IdNotFoundException(courseSetEid, CourseSet.class.getName());
	}

	public Set getCourseSets() {
         if (debug) {System.out.println("*********>getCourseSets");};
		return null;
	}

	public List getCurrentAcademicSessions() {
    	if (debug) {System.out.println("*********>getCurrentAcademicSessions");};
        /*Real*/

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT curso,nombre,descripcion,fecha_ini,fecha_fin " +
				  "FROM sak_cursos c " +
				  "WHERE (fecha_ini IS NULL or fecha_ini <=current_date) and " +
      			  "(fecha_fin IS NULL or fecha_fin >=current_date)";
			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			ArrayList<AcademicSession> acList= new ArrayList<AcademicSession>();
			while(result.next()) {
				//System.out.println("		@>getCurrentAcademicSessions: CONEXION Y RESULTADO: " + result.getString("curso"));
				AcademicSession ac = new AcademicSessionCmImpl(result.getString("curso"),result.getString("nombre"),result.getString("descripcion"),result.getDate("fecha_ini"),result.getDate("fecha_fin"));
				acList.add(ac);
			}
			//endDatabaseConection();
			return acList;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/
		return null;
	}

	public EnrollmentSet getEnrollmentSet(String enrollmentSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEnrollmentSet");};
         if (debug) {System.out.println("		 @>enrollmentSetEid:"+enrollmentSetEid);};

		throw new IdNotFoundException(enrollmentSetEid, EnrollmentSet.class.getName());
	}
        /* DESCONECTADO POR OBSOLETO: RAUL OCT 2007
	public Set getEnrollmentSets(String courseOfferingEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEnrollmentSets");};
         if (debug) {System.out.println("		 @>courseOfferingEid:"+courseOfferingEid);};

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT g.sak_codigogrupo,g.nombre,s.sak_codigo " +
				  "FROM sak_grupos g, sak_sites s " +
				  "WHERE s.codigo=g.site_codigo and g.sak_codigogrupo='" + courseOfferingEid + "' and g.fecha_baja IS NULL and g.tipo in ('TA','T') ";

			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			HashSet<EnrollmentSet> Enroll= new HashSet<EnrollmentSet>();
			while(result.next()) {
                                CourseOffering courseofer=getCourseOffering(result.getString("sak_codigo"));
				//public EnrollmentSetCmImpl(String eid, String title, String description, String category, String defaultEnrollmentCredits, CourseOffering courseOffering, Set officialInstructors)
                                EnrollmentSetCmImpl unEnrollset = new  EnrollmentSetCmImpl(result.getString("sak_codigogrupo"),result.getString("nombre"),result.getString("nombre"),"SINCATEGORIA","0",courseofer,null);
				Enroll.add(unEnrollset);
			}
			return Enroll;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/


	public Set getEnrollmentSets(String courseOfferingEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEnrollmentSets");};
         if (debug) {System.out.println("		 @>courseOfferingEid:"+courseOfferingEid);};

                
	        HashSet<EnrollmentSet> Enroll= new HashSet<EnrollmentSet>();
                CourseOffering courseofer=getCourseOffering(courseOfferingEid);
                //public EnrollmentSetCmImpl(String eid, String title, String description, String category, String defaultEnrollmentCredits, CourseOffering courseOffering, Set officialInstructors)
                EnrollmentSetCmImpl unEnrollset = new  EnrollmentSetCmImpl(courseOfferingEid,courseOfferingEid,courseOfferingEid,"SINCATEGORIA","0",courseofer,null);
	        Enroll.add(unEnrollset);

         return Enroll;
	}
        
        

	public Set getEnrollments(String enrollmentSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEnrollments");};
         if (debug) {System.out.println("		 @>enrollmentSetEid:"+enrollmentSetEid);};
		/*Real*/

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();
                        
            HashSet<Enrollment> Enroll= new HashSet<Enrollment>();

            //CASO1: Entra el id de un courseoffering
			sql = "SELECT s.sak_codigo,lower(us.usu_userid) usu_userid,us.per_perfil " +
				  "FROM sak_sites s, sak_ususite us " +
                         "WHERE us.site_codigo=s.codigo and s.sak_codigo=? and us.fecha_baja IS NULL";

			statement = conn.prepareStatement(sql);
            statement.setString(1, enrollmentSetEid);
			result = statement.executeQuery();
			while(result.next()) {
				//System.out.println("		@>getSectionMemberships: CONEXION Y RESULTADO: " + result.getString("usite_usu_userid"));
				//public EnrollmentCmImpl(String userId,                  EnrollmentSet enrollmentSet, String enrollmentStatus, String credits, String gradingScheme) {
                                Enrollment unUsuario = new  EnrollmentCmImpl(result.getString("usu_userid"),null,result.getString("usu_userid"),"0",null );
				Enroll.add(unUsuario);
			}

			//CASO2:Entra el id de un grupo. Ahora sacamos los profesores asociados a un grupo. Mas los extra del desglose menos los que se deben quitar del desglose
 			sql = "SELECT lower(us.usu_userid) usu_userid,us.per_perfil FROM sak_ususite us,sak_usugru usg,sak_grupos g WHERE g.sak_codigogrupo=? and g.fecha_baja is null and usg.usite_site_codigo=g.site_codigo and usg.gru_codigo=g.codigo and us.site_codigo=g.site_codigo and us.usu_userid=usg.usite_usu_userid and us.per_perfil<>'alumno' and us.fecha_baja IS NULL and usg.fecha_baja IS NULL " +
                    " UNION SELECT lower(ud.usu_userid) usu_userid,ud.per_perfil per_perfil FROM sak_grupos g, sak_ususite_desglose ud " +
                           " WHERE g.sak_codigogrupo=? and g.fecha_baja is null and g.site_codigo=ud.site_codigo and ud.gru_codorigen=g.codigo_origen and ud.tipo='ADD' and ud.per_perfil<>'alumno' " +
                    " MINUS SELECT lower(ud.usu_userid) usu_userid,ud.per_perfil per_perfil FROM sak_grupos g, sak_ususite_desglose ud " +
                           " WHERE g.sak_codigogrupo=? and g.fecha_baja is null and g.site_codigo=ud.site_codigo and ud.gru_codorigen=g.codigo_origen and ud.tipo='DEL' and ud.per_perfil<>'alumno' ";
                        //System.out.println("SQL...:"+sql);

			statement = conn.prepareStatement(sql);
            statement.setString(1, enrollmentSetEid);
            statement.setString(2, enrollmentSetEid);
            statement.setString(3, enrollmentSetEid);
			result = statement.executeQuery();
			while(result.next()) {
				//System.out.println("		@>getSectionMemberships: CONEXION Y RESULTADO: " + result.getString("usite_usu_userid"));
				//public EnrollmentCmImpl(String userId,EnrollmentSet enrollmentSet, String enrollmentStatus, String credits, String gradingScheme) {
                Enrollment unUsuario = new  EnrollmentCmImpl(result.getString("usu_userid"),null,result.getString("per_perfil"),"0",null );
				Enroll.add(unUsuario);
			}
                        //Retornamos la lista de lo obtenido
			return Enroll;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted en getEnrollments.  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/
		throw new IdNotFoundException(enrollmentSetEid, EnrollmentSet.class.getName());
	}

	public Set getEquivalentCanonicalCourses(String canonicalCourseEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEquivalentCanonicalCourses");};
         if (debug) {System.out.println("		 @>canonicalCourseEid:"+canonicalCourseEid);};
                return new HashSet<CanonicalCourse>();
		//throw new IdNotFoundException(canonicalCourseEid, CanonicalCourse.class.getName());
	}

        public Set getEquivalentCourseOfferings(String courseOfferingEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEquivalentCourseOfferings");};
         if (debug) {System.out.println("		 @>courseOfferingEid:"+courseOfferingEid);};
         return new HashSet<CourseOffering>();
		//throw new IdNotFoundException(courseOfferingEid, CourseOffering.class.getName());
	}

	/*DESCONECTADO POR RAUL: OCT 2007. NO ES NECESARIO
        public Set getEquivalentCourseOfferings(String courseOfferingEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getEquivalentCourseOfferings");};
         if (debug) {System.out.println("		 @>courseOfferingEid:"+courseOfferingEid);};

		
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

                HashSet<CourseOffering> lista=new HashSet<CourseOffering>();

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT u.origen,u.destino,o.curso,o.nombre,o.fecha_alta,o.fecha_baja " +
				  "FROM sak_sites o, sak_unificar u " +
				  "WHERE o.sak_codigo=u.origen and u.destino='" + courseOfferingEid + "'";

			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
                                //CourseOfferingCmImpl(String eid, String title, String description,String status, AcademicSession academicSession, CanonicalCourse canonicalCourse, Date startDate, Date endDate)
				CourseOffering offer = new CourseOfferingCmImpl(result.getString("ORIGEN"),result.getString("NOMBRE"),result.getString("NOMBRE"),"Estado UPV",null,null, result.getDate("FECHA_ALTA"), result.getDate("FECHA_BAJA"));
				lista.add(offer);
			}
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}

                return lista;
		//throw new IdNotFoundException(courseOfferingEid, CourseOffering.class.getName());
	}*/

	public Set getInstructorsOfRecordIds(String enrollmentSetEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getInstructorsOfRecordIds");};
         if (debug) {System.out.println("		 @>enrollmentSetEid:"+enrollmentSetEid);};
		//throw new IdNotFoundException(enrollmentSetEid, EnrollmentSet.class.getName());
         HashSet<String> lista=new HashSet<String>();
         return lista;
	}

	public Section getSection(String sectionEid) throws IdNotFoundException {
		if (debug) {System.out.println("*********>getSection");};
		if (debug) {System.out.println("		@>sectionEid: "+ sectionEid);};

		/*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			/*sql = "SELECT g.sak_codigogrupo, t.sak_codigo tsakcodigo, s.sak_codigo course_offering, s.nombre nombre, g.nombre||sak_cm_pck.sufijogrupo(s.codigo) nombre_g, s.fecha_alta, s.fecha_baja " +
				  "FROM sak_grupos g, sak_sites s, sak_tipogrupos t " +
				  "WHERE g.tipo=t.codigo and g.site_codigo=s.codigo and g.sak_codigogrupo='" + sectionEid + "'";*/
                        //sql = "SELECT g.sak_codigogrupo, t.sak_codigo tsakcodigo, s.sak_codigo course_offering, s.nombre nombre, g.nombre||sak_cm_pck.sufijogrupo(s.codigo) nombre_g, s.fecha_alta, s.fecha_baja " +
			//	  "FROM sak_grupos g, sak_sites s, sak_tipogrupos t " +
			//	  "WHERE g.tipo=t.codigo and g.site_codigo=s.codigo and g.sak_codigogrupo=?";
                        sql = "SELECT g.sak_codigogrupo, t.sak_codigo tsakcodigo, nvl(d.sak_codigo,s.sak_codigo) course_offering, s.nombre nombre, g.nombre||sak_cm_pck.sufijogrupo(s.codigo) nombre_g, s.fecha_alta, s.fecha_baja " +
				  "FROM sak_grupos g, sak_sites s, sak_tipogrupos t, sak_sites_desglose d " +
				  "WHERE g.tipo=t.codigo and g.site_codigo=s.codigo and g.sak_codigogrupo=? and g.fecha_baja is null " +
                                  "  and g.site_codigo=d.site_codigo(+) and g.codigo_origen=d.valor(+) ";
                                
			statement = conn.prepareStatement(sql);
                        statement.setString(1, sectionEid);
			result = statement.executeQuery();
			while(result.next()) {
				//System.out.println("		@>getSection: CONEXION Y RESULTADO: " + result.getString("SAK_CODIGOGRUPO") + " $$ "+result.getString("tsakcodigo"));
				//Create Offering from result.getString("COURSE_OFFERING")
                                //CourseOfferingCmImpl(String eid, String title, String description,String status, AcademicSession academicSession, CanonicalCourse canonicalCourse, Date startDate, Date endDate)
				CourseOffering offer = new CourseOfferingCmImpl(result.getString("COURSE_OFFERING"),result.getString("NOMBRE"),result.getString("NOMBRE"),"Estado UPV",null,null, result.getDate("FECHA_ALTA"), result.getDate("FECHA_BAJA"));
                                //public EnrollmentSetCmImpl(String eid, String title, String description, String category, String defaultEnrollmentCredits, CourseOffering courseOffering, Set officialInstructors)
                                EnrollmentSetCmImpl unEnrollset = new  EnrollmentSetCmImpl(sectionEid,sectionEid,sectionEid,"SINCATEGORIA","0",offer,null);				
                                //Create Section
				//public SectionCmImpl(String eid, String title, String description, String category, Section parent, CourseOffering courseOffering, EnrollmentSet enrollmentSet, Integer maxSize) {
				Section sect = new SectionCmImpl(result.getString("SAK_CODIGOGRUPO"),result.getString("NOMBRE_G"),result.getString("NOMBRE_G"),result.getString("tsakcodigo"),null,offer,unEnrollset,null);//Integer.parseInt(result.getString("TIPO")));
				//endDatabaseConection();
				//System.out.println("		 @> g.nombre: "+result.getString("nombre_g"));
				return sect;
			}
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e+" SQL:"+sql);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Aplicacion Real*/
		throw new IdNotFoundException(sectionEid, Section.class.getName());

	}

	public Set getSectionMemberships(String sectionEid) throws IdNotFoundException {
		if (debug) {System.out.println("*********>getSectionMemberShips");};
		if (debug) {System.out.println("		@>sectionEid: "+ sectionEid);};

		/*Real*/

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "select g.sak_codigogrupo, lower(SU.USU_USERID) usu_userid, su.per_perfil as per_perfil from sak_grupos g, sak_ususite su, sak_usugru sg where " +
			    "G.SAK_CODIGOGRUPO=? and SU.SITE_CODIGO=G.SITE_CODIGO and sg.usite_usu_userid= su.usu_userid " +
			    "and sg.usite_site_codigo=su.site_codigo  and sg.gru_codigo=g.codigo and su.fecha_baja is null and sg.fecha_baja is null";

			statement = conn.prepareStatement(sql);
                        statement.setString(1, sectionEid);
			result = statement.executeQuery();
			HashSet<Membership> SectMem= new HashSet<Membership>();
			while(result.next()) {
				//MembershipCmImpl(String userId, String role, AbstractMembershipContainerCmImpl memberContainer, String status)
				/*JJ*/
				Membership unUsuario = new MembershipCmImpl(result.getString("usu_userid"), result.getString("per_perfil"), null, "member");
				SectMem.add(unUsuario);
			}
			//endDatabaseConection();
			return SectMem;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/
		throw new IdNotFoundException(sectionEid, Section.class.getName());
	}

	public Set<Section> getSections(String courseOfferingEid) throws IdNotFoundException {
         if (debug) {System.out.println("*********>getSections");};
         if (debug) {System.out.println("		 @>courseOfferingEid:"+courseOfferingEid);};
		/*Real*/

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			//sql = "SELECT g.sak_codigogrupo,g.nombre,t.sak_codigo " +
			//	  "FROM sak_grupos g, sak_sites s, sak_tipogrupos t " +
			//	  "WHERE g.sak_codigogrupo is not null and g.tipo=t.codigo and g.site_codigo=s.codigo and s.sak_codigo=?";
                        // Comentada el 3/3/2008 porque va mï¿½s rï¿½pido con un UNION que con el OUTER JOIN
			//sql = "SELECT g.sak_codigogrupo,g.nombre,t.sak_codigo " +
                        //         " FROM sak_grupos g, sak_sites s, sak_tipogrupos t , sak_sites_desglose d " +
                        //         " WHERE g.sak_codigogrupo is not null and g.tipo=t.codigo and g.site_codigo=s.codigo and nvl(d.sak_codigo,s.sak_codigo)=? " +
                        //         "  and g.site_codigo=d.site_codigo(+) and g.codigo_origen=d.valor(+) ";
                        sql = "SELECT g.sak_codigogrupo,g.nombre,t.sak_codigo " +
                                 " FROM sak_grupos g, sak_sites s, sak_tipogrupos t , sak_sites_desglose d " +
                                 " WHERE g.sak_codigogrupo is not null and g.fecha_baja is null and g.tipo=t.codigo and g.site_codigo=s.codigo and d.sak_codigo=? " +
                                 "  and g.site_codigo=d.site_codigo and g.codigo_origen=d.valor " +
                       " UNION SELECT g.sak_codigogrupo,g.nombre,t.sak_codigo " +
                                 " FROM sak_grupos g, sak_sites s, sak_tipogrupos t " +
                                 " WHERE g.sak_codigogrupo is not null and g.fecha_baja is null and g.tipo=t.codigo and g.site_codigo=s.codigo and s.sak_codigo=? " ;

			statement = conn.prepareStatement(sql);
                        statement.setString(1, courseOfferingEid);
                        statement.setString(2, courseOfferingEid);
			result = statement.executeQuery();
                        CourseOffering courseOffering = getCourseOffering(courseOfferingEid);
			HashSet<Section> secSet= new HashSet<Section>();
			while(result.next()) {
				//System.out.println("		@>getSections: CONEXION Y RESULTADO: " + result.getString("sak_codigogrupo"));
				//public SectionCmImpl(String eid, String title, String description, String category, Section parent, CourseOffering courseOffering, EnrollmentSet enrollmentSet, Integer maxSize) {
				Section sec = new SectionCmImpl(result.getString("sak_codigogrupo"),result.getString("nombre"),result.getString("nombre"),result.getString("sak_codigo"),null,courseOffering, null,null);
				secSet.add(sec);
			}
			//endDatabaseConection();
			return secSet;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Real*/
		throw new IdNotFoundException(courseOfferingEid, CourseOffering.class.getName());
	}

	public boolean isEmpty(String courseSetEid) {
         if (debug) {System.out.println("*********>isEmpty");};
         if (debug) {System.out.println("		 @>courseSetEid:"+courseSetEid);};
		throw new UnsupportedOperationException();
	}

	public boolean isEnrolled(String userEid, Set<String> enrollmentSetEids) {
         if (debug) {System.out.println("*********>isEnrolled");};
         if (debug) {System.out.println("		 @>userId:"+userEid);};
         if (debug) {System.out.println("		 @>enrollmentSetEids:"+enrollmentSetEids);};

		throw new UnsupportedOperationException();
	}

	public boolean isEnrolled(String userId, String eid) {
         if (debug) {System.out.println("*********>isEnrolled");};
         if (debug) {System.out.println("		 @>userId:"+userId);};
         if (debug) {System.out.println("		 @>eid:"+eid);};
		//throw new UnsupportedOperationException();
         return true;
	}

	public Set findEnrolledSections(String userId) {
         if (debug) {System.out.println("*********>findEnrolledSections");};
         if (debug) {System.out.println("		 @>userId:"+userId);};
		return null;
	}

	public Map findCourseOfferingRoles(String userEid) {
                if (debug) {System.out.println("*********>findCourseOfferingRoles");};
		if (debug) {System.out.println("		@>userEid:"+userEid);};
		/*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

			//String vendor = sqlService.getVendor();

			conn = sqlService.borrowConnection();

			sql = "SELECT NVL(U.DESTINO,S.SAK_CODIGO) SAK_CODIGO,US.PER_PERFIL "+
                              "  FROM SAK_SITES S, SAK_USUSITE US, SAK_UNIFICAR U "+
                              " WHERE S.CODIGO=US.SITE_CODIGO AND US.FECHA_BAJA IS NULL AND US.per_perfil<>'alumno' "+
                              "       AND US.USU_USERID=UPPER(?) AND S.SAK_CODIGO=U.ORIGEN(+) "+
                              "       AND EXISTS (SELECT 'X' FROM SAK_USUGRU USG WHERE USG.USITE_USU_USERID=US.USU_USERID AND USG.USITE_SITE_CODIGO=US.SITE_CODIGO AND USG.FECHA_BAJA IS NULL) "+
                              "UNION "+
                              "SELECT DISTINCT D.SAK_CODIGO,US.PER_PERFIL "+
                              "  FROM SAK_SITES S, SAK_USUSITE US, SAK_SITES_DESGLOSE D "+
                              " WHERE S.CODIGO=US.SITE_CODIGO AND US.FECHA_BAJA IS NULL AND US.per_perfil<>'alumno' "+
                              "       AND US.USU_USERID=UPPER(?) AND S.CODIGO=D.SITE_CODIGO "+
                              "       AND EXISTS (SELECT 'X' FROM SAK_USUGRU USG WHERE USG.USITE_USU_USERID=US.USU_USERID AND USG.USITE_SITE_CODIGO=US.SITE_CODIGO AND USG.FECHA_BAJA IS NULL) "+
                              "UNION "+
                              "SELECT UD.SAK_CODIGO, UD.PER_PERFIL "+
                              "  FROM SAK_USUSITE_DESGLOSE UD "+
                              " WHERE UD.USU_USERID=UPPER(?) AND UD.TIPO='ADD' "+
                              "MINUS "+
                              "SELECT UD.SAK_CODIGO, UD.PER_PERFIL "+
                              "  FROM SAK_USUSITE_DESGLOSE UD "+
                              " WHERE UD.USU_USERID=UPPER(?) AND UD.TIPO='DEL'";

			statement = conn.prepareStatement(sql);
                        statement.setString(1, userEid);
                        statement.setString(2, userEid);
                        statement.setString(3, userEid);
                        statement.setString(4, userEid);
			result = statement.executeQuery();
			Map<String, String> sectionRoleMap = new HashMap<String, String>();
			while(result.next()) {
				String name =result.getString("SAK_CODIGO");
				String role =result.getString("PER_PERFIL");
				sectionRoleMap.put(name, role);
			}
			//endDatabaseConection();
			//System.out.println("		@> sectionRoleMap: "+sectionRoleMap);
			return sectionRoleMap;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException findCourseOfferingRoles: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Aplicacion Real*/
		return null;
	}

	public Map findCourseSetRoles(String userEid) {
         if (debug) {System.out.println("*********>findCourseSetRoles");};
         if (debug) {System.out.println("		 @>userEid:"+userEid);};
		return null;
	}

	public Map findSectionRoles(String userEid) {
           if (debug) {System.out.println("*********>findSectionRoles");};
           if (debug) {System.out.println("		@>userEid:"+userEid);};
		/*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();

			conn = sqlService.borrowConnection();

			sql = "SELECT G.SAK_CODIGOGRUPO,US.PER_PERFIL " +
				  "FROM SAK_GRUPOS G, SAK_USUGRU UG,SAK_USUSITE US " +
				  "WHERE G.CODIGO=UG.GRU_CODIGO AND G.FECHA_BAJA IS NULL AND UG.USITE_USU_USERID = US.USU_USERID AND UG.USITE_SITE_CODIGO=US.SITE_CODIGO " +
				  "AND US.FECHA_BAJA IS NULL AND UG.FECHA_BAJA IS NULL " +
				  "AND UG.USITE_USU_USERID=UPPER(?)";

			statement = conn.prepareStatement(sql);
                        statement.setString(1, userEid);
			result = statement.executeQuery();
			Map<String, String> sectionRoleMap = new HashMap<String, String>();
			while(result.next()) {
				String name =result.getString("SAK_CODIGOGRUPO");
				String role =result.getString("PER_PERFIL");
				sectionRoleMap.put(name, role);
                                if (debug) {System.out.println("		@>RoleMap("+name+","+role+")");};
			}
			//endDatabaseConection();
			//System.out.println("		@> sectionRoleMap: "+ sectionRoleMap);
			return sectionRoleMap;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException findSectionRoles: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Aplicacion Real*/
        return null;
	}

	public Set getCourseOfferingsInCanonicalCourse(String canonicalCourseEid) throws IdNotFoundException {
               if (debug) {System.out.println("*********>getCourseOfferingsInCanonicalCourse");};
               if (debug) {System.out.println("		@>canonicalCourseEid: "+canonicalCourseEid);};

		//Primero comprobar que existe dicho curso
		if(!isCanonicalCourseDefined(canonicalCourseEid)) {
			throw new IdNotFoundException(canonicalCourseEid, CanonicalCourseCmImpl.class.getName());
		}
		//Llamada SQL
		/*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT s.sak_codigo,s.nombre,a.sak_codigo asak_codigo,s.fecha_inicio,s.fecha_fin,s.curso " +
				  "FROM sak_sites s, sak_asignaturas a " +
				  "WHERE asi_codigo=? AND s.asi_codigo=a.codigo";

			statement = conn.prepareStatement(sql);
                        statement.setString(1, canonicalCourseEid);
			result = statement.executeQuery();
			Set<CourseOffering> setCourseOff = new HashSet<CourseOffering>();
			while(result.next()) {
				//CourseOfferingCmImpl(String eid, String title, String description,String status, AcademicSession academicSession, CanonicalCourse canonicalCourse, Date startDate, Date endDate)
				AcademicSession acSession = getAcademicSession(result.getString("curso"));
				CanonicalCourse canCourse = getCanonicalCourse(result.getString("sak_codigo"));
				CourseOffering cOff = new CourseOfferingCmImpl(result.getString("sak_codigo"), result.getString("nombre"), result.getString("nombre"),"enrolled", acSession, canCourse, result.getDate("fecha_inicio"), result.getDate("fecha_fin"));
				setCourseOff.add(cOff);
			}
			//endDatabaseConection();
			return setCourseOff;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(conn != null) sqlService.returnConnection(conn);
			}
			catch (SQLException e) {
				System.out.println("SQLException in finally block: "+e);
			}
		}
		/*Fin Aplicacion Real*/
		return null;

		//throw new IdNotFoundException(canonicalCourseEid, CanonicalCourse.class.getName());
	}

	public boolean isAcademicSessionDefined(String eid) {
                if (debug) {System.out.println("*********>isAcademicSessionDefined");};
                if (debug) {System.out.println("		@>eid:"+eid);};
        /*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {


			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

		 	sql = "SELECT count(curso) res" +
		 		  "FROM SAK_CURSOS " +
		 		  "WHERE curso=?";

		 	statement = conn.prepareStatement(sql);
                        statement.setString(1, eid);
		 	result = statement.executeQuery();
		 	int dev=0;
		 	while(result.next()) {
		 		dev=result.getInt("res");
		 	}
			//endDatabaseConection();
		 	//System.out.println("		@>dev: " + dev);
		 	return (dev==1);
		 }
		 catch (SQLException e) {
		 	System.out.println("Job Aborted!  SQLException: "+e);
		 }
		 finally {
		 	try {
		 		if(result != null) result.close();
		 		if(statement != null) statement.close();
		 		if(conn != null) sqlService.returnConnection(conn);
		 	}
		 	catch (SQLException e) {
		 		System.out.println("SQLException in finally block: "+e);
		 	}
		}
		/*Fin Aplicacion Real*/
		throw new UnsupportedOperationException();
	}

	public boolean isCanonicalCourseDefined(String eid) {
                if (debug) {System.out.println("*********>isCanonicalCourseDefined");};
                if (debug) {System.out.println("		@>eid:"+eid);};
        /*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
		 	//String vendor = sqlService.getVendor();
		 	conn = sqlService.borrowConnection();

		 	sql = "SELECT count(codigo) res" +
		 		  "FROM SAK_ASIGNATURAS " +
		 		  "WHERE sak_codigo=?";

		 	statement = conn.prepareStatement(sql);
                        statement.setString(1, eid);
		 	result = statement.executeQuery();
		 	int dev=0;
		 	while(result.next()) {
		 		dev=result.getInt("res");
		 	}
		 	//System.out.println("		@>dev: " + dev);
			//endDatabaseConection();
		 	return (dev==1);
		 }
		 catch (SQLException e) {
		 	System.out.println("Job Aborted!  SQLException: "+e);
		 }
		 finally {
		 	try {
		 		if(result != null) result.close();
		 		if(statement != null) statement.close();
		 		if(conn != null) sqlService.returnConnection(conn);
		 	}
		 	catch (SQLException e) {
		 		System.out.println("SQLException in finally block: "+e);
		 	}
		}
		 /*Fin Aplicacion Real*/

		throw new UnsupportedOperationException();
	}

	public boolean isCourseOfferingDefined(String eid) {
    	        if (debug) {System.out.println("*********>isCourseOfferingDefined");};
    	        if (debug) {System.out.println("		@>eid:"+eid);};
        /*Aplicacion Real*/
		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		 try {
		 	//String vendor = sqlService.getVendor();
		 	conn = sqlService.borrowConnection();

		 	sql = "SELECT count(sak_codigo) res " +
		 		  "FROM SAK_SITES " +
		 		  "WHERE sak_codigo=?";

		 	statement = conn.prepareStatement(sql);
                        statement.setString(1, eid);
		 	result = statement.executeQuery();
		 	int dev=0;
		 	while(result.next()) {
		 		dev=result.getInt("res");
		 	}
		 	//System.out.println("		@>dev: " + dev);
			//endDatabaseConection();
		 	return (dev==1);
		 }
		 catch (SQLException e) {
		 	System.out.println("Job Aborted!  SQLException: "+e);
		 }
		 finally {
		 	try {
		 		if(result != null) result.close();
		 		if(statement != null) statement.close();
		 		if(conn != null) sqlService.returnConnection(conn);
		 	}
		 	catch (SQLException e) {
		 		System.out.println("SQLException in finally block: "+e);
		 	}
		}
		/*Fin Aplicacion Real*/
		throw new UnsupportedOperationException();
	}

	public boolean isCourseSetDefined(String eid) {
         if (debug) {System.out.println("*********>isCourseSetDefined");};
         if (debug) {System.out.println("		 @>eid:"+eid);};
		throw new UnsupportedOperationException();
	}

	public boolean isEnrollmentSetDefined(String eid) {
         if (debug) {System.out.println("*********>isEnrollmentSetDefined");};
         if (debug) {System.out.println("		 @>eid:"+eid);};
	 if (debug) {System.out.println("                @>No");};
		throw new UnsupportedOperationException();
	}

	public boolean isSectionDefined(String eid) {
    	        if (debug) {System.out.println("*********>isSectionDefined");};
                if (debug) {System.out.println("		@>eid:"+eid);};
        /*Aplicacion Real*/

		SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {

		 	//String vendor = sqlService.getVendor();
		 	conn = sqlService.borrowConnection();

		 	sql = "SELECT count(sak_codigogrupo) res " +
		 		  "FROM SAK_GRUPOS " +
		 		  "WHERE sak_codigogrupo=? and fecha_baja is null";

		 	statement = conn.prepareStatement(sql);
                        statement.setString(1, eid);
		 	result = statement.executeQuery();
		 	int dev=0;
		 	while(result.next()) {
		 		dev=result.getInt("res");
		 	}
		 	//System.out.println("		@>dev: " + dev);
			//endDatabaseConection();
		 	return (dev==1);
		 }
		 catch (SQLException e) {
		 	System.out.println("Job Aborted!  SQLException: "+e);
		 }
		 finally {
		 	try {
		 		if(result != null) result.close();
		 		if(statement != null) statement.close();
		 		if(conn != null) sqlService.returnConnection(conn);
		 	}
		 	catch (SQLException e) {
		 		System.out.println("SQLException in finally block: "+e);
		 	}
		}
		/*Fin Aplicacion Real*/
		throw new UnsupportedOperationException();
	}

	public List<String> getSectionCategories() {
                if (debug) {System.out.println("*********>getSectionCategories");};
                /*Real*/
                SqlService sqlService;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
	  	String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT sak_codigo " +
			  	  "FROM sak_tipogrupos ";

			statement = conn.prepareStatement(sql);

			result = statement.executeQuery();

			ArrayList<String> scList= new ArrayList<String>();
			while(result.next()) {
				//System.out.println("		@>getSectionCategories: CONEXION Y RESULTADO: " + result.getString("sak_codigo"));
				scList.add(result.getString("sak_codigo"));
			}
			//endDatabaseConection();
			return scList;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			 try {
			 	if(result != null) result.close();
			  	if(statement != null) statement.close();
			  	if(conn != null) sqlService.returnConnection(conn);
			  }
			  catch (SQLException e) {
			  	System.out.println("SQLException in finally block: "+e);
			  }
	  }
		/*Fin Real*/
		return null;
	}

	public String getSectionCategoryDescription(String categoryCode) {

    	if (debug) {System.out.println("*********>getSectionCategoryDescription");};
       	if (debug) {System.out.println("		@>categoryCode: "+categoryCode);};

       	/*Real*/
		SqlService sqlService;
	  	Connection conn = null;
	  	PreparedStatement statement = null;
	  	ResultSet result = null;
	  	String sql = null;

		sqlService = org.sakaiproject.db.cover.SqlService.getInstance();
		try {
			//String vendor = sqlService.getVendor();
			conn = sqlService.borrowConnection();

			sql = "SELECT sak_codigo,nombre " +
			  	  "FROM sak_tipogrupos " +
			  	  "WHERE sak_codigo=?";

			statement = conn.prepareStatement(sql);
                        statement.setString(1, categoryCode);
			result = statement.executeQuery();

			String desc= new String();

			while(result.next()) {
				//System.out.println("		@>getSectionCategoryDescription: CONEXION Y RESULTADO: " + result.getString("nombre"));
				desc=result.getString("nombre");
				if(desc.equals("")){
					desc="Descartado";
				}
			}
			//endDatabaseConection();
			//System.out.println("		@>desc: "+desc);
			return desc;
		}
		catch (SQLException e) {
			System.out.println("Job Aborted!  SQLException: "+e);
		}
		finally {
			  	try {
			  		if(result != null) result.close();
			  		if(statement != null) statement.close();
			  		if(conn != null) sqlService.returnConnection(conn);
			  	}
			  	catch (SQLException e) {
			  		System.out.println("SQLException in finally block: "+e);
			  	}
	  }
		/*Fin Real*/

		return null;
	}

	public Map<String, String> getEnrollmentStatusDescriptions(Locale locale) {
         if (debug) {System.out.println("*********>getEnrollmentStatusDescriptions");};
         if (debug) {System.out.println("		 @>locale:"+locale);};
		return null;
	}

	public Map<String, String> getGradingSchemeDescriptions(Locale locale) {
         if (debug) {System.out.println("*********>getGradingSchemeDescriptions");};
         if (debug) {System.out.println("		 @>locale:"+locale);};
		return null;
	}

	public Map<String, String> getMembershipStatusDescriptions(Locale locale) {
         if (debug) {System.out.println("*********>getMembershipStatusDescriptions");};
         if (debug) {System.out.println("		@>locale:"+locale);};
		return null;
	}

	public List<CourseOffering> findActiveCourseOfferingsInCanonicalCourse(
			String eid) {
		// TODO Auto-generated method stub
		return null;
	}
}

