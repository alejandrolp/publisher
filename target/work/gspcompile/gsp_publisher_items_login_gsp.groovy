import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_publisher_items_login_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/items/_login.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (session.user)) {
printHtmlPart(0)
out.print("${session.user}")
printHtmlPart(1)
invokeTag('createLink','g',2,['action':("logout")],-1)
printHtmlPart(2)
}
else {
printHtmlPart(3)
invokeTag('createLink','g',5,['action':("authenticate")],-1)
printHtmlPart(4)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426643644000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
