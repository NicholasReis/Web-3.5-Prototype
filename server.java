import java.net.*;  
public class MyServer {  
	public static void main(String[] args){  
		try{  
			ServerSocket serverPort = new ServerSocket(1025);  
			Socket clientConnection = serverPort.accept();
			System.out.println("Connection from Client Successful.");
			serverPort.close();  
		}catch(Exception e){
			System.out.println(e);
		}  
	}  
}  