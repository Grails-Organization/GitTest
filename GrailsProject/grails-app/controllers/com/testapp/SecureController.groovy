package com.testapp

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class SecureController {
	def springSecurityService
    def index() {
		
		println "Hello user===="+springSecurityService.currentUser.username
		
		
	}
}
