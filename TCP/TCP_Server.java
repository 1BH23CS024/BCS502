import java.io.*;
import java.net.*;

public class TCP_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server is running... Waiting for file requests.");

        while (true) {
            try (Socket s = ss.accept();
                 DataInputStream din = new DataInputStream(s.getInputStream());
                 DataOutputStream dout = new DataOutputStream(s.getOutputStream())) {

                String filename = din.readUTF();
                File file = new File(filename);

                if (!file.exists()) {
                    dout.writeUTF("404");
                    System.out.println("Client requested non-existent file: " + filename);
                } else {
                    dout.writeUTF(String.valueOf(file.length()));
                    
                    System.out.println("Sending " + filename + " (" + file.length() + " bytes)...");
                    try (FileInputStream fin = new FileInputStream(file)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = fin.read(buffer)) != -1) {
                            dout.write(buffer, 0, bytesRead);
                        }
                    }
                    System.out.println("File sent successfully.");
                }
            } catch (Exception e) {
                System.out.println("Connection Error: " + e.getMessage());
            }
        }
    }
}