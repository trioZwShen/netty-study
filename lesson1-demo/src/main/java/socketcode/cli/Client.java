package socketcode.cli;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by shenzhiwei on 2019/10/28 9:52 上午.
 *
 * @author shenzhiwei
 */
public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(() -> {
            System.out.println("client boot success");
            for (;;) {
                try {
                    String msg = "hello world";
                    System.out.println("client send message: " + msg);
                    socket.getOutputStream().write(msg.getBytes());
                } catch (IOException e) {
                    System.out.println("client");
                }
                sleep();
            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
