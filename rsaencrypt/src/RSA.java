
import java.math.BigInteger;
 
import java.util.Random;
 
import java.io.*;
 
public class RSA {
 
	private BigInteger p;
 
	private BigInteger q;
 
	public BigInteger z; //public
 
	private BigInteger phi;
 
	public BigInteger n; //public 
 
	private BigInteger s;  //private key
 
	private int bitlength = 1024; 
 
	private Random r;
 
	public RSA() {
 
		r = new Random();
 
		p = BigInteger.probablePrime(bitlength, r);
 
		q = BigInteger.probablePrime(bitlength, r);
 
		z = p.multiply(q);
 
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
 
		n = BigInteger.probablePrime(bitlength/2, r);
 
		while (phi.gcd(n).compareTo(BigInteger.ONE) > 0 && n.compareTo(phi) < 0 ) {
 
			n.add(BigInteger.ONE);
 
		}
 
		s = n.modInverse(phi);
 
	}
 // Constructor for inputting values for the encryption keys
	public RSA(BigInteger e, BigInteger d, BigInteger N) {
 
		this.n = e;
 
		this.s = d;
 
		this.z = N;
 
	}
 
	//Encrypt message using "messageinbytes*mod(public val, public val)";
 
	public byte[] encrypt(byte[] mes) {
 
		return (new BigInteger(mes)).modPow(n, z).toByteArray();
 
	}
 
	// Decrypt message using "encryptedmessageinbytes*modPow(privatekey, publickey)"
 
	public byte[] decrypt(byte[] message) {
 
		return (new BigInteger(message)).modPow(s, z).toByteArray();
 
	}
	public BigInteger getPublickey() {
		return z;
	}
	
	public BigInteger getPrivatekey() {
		return s;
	}
}
 
