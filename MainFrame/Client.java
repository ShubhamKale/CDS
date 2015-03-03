import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.*;
import java.net.*;
public class Client extends JFrame
{
	
	public Client(String ip,int port)
	{
		try
		{
			Socket server=new Socket(ip,port);
			//while(true){}
			server.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	/*public void drawFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		panel1=new JPanel();
		setSize(dim.width,dim.width);
		setTitle("Main Frame");
		setVisible(true);
		tree=new JTree(root);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,tree, panel1);
		add(splitPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		setDefaultCloseOperation(3);
	}*/
	public static void main(String args[]){
		Client c=new Client("localhost",6069);
	}
}
