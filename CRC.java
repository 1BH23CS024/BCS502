import java.util.Scanner;

public class CRC {
    static final int[] GP = {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};

    static void divide(int[] data, int limit) {
        for (int i = 0; i < limit; i++) {
            if (data[i] == 1) {
                for (int j = 0; j < GP.length; j++) {
                    data[i + j] ^= GP[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Message: "); 
        // Enter Message: 1011
        String msg = sc.next();
        
        int n = msg.length();
        int m = GP.length - 1;
        
        int[] data = new int[n + m]; 
        for (int i = 0; i < n; i++) data[i] = msg.charAt(i) - '0';

        int[] checksum = data.clone();
        divide(checksum, n);
        
        for (int i = n; i < data.length; i++) data[i] = checksum[i];

        System.out.print("Data to Transmit: "); 
        // Data to Transmit: 10111011000101101011
        for (int bit : data) System.out.print(bit);
        System.out.println();


        System.out.print("Enter Received Data: ");
        // Enter Received Data: 10111011000101101010 -> ERROR
        // Enter Received Data: 10111011000101101011 -> NO ERROR
        String receivedStr = sc.next();
        int[] received = new int[receivedStr.length()];
        for (int i = 0; i < receivedStr.length(); i++) 
            received[i] = receivedStr.charAt(i) - '0';

        divide(received, receivedStr.length() - m);

        boolean error = false;
        for (int bit : received) {
            if (bit != 0) {
                error = true;
                break;
            }
        }
        
        System.out.println(error ? "ERROR" : "NO ERROR");
        sc.close();
    }
}