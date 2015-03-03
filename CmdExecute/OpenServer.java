import java.net.*;
import java.io.*;
class OpenServer{
	public static void main(String args[]){
		try{
		ServerSocket sc=new ServerSocket(2500);
		Socket c=sc.accept();
		System.out.println("Connected to "+ c.getRemoteSocketAddress());
		BufferedReader ins=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in=new BufferedReader(new InputStreamReader(c.getInputStream()));
		PrintWriter out=new PrintWriter(c.getOutputStream(),true);
		out.println(ins.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}