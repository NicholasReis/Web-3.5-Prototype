import java.net.*;  
public class MyClient {  
	public static void main(String[] args) {  
		try{      
			Socket connectionToServer = new Socket("localhost", 1025);  
			System.out.println("Connection to Server Successful.");
			connectionToServer.close();  
		}catch(Exception e){
			System.out.println(e);
		}  
	}  
}  