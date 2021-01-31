package com.ph.dir.app.util;

import com.ph.dir.app.constants.Constants;

public class Utility {

	private Utility(){
		
	}
	
	public static boolean isNotBlank(Object param){
		return (param == null || param == Constants.BLANK)?false:true;
	} 
}
