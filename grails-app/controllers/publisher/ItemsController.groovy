package publisher

import grails.converters.JSON
import grails.web.JSONBuilder

import org.codehaus.groovy.grails.web.json.JSONObject

import com.app.mercadolibre.Item
import com.app.mercadolibre.JavaSDK
import com.ning.http.client.FluentStringsMap
import com.ning.http.client.Response

class ItemsController {
	
	def prestashopService

    def index() { 
		render "hello!" 
	}
	
	def list() {
		def items = prestashopService.getItems()
		render (view: 'listItems', model: [items: items])
	}
	
	def authenticate() {
		String redirectUrl = JavaSDK.getInstance().getAuthUrl();
		redirect url: redirectUrl
	}

	def authorize(String code) {
		JavaSDK.getInstance().authorize(code)
		register()
		redirect action: 'list'
	}
	
	def logout() {
		session["user"] = null
		redirect action: 'list'
	}
	
	def register() {
		JSONObject json = JavaSDK.getInstance().get("/users/me", true);
		session["user"] = json.nickname
	}
	
	def publish(Integer id) {
		Item item = prestashopService.getItem(id)
		JSON json = buildItemJSON(item)
		JSONObject jsonObject = JavaSDK.getInstance().post("/items", json.toString(), true);
		redirect action: 'list'
	}
	
	private JSON buildItemJSON(Item item) {
		def imgs = item.images
		JSONBuilder jsonBuilder = new JSONBuilder()
		JSON json = jsonBuilder.build (
			  {
				  title = item.name
				  category_id = "MLA86029"
				  price = item.price
				  currency_id = "ARS"
				  available_quantity = item.amount
				  buying_mode = "buy_it_now"
				  listing_type_id = "bronze"
				  condition = "new"
				  description = item.description
				  pictures = array {
			         for (im in imgs) {
				  			sarazaaaaaaaaaaaaaaaaa source: im
			         }
				  }
			  }
									)
	}
		
	

}