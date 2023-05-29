# prova1_topicos_1
This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application
The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.
The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.
If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```
The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable
You can create a native executable using: 
```shell script
./mvnw package -Pnative
```
Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```
You can then execute your native executable with: `./target/prova1_topicos_1-1.0.0-SNAPSHOT-runner`
If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides
- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate JAX-RS resources for your Hibernate Panache entities and repositories
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

### RESTEasy JAX-RS
Easily start your RESTful Web Services
[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)



# Implementação do JWT
1) Atualizar o Quarkus para a versão 3
 - ./mvnw io.quarkus.platform:quarkus-maven-plugin:3.0.1.Final:update -N -Dstream=3.0
2) Perfil de Usuário
3) PerfilConverter
4) import.sql -> Adicionar o perfil de usuario
5) hash da senha
 - atualizar import.sql
6) TokenJwtService
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-smallrye-jwt</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-smallrye-jwt-build</artifactId>
    </dependency>
7) Configurar Properties
	mp.jwt.verify.publickey.location=token/publickey.pem
	mp.jwt.verify.issuer=unitins-jwt
	smallrye.jwt.sign.key.location=token/privatekey.pem

8) Instalar openssl
	Download: https://slproweb.com/products/Win32OpenSSL.html
	Tutorial de instalação: https://thesecmaster.com/procedurce-to-install-openssl-on-the-windows-platform/

9) Gerar os arquivos publicKey e privateKey, adiciona-los à pasta token

openssl genrsa -out rsaPrivateKey.pem 2048
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem

10) Criar o arquivo AuthResource.java
 - criar o arquivo AuthUsuarioDTO.java

11) Adicionar as anotacoes de seguranca
    @PermitAll, @RolesAllowed({"Admin","User"})

12) Tarefa para casa, pesquisar como enviar um token por através de um test. Adicionar em pelo menos uma das classes do seu projeto e enviar como trabalho no educa.

https://learn.microsoft.com/pt-br/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package

wsl --update 

./mvw compile quarkus:dev

https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

./mvnw quarkus:add-extension -Dextensions='hibernate-validator'

 