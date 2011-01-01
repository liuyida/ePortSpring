package com.xmhuanyu.eport.page;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.xmhuanyu.eport.entity.SysUser;
import com.xmhuanyu.eport.services.SysUserServices;

/**
 * @category 系统登录界面
 * @author EDA
 * 
 */
public class LoginPage {

	private String loginName;
	private String loginPwd;

	private SysUserServices userServices;

	public String login() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = true;
		SysUser user = userServices.getSysUserByLoginId(loginName);
		if (user == null) {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "登录错误",
					"该用户名未注册！");
		}
		if (!user.getLoginPwd().equals(loginPwd)) {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "登录错误", "密码出错！");
		}
		context.addCallbackParam("loggedIn", loggedIn);  
		if (!loggedIn) {
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		Date tmp = Calendar.getInstance().getTime();
		user.setLastLoginTime(tmp);
		userServices.changeLoginTime(user);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SysUser", user); 
		return "/pages/index.xhtml";
	}

}
