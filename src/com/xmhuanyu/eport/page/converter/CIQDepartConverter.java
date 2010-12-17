package com.xmhuanyu.eport.page.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.xmhuanyu.eport.entity.CIQDepart;

/**
 * @category CIQDepart对象转换器
 * @author EDA
 *
 */
@FacesConverter("CIQConverter")
public class CIQDepartConverter implements Converter{
   
	@Override
	public Object getAsObject(FacesContext fc, UIComponent ui, String value) {
		if(value==null||value.trim().length()==0)
			return new CIQDepart();
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent ui, Object value) {
		CIQDepart ciqDepart=null;
		if(value instanceof CIQDepart){
			ciqDepart=(CIQDepart)value;
			return ciqDepart.getCiqName();
		}
		return "";
	}

}
