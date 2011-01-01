package com.xmhuanyu.eport.services;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @category 用户登录情况验证
 * @author EDA
 *
 */
public class LoginPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext fc = event.getFacesContext();
		 // Check to see if they are on the login page.
        boolean loginPage = 
          fc.getViewRoot().getViewId().lastIndexOf("login") > -1 ? true : false;
        if (!loginPage && !loggedIn()) {
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "logout");
        }
	}

	private boolean loggedIn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
