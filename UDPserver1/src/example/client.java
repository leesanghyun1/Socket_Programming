package example;
import java.net.*;
import java.io.*;

public class client {
	public static void main(String args[]) {
		
		try {
			DatagramSocket ds = new DatagramSocket();
			InetAddress ia = InetAddress.getByName("127.0.0.1");
			String text="연결 됨";
			byte[] bf = text.getBytes();
			DatagramPacket dp = new DatagramPacket(bf,bf.length,ia, 9999);
			ds.send(dp);
			System.out.println("send Msg: "+text);
		}catch(Exception e) {		
			System.out.println(e);
		}
	}
}
