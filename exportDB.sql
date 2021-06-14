--
-- Файл сгенерирован с помощью SQLiteStudio v3.3.3 в Вс июн 6 22:07:45 2021
--
-- Использованная кодировка текста: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Таблица: users
CREATE TABLE users (name TEXT UNIQUE NOT NULL, date INTEGER NOT NULL);
INSERT INTO users (name, date) VALUES ('Александр', 1623003823326);
INSERT INTO users (name, date) VALUES ('Игорь', 1623003788633);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
