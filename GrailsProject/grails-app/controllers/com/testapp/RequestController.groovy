package com.testapp

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class RequestController {

    def index() { 
		if(SpringSecurityUtils.ifAnyGranted("ROLE_ADMIN")){
			redirect controller:"user"
			return
		}
		if(SpringSecurityUtils.ifAnyGranted("ROLE_USER")){
			redirect controller:"secure",action: "index"
			return
		}
		
	}
}
