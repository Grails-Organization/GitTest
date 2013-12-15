package com.testapp

class File {
    String name
	String type
	int size
	byte[] file
	static auditable = true
	static constraints = {
		file(nullable:true, maxSize:1073741824) // max of 4GB file for example
		type(blank:true, nullable:true)
		name(blank:true, nullable:true)
	}
}
