#Frigo

if you want to test the versioning via the header try

**default**

```curl -X GET --header "http://localhost:8081/frigo"```

or (note that the v1 is not defined in any controller, how do we block v5000?

```curl -X GET --header "frigo.version:v1" "http://localhost:8081/frigo"```

**deprecated**

```curl -X GET --header "frigo.version:v0" "http://localhost:8081/frigo"```

**snapshot version - unstable**

```curl -X GET --header "frigo.version:v2" "http://localhost:8081/frigo"```

