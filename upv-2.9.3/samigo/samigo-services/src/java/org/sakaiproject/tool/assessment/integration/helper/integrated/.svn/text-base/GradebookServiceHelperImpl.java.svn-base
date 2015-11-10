/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/sam/trunk/component/src/java/org/sakaiproject/tool/assessment/integration/helper/integrated/GradebookServiceHelperImpl.java $
 * $Id: GradebookServiceHelperImpl.java 9273 2006-05-10 22:34:28Z daisyf@stanford.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2007, 2008, 2009 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.tool.assessment.integration.helper.integrated;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.tool.assessment.services.assessment.PublishedAssessmentService;
import org.sakaiproject.tool.assessment.services.GradingService;
import org.sakaiproject.tool.assessment.facade.AgentFacade;
import org.sakaiproject.tool.assessment.facade.GradebookFacade;
import org.sakaiproject.authz.api.SecurityAdvisor;
import org.sakaiproject.authz.api.AuthzGroupService;
import org.sakaiproject.authz.api.SecurityService;
import org.sakaiproject.component.cover.ComponentManager;
import org.apache.commons.math.util.MathUtils;
import org.sakaiproject.event.api.Event;
import org.sakaiproject.event.api.EventTrackingService;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.service.gradebook.shared.Assignment;
import org.sakaiproject.service.gradebook.shared.GradebookExternalAssessmentService;
import org.sakaiproject.service.gradebook.shared.GradebookNotFoundException;
import org.sakaiproject.service.gradebook.shared.GradebookService;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SitePage;
import org.sakaiproject.site.api.ToolConfiguration;
import org.sakaiproject.site.cover.SiteService;
import org.sakaiproject.tool.assessment.data.dao.assessment.PublishedAssessmentData;
import org.sakaiproject.tool.assessment.data.ifc.assessment.PublishedAssessmentIfc;
import org.sakaiproject.tool.assessment.data.ifc.grading.AssessmentGradingIfc;
import org.sakaiproject.tool.assessment.integration.helper.ifc.GradebookServiceHelper;
import org.sakaiproject.tool.api.SessionManager;
import org.sakaiproject.user.api.PreferencesService;

/**
 *
 * <p>Description:
 * This is an integrated context implementation helper delegate class for
 * the GradebookService class.
 * "Integrated" means that Samigo (Tests and Quizzes)
 * is running within the context of the Sakai portal and authentication
 * mechanisms, and therefore makes calls on Sakai for things it needs.</p>
 * <p>Note: To customize behavior you can add your own helper class to the
 * Spring injection via the integrationContext.xml for your context.
 * The particular integrationContext.xml to be used is selected by the
 * build process.
 * </p>
 * <p>Sakai Project Copyright (c) 2005</p>
 * <p> </p>
 * @author Ed Smiley <esmiley@stanford.edu>
 */
public class GradebookServiceHelperImpl implements GradebookServiceHelper, SecurityAdvisor
{
  private static Log log = LogFactory.getLog(GradebookServiceHelperImpl.class);

  private static AuthzGroupService authzGroupService = (AuthzGroupService)ComponentManager.get(AuthzGroupService.class);
  
  private static SecurityService securityService = (SecurityService)ComponentManager.get(SecurityService.class);
  
  private static EventTrackingService eventTrackingService = (EventTrackingService)ComponentManager.get(EventTrackingService.class);
  
  /**
   * Does a gradebook exist?
   * @param gradebookUId the gradebook id
   * @param g  the Gradebook Service
   * @return true if the given gradebook exists
   */
  public boolean gradebookExists(String gradebookUId, GradebookService g)
  {
    log.debug("GradebookService = " + g);
    if (gradebookUId == null)
    {
      return false;
    }
    return g.isGradebookDefined(gradebookUId);
  }
  
