package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	public static void main(String[] args) throws IOException{
		try {
			DatagramSocket server = new DatagramSocket(3000);
			System.out.println("\nPorta 3000 aberta e aguarda requisições do cliente");
			
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			server.receive(packet);
			
			System.out.println("\nConexão feita\n");
			
			String data = new String(packet.getData()).toUpperCase();
			
			packet.setData(data.getBytes());
			server.send(packet);
			
			server.close();
		} catch (IOException e) {
			System.out.println("\nError: " + e.getMessage());
		}
	}
}
