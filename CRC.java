import java.util.*;

public class CRC {
    static final int[] G = {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Message: ");
        // Enter Message: 1011
        String msg = sc.next();
        int m = G.length - 1;
        
        int[] data = toIntArray(msg, m);
        
        int[] rem = data.clone();
        divide(rem, msg.length());
        
        for (int i = 0; i < data.length; i++) data[i] |= rem[i];

        System.out.print("Data to Transmit: ");
        for (int b : data) System.out.print(b);

        System.out.print("\nEnter Received Data: ");
        // Enter Received Data: 10111011000101101010 -> ERROR
        // Enter Received Data: 10111011000101101011 -> NO ERROR
        String recvStr = sc.next();
        int[] recv = toIntArray(recvStr, 0);

        divide(recv, recvStr.length() - m);
        
        boolean err = false;
        for (int b : recv) if (b != 0) err = true;
        System.out.println(err ? "ERROR" : "NO ERROR");
        sc.close();
    }

    static void divide(int[] d, int limit) {
        for (int i = 0; i < limit; i++)
            if (d[i] == 1) 
                for (int j = 0; j < G.length; j++) d[i + j] ^= G[j];
    }

    static int[] toIntArray(String s, int pad) {
        int[] d = new int[s.length() + pad];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }
}