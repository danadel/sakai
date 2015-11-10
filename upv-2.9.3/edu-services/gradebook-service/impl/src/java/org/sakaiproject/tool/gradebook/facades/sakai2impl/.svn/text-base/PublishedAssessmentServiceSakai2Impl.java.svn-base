/**********************************************************************************
*
* $Id: UserDirectoryServiceSakai2Impl.java 59674 2009-04-03 23:05:58Z arwhyte@umich.edu $
*
***********************************************************************************
*
 * Copyright (c) 2005, 2006, 2007, 2008 The Sakai Foundation, The MIT Corporation
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

package org.sakaiproject.tool.gradebook.facades.sakai2impl;

import java.util.List;

import org.sakaiproject.tool.assessment.facade.PublishedAssessmentFacade;
import org.sakaiproject.tool.assessment.facade.PublishedAssessmentFacadeQueriesAPI;
import org.sakaiproject.tool.gradebook.facades.PublishedAssessmentService;

/**
 * Sakai2 implementation of the gradebook PublishedAssessmentService API.
 */
public class PublishedAssessmentServiceSakai2Impl implements PublishedAssessmentService {
    
	private PublishedAssessmentFacadeQueriesAPI publishedAssessmentFacadeQueries;
	
	@Override
	public List getBasicInfoOfAllPublishedAssessments(String orderBy, boolean ascending, String siteId) {
		
		List<PublishedAssessmentFacade> assessments = publishedAssessmentFacadeQueries.getBasicInfoOfAllPublishedAssessments2(orderBy, ascending, siteId);
		
		return assessments;
	}
	
	public Object getPublishedAssessment(Long assessmentId) {
		return publishedAssessmentFacadeQueries.getPublishedAssessment(assessmentId);
	}
	
	public PublishedAssessmentFacadeQueriesAPI getPublishedAssessmentFacadeQueries() {
		return publishedAssessmentFacadeQueries;
	}
	
	public void setPublishedAssessmentFacadeQueries(
			PublishedAssessmentFacadeQueriesAPI publishedAssessmentFacadeQueries) {
		this.publishedAssessmentFacadeQueries = publishedAssessmentFacadeQueries;
	}
}
