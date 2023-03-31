package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			System.out.println("\nPorta 3000 aberta e aguarda requisições do cliente");
			
			Socket socket = serverSocket.accept();
			System.out.println("\nConexão feita\n");
			
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String text = input.readUTF();
			String newText = text.toUpperCase();
			
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(newText);
			
			input.close(); output.close();
			
			socket.close(); serverSocket.close();
		} catch (IOException e) {
			System.out.println("\nError: " + e.getMessage());
		}
	}
}
