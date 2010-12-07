package com.xmhuanyu.eport.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;

public class ListPage<T> {	

	private LazyDataModel<T> lazyModel;
	
	public ListPage() {
		lazyModel = new LazyDataModel<T>() {
			@Override
			public List<T> load(int first, int pageSize, String sortField,
					boolean sortOrder, Map<String, String> filters) {				
				List<T> lazyT=new ArrayList<T>();
				populateList(lazyT, first, pageSize);
				return lazyT;
			}
		};
	}

	protected void populateList(List<T> lazyT, int first, int pageSize) {
		// TODO Auto-generated method stub
		
	}


	public LazyDataModel<T> getLazyModel() {
		return lazyModel;
	}

}
