#Frigo
This project deals with items you can store in your fridge.
It is a dummy project, but it helps me gather few ideas on design and development

###VERSIONING
let's say you want to serve your api with different, concurrent versions.
imagine you want to keep your current version (default, say version 1) and you want to serve a snapshot version, something you are still working on (say version2) and then you want to still serve a deprecated version (version 0) just to notify you clients with a clean exception
... 


we can achieve multiversioning with some headers, organise apis in specific tagged controllers
and document them with swagger

so, if you want to test the versioning via the header try

**v1 - default**

```curl -X GET --header "frigo.version:v1" "http://localhost:8081/frigo"```

**v0 - deprecated**

```curl -X GET --header "frigo.version:v0" "http://localhost:8081/frigo"```

**v2 - snapshot version - unstable**

```curl -X GET --header "frigo.version:v2" "http://localhost:8081/frigo"```

**any other version**


```curl -X GET --header "http://localhost:8081/frigo"```

this will produce a 

```{
  "timestamp": 1476736041746,
  "status": 404,
  "error": "Not Found",
  "message": "No message available",
  "path": "/frigo"
}```    

**notes**
I found how to add header UI information on swagger here: 
```http://stackoverflow.com/questions/26742521/sending-dynamic-custom-headers-in-swagger-ui-try-outs```  
	
>It worked. Thanks!. 
>@ApiImplicitParams({@ApiImplicitParam(name = "callerId", required = true, dataType = "string", paramType = "header")}) 
> Sharath B. Patel Nov 5 '14 at 8:28
