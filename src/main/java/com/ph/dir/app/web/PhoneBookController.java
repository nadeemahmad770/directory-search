package com.ph.dir.app.web;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ph.dir.app.constants.Constants;
import com.ph.dir.app.constants.URLConstants;
import com.ph.dir.app.exception.NoDataFoundException;
import com.ph.dir.app.service.PhoneBookService;
 
@RestController
@RequestMapping(URLConstants.DIRECTORY_SERVICE)
public class PhoneBookController
{
    @Autowired
    PhoneBookService phoneBookService;
 
    
    @GetMapping(URLConstants.DIRECTORY_LOAD)
    public ModelAndView getAllEmployeess() {
        return new ModelAndView(URLConstants.HOME_PAGE_JSP);
    }
    
    @GetMapping(URLConstants.DIRECTORY_SEARCH)
    public @ResponseBody String search(@RequestParam(Constants.DATA) String contactName) throws NoDataFoundException, JSONException{
    	return phoneBookService.loadSearchData(contactName);
    }
}