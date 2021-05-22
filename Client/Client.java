package Client;

import Connection.*;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Connection connection;
    private static ModelGuiClient model;
    private static ViewGuiClient gui;
    private volatile boolean isConnect = false; //флаг отобаржающий состояние подключения клиента  серверу

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }
public class Client {
    private Connection connection;
    private static ModelGuiClient model;
    private static ViewGuiClient gui;
    private volatile boolean isConnect = false; //флаг отобаржающий состояние подключения клиента  серверу

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }
public class Client {
    private Connection connection;
    private static ModelGuiClient model;
    private static ViewGuiClient gui;
    private volatile boolean isConnect = false; //флаг отобаржающий состояние подключения клиента  серверу

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }etPortServerFromOptionPane();
                    //создаем сокет и объект connection
                    Socket socket = new Socket(addressServer, port);
                    connection = new Connection(socket);
                    isConnect = true;
                    gui.addMessage("Сервисное сообщение: Вы подключились к серверу.\n");
                    break;
                } catch (Exception e) {
                    gui.errorDialogWindow("Произошла ошибка! Возможно Вы ввели не верный адрес сервера или порт. Попробуйте еще раз");
                    break;
                }
            }
        } else gui.errorDialogWindow("Вы уже подключены!");
    }

    //метод, реализующий регистрацию имени пользователя со стороны клиентского приложения
    protected void nameUserRegistration() {
public class Client {
    private Connection connection;
    private static ModelGuiClient model;
    private static ViewGuiClient gui;
    private volatile boolean isConnect = false; //флаг отобаржающий состояние подключения клиента  серверу

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }
                gui.errorDialogWindow("Произошла ошибка при регистрации имени. Попробуйте переподключиться");
                try {
                    connection.close();
                    isConnect = false;
                    break;
                } catch (IOException ex) {
                    gui.errorDialogWindow("Ошибка при закрытии соединения");
                }
            }

        }
    }

    //метод отправки сообщения предназначенного для других пользователей на сервер
    protected void sendMessageOnServer(String text) {
        try {
            connection.send(new Message(MessageType.TEXT_MESSAGE, text));
        } catch (Exception e) {
            gui.errorDialogWindow("Ошибка при отправки сообщения");
        }
    }

    //метод принимающий с сервера собщение от других клиентов
    protected void receiveMessageFromServer() {
        while (isConnect) {
            try {
                Message message = connection.receive();
                //если тип TEXT_MESSAGE, то добавляем текст сообщения в окно переписки
                if (message.getTypeMessage() == MessageType.TEXT_MESSAGE) {
                    gui.addMessage(message.getTextMessage());
                }
                //если сообщение с типо USER_ADDED добавляем сообщение в окно переписки о новом пользователе
                if (message.getTypeMessage() == MessageType.USER_ADDED) {
                    model.addUser(message.getTextMessage());
                    gui.refreshListUsers(model.getUsers());
public class Client {
    private Connection connection;
    private static ModelGuiClient model;
    private static ViewGuiClient gui;
    private volatile boolean isConnect = false; //флаг отобаржающий состояние подключения клиента  серверу

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }
                connection.send(new Message(MessageType.DISABLE_USER));
                model.getUsers().clear();
                isConnect = false;
                gui.refreshListUsers(model.getUsers());
            } else gui.errorDialogWindow("Вы уже отключены.");
        } catch (Exception e) {
            gui.errorDialogWindow("Сервисное сообщение: произошла ошибка при отключении.");
        }
    }
}
