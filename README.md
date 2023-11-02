# Spring boot chat rest api with websocket (STOMP).

### Websocket address
> ws://localhost:8080/chat-websocket

#### Destinations:
|Path           |
|---------------|
|/chat/messages |

### Endpoints:
| Method | Path          |Body                            | 
| ------ | --------------|--------------------------------|
| GET    | /get-messages |-                               | 
| POST   | /send-message |{"userId": int, "text": string} |
| POST   | /add-user     |{"name": string}                |
