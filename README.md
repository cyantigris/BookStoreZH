# BookStoreZH
## Outline
This is a outline of a book store structure contained with 4 different parts:
- Ai Part: Use XfXhModel(讯飞星火大模型) as the ai assistant.
- User Part: Implemented basic CRUD and login function by using restAPi and MySql.
             can be modified with JWT token later.
- Book Part: Implemented basic CRUD of book related functions.
- Order Part: Implemented basic CRUD of Order Part.

## Entry point: 
- BookstoreApplication.java is the entry point.

## APIs:
### Book:
    "/book/create": Create new book record;
    "/book/delete": Delete target book record;
    "/book/update": Update book info;
    "/book/get": Get book detail by bookId;
    "/book/list": List all book with page;
 
### Order:
    "/order/create": Create new order;
    "/order/updateAddress": Update shipping address;
    "/order/updateStatus": Update order status;
    "/order/delete": Remove target order record;
### User:
    "/user/register": Create/Register new user (Should add a Token generation for register but no time);
    "/user/login": login api without token, no time to add now;
    "/user/update": Update user detail;
    "/user/delete": Remove target user record;

### Ai:
    "/ai/question": Ask question to XfXh Model.