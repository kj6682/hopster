#Frigo

if you want to test the versioning via the header try

**v1 - default**

```curl -X GET --header "http://localhost:8081/frigo"```

or (note that the v1 is not defined in any controller, how do we block v5000?

```curl -X GET --header "frigo.version:v1" "http://localhost:8081/frigo"```

**v0 - deprecated**

```curl -X GET --header "frigo.version:v0" "http://localhost:8081/frigo"```

**v2 - snapshot version - unstable**

```curl -X GET --header "frigo.version:v2" "http://localhost:8081/frigo"```

**notes**
I found how to add header UI information on swagger here: 
```http://stackoverflow.com/questions/26742521/sending-dynamic-custom-headers-in-swagger-ui-try-outs```  
	
>It worked. Thanks!. 
>@ApiImplicitParams({@ApiImplicitParam(name = "callerId", required = true, dataType = "string", paramType = "header")}) 
> Sharath B. Patel Nov 5 '14 at 8:28
