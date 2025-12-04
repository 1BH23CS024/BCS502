import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCP_Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Filename to Request: ");
        String filename = sc.next();

        try (Socket s = new Socket("localhost", 5000);
             DataInputStream din = new DataInputStream(s.getInputStream());
             DataOutputStream dout = new DataOutputStream(s.getOutputStream())) {

            dout.writeUTF(filename);

            String msg = din.readUTF();
            if (msg.equals("404")) {
                System.out.println("Error: File not found on server.");
                return;
            }

            System.out.println("Downloading " + filename + "...");
            try (FileOutputStream fos = new FileOutputStream("received_" + filename)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long fileSize = Long.parseLong(msg);
                long total = 0;

                while (total < fileSize && (bytesRead = din.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    total += bytesRead;
                }
            }
            System.out.println("File received successfully!");

        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
        sc.close();
    }
}