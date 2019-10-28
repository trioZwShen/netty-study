package socketcode.svr;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by shenzhiwei on 2019/10/28 9:46 上午.
 *
 * @author shenzhiwei
 */
public class ClientHandler {
    private Socket socket;
    private static final int MAX_DATA_LEN = 1024;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        new Thread(this::doStart).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            for(;;) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("message from client: " + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            System.out.println("some thing wrong");
            e.printStackTrace();
        }
    }
}
