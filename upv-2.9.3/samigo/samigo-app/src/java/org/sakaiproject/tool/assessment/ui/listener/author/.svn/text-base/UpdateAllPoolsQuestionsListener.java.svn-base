package org.sakaiproject.tool.assessment.ui.listener.author;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.sakaiproject.tool.assessment.services.assessment.AssessmentService;
import org.sakaiproject.tool.assessment.ui.bean.author.AssessmentBean;
import org.sakaiproject.tool.assessment.ui.bean.delivery.SectionContentsBean;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;

public class UpdateAllPoolsQuestionsListener  implements ActionListener{
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		
		AssessmentBean assessmentBean = (AssessmentBean) ContextUtil.lookupBean("assessmentBean");
		List<SectionContentsBean> listSectionBean = assessmentBean.getSections();
		
		for (SectionContentsBean sectionBean : listSectionBean) {
			if (sectionBean.getPoolIdToBeDrawn() != null) {
				int success = assessmentBean.updateRandomPoolQuestions(sectionBean.getSectionId());
				if(success != AssessmentService.UPDATE_SUCCESS){
					FacesContext context = FacesContext.getCurrentInstance();
					if(success == AssessmentService.UPDATE_ERROR_DRAW_SIZE_TOO_LARGE){  		    		
						String err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AuthorMessages","update_pool_error_size_too_large");
						context.addMessage(null,new FacesMessage(err));
					}else{
						String err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AuthorMessages","update_pool_error_unknown");
						context.addMessage(null,new FacesMessage(err));
					}
				}
			}
		}
	}

}
