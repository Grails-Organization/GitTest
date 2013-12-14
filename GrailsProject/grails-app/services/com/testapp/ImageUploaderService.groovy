package com.testapp

import java.awt.Color
import java.awt.Font

class ImageUploaderService {
	def burningImageService
	def grailsApplication
    def imageConverter(def file) {
		def uploadPath = grailsApplication.config.grails.file.upload
		try{
		burningImageService.doWith(file, grailsApplication.config.grails.file.upload)
		.execute {
			it.scaleAccurate(800,800)
		 }
		/*.execute {
			it.crop(0,0,50,50)
			//orginalFileName = it.watermark('path/to/watermark', ['right':10, 'bottom': 10])
		 }
		.execute {img ->
			img.text(Color.WHITE, new Font('Arial', Font.PLAIN, 30), {
				it.write("text one", 10, 10)
				it.write("text two", 100, 100)
				it.write("text three", 200, 200)
			})
	   }
		.execute ('thumbnail', {
			it.scaleAccurate(200, 200)
		 })
		*/
		def f = new java.io.File(grailsApplication.config.grails.file.upload+'/'+file?.originalFilename)
		return f
		}
		
		catch(Exception e){println "error"+e}
    }
}