	/**
	 *  Does a gradebook exist?
	 * @param siteId  the site id
	 * @return true if the given gradebook exists
	 */
	public boolean isGradebookExist(String siteId)
	{
		Site currentSite = getCurrentSite(siteId);
		if (currentSite == null) {
			return false;
		}
		SitePage page = null;
		String toolId = null;
		try {
			// get page
			List pageList = currentSite.getPages();
			for (int i = 0; i < pageList.size(); i++) {
				page = (SitePage) pageList.get(i);
				List pageToolList = page.getTools();
				try {
					toolId = ((ToolConfiguration) pageToolList.get(0)).getTool().getId();
				} catch (Exception ee) {
					log.warn(siteId + " contains a page (" + page.getTitle() + ") without a valid tool registration");
				}
				if (toolId != null && toolId.equalsIgnoreCase("sakai.gradebook.tool")) {
					return true;
				} else if (toolId != null && toolId.equalsIgnoreCase("sakai.gradebook.gwt.rpc")) {
					return true;
				}

			}
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		return false;
	}

	private Site getCurrentSite(String id) {
		Site site = null;
		try {
			site = SiteService.getSite(id);
		} catch (IdUnusedException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return site;
	}
	
  /**
   * Remove a published assessment from the gradebook.
   * @param gradebookUId the gradebook id
   * @param g  the Gradebook Service
   * @param publishedAssessmentId the id of the published assessment
   * @throws java.lang.Exception
   */
  public void removeExternalAssessment(String gradebookUId,
   String publishedAssessmentId, GradebookService g) throws Exception
  {
    if (g.isGradebookDefined(gradebookUId))
    {
      g.removeExternalAssessment(gradebookUId, publishedAssessmentId);
    }
  }

	public Long getExternalAssessmentCategoryId(String gradebookUId,
		   String publishedAssessmentId, GradebookExternalAssessmentService g) {
		Long categoryId = null;
		if (g.isGradebookDefined(gradebookUId)) 
		{
			categoryId = g.getExternalAssessmentCategoryId(gradebookUId, publishedAssessmentId);
		}
		return categoryId;
	}

  public boolean isAssignmentDefined(String assessmentTitle,
                                GradebookService g) throws Exception
  {
    String gradebookUId = GradebookFacade.getGradebookUId();
    return g.isAssignmentDefined(gradebookUId, assessmentTitle);
  }

  public boolean addToGradebook(PublishedAssessmentData publishedAssessment,
          GradebookExternalAssessmentService g) throws Exception
  {
	  return addToGradebook(publishedAssessment, null, g);
  }

  /**
   * Add a published assessment to gradebook.
   * @param publishedAssessment the published assessment
   * @param g  the Gradebook Service
   * @return false: cannot add to gradebook
   * @throws java.lang.Exception
   */
  public boolean addToGradebook(PublishedAssessmentData publishedAssessment, Long categoryId,
                                GradebookExternalAssessmentService g) throws
    Exception
  {
    //log.info("total point(s) is/are =" +
    //          publishedAssessment.getTotalScore().longValue());
    //log.info("gradebookId =" + GradebookFacade.getGradebookUId());
    boolean added = false;
    //log.info("GradebookService instance=" + g);
    String gradebookUId = GradebookFacade.getGradebookUId();
    if (gradebookUId == null)
    {
      return false;
    }

    //log.info("inside addToGradebook, gradebook exists? " +
    //          g.isGradebookDefined(gradebookUId));
    if (g.isGradebookDefined(gradebookUId))
    {
      String title = StringEscapeUtils.unescapeHtml(publishedAssessment.getTitle());
      if(!g.isAssignmentDefined(gradebookUId, title))
      {
        g.addExternalAssessment(gradebookUId,
                              publishedAssessment.getPublishedAssessmentId().
                              toString(), null,
                              title,
                              publishedAssessment.getTotalScore().doubleValue(),
                              publishedAssessment.getAssessmentAccessControl().
                              getDueDate(),
                              "sakai.samigo",
                              false,
                              categoryId); // For i18n issues, use this constant
        added = true;
      }
    }
    return added;
  }

  /**
   * Update a gradebook.
   * @param publishedAssessment the published assessment
   * @param g  the Gradebook Service
   * @return false: cannot update the gradebook
   * @throws java.lang.Exception
   */
  public boolean updateGradebook(PublishedAssessmentIfc publishedAssessment,
		  GradebookService g) throws Exception
  {
    log.debug("updateGradebook start");
    String gradebookUId = GradebookFacade.getGradebookUId();
    if (gradebookUId == null)
    {
      return false;
    }

    log.debug("before g.isAssignmentDefined()");
	g.updateExternalAssessment(gradebookUId,
				publishedAssessment.getPublishedAssessmentId().
				toString(), null,
				publishedAssessment.getTitle(),
				publishedAssessment.getTotalScore().doubleValue(),
				publishedAssessment.getAssessmentAccessControl().
				getDueDate());
    return true;
  }

  /**
   * Update the grading of the assessment.
   * @param ag the assessment grading.
   * @param g  the Gradebook Service
   * @throws java.lang.Exception
   */
  public void updateExternalAssessmentScore(AssessmentGradingIfc ag,
   GradebookService g) throws
    Exception
  {
    boolean testErrorHandling=false;
    //log.info("GradebookService instance=" + g);
    PublishedAssessmentService pubService = new PublishedAssessmentService();
    GradingService gradingService = new GradingService();
    PublishedAssessmentIfc pub = (PublishedAssessmentIfc) gradingService.getPublishedAssessmentByAssessmentGradingId(ag.getAssessmentGradingId().toString());

    String gradebookUId = pubService.getPublishedAssessmentOwner(
        pub.getPublishedAssessmentId());
    if (gradebookUId == null)
    {
      return;
    }
    
    //SAM-1562 We need to round the float score and covert to a double -DH
    float fScore = MathUtils.round(ag.getFinalScore(), 2);
    Double score = Float.valueOf(fScore).doubleValue();
    log.info("rounded:  " + ag.getFinalScore() + " to: " + score.toString() );
    g.updateExternalAssessmentScore(gradebookUId,
      ag.getPublishedAssessmentId().toString(),
      ag.getAgentId(),  score);
    if (testErrorHandling){
      throw new Exception("Encountered an error in update ExternalAssessmentScore.");
    }
  }
  
  public void updateExternalAssessmentScores(Long publishedAssessmentId, final Map studentUidsToScores,
		  GradebookService g) throws Exception {
	  boolean testErrorHandling=false;
	  PublishedAssessmentService pubService = new PublishedAssessmentService();
	  String gradebookUId = pubService.getPublishedAssessmentOwner(publishedAssessmentId);
	  if (gradebookUId == null) {
		  return;
	  }
	  g.updateExternalAssessmentScores(gradebookUId,
			  publishedAssessmentId.toString(),
			  studentUidsToScores);

	  if (testErrorHandling){
		  throw new Exception("Encountered an error in update ExternalAssessmentScore.");
	  }
  }
  
  /**
   * 
   * @param g the GradebookService
   * @return a list of Assignments linked with Assessments
   * @exception GradebookNotFoundException
   */
  public List<String> getAssignments(GradebookService g) throws GradebookNotFoundException {
	  List<String> assignments = new ArrayList<String>();
	  
	  Iterator iter = g.getAssignments(GradebookFacade.getGradebookUId()).iterator();
	  while (iter.hasNext()) {
		  Assignment assignment = (Assignment)iter.next(); 
		  if (assignment.getExternalAppName() == null || "".equals(assignment.getExternalAppName())) {
			  assignments.add(assignment.getName());
		  }
	  }
	  
	  return assignments;
  }

  /**
   * Update the grading of the assessment.
   * @param ag the assessment grading.
   * @param assignmentName the assignment name
   * @param g  the Gradebook Service
   * @throws java.lang.Exception
   */
  public void updateAssignmentScore(AssessmentGradingIfc ag, String assignmentName, 
   GradebookService g) throws Exception
  {
    boolean testErrorHandling=false;
    //log.info("GradebookService instance=" + g);
    PublishedAssessmentService pubService = new PublishedAssessmentService();
    GradingService gradingService = new GradingService();
    PublishedAssessmentIfc pub = (PublishedAssessmentIfc) gradingService.getPublishedAssessmentByAssessmentGradingId(ag.getAssessmentGradingId().toString());

    String gradebookUId = pubService.getPublishedAssessmentOwner(
        pub.getPublishedAssessmentId());
    if (gradebookUId == null)
    {
      return;
    }
    //SAM-1562 We need to round the float score and covert to a double -DH
    float fScore = MathUtils.round(ag.getFinalScore().floatValue(), 2);
    Double score = Float.valueOf(fScore).doubleValue();
    log.info("rounded:  " + ag.getFinalScore() + " to: " + score.toString() );    
        
    try {
    	securityService.pushAdvisor(this);
		g.setAssignmentScoreString(gradebookUId, assignmentName, ag.getAgentId(), getFormattedScore(score), null);
		postUpdateGradeEvent(gradebookUId, assignmentName, ag.getAgentId(), Float.valueOf(fScore), g);
	} catch (Exception e) {
		log.warn("Error when trying to send the score to a gradebook.", e);
	} finally {
		securityService.popAdvisor(this);
	}
    
    if (testErrorHandling){
      throw new Exception("Encountered an error in update ExternalAssessmentScore.");
    }
  }
  
  	public void postUpdateGradeEvent(String gradebookUid, String assignmentName, String studentUid, Float pointsEarned, GradebookService g) {
  		//SAM-1562 We need to round the float score and covert to a double -DH
  		float fScore = MathUtils.round(pointsEarned.floatValue(), 2);
  		Double score = Float.valueOf(fScore).doubleValue();
	  
  		Assignment assignment = null;
  		try {
  	    	securityService.pushAdvisor(this);
  	    	assignment = g.getAssignment(gradebookUid, assignmentName);
  		} catch (Exception e) {
  			log.warn("Error when trying to send the score to a gradebook.", e);
  		} finally {
  			securityService.popAdvisor(this);
  		}
  		
  		if (eventTrackingService != null) {
  			Event event = eventTrackingService.newEvent(
  					"gradebook.updateItemScore", 
  					"/gradebook/"+gradebookUid+"/"+assignment.getId()+"/"+studentUid+"/"+score.toString()+"/student", 
  					true);
  	        eventTrackingService.post(event);
  		}
	}
  
  public void updateAssignmentScores(Long publishedAssessmentId, String assignmentName, 
		  final Map studentUidsToScores, GradebookService g) throws Exception {
	  
	  boolean testErrorHandling=false;
	  PublishedAssessmentService pubService = new PublishedAssessmentService();
	  String gradebookUId = pubService.getPublishedAssessmentOwner(publishedAssessmentId);
	  if (gradebookUId == null) {
		  return;
	  }
	  
	  Iterator it = studentUidsToScores.keySet().iterator();
	  while (it.hasNext()) {
		  String agentId = (String)it.next();
		  Double score = (Double)studentUidsToScores.get(agentId);
		  g.setAssignmentScoreString(gradebookUId, assignmentName, agentId, getFormattedScore(score), null);
		  postUpdateGradeEvent(gradebookUId, assignmentName, agentId, Float.valueOf(score.toString()), g);
	  }
	  
	  if (testErrorHandling){
		  throw new Exception("Encountered an error in update ExternalAssessmentScore.");
	  }
  }
  
  	private String getFormattedScore(Double score) {
  		Locale locale = null;
  		String userId = AgentFacade.getEid();
  		
		// check if locale is requested for specific user
		if (userId != null)
		{
			PreferencesService preferencesService = (PreferencesService) 
				  ComponentManager.get(PreferencesService.class);
			locale = preferencesService.getLocale(userId);
		}
		 
		if (locale == null)
		{
			SessionManager sessionMngr = (SessionManager)
					ComponentManager.get(SessionManager.class);
			locale = (Locale) sessionMngr.getCurrentSession().getAttribute("sakai.locale."+sessionMngr.getCurrentSessionUserId());
		}
		
		if (locale == null)
		{
			locale = Locale.getDefault();
		}
  		
		// get localized number format
		NumberFormat nbFormat = NumberFormat.getInstance();				
		try {
			nbFormat = NumberFormat.getNumberInstance(locale);
		}					
		catch (Exception e) {
			log.warn("Error while retrieving local number format, using default ", e);
		}
		nbFormat.setMaximumFractionDigits(2);
		nbFormat.setMinimumFractionDigits(1);
		nbFormat.setGroupingUsed(false);
		  
		return nbFormat.format(score);
  	}
	
  	/**
  	 * Comprueba si el usuario tiene los permisos de gradeAll (si es un profesor)
  	 * Si es un alumno deberia tener los permisos de submitAssessmentForGrade
  	 */
	public SecurityAdvice isAllowed(String userId, String function, String reference)
	{
		boolean isAllowed = authzGroupService.isAllowed(userId, function, reference);
		if (!isAllowed) {
			isAllowed = authzGroupService.isAllowed(userId, "assessment.submitAssessmentForGrade", reference);
		}
		
		return isAllowed ? SecurityAdvice.ALLOWED : SecurityAdvice.NOT_ALLOWED;
	}
}
