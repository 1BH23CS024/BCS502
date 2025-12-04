import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Bucket Size, Output Rate, & Total Seconds: ");
        int bucket = sc.nextInt();
        int rate = sc.nextInt();
        int n = sc.nextInt();

        int[] packets = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Packet size at " + (i + 1) + "s: ");
            packets[i] = sc.nextInt();
        }

        System.out.println("\nTime | Recv | Sent | Left | Drop");
        System.out.println("--------------------------------");

        int count = 0;
        
        for (int i = 0; i < n || count > 0; i++) {
            int incoming = (i < n) ? packets[i] : 0;
            
            count += incoming;
            
            int drop = Math.max(0, count - bucket);
            count = Math.min(count, bucket);

            int sent = Math.min(count, rate);
            count -= sent;

            System.out.printf("%4d | %4d | %4d | %4d | %4d%n", i + 1, incoming, sent, count, drop);
            
            try { Thread.sleep(500); } catch (Exception e) {}
        }
        sc.close();
    }
}