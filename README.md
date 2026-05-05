# TechStore

Backend-приложение для магазина компьютеров и комплектующих.

---

## 🚀 Стек технологий

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Liquibase
- Maven
- Docker / Docker Compose
- Swagger (OpenAPI)

---

## 📦 Функциональность

Поддерживаются следующие типы товаров:

- Настольные компьютеры
- Ноутбуки
- Мониторы
- Жесткие диски

Реализованные операции:

- ➕ Добавление товара (POST)
- ✏️ Редактирование товара (PUT)
- 📄 Получение списка товаров по типу (GET)
- 🔍 Получение товара по ID (GET)

❗ Удаление (DELETE) не реализовано, так как не требуется по ТЗ.

---

## ⚙️ Запуск 

В корне проекта:

1. Сборка через maven
```bash
mvn clean package 
```
2. Запуск через Docker

```bash
docker compose up --build
```
После запуска приложение будет доступно:

- http://localhost:8080/techStore/swagger-ui/index.html

 Корень проекта: 

- http://localhost:8080/techStore

## 🌐 Мой сервер

Приложение развернуто и доступно онлайн на моем сервере:

Swagger UI:
http://77.66.185.97:8080/techStore/swagger-ui/index.html

Можно сразу протестировать API без локального запуска.

## 📚 Swagger (документация API)

Swagger UI:

http://localhost:8080/techStore/swagger-ui/index.html

OpenAPI JSON:

http://localhost:8080/techStore/v3/api-docs

## 🗄 База данных

Используется PostgreSQL.

Схема базы создаётся автоматически через Liquibase при запуске приложения.

Также автоматически добавляются тестовые данные.

## 🔌 Подключение к базе данных

Параметры подключения:

- Host: localhost
- Port: 5439
- Database: postgres
- User: postgres
- Password: postgres

JDBC URL:

- jdbc:postgresql://localhost:5439/postgres

## 📡 Основные endpoints

Desktop Computers
- GET  /techStore/desktop-computers
- GET  /techStore/desktop-computers/{id}
- POST /techStore/desktop-computers
- PUT  /techStore/desktop-computers/{id}

Laptops
- GET  /techStore/laptops
- GET  /techStore/laptops/{id}
- POST /techStore/laptops
- PUT  /techStore/laptops/{id}

Monitors
- GET  /techStore/monitors
- GET  /techStore/monitors/{id}
- POST /techStore/monitors
- PUT  /techStore/monitors/{id}

Hard Drives
- GET  /techStore/hard-drives
- GET  /techStore/hard-drives/{id}
- POST /techStore/hard-drives
- PUT  /techStore/hard-drives/{id}