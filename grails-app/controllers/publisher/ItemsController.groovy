package publisher

import grails.converters.JSON
import grails.web.JSONBuilder
import groovy.json.JsonSlurper

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject

import com.app.mercadolibre.Item
import com.app.mercadolibre.JavaSDK

class ItemsController {
	
	def beforeInterceptor = {
		println "#### " + params + " #### "
	}
	
	def prestashopService

    def index() { 
		render "hello!" 
	}
	def items
	def categories
	def levels
	def selectedItem
	
	
	def list() {
		setItems()
		setCategories()
		levels = [ categories ]
		render (view: 'listItems', model: [items: items])
	}
	
	def setItems() {
		if (this.items == null)
			this.items = prestashopService.getItems()
	}
	
	def setCategories() {
		if (this.categories == null) {
			this.categories = getRootCategories()
		}
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
	
	
	def publish() {
		String idCategory = params.idCategorySelected
		JSON json = buildItemJSON(this.selectedItem, idCategory)
		JSONObject jsonObject = JavaSDK.getInstance().post("/items", json.toString(), true);
		if(jsonObject.error != null) {
			render (view: 'errors', model: [message: jsonObject.toString() ])
		}
		else { 
			redirect action: 'list'
		}
	}
	
	def toChoseCategory(Integer id) {
		this.selectedItem = prestashopService.getItem(id) 
		render (view: 'selectedItem', model: [item: selectedItem, levels: levels])
	}

	def getRootCategories() {
		JSONArray categories = JavaSDK.getInstance().get("/sites/MLA/categories", false);
	}
	
	def getChildrenCategory() {
		def idCategory = params.idCategory
		def level = params.int("level") + 1
		JSONObject details = JavaSDK.getInstance().get("/categories/$idCategory", false);
		JSONArray children = details.getJSONArray("children_categories")
		levels[level] = children
		render (view: 'selectedItem', model: [item: this.selectedItem, categoryDescriptionSelected: details.name, categoryIdSelected: idCategory, levels: levels])
	}
	
	private JSON buildItemJSON(Item item, String idCategory) {
		def imgs = item.images
		JSONBuilder jsonBuilder = new JSONBuilder()
		JSON json = jsonBuilder.build (
			  {
				  title = item.name
				  category_id = idCategory
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

	
	/*

	def kk() {
		JSONArray jsonArrayCategories = JavaSDK.getInstance().get("/sites/MLA/categories", false);
		def listCategories = jsonArrayCategories.asList()
				println buildTree("|", 0, jsonArrayCategories)
				render "probando"
	}
	
	def buildTree(String space, int index, JSONArray categories) {
		if (index < categories.size()) {
			log.debug (space + "categories: " + categories)
			String delta = space + "     |"
			JSONObject category = categories.getJSONObject(index);
			String idCategory = category.getString("id")
			String name = category.getString("name")

			JSONObject details = JavaSDK.getInstance().get("/categories/$idCategory", false);
			log.debug (space + "details:" + details)
			JSONArray children = details.getJSONArray("children_categories")
			log.debug (space + "children: " + children)

			log.debug (space + "[" + idCategory + "] [" + children.size() + "] " + name)
			
			if (children.size() != 0) {
				 buildTree(delta, 0, children) 
			}
			return  buildTree(space, index + 1, categories)
		}
	}
	
	private void printids(JSONArray jsonArray) {
		int i = 0
		while (i < jsonArray.size()) {
			JSONObject element = jsonArray.getJSONObject(i++)
			String idd = element.getString("id")
			print idd + " "
		}
		println ""
	}
	
	private boolean hasChildren(JSONObject details) {
		def obj = details.getString("children_categories")
		def result = obj.size() != 0
		return result 
	}
	*/
	

}