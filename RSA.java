import java.math.BigInteger;
import java.util.*;

public class RSA {
    private BigInteger n, d, e;

    public RSA(int bitlen) {
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(bitlen, r);
        BigInteger q = BigInteger.probablePrime(bitlen, r);
        
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        e = BigInteger.probablePrime(bitlen / 2, r); 
        while (!phi.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }
        
        d = e.modInverse(phi);
        

        System.out.println("Public Key: " + e);
        System.out.println("Private Key: " + d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RSA rsa = new RSA(512);

        System.out.print("\nEnter message to encrypt: ");
        String msg = sc.nextLine();
        
        BigInteger plaintext = new BigInteger(msg.getBytes());
        
        BigInteger ciphertext = plaintext.modPow(rsa.e, rsa.n);
        System.out.println("Encrypted Ciphertext: " + ciphertext);

        BigInteger decryptedBigInt = ciphertext.modPow(rsa.d, rsa.n);
        String decryptedMsg = new String(decryptedBigInt.toByteArray());
        
        System.out.println("\nDecrypted Message: " + decryptedMsg);
        sc.close();
    }
}