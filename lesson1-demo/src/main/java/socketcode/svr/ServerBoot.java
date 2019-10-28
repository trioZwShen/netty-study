package socketcode.svr;

/**
 * Created by shenzhiwei on 2019/10/28 9:40 上午.
 *
 * @author shenzhiwei
 */
public class ServerBoot {
    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
