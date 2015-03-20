package com.app.mercadolibre

class Item {
	
	Long idd
	String name
	String description
	def images
	Float price
	Integer amount
	
	Item (Long idd, String name, String description, Float price, Integer amount, List<String> images) {
		this.idd = idd
		this.name = name
		this.description = description
		this.price = price
		this.amount = amount
		this.images = images
	}

    static constraints = {
    }
}
