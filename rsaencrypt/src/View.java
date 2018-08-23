/**
 * 
 * View class that creates two buttons, three textFields for user input, and 
 * three output labels for answers to the puzzle.  Dialogue is also included
 * to notify about the outcome.
 * 
 * .
 *
 * @author Mason Perrella
 * @version 1.0 (November 2016)
 * 
 */

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.lang.reflect.Method;
import java.util.Scanner;

@SuppressWarnings("serial")
public class View extends Frame
{

    /**
     * Properties
     * 
     */

    private Button myResetButton;
    private Button myEncryptButton;
    private Label myTitle;
    private TextArea myInputBox;
    private TextArea myPublickey;
    private TextArea myPrivatekey;
    private TextArea myEncrypted;
    private TextArea myOutputBox;
    private Label myInputlabel;
    private Label myPubliclabel;
    private Label myPrivatelabel;
    private Label myEncryptlabel;
    private Label myOutputlabel;

    private ButtonListener myResetListener;
    private ButtonListener myEncryptListener;

    public View(Controller controller)
    {

        this.setSize(600, 600);
        this.setLayout(null);
        this.setBackground(Color.black);
        this.associateListeners(controller);

        myTitle = new Label("RSA Encryption and Decryption");
        myTitle.setLocation(190, 20);
        myTitle.setSize(300, 20);
        myTitle.setForeground(Color.ORANGE);
    
        
        myInputBox = new TextArea("");
        myInputBox.setLocation(200, 100);
        myInputBox.setSize(300, 50);
        
        myInputlabel = new Label("Insert the message you would like to encrypt below");
        myInputlabel.setLocation(200, 75);
        myInputlabel.setSize(400, 25);
        myInputlabel.setForeground(Color.white);

        
        myPublickey = new TextArea("This box will be filled in once you encrypt...");
        myPublickey.setLocation(200, 200);
        myPublickey.setSize(300, 50);
        
        myPubliclabel = new Label("Your Public Key:");
        myPubliclabel.setLocation(200, 175);
        myPubliclabel.setSize(300, 25);
        myPubliclabel.setForeground(Color.white);

        myPrivatekey = new TextArea("This box will be filled in once you encrypt...");
        myPrivatekey.setLocation(200, 300);
        myPrivatekey.setSize(300, 50);
        
        myPrivatelabel = new Label("Your Private Key (shhhh):");
        myPrivatelabel.setLocation(200, 275);
        myPrivatelabel.setSize(300, 25);
        myPrivatelabel.setForeground(Color.white);

        myEncrypted = new TextArea("This box will be filled in once you encrypt...");
        myEncrypted.setLocation(200, 400);
        myEncrypted.setSize(300, 50);
        
        myEncryptlabel = new Label("Encrytped Text");
        myEncryptlabel.setLocation(200, 375);
        myEncryptlabel.setSize(300, 25);
        myEncryptlabel.setForeground(Color.white);

        myOutputBox = new TextArea("This box will be filled in once you encrypt...");
        myOutputBox.setLocation(200, 500);
        myOutputBox.setSize(300, 50);
        
        myOutputlabel = new Label("Decrypted Text");
        myOutputlabel.setLocation(200, 475);
        myOutputlabel.setSize(300, 25);
        myOutputlabel.setForeground(Color.white);

     
        myResetButton = new Button("Reset");
        myResetButton.setSize(100, 25);
        myResetButton.setLocation(15, 510);

        myEncryptButton = new Button("Encrypt");
        myEncryptButton.setSize(100, 25);
        myEncryptButton.setLocation(15, 110);

        myResetButton.addMouseListener(myResetListener);
        myEncryptButton.addMouseListener(myEncryptListener);

        this.add(myResetButton);
        this.add(myTitle);
        this.add(myEncryptButton);
        this.add(myInputBox);
        this.add(myPublickey);
        this.add(myPrivatekey);
        this.add(myEncrypted);
        this.add(myOutputBox);
        this.add(myInputlabel);
        this.add(myEncryptlabel);
        this.add(myPubliclabel);
        this.add(myPrivatelabel);
        this.add(myOutputlabel);
        this.addWindowListener(new AWindowListener());
        this.setVisible(true);

    }

    /**
     * Associates each component's listener with the controller and the correct
     * method to invoke when triggered.
     *
     * <pre>
     * pre:  the controller class has to be instantiated
     * post: all listeners have been associated to the controller
     *       and the method it must invoke
     * </pre>
     */
    public void associateListeners(Controller controller)
    {
        Class<? extends Controller> controllerClass;
        Method resetMethod, encryptMethod;

        controllerClass = controller.getClass();

        resetMethod = null;
        encryptMethod = null;

        try
        {
            resetMethod = controllerClass.getMethod("reset", (Class<?>[]) null);
            encryptMethod = controllerClass.getMethod("encrypt", (Class<?>[]) null);
        } catch (NoSuchMethodException exception)
        {
            String error;

            error = exception.toString();
            System.out.println(error);
        } catch (SecurityException exception)
        {
            String error;

            error = exception.toString();
            System.out.println(error);
        }

        myResetListener = new ButtonListener(controller, resetMethod, null);
        myEncryptListener = new ButtonListener(controller, encryptMethod, null);
    }

    /**
     * Updates Labels with the String text.
     *
     * @param text
     *            the text string to use in updating the text field
     */
   public String getInputText() {
	   return myInputBox.getText();
   }
   public void setEncryptText(String t) {
	   myEncrypted.setText(t);
   }
   public void setOutputText(String t) {
	   myOutputBox.setText(t);
   }
   public void setPrivateText(String t) {
	   myPrivatekey.setText(t);
   }
   public void setPublicText(String t) {
	   myPublickey.setText(t);
   }
}
