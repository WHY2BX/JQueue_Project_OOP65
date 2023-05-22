
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEnqueue {

    private Socket socket;
    private OutputStream ots;
    private ObjectOutputStream oos;
    private TaList taList;

    public ClientEnqueue(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("connected");
    }

    public void Enqueue(TaList taList) throws IOException {
        while (socket.isConnected()) {
            try (OutputStream dos = socket.getOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(dos);) {
                oos.writeObject(taList);
                System.out.println("write completed");

            } catch (IOException ex) {
                this.closeAll();
            }
        }
    }

    private void closeAll() throws IOException {
        if (socket != null) {
            socket.close();
        }
        if (ots != null) {
            ots.close();
        }
        if (oos != null) {
            oos.close();
        }
    }

    public static void main(String[] args) throws IOException {
        TaList taList = new TaList();
        Socket socket = new Socket("192.168.1.117", 64236);
        ClientEnqueue ce = new ClientEnqueue(socket);
        ce.Enqueue(taList);
    }
}
