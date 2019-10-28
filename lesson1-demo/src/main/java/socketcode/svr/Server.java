package socketcode.svr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shenzhiwei on 2019/10/28 9:40 上午.
 *
 * @author shenzhiwei
 */

public class Server {
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("server boot success, port: " + port);
        } catch (IOException e) {
            System.out.println("server boot failed");
        }
    }

    public void start() {
        new Thread(this::doStart).start();
    }

    private void doStart() {
        for (; ; ) {
            try {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            } catch (IOException e) {
                System.out.println("server exception");
                e.printStackTrace();
            }
        }
    }
}
