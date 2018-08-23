import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller
{
    private RSA rsa;
    private View myView;

    /**
     * Controller constructor; view must be passed in since controller has
     * responsibility to notify view when some event takes place.
     */
    public Controller()
    {
        myView = new View(this);
    	 rsa = new RSA();
    }

    public void reset()
    {
    	myView = new View(this);
    	rsa = new RSA();
    }

    public void encrypt()
    {
    	 
 
		String message;
		
		message = myView.getInputText();
 
		// encrypt
 
		byte[] encrypted = rsa.encrypt(message.getBytes());
 
		myView.setEncryptText(bytesToString(encrypted));
		// decrypt
		
		byte[] decrypted = rsa.decrypt(encrypted);
		
		myView.setOutputText(new String(decrypted));
		
		myView.setPublicText(rsa.getPublickey().toString());
		
		myView.setPrivateText(rsa.getPrivatekey().toString());


    }
    
    /*
	 * Static Helper function that converts an array of bytes to a string
	 */
	public static String bytesToString(byte[] encrypted) {
		 
		String inbytes = "";
 
		for (byte b : encrypted) {
			inbytes += Byte.toString(b);
		}
 
		return inbytes;
	}
 

}
