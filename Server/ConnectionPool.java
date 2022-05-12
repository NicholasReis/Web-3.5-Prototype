import java.util.ArrayList;

public class ConnectionPool extends Thread{
	//Creates an empty array list for connections
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
    public ConnectionPool(){
    	//Verifies it is working
        System.out.println("Pool started");
    }

    public void addConnection(Connection client) {
    	//Adds client connection to arraylist
    	connections.add(client);
    }
    
    //There will be a running loop to apply logic based on the request types (It will pair users, or whatever I make it do)
}
