import java.net.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
public class ImageServer extends Thread
{
       private ServerSocket serverSocket;
       Socket server;
		JFrame imageFrame=new JFrame("Image");
		JPanel panel=new JPanel();
		JLabel lbl=new JLabel();
		JScrollPane scroll=new JScrollPane(panel);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
       public ImageServer(int port) throws Exception
       {
          serverSocket = new ServerSocket(port);
		  imageFrame.setSize(d.width,d.height);
			imageFrame.setVisible(true);
			imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //serverSocket.setSoTimeout(20000);
       }
		/*class ImgCanvas extends Canvas{
		Image i;
		public ImgCanvas(Image i){
			this.i=i;
		}
		public void paint(Graphics g){
			g.drawImage(i,0,0,this);
		}
		}*/
       public void run()
       {
			panel.add(lbl);
			imageFrame.add(scroll);
           while(true)
          {
               try
               {
				
                  server = serverSocket.accept();
                 // DataInputStream din=new DataInputStream(server.getInputStream());
                 // DataOutputStream dout=new DataOutputStream(server.getOutputStream());
//System.out.println("-==========================================================================-");
                  java.awt.image.BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(server.getInputStream()));
				  lbl.setIcon(new ImageIcon(img));
				 // lbl.updateUI();
				 
				  
				  
				  /*File outputfile=new File("Client.jpg");
				  ImageIO.write(img,"jpg",outputfile);*/
                  System.out.println("Image received!!!!");
                  //lblimg.setIcon(img);
              }
             catch(SocketTimeoutException st)
             {
                   System.out.println("Socket timed out!");
                  break;
             }
             catch(IOException e)
             {
                  e.printStackTrace();
                  break;
             }
             catch(Exception ex)
            {
                  System.out.println(ex);
            }
          }
       }
      
       public static void main(String [] args) throws Exception
       {
              //int port = Integer.parseInt(args[0]);
			 
              Thread t = new ImageServer(6066);
              t.start();
       }
	   
}