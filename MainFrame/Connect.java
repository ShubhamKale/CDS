//package Server;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;


import java.io.*;
import java.net.*;
public class Connect extends JFrame
{
	DefaultMutableTreeNode root=new DefaultMutableTreeNode("All");
	JTree tree;
	JPanel panel1;
	JSplitPane splitPane;
	DefaultTreeModel model;
	JTabbedPane tabs=new JTabbedPane();
	public Connect(int port)
	{
		try
		{
			ServerSocket server=new ServerSocket(port);
			drawFrame();
			while(true)
			{
				Socket c=server.accept();
				System.out.println("Client Accepted"+c.getInetAddress()+" "+c.getPort());
				try
				{
				//if((root.getNextLeaf()==null) || (!(root.getNextLeaf().toString().equals(c.getInetAddress()))))
				//{
					root.add(new DefaultMutableTreeNode((c.getInetAddress()+" "+c.getPort())));
					model = (DefaultTreeModel)tree.getModel();
					model.reload(root);
				//}
				}
				catch(Exception e)
				{}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void drawFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		panel1=new JPanel();
		JPanel p1=new JPanel();
		tabs.addTab("Remote Connection",p1);
		JPanel p2=new JPanel();
		tabs.addTab("Remote Connection",p2);
		JPanel p3=new JPanel();
		tabs.addTab("Remote Connection",p3);
		panel1.add(tabs);
		setSize(dim.width,dim.width);
		setTitle("Main Frame");
		setVisible(true);
		tree=new JTree(root);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,tree, panel1);
		add(splitPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		setDefaultCloseOperation(3);	
	}
	public static void main(String args[]){
		Connect c=new Connect(6067);
	}
}
