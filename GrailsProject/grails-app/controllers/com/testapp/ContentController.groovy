package com.testapp

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class ContentController {
	def imageUploaderService
    def index() { 
		
		
	}
	def upload() {
		def fileInstance = new File(params)
		def uploadedFile = request.getFile("filePayload")
		fileInstance.file = uploadedFile.getBytes() 
		fileInstance.name = uploadedFile.originalFilename //getting the file name from the uploaded file
		fileInstance.type = uploadedFile.contentType//getting and storing the file type
		fileInstance.size = uploadedFile.getSize()
		def file =imageUploaderService.imageConverter(uploadedFile)
		fileInstance.file = file.getBytes() //converting the file to bytes
		if(!fileInstance.save()){
			fileInstance.errors.allErrors.each{
				println "error="+it
				
			}
			
		} //Create the record in DB by sending the needed Select command
		redirect(action: "list")
	}
	
	def list(){
		
		def fileList = File.list()
		[fileList:fileList]		
	}
	
	def showPayload() {
		def fileInstance = File.get(params.id)
		response.outputStream << fileInstance.file // write the image to the outputstream
		response.outputStream.flush()
		}
	
}
