# AUTENTICACAO-SERVICE

### Pré-Requisitos

Compilar e executar o projeto **https://github.com/clinicaodontoweb/arquitetura**

### Instalação

Para compilar o projeto rode o seguinte comando:

`gradle clean build`

Para iniciar o serviço rode o seguinte comando na raiz do projeto:

`java -jar build\libs\sample-service-1.x.x.jar`

Para iniciar o serviço pela IDE apenas rode a classe **com.odontoweb.microservice.Application.java**

### Lista de serviços:

#### Autenticação (POST)

```
http://localhost:8000/sample-service/auth
```

**Request**

```
{
  "email": "andre@gmail.com",
  "senha": "123456"
}
```

--------------------------------------------


#### Lista de roles (GET)

```
http://localhost:8000/sample-service/protected
```

**Request Header**

`
X-Auth-Token : {token}
`

--------------------------------------------