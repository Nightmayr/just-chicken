INSERT INTO RESTAURANT (id, name, address, photo, description) VALUES (1, 'KFC', '34 Imaginary Gardens, Valhalla, V31 1YY', 'kfc.jpg', 'Juicy and succulent fried chicken originating from kentucky USA')
INSERT INTO RESTAURANT (id, name, address, photo, description) VALUES (2, 'Nandos', '45 Made-up Road, Salford, M76 2BU', 'nandos.jpg', 'Tasty piri piri chicken')
INSERT INTO USER (id, username, email, password) VALUES (1, 'nightmayr', 'umayr23@gmail.com', 'password')
INSERT INTO USER (id, username, email, password) VALUES (2, 'nutmayr', 'jason@email.com', 'password2')
INSERT INTO COMMENT (id, userId, restaurantId, comment, author) VALUES (1, 1, 1, 'The food here is amazing!!!', 'nightmayr')
INSERT INTO COMMENT (id, userId, restaurantId, comment, author) VALUES (2, 2, 1, 'I hate the food', 'nutmayr')
INSERT INTO COMMENT (id, userId, restaurantId, comment, author) VALUES (3, 2, 2, 'There was a fly in my sunset burger!! Never coming here again!', 'nutmayr')



