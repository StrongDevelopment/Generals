package net.strongdev.generals.managers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by oleg on 15.09.16.
 */
public class Connection implements Runnable {

    private static final String host = "localhost";
    private static final int port = 2706;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private static final Connection instance = new Connection();

    public static Connection getInstance() {
        return instance;
    }

    public void open() {
        try {
            socket = new Socket(host, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t = new Thread(this);
        t.start();
    }

    public void send(byte command) {
        if (dataOutputStream != null) {
            byte data[] = {0, command, 0, 0};
            try {
                dataOutputStream.write(data);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (socket != null) {

        }
    }


}
