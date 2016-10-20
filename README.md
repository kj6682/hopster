# hopster
**hopsters** are not hipsters
..as much as an **IPA** is not **API**

This hopster has two submodules:

##business services
* **hop** (a services for media stuff)
* **frigo** (a service for storing stuff with an expiring date)

##technical services
* **gateway** (a zuul service gateway)


### Notes
when performing release remember to skip deployment 

```mvn release:perform -Darguments="-Dmaven.deploy.skip=true```