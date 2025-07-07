# 🍽️ Dining Review Restaurant

Aplicação completa para avaliação de restaurantes por usuários. Este repositório é um **monorepo** contendo:

- 🎯 Backend em [Spring Boot](https://spring.io/projects/spring-boot)
- 💻 Frontend em [React](https://react.dev/) com [Vite](https://vitejs.dev/)

---

## 📁 Estrutura do Projeto

```bash
DiningReviewRestaurant/
├── DiningReviewRestaurantReact/     # Frontend em React
└── DiningReviewRestaurantSpring/    # Backend em Spring Boot
```

---

## 🚀 Como Rodar o Projeto Localmente

### 🔧 Pré-requisitos

Instale as seguintes ferramentas:

| Ferramenta       | Versão mínima | Link                                                   |
|------------------|---------------|--------------------------------------------------------|
| Java             | 17+           | https://adoptium.net/pt/temurin/releases/             |
| Maven            | 3.8+          | https://maven.apache.org/install.html                 |
| Node.js + npm    | 18+           | https://nodejs.org/en/download                        |
| PostgreSQL       | 15+           | https://www.postgresql.org/download/                  |

---

### Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/DiningReviewRestaurant.git
cd DiningReviewRestaurant
```

### Backend: Spring Boot
Criar o Banco de Dados
Execute no PostgreSQL:

```sql 
CREATE DATABASE diningdb;
CREATE USER dininguser WITH PASSWORD 'diningpass';
GRANT ALL PRIVILEGES ON DATABASE diningdb TO dininguser;
```

Configurar credenciais
Edite o arquivo:

```css
DiningReviewRestaurantSpring/src/main/resources/application.properties
```

E insira:

```txt
spring.datasource.url=jdbc:postgresql://localhost:5432/diningdb
spring.datasource.username=dininguser
spring.datasource.password=diningpass
spring.jpa.hibernate.ddl-auto=validate
spring.profiles.active=dev
```

Rodar o backend:
```bash
cd DiningReviewRestaurantSpring
./mvnw spring-boot:run
```

## 💻 Frontend: React + Vite

Acessar a pasta

```bash
cd ../DiningReviewRestaurantReact
```

Instalar dependências
```bash
npm install
```

Iniciar a aplicação
```bash
npm run dev
```

> A aplicação abrirá em: http://localhost:5173

Proxy para a API

O proxy já está configurado no `package.json`:
```json
"proxy": "http://localhost:8080"
```

## Testes

### Backend

Execute:

```bash
cd DiningReviewRestaurantSpring
./mvnw test
```

Os testes estão localizados em:
```bash
DiningReviewRestaurantSpring/src/test/java
```

## 📌 Tecnologias Utilizadas
- Spring Boot 3

- React 18 + Vite

- JWT + Spring Security

- PostgreSQL / H2

- Flyway

- Zustand + React Query

- Axios + Material UI (MUI)

## 📬 Contato
Desenvolvido por [Paulo Rolinski](https://www.linkedin.com/in/paulo-rolinski/)