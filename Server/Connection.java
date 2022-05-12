import java.net.*;
import java.io.*;

public class Connection {
	//Initializes variables that each client connection will need
	Socket socket;
	String requestType;
	
	public Connection(Socket client){
		//Assigns the socket 
		socket = client;
		
		//Assigns request type (Will be checked and used to determine what connection pool will do)
		requestType = getRequestType();
	}
	
	public String getRequestType() {
		//Initializes response with 0
		String response = "0";
		try {
			//Initializes data streams to communicate with client
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			//This can be tighter, probably shouldn't be using writeUTF
			//Outputs menu to client
			dos.writeUTF("What would you like to interact with:\n\"friend\"\n\"forum\"");
			//Assigns response from client
			response = dis.readUTF();
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Returns response as an integer
		return response;
	}
}
