import java.net.*;

public class UDP_Server {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(6788)) {
            System.out.println("Server listening on Port 6788...");
            byte[] buff = new byte[1024];

            while (true) {
                DatagramPacket req = new DatagramPacket(buff, buff.length);
                socket.receive(req);

                String msg = new String(req.getData(), 0, req.getLength());
                System.out.println("Received: " + msg);

                byte[] data = (msg + " [Processed]").getBytes();
                DatagramPacket reply = new DatagramPacket(
                    data, data.length, req.getAddress(), req.getPort()
                );
                socket.send(reply);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}