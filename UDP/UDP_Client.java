import java.net.*;
import java.util.Scanner;

public class UDP_Client {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
             Scanner sc = new Scanner(System.in)) {
          
            System.out.print("Enter Message: ");
            byte[] data = sc.nextLine().getBytes();

            socket.send(new DatagramPacket(data, data.length, "localhost", 6788));

            byte[] buff = new byte[1024];
            DatagramPacket resp = new DatagramPacket(buff, buff.length);
            socket.receive(resp);

        } catch (Exception e) { e.printStackTrace(); }
    }
}