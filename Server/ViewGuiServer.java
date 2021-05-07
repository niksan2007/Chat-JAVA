package Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ViewGuiServer {
    private JFrame frame = new JFrame("Запуск сервера");
    private JTextArea dialogWindow = new JTextArea(10, 40);
    private JButton buttonStartServer = new JButton("Запустить сервер");
    private JButton buttonStopServer = new JButton("Остановить сервер");
    private JPanel panelButtons = new JPanel();
    private final Server server;

    public ViewGuiServer(Server server) {
        this.server = server;
    }