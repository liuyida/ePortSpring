package com.xmhuanyu.eport.page.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.xmhuanyu.eport.entity.CIQDepart;

/**
 * @category CIQDepart对象转换器
 * @author EDA
 *
 */
public class CIQDepartConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value==null||value.trim().length()==0)
			return value;
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		CIQDepart ciqDepart=null;
		if(value instanceof CIQDepart){
			ciqDepart=(CIQDepart)value;
			return ciqDepart.getCiqName();
		}
		return "";
	}

}
