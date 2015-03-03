import java.net.*;
import java.io.*;
class OpenClient{
	public static void main(String args[]){
		try{
		Socket s=new Socket("localhost",2500);
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		String str=in.readLine();
		ProcessBuilder p=new ProcessBuilder("cmd.exe","/c",str);
		Process p1=p.start();
		out.println("Program Complete");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}