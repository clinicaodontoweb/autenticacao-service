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

**Response**

```
{
  "token": "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJ0ZW5hbnQiOiIzMTY0MDg4NjAwMDE2MSIsImlzQWRtaW4iOnRydWUsInRpcG9Vc3VhcmlvIjoiUmVjZXBjaW9uaXN0YSIsInJvbGVzIjpbIkFETUlOIl0sImlhdCI6MTU4NTI3MTcwNn0.8eMcP1VVlxiUN037e_4JT-N93KeL1M3bS8F9dpZluqsqb0JYp4yIh1eZDdmWiXBHz90WhFFNBV1GHyUN75C03w"
}
```

**Response Error**

```
{
  "message": "Usuario ou Senha nao conferem.",
  "stacktrace": null,
  "status": 400
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
