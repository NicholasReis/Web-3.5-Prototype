import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args){
		//Intializes scanner
		Scanner userInput = new Scanner(System.in);
		
		//Assigns choice for the switch
		int choice = -1;
		while(choice != 0){
			//Outputs a welcome screen and provides the user with options
			System.out.println("Welcome. Please select an option:\n1. Add Data\n2. Connect to Server\n(0 to exit...)");
			//Waits for the user's input
			choice = userInput.nextInt();
			switch(choice){
				case 0:
					userInput.close();
					System.out.println("Goodbye");
				case 1:
					addData();
				break;
				case 2:
					connectToServer();
				break;
			}
		}
	}

	//Works, but not built. This is where the user will deal with data.
	private static void addData(){
		try{
			FileWriter writer = new FileWriter("Data.txt");
			writer.write("This ");
			writer.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}

	
	private static void connectToServer(){
		try{
			//Attempts to connect to the server
			Socket connectionToServer = new Socket("localhost", 1025);
			System.out.println("Connection to Server Successful.");
			
			//Initializes input and output streams for server communication
			DataInputStream dis = new DataInputStream(connectionToServer.getInputStream());
			DataOutputStream dos = new DataOutputStream(connectionToServer.getOutputStream());
			
			//Outputs the server's greeting and asks for selection
			System.out.println(dis.readUTF());
			
			//Initializes scanner to respond
			Scanner scan = new Scanner(System.in);
			//Responds with user input
			dos.writeUTF(scan.nextLine());
			
			//Closes scanner and connection
			
			connectionToServer.close();
			
			//Exception NO SUCH ELEMENT when closing scan
			//Requires further investigation.
			//scan.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}  
