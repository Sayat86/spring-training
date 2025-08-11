API для управления пользователями, каналами и видео.
Поддерживает CORS для фронтенда на http://localhost:5173.

📑 Оглавление
User API

Создание пользователя

Получение пользователя по ID

Удаление пользователя по ID

Channel API

Создание канала

Обновление канала

Получение канала по ID

Получение собственного канала

Video API

Создание видео

Получение видео по ID

Получение всех видео канала

Регистрация просмотра видео

User API
1. Создание пользователя
   POST /users
   Создаёт нового пользователя.

Тело запроса (JSON):

json
Копировать
Редактировать
{
"name": "Иван Иванов",
"email": "ivan@example.com"
}
Пример запроса (cURL):

bash
Копировать
Редактировать
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{"name":"Иван Иванов", "email":"ivan@example.com"}'
Пример ответа (201 Created):

```json
{
"id": 1,
"name": "Иван Иванов",
"email": "ivan@example.com"
}
```

2. Получение пользователя по ID
   GET /users/{userId}

bash
Копировать
Редактировать
curl -X GET http://localhost:8080/users/1
Ответ (200 OK):

json
Копировать
Редактировать
{
"id": 1,
"name": "Иван Иванов",
"email": "ivan@example.com"
}
3. Удаление пользователя по ID
   DELETE /users/{userId}

bash
Копировать
Редактировать
curl -X DELETE http://localhost:8080/users/1
Ответ (204 No Content) — без тела.

Channel API
1. Создание канала
   POST /channels

Заголовки:

X-User-Id — ID пользователя (обязателен).

Тело запроса:

json
Копировать
Редактировать
{
"name": "Tech World",
"description": "Канал о технологиях",
"country": "Kazakhstan"
}
bash
Копировать
Редактировать
curl -X POST http://localhost:8080/channels \
-H "Content-Type: application/json" \
-H "X-User-Id: 1" \
-d '{"name":"Tech World","description":"Канал о технологиях","country":"Kazakhstan"}'
2. Обновление канала
   PATCH /channels/me

Заголовки:

X-User-Id — ID пользователя (обязателен).

Пример:

bash
Копировать
Редактировать
curl -X PATCH http://localhost:8080/channels/me \
-H "Content-Type: application/json" \
-H "X-User-Id: 1" \
-d '{"description":"Обновлённое описание"}'
3. Получение канала по ID
   GET /channels/{channelId}

Заголовки:

X-User-Id — ID пользователя (обязателен).

bash
Копировать
Редактировать
curl -X GET http://localhost:8080/channels/10 \
-H "X-User-Id: 1"
4. Получение собственного канала
   GET /channels/me

Заголовки:

X-User-Id — ID пользователя (обязателен).

bash
Копировать
Редактировать
curl -X GET http://localhost:8080/channels/me \
-H "X-User-Id: 1"
Video API
1. Создание видео
   POST /videos

Заголовки:

X-User-Id — ID пользователя (обязателен).

Тело запроса:

json
Копировать
Редактировать
{
"name": "Как собрать ПК",
"description": "Подробная инструкция по сборке компьютера",
"isPublic": true
}
bash
Копировать
Редактировать
curl -X POST http://localhost:8080/videos \
-H "Content-Type: application/json" \
-H "X-User-Id: 1" \
-d '{"name":"Как собрать ПК","description":"Подробная инструкция","isPublic":true}'
2. Получение видео по ID
   GET /videos/{videoId}

bash
Копировать
Редактировать
curl -X GET http://localhost:8080/videos/101
3. Получение всех видео канала
   GET /videos?channelId={id}&from={from}&size={size}

bash
Копировать
Редактировать
curl -X GET "http://localhost:8080/videos?channelId=10&from=0&size=5"
4. Регистрация просмотра видео
   POST /videos/{videoId}/views

Заголовки:

X-User-Id — ID пользователя (опционален).

bash
Копировать
Редактировать
curl -X POST http://localhost:8080/videos/101/views \
-H "X-User-Id: 1"