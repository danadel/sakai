/**********************************************************************************
 * $URL: https://source.sakaiproject.org/contrib/conditionalrelease/tags/sakai_2-4-1/impl/src/java/org/sakaiproject/conditions/impl/ResourceReleaseRule.java $
 * $Id: ResourceReleaseRule.java 44304 2007-12-17 04:35:22Z zach.thomas@txstate.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006, 2007, 2008 Sakai Foundation
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
package org.sakaiproject.tool.assessment.conditionalrelease;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.sakaiproject.authz.api.AuthzGroup;
import org.sakaiproject.authz.api.GroupNotDefinedException;
import org.sakaiproject.authz.api.Member;
import org.sakaiproject.authz.api.SecurityAdvisor;
import org.sakaiproject.authz.api.AuthzGroupService;
import org.sakaiproject.authz.api.SecurityService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.conditions.api.Condition;
import org.sakaiproject.conditions.api.Rule;
import org.sakaiproject.content.api.ContentHostingService;
import org.sakaiproject.event.api.Event;
import org.sakaiproject.event.api.Notification;
import org.sakaiproject.event.api.NotificationAction;
import org.sakaiproject.event.api.Obsoletable;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.PermissionException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.sakaiproject.tool.assessment.data.ifc.assessment.AssessmentAccessControlIfc;
import org.sakaiproject.tool.assessment.services.assessment.PublishedAssessmentService;
import org.sakaiproject.conditions.api.ConditionService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author zach
 *
 */
public class AssessmentReleaseRule implements Rule, Obsoletable {
	//private static final String SATISFIES_RULE = "resource.satisfies.rule";
	//private static final long LENGTH_OF_A_DAY = 86400000; // length of a day in milliseconds
	private String resourceId;
	private List<Condition> predicates;
	private Conjunction conj;
	
	private static Log log = LogFactory.getLog(AssessmentReleaseRule.class);
	
	private ContentHostingService chs = (ContentHostingService)ComponentManager.get("org.sakaiproject.content.api.ContentHostingService");
	public void setContentHostingService(ContentHostingService chs) {
		this.chs = chs;
	}

	private ConditionService conditionService = (ConditionService) ComponentManager.get("org.sakaiproject.conditions.api.ConditionService");
	public void setConditionService(ConditionService conditionService) {
		this.conditionService = conditionService;
	}
	
	private SecurityService securityService = (SecurityService)ComponentManager.get("org.sakaiproject.authz.api.SecurityService");
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	
	private AuthzGroupService authzGroupService = (AuthzGroupService)ComponentManager.get("org.sakaiproject.authz.api.AuthzGroupService");;
	public void setAuthzGroupService(AuthzGroupService authzGroupService) {
		this.authzGroupService = authzGroupService;
	}

	// we need a no-arg constructor so BaseNotificationService can instantiate these things with Class.forName(className).newInstance();
	public AssessmentReleaseRule() {

	}
	
	public AssessmentReleaseRule(String resourceId, List<Condition> predicates, Conjunction conj) {
		this.resourceId = resourceId;
		this.predicates = predicates;
		this.conj = conj;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.collections.Predicate#evaluate(java.lang.Object)
	 */
	public boolean evaluate(Object arg0) {
		Predicate judgement = new NullPredicate();
		if (predicates.size() == 1) {
			judgement = predicates.get(0);
		} else {
			if (conj == Conjunction.AND) {
				judgement = PredicateUtils.allPredicate(predicates);
			}
			else if (conj == Conjunction.OR) {
				judgement = PredicateUtils.anyPredicate(predicates);
			}
		}
		
		return judgement.evaluate(arg0);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.event.api.NotificationAction#getClone()
	 */
	public NotificationAction getClone() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.event.api.NotificationAction#notify(org.sakaiproject.event.api.Notification, org.sakaiproject.event.api.Event)
	 */
	public void notify(Notification notification, Event event) {
		System.out.println("---------------- AssessmentReleaseRule.notify ----------------------");
		
		securityService.pushAdvisor(new SecurityAdvisor() {
			public SecurityAdvice isAllowed(String userId, String function,
					String reference) {
				return SecurityAdvice.ALLOWED;
			}
		});
		
		System.out.println("	> event: " + event.getEvent());
		System.out.println("	> event.resource: " + event.getResource());

		String siteId = notification.getProperties().getProperty("AssociatedSite");
		
		if(notification.getProperties().getProperty("AssociatedTool")!=null
				&& siteId != null){
				
			System.out.println("	> siteId: " + siteId);
			System.out.println("	> assessmentId (examen publicado): " + this.resourceId);
			
			try {
				
				PublishedAssessmentService assessmentService = new PublishedAssessmentService();
				AssessmentAccessControlIfc accessControl = assessmentService.loadPublishedAccessControl(Long.valueOf(this.resourceId));
				System.out.println("	> EXAMEN PUBLICADO");
				
				if (("gradebook.updateItemScore").equals(event.getEvent())) {
					AssignmentGrading grading = produceAssignmentGradingFromEvent(event);
					System.out.println("	> grading.score: " + grading.getScore());
					System.out.println("	> grading.itemGB: " + grading.getItemGBId());
					
					boolean shouldBeAvailable = this.evaluate(grading);
					// update access control list on ContentHostingService here
					
					// since we're following a per-user event now, the global rule property should be removed
					accessControl.setSatisfiesRule(null);

					List<String> prop = null;
					if(accessControl.getConditionalAccessList()!=null)
						prop = Arrays.asList( accessControl.getConditionalAccessList().replaceAll("\\[|\\]| ","").split(",") );
					if (prop == null) prop = new ArrayList<String>();
					Set<String> acl = new TreeSet<String>(prop);
					if ((shouldBeAvailable && acl.contains(grading.getUserId()))
						|| (!shouldBeAvailable && !acl.contains(grading.getUserId()))) {
						// no change to the ACL necessary, but we still have to commit the change to SATISFIES_RULE
						//assessment.setAssessmentAccessControl(accessControl);
						assessmentService.saveOrUpdatePublishedAccessControl(accessControl);
						securityService.popAdvisor(null);//??
						return;
					}
					if (!shouldBeAvailable && acl.contains(grading.getUserId())) {
						// remove user from access list
						acl.remove(grading.getUserId());
						// time to re-populate the property list, start by tearing it down
						// we only have to do it this way because props does not have a removePropertyFromList method
						accessControl.setConditionalAccessList((new ArrayList<String>(acl)).toString());
					} else if (shouldBeAvailable && !acl.contains(grading.getUserId()))  {
						// add user to access list						
						acl.add(grading.getUserId());
						accessControl.setConditionalAccessList((new ArrayList<String>(acl)).toString());
					}
					
					assessmentService.saveOrUpdatePublishedAccessControl(accessControl);
					
				} else if ("gradebook.updateAssignment".equals(event.getEvent()) || ("cond+gradebook.updateAssignment").equals(event.getEvent()) || ("datetime.update".equals(event.getEvent()))) {
					// this availability applies to the whole Resource, not on a per-user basis
					// TODO set the resource availability
					AssignmentUpdate update = produceAssignmentUpdateFromEvent(event);
					boolean shouldBeAvailable = this.evaluate(update);
					
					accessControl.setSatisfiesRule(Boolean.valueOf(shouldBeAvailable));
					assessmentService.saveOrUpdatePublishedAccessControl(accessControl);
					
				} else if (("cond+gradebook.updateItemScore").equals(event.getEvent())) {
					// this event means the Rule has just been added
					// and we need to look at any scores that may have been recorded already
					
					String[] assignmentRefParts = event.getResource().split("/");
					AuthzGroup group = authzGroupService.getAuthzGroup("/site/" + siteId);
					Set<Member> members = group.getMembers();			
					// build access control list up from scratch using site members
					Set<String> acl = new HashSet<String>();
					for (Member member : members) {
						boolean shouldBeAvailable = false;
						if (! member.getRole().getId().equals(group.getMaintainRole())) {
							Map<String,String> scoreData = conditionService.getConditionProvider("gradebook").getData("grades", assignmentRefParts[2] + "|" + assignmentRefParts[3] + "|" + member.getUserId());
							String scoreString = scoreData.get("score");
							Double score = null;
							Long itemGB = Long.parseLong(scoreData.get("assignmentId"));
							if ((scoreString!=null) && (scoreString.trim().length()>0)){
								try {
									score = Double.parseDouble(scoreString);
								} catch (NumberFormatException e) {
									//continue;
								}
							}
							
							AssignmentGrading grading = produceAssignmentGrading(member.getUserId(), score, itemGB);
							shouldBeAvailable = this.evaluate(grading);
						}
						if (shouldBeAvailable) acl.add(member.getUserId());	
					}

					// since we're following a per-user event now, the global rule property should be removed
					accessControl.setSatisfiesRule(null);
					accessControl.setConditionalAccessList((new ArrayList<String>(acl)).toString());
						
					assessmentService.saveOrUpdatePublishedAccessControl(accessControl);
				} 
				
			} catch(GroupNotDefinedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				securityService.popAdvisor(null);
			}
			
		}
	}

	public boolean isObsolete() {
		securityService.pushAdvisor(new SecurityAdvisor() {
			public SecurityAdvice isAllowed(String userId, String function,
					String reference) {
				return SecurityAdvice.ALLOWED;
			}
		});
		try {
			chs.getProperties(this.resourceId);
			return false;
		} catch (PermissionException e1) {
			return true;
		} catch (IdUnusedException e1) {
			return true;
		} finally {
			securityService.popAdvisor(null);
		}
	}
	

	private AssignmentUpdate produceAssignmentUpdateFromEvent(Event event) {
		// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
		AssignmentUpdate rv = new AssignmentUpdate();
		if ("datetime.update".equals(event.getEvent())) {
			for (Predicate p : this.predicates) {
				if (((Condition)p).getArgument() != null) {
					Object arg = ((Condition)p).getArgument();
					if ((arg instanceof String) && (((String)arg).startsWith("dateMillis:"))) {
						rv.setDueDate(new java.util.Date(Long.parseLong(((String)((Condition)p).getArgument()).substring("dateMillis:".length()))));
					}
					return rv;
				}
			}
			return rv;
		}
		String[] assignmentRefParts = event.getResource().split("/");
		rv.setItemGBId(Long.parseLong(assignmentRefParts[3]));
		rv.setDueDate(new Date(Long.parseLong(assignmentRefParts[5])));
		rv.setIncludedInCourseGrade(Boolean.parseBoolean(assignmentRefParts[7]));
		rv.setReleasedToStudents(Boolean.parseBoolean(assignmentRefParts[6]));
		// since we've received an update, we'd better update the predicates
		for (Predicate p : this.predicates) {
			if (((Condition)p).getArgument() != null) {
				Object arg = ((Condition)p).getArgument();
				if ((arg instanceof String) && (((String)arg).startsWith("dateMillis:"))) {
					((BooleanExpression)p).setArgument("dateMillis:" + rv.getDueDate().getTime());
				}
			}
		}
		return rv;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.event.api.NotificationAction#set(org.w3c.dom.Element)
	 */
	public void set(Element el) {

		// setup for predicates
		predicates = new Vector<Condition>();

		this.resourceId = el.getAttribute("resourceId");
		
		String conjunction = el.getAttribute("conjunction");
		if("OR".equals(conjunction)) {
			this.conj = Rule.Conjunction.OR;
		} else if("AND".equals(conjunction)) {
			this.conj = Rule.Conjunction.AND;
		}

		// the children (predicates)
		NodeList children = el.getChildNodes();
		final int length = children.getLength();
		for (int i = 0; i < length; i++)
		{
			Node child = children.item(i);
			if (child.getNodeType() != Node.ELEMENT_NODE) continue;
			Element element = (Element) child;

			// look for properties
			if (element.getTagName().equals("predicates"))
			{
				// re-create properties
				predicates = reconstitutePredicates(element);
			}
		}
	}

	private List<Condition> reconstitutePredicates(Element element) {
		List<Condition> rv = new ArrayList<Condition>();
		try {
			Condition aPredicate = null;
			NodeList children = element.getChildNodes();
			final int length = children.getLength();
			for (int i = 0; i < length; i++) {
				Node child = children.item(i);
				if (child.getNodeType() != Node.ELEMENT_NODE) continue;
				Element predicate = (Element) child;

				// look for properties
				if (predicate.getTagName().equals("predicate")) {
					String className = predicate.getAttribute("class");
					aPredicate = (Condition) Class.forName(className).newInstance();
					((BooleanExpression) aPredicate).setReceiver(predicate.getAttribute("receiver"));
					((BooleanExpression) aPredicate).setMethod(predicate.getAttribute("method"));
					((BooleanExpression) aPredicate).setOperator(predicate.getAttribute("operator"));
					((BooleanExpression) aPredicate).setArgument(predicate.getAttribute("argument"));
					rv.add(aPredicate);
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rv;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.event.api.NotificationAction#set(org.sakaiproject.event.api.NotificationAction)
	 */
	public void set(NotificationAction other) {
		AssessmentReleaseRule eOther = (AssessmentReleaseRule) other;
		resourceId = eOther.resourceId;

	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.event.api.NotificationAction#toXml(org.w3c.dom.Element)
	 */
	public void toXml(Element el) {
		el.setAttribute("resourceId", this.resourceId);
		
		if(this.conj == Rule.Conjunction.OR) {
			el.setAttribute("conjunction", "OR");
		} else if(this.conj == Rule.Conjunction.AND) {
			el.setAttribute("conjunction", "AND");
		}
		
		Element predicates = el.getOwnerDocument().createElement("predicates");
		el.appendChild(predicates);
		for (Predicate p : this.predicates) {
			Element predicateElement = el.getOwnerDocument().createElement("predicate");
			predicateElement.setAttribute("class", p.getClass().getName());
			predicateElement.setAttribute("receiver", ((BooleanExpression)p).getReceiver());
			predicateElement.setAttribute("method", ((BooleanExpression)p).getMethod());
			predicateElement.setAttribute("operator", ((BooleanExpression)p).getOperator());
			Object argument = ((BooleanExpression)p).getArgument();
			if (argument == null) {
				argument = "";
			}
			predicateElement.setAttribute("argument", argument.toString());
			predicates.appendChild(predicateElement);
		}

	}
	
	private AssignmentGrading produceAssignmentGradingFromEvent(Event event) {
		Double score;
		String userId;
		Long itemGB;
		String[] assignmentRefParts = event.getResource().split("/");
		// a score may be null after a grading event
		try {
			score = new Double(assignmentRefParts[5]);
		} catch (NumberFormatException e) {
			score = null;
		}
		userId = assignmentRefParts[4];
		
		itemGB = Long.parseLong(assignmentRefParts[3]);
		return produceAssignmentGrading(userId, score, itemGB);
	}
	
	private AssignmentGrading produceAssignmentGrading(String userId, Double score, Long itemGB) {
		AssignmentGrading rv = new AssignmentGrading();
		rv.setUserId(userId);
		rv.setScore(score);
		rv.setItemGBId(itemGB);
		return rv;
	}
	
}
