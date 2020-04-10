package server;
import java.io.*; 
import java.net.*;

public class serverEX {
	public static void main(String[] args) 
			throws IOException { 
	 
		BufferedReader in=null;
		BufferedWriter out=null;
		BufferedReader stin=null;
		ServerSocket listener=null;
		Socket socket =null;
		try {
			listener =new ServerSocket(9999);
			socket = listener.accept();
			System.out.println("연결 됨");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stin=new BufferedReader(new InputStreamReader(System.in));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String inputMessage;
		while(true) {
			inputMessage=in.readLine();
			if(inputMessage.equalsIgnoreCase("bye")) {
				System.out.println("연결 종료됨");
				break;}
			System.out.println(inputMessage);
			String outputMessage= stin.readLine();
			out.write("서버>"+outputMessage+"\n");
			out.flush();
		}
			
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}finally {
			try {
				socket.close();
				listener.close();	
			}
			catch(IOException e){
				System.out.println("채팅중 오류발생");
				
			}
		}

	}

	
}
