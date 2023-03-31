package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException{
		try {
			Scanner in = new Scanner(System.in);
			
			DatagramSocket client = new DatagramSocket();
			InetAddress add = InetAddress.getByName("localhost");
			
			System.out.println("\nInfome texto para enviar ao servidor: ");
			String text = in.nextLine();
			byte[] buf = text.getBytes();
			
			DatagramPacket packet = new DatagramPacket(buf, buf.length, add, 3000);
			client.send(packet);
			client.receive(packet);
			
			String newText = new String(packet.getData());
			
			System.out.println("\nResposta do servidor: " + newText + "\n");
			
			in.close(); client.close();
		} catch (IOException e) {
			System.out.println("\nError: " + e.getMessage());
		}
	}
}
