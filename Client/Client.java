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

    //точка входа в клиентское приложение
    public static void main(String[] args) {
        Client client = new Client();
        model = new ModelGuiClient();
        gui = new ViewGuiClient(client);
        gui.initFrameClient();
        while (true) {
            if (client.isConnect()) {
                client.nameUserRegistration();
                client.receiveMessageFromServer();
                client.setConnect(false);
            }
        }
    }

    //метод подключения клиента  серверу
    protected void connectToServer() {
        //если клиент не подключен  сервере то..
        if (!isConnect) {
            while (true) {
                try {
                    //вызываем окна ввода адреса, порта сервера
                    String addressServer = gui.getServerAddressFromOptionPane();
                    int port = gui.getPortServerFromOptionPane();
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