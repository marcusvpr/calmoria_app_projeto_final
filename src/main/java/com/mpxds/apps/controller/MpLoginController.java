package com.mpxds.apps.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
public class MpLoginController {
    //
	public String email = "marcus_vpr@hotmail.com";
	public String password = "1234567";
	
	// ---
	
    @PostConstruct
    public void init() {
        //
    	System.out.println("MpLoginController.init() ...000 " + this.email + " / " + this.password);
    }

	public void entrar() {
		//
    	System.out.println("entrar() ... " + this.email + " /  " + this.password);
	}
    
}