import java.util.*;

public class Lab02 {
    public static void main(String[] args) throws InterruptedException {
        int windowSize = 4, totalPackets = 10, sent = 0;
        Queue<Integer> window = new LinkedList<>();

        while (sent < totalPackets || !window.isEmpty()) {
            while (window.size() < windowSize && sent < totalPackets) {
                System.out.println("Sent Packet: " + sent);
                window.add(sent++);
            }

            Thread.sleep(1000);

            if (!window.isEmpty()) {
                System.out.println("ACK Received for Packet: " + window.poll());
            }
        }
        
        System.out.println("\nAll packets transmitted successfully");
    }
}