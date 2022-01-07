import java.net.*;
import java.io.*;

public class DailyAdviceServer {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat",
    "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
    "You might want to rethink that haircut"};

    public void go() {

        try {
            // ServerSocket listening for clients request on port 4242
            ServerSocket serverSocket = new ServerSocket(4242);

            // permanent loop waiting and servicing client requests
            while(true) {

                // the accept method just sits here until a request comes in then returns a socket
                // for communicating with the client
                Socket sock = serverSocket.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

}
