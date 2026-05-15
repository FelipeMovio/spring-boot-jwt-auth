# 🔐 API de Autenticação JWT com Spring Security

Projeto desenvolvido com Java + Spring Boot focado em autenticação e autorização utilizando JWT (JSON Web Token) e Spring Security.

A aplicação implementa login seguro, cadastro de usuários, controle de permissões por roles (`USER` e `ADMIN`) e proteção de rotas utilizando autenticação stateless.

---

# 🚀 Funcionalidades

## ✅ Autenticação

* Login com e-mail e senha
* Geração de token JWT
* Validação automática do token
* Autenticação stateless

## ✅ Cadastro de usuários

* Registro de novos usuários
* Senhas criptografadas com BCrypt
* Validação de e-mail único

## ✅ Controle de acesso

* Roles:

  * `ROLE_USER`
  * `ROLE_ADMIN`
* Proteção de rotas com Spring Security
* Controle de autorização com `@PreAuthorize`

## ✅ Segurança

* Filtro JWT personalizado
* Interceptação de requisições
* Password Encoder
* CORS configurado
* Rotas públicas e privadas

## ✅ Documentação e testes

* Swagger/OpenAPI liberado
* H2 Console habilitado

---

# 🛠 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (Auth0 Java JWT)
* Spring Validation
* Spring Data JPA
* H2 Database
* Lombok
* Swagger / OpenAPI

---

# 📂 Estrutura do Projeto

```bash id="89d1x1"
config/
 ├── SecurityConfig
 ├── SecurityFilter
 ├── TokenConfig
 └── AuthConfig

controller/
 ├── AuthController
 └── AdminController

DTO/
 ├── request
 └── response

model/
 ├── Usuario
 └── Role

service/
 └── UsuarioService

repository/
 └── UsuarioRepository
```

---

# 🔑 Fluxo de autenticação

1. Usuário realiza cadastro
2. Senha é criptografada com BCrypt
3. Usuário faz login
4. API gera token JWT
5. Cliente envia token no Header:

```http id="j28sk1"
Authorization: Bearer TOKEN
```

6. Filtro JWT valida token
7. Usuário autenticado acessa rotas protegidas

---

# 🌐 Endpoints principais

## Auth

### Registrar usuário

```http id="71k2m1"
POST /api/auth/register
```

### Login

```http id="82m2d1"
POST /api/auth/login
```

---

## Admin

### Criar administrador

```http id="4j2ks1"
POST /admin/create-admin
```

Necessário:

* Token JWT válido
* Role ADMIN

---

# 🔒 Controle de rotas

| Rota           | Acesso       |
| -------------- | ------------ |
| `/api/auth/**` | Público      |
| `/admin/**`    | ADMIN        |
| `/user/**`     | USER / ADMIN |
| `/product/**`  | USER / ADMIN |

---

# 📚 Conceitos aplicados

* Spring Security
* JWT Authentication
* Stateless Authentication
* Filters
* Authorization
* Roles e Permissions
* DTO Pattern
* Password Hashing
* REST API
* Clean Code
* Injeção de Dependência
* Validação de dados

---

# ▶ Como executar

1. Clone o repositório
2. Abra na IDE
3. Execute a aplicação Spring Boot
4. Acesse:

Swagger:

```bash id="82md91"
http://localhost:8080/swagger-ui.html
```

H2 Console:

```bash id="1m9dk2"
http://localhost:8080/h2-console
```

---

# 👨‍💻 Autor

Felipe Movio
