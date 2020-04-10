package example;
import java.net.*;
import java.io.*;
import java.lang.*;

public class sever {
	public static void main(String args[]) {
		try {
			DatagramSocket ds= new DatagramSocket(9999);
			
			while(true) {
				try {
					byte[] bf=new byte[300];
					DatagramPacket dp = new DatagramPacket(bf,bf.length);
					ds.receive(dp);
					String rs1 = new String(dp.getData());
					String rs2 = new String(rs1.trim());
					System.out.println("주소:"+dp.getAddress()+"포트번호:"+dp.getPort());
					System.out.println("수신된 메시지(Client->Server):"+rs2);
				}catch(IOException e) {}
			}
			
		}catch(IOException e) {}
	}
	
}
