This is the repository for the Demo Microservice.

# Demo Microservice

##

To start up the org_data microservice, follow these steps -
1. Build the project - mvn clean install
2. Start the container - mvn -Djasypt.encryptor.password=xxx-public-key spring-boot:run

These steps are needed for data-zone microservices on startup. The database properties are loaded from the config server and decrypted to be used to connect to the database. 

## Resources

| Path             | Description  |
|------------------|--------------|
| /demo   | application context for app zone|
| /demo_data   | application context for data zone|

## Spring Profiles

-Dspring.profiles.active=default : for local and aws
-Dspring.profiles.active=devint : for DEVINT
-Dspring.profiles.active=test : for TEST
-Dspring.profiles.active=devint : for IMPL
-Dspring.profiles.active=prod : for PROD


## JASYPT Encryption Command

To create encrypted properties for the datasource, follow these steps -

java -cp ~/.m2/repository/demo/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar  org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="samplepassword" password=eqrs-public-key algorithm=PBEWithMD5AndDES

Sample Output ->

----ENVIRONMENT-----------------

Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 24.45-b08



----ARGUMENTS-------------------

algorithm: PBEWithMD5AndDES
input: samplepassword
password: demo-public-key



----OUTPUT-----------------------

XcBjfjDDjxeyFBoaEPhG14wEzc6Ja+Xx+hNPrJyQT88=

