/**
 * 
 */
package com.xmhuanyu.eport.third.Util.Spring;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author EDA
 * 
 */
public class ViewScope implements Scope {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.Scope#get(java.lang.String,
	 * org.springframework.beans.factory.ObjectFactory)
	 */
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		if (FacesContext.getCurrentInstance().getViewRoot() != null) {
			Map<String, Object> viewMap = FacesContext.getCurrentInstance()
					.getViewRoot().getViewMap();
			if (viewMap.containsKey(name)) {
				return viewMap.get(name);
			} else {
				Object object = objectFactory.getObject();
				viewMap.put(name, object);
				return object;
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.Scope#getConversationId()
	 */
	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.config.Scope#registerDestructionCallback
	 * (java.lang.String, java.lang.Runnable)
	 */
	@Override
	public void registerDestructionCallback(String arg0, Runnable arg1) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.config.Scope#remove(java.lang.String)
	 */
	@Override
	public Object remove(String name) {
		if (FacesContext.getCurrentInstance().getViewRoot() != null) {
			return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
					.remove(name);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.config.Scope#resolveContextualObject
	 * (java.lang.String)
	 */
	@Override
	public Object resolveContextualObject(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
