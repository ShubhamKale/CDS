import java.net.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.Robot;
public class ImageClient
{
    Image newimg;
    static java.awt.image.BufferedImage bimg;
    byte[] bytes;
	
   public static void main(String [] args)
   {
      String serverName = "localhost";
      int port = 6066;
      try
      {
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
		while(true)
		 {				 
         Socket client = new Socket(serverName, port);
        //DataInputStream in=new DataInputStream(client.getInputStream());
       // DataOutputStream out =
                      // new DataOutputStream(client.getOutputStream());
        /* ImageIcon img1=new ImageIcon("Ashish.jpg");
         Image img = img1.getImage();
         Image newimg = img.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH);
         ImageIcon newIcon = new ImageIcon(newimg);*/
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 Dimension d=tk.getScreenSize();
			Robot ro=new Robot();
			
			bimg = ro.createScreenCapture(new Rectangle(0,0,d.width,d.height));//ImageIO.read(new File("G:\\trophy.jpg"));
		
			ImageIO.write(bimg,"JPG",client.getOutputStream());
			System.out.println("Image sent!!!!");
			client.close();
		 }
      }catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}