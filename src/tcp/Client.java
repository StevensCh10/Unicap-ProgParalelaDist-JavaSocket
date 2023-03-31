package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException{
		try {
			Scanner in = new Scanner(System.in);
			Socket socket = new Socket("localhost", 3000);
			
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("\nInfome texto para enviar ao servidor: ");
			String text = in.nextLine();
			output.writeUTF(text);
			
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String newText = input.readUTF();
			System.out.println("\nResposta do servidor: " + newText + "\n");
			
			input.close(); output.close();
			
			socket.close(); in.close();
		} catch (IOException e) {

			System.out.println("\nError: " + e.getMessage());
		}
	}
}
