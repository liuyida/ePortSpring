package com.xmhuanyu.eport.page;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.xmhuanyu.eport.entity.SysUser;
import com.xmhuanyu.eport.services.SysUserServices;

/**
 * @category 系统登录界面
 * @author EDA
 * 
 */
@Named("loginPage")
@Scope("request")
public class LoginPage {
	private final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private String loginName;
	private String loginPwd;
    @Inject
	private SysUserServices userServices;

	public String login() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = true;
		SysUser user = userServices.getSysUserByLoginId(loginName);
		if (user == null) {
			loggedIn = false;	
			logger.info("23");
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "登录错误",
					"该用户名未注册！");			
		}else
		if (!user.getLoginPwd().equals(loginPwd)) {
			loggedIn = false;
			logger.info("12");
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "登录错误", "密码出错！");			
		}
		context.addCallbackParam("loggedIn", loggedIn);  
		if (!loggedIn) {
			logger.info("34");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login.faces";
		}

		Date tmp = Calendar.getInstance().getTime();
		user.setLastLoginTime(tmp);
		userServices.changeLoginTime(user);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SysUser", user); 
		return "/pages/index.xhtml";
	}
	
	public String login1(){
			return "/pages/index.xhtml";
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	

}
