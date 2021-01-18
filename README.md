# springboot
常用注解:
 
    Swagger所有注解并非必须，若不加就只显示类目/方法名/参数名没有注释而已，但若注解中含@ApiParam不对应@RequestParam将无效果
 
    @Api:注解controller，value为@RequestMapping路径
 
    @ApiOperation:注解方法，value为简要描述,notes为全面描述,hidden=true Swagger将不显示该方法，默认为false
 
    @ApiParam:注解参数,hidden=true Swagger参数列表将不显示该参数,name对应参数名，value为注释，defaultValue设置默认值,allowableValues设置范围值,required设置参数是否必须，默认为false
 
    @ApiModel:注解Model
 
    @ApiModelProperty:注解Model下的属性，当前端传过来的是一个对象时swagger中该对象的属性注解就是ApiModelProperty中的value
 
    @ApiIgnore:注解类、参数、方法，注解后将不在Swagger UI中显示