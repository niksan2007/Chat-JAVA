--
-- ���� ������������ � ������� SQLiteStudio v3.3.3 � �� ��� 6 22:07:45 2021
--
-- �������������� ��������� ������: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- �������: users
CREATE TABLE users (name TEXT UNIQUE NOT NULL, date INTEGER NOT NULL);
INSERT INTO users (name, date) VALUES ('���������', 1623003823326);
INSERT INTO users (name, date) VALUES ('�����', 1623003788633);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
