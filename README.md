# springboot
常用注解:
 
    Swagger所有注解并非必须，若不加就只显示类目/方法名/参数名没有注释而已，但若注解中含@ApiParam不对应@RequestParam将无效果
 
    @Api:注解controller，value为@RequestMapping路径
 
    @ApiOperation:注解方法，value为简要描述,notes为全面描述,hidden=true Swagger将不显示该方法，默认为false
 
    @ApiParam:注解参数,hidden=true Swagger参数列表将不显示该参数,name对应参数名，value为注释，defaultValue设置默认值,allowableValues设置范围值,required设置参数是否必须，默认为false
 
    @ApiModel:注解Model
 
    @ApiModelProperty:注解Model下的属性，当前端传过来的是一个对象时swagger中该对象的属性注解就是ApiModelProperty中的value
 
    @ApiIgnore:注解类、参数、方法，注解后将不在Swagger UI中显示
    
    
```markdown
跨域请求分为简单跨域请求和复杂跨域请求：
	当发起复杂跨域请求时，浏览器会自主发起预检请求。
	请求方法为OPTIONS，用来检测服务器所支持的请求方法。在预检请求时，不会携带自定义的请求头信息，而且不允许重定向。
	只有option预检请求成功了，才会发起正式的请求。
	什么时候会发起预检请求：
		1.对于简单跨域请求，
			浏览器是不会发送options请求的。 
		2.对于复杂跨域请求，
			1.浏览器会自主发送一个options预检请求。
			2.只有options预检请求通过了，你真正的请求才会被正式的发起。
			注：
				那怎样options预检请求算通过了，
				1.返回200
				2.你的请求规范符合后端的要求。
				如你的请求头要包含在Access-Control-Allow-Headers:中。 
			
		复杂跨域请求要满足以下：
			1、请求方法不是GET/HEAD/POST
			2、POST请求的Content-Type并非application/x-www-form-urlencoded, multipart/form-data, 或text/plain
			3、请求设置了自定义的header字段
			
			
			
			
			
跨域：
	同源策略（Sameoriginpolicy）浏览器最基本的安全功能。
	同源策略会阻止一个域的javascript脚本和另外一个域的内容进行交互。
	注：
		1.如何算同源:具有相同的协议（protocol），主机（host）和端口号（port）
		2.非同源的请求后端是能接收到了请求并返回响应，但浏览器对会因为同源策略，而对非同源请求返回的结果进行拦截。
	注2：
		跨域浏览器自主发起预检请求：
			只有option预检请求成功了，才会发起正式的请求。
			./option请求.txt
解决方案：
	1，2：
		https://blog.csdn.net/qq_38128179/article/details/84956552
	jsonnp：
		https://blog.csdn.net/hansexploration/article/details/80314948
	CORS：
		http://www.ruanyifeng.com/blog/2016/04/cors.html
		CORS是一个W3C标准，全称是"跨域资源共享"（Cross-origin resource sharing）。
		它允许浏览器向跨源服务器，发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制。
		解决方案：
			https://blog.csdn.net/dadiyang/article/details/80289956
			服务器拦截请求，并设置些响应头即可实现跨域资源请求。
			注：
				1.该方案前端无需任何修改，只要后端设置一下即可。
			附：
				1.如果同时设置了下面两个响应头，则Origin的值要为请求源，否则前端console会（但是不影响请求和cookie存储..）报异常。
					response.setHeader('Access-Control-Allow-Credentials',true);
					response.setHeader('Access-Control-Allow-Origin','http://localhost:63342');
					https://blog.csdn.net/cowshield/article/details/80841034
		例:
			./CorsFilter.java
			附：
				Spring MVC 注解实现 CORS 跨域：
					https://www.jianshu.com/p/13d53acc124f
		附：
			跨域设置cookie：
				https://blog.csdn.net/cowshield/article/details/80841034
				1.（目的为表明后端允许接收跨域的cookie等身份认证，所以浏览器你就不要阻止跨域请求带上cookie的行为了）
					response.setHeader('Access-Control-Allow-Credentials',true);
					response.setHeader('Access-Control-Allow-Origin','http://localhost:63342');
					response.setHeader('Set-Cookie','token=cowshield');
					注：
						此时cookie属于的是服务器域名的，而不是请求端域名的。
						解决方案：
							I.
								域名为：a.abc.com b.abc.com
								那么cookie.setDomain("abc.com");即可。
							II.
								域名为：a.com b.com
								该情况应该是没法携带cookie，把值放header或请求参数中吧。
				2.（目的为，为跨域的请求带上本域的cookie）
					前端跨域请求设置withCredentials：
						axios：
							axios.defaults.withCredentials =true;
						注：
							*1.通过设置withCredentials 为true获得的第三方cookies，将会依旧享受同源策略，
							即只有用服务器域名设置的Cookie才会上传，其他域名的Cookie并不会上传。
							http://www.ruanyifeng.com/blog/2016/04/cors.html
							https://developer.mozilla.org/zh-CN/docs/Web/API/XMLHttpRequest/withCredentials
							
				附：
					前端请求的request headre 显示为：Provisional headers are shown（临时头部显示），
					而且你在前端可能会一直看不到携带的cookie，
					那么此时你应该去后端看下是否接收到cookie。
						
	Nginx代理：
		hcg：
			访问代理，然后由代理再去请求数据
```