import java.net.*;

public class Server {
	public static void main(String[] args){
		//Creates a pool of connections
		//Eventually this class will just be a listener for new connections
		//The logic will be implemented in the ConnectionPool class
		ConnectionPool pool = new ConnectionPool();
				
		try{
			//Opens a server socket on port 1025
			ServerSocket serverPort = new ServerSocket(1025);
			System.out.println("Server Loaded and Running");
			
			//Waits for a client to connect
			Socket clientConnection = serverPort.accept();
			//Passes the socket into a new connection
			//The new connection is then put into the pool
			pool.addConnection(new Connection(clientConnection));
			
			//Closes the server port
			serverPort.close();

		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}  
