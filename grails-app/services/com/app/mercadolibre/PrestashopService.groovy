package com.app.mercadolibre

import grails.transaction.Transactional


@Transactional
class PrestashopService {
	
	
	// TODO porque de esta manera no setea el valor del atributo images?
//	def items = [new Item(idd: 1, name: "[Testing Item] ventilador de techo", description: "Alto ventilador de techo", price: 111.11f, amount: 11, images: ["1", "2"]),
//	 aaaaa            new Item(idd: 2, name: "[Testing Item] notebook", description: "La mejor notebook del mercado", price: 222.22f, amount: 22, images: ["1", "2"]),
//	             new Item(idd: 3, name: "[Testing Item] mouse inalambrico", description: "El mejor mouse!!", price: 333.33f, amount: 33, images: ["1", "2"])
//	]
	
	def items = [new Item(1, "[Testing Item] ventilador de techo", "Alto ventilador de techo",      111.11f, 11, [ "http://www.imprexeurope.es/main/sites/default/files/styles/320h/public/imagenes/kaz/principal/ht-112e_new.jpg",
		                                                                                                           "http://mla-s1-p.mlstatic.com/ventilador-de-pared-industrial-30-embassy-250-watts-17406-MLA20137905819_072014-O.jpg", 
								                                                                                   "http://mla-s2-p.mlstatic.com/ventilador-industrial-de-pie-30-liliana-21826-MLA20217756085_122014-O.jpg"]),
							  
		         new Item(2, "[Testing Item] notebook",            "La mejor notebook del mercado", 222.22f, 22, [ "http://mla-s2-p.mlstatic.com/dell-inspiron-14-dual-core-mouse-inalambrico-de-regalo-16094-MLA20114188523_062014-O.jpg", 
								                                                                                   "http://mla-s1-p.mlstatic.com/dell-inspiron-14-dual-core-mouse-inalambrico-de-regalo-16007-MLA20112271475_062014-O.jpg", 
																												   "http://mla-s1-p.mlstatic.com/notebook-lenovo-g485-dual-core-4gb-500gb-wifi-dvdrw-windows8-15895-MLA20109899796_062014-F.jpg",
								                                                                                   "http://mla-s2-p.mlstatic.com/notebook-e920-tv-positivo-bgh-14-led-celeron-4gb-500gb-101101-MLA20248601342_022015-O.jpg"]),
																												
		         new Item(3, "[Testing Item] mouse inalambrico",   "El mejor mouse!!",              333.33f, 33, [ "http://www.spectrose.com/wp-content/uploads/2014/05/Mouse.jpg",
								                                                                                   "http://mla-s2-p.mlstatic.com/mouse-gamer-razer-deathadder-chroma-luz-rgb-dpi-cs-dota-lol-21053-MLA20203822870_112014-F.jpg", 
								                                                                                   ])
]

 

    def serviceMethod() {
    }
	
	def getItems() {
		return items;
	}
	
	public Item getItem(Long itemId) {
		Item item = items.find { i -> i.idd == itemId}
		return item
	}
	
}
