package server;
import java.io.*; 
import java.net.*;

public class clientEX {
	public static void main(String[] args) 
			throws IOException { 
	 
		BufferedReader in=null;
		BufferedWriter out=null;
		BufferedReader stin=null;
		
		Socket socket =null;
		try {
			socket=new Socket("localhost",9999);
			System.out.println("연결 됨");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stin=new BufferedReader(new InputStreamReader(System.in));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String outputMessage;
			while(true) {
			outputMessage=stin.readLine();
			if(outputMessage.equalsIgnoreCase("bye")) {
				System.out.println("연결 종료됨");
				out.write(outputMessage);
				out.flush();
			break;
		}
			out.write("클라이언트>"+outputMessage+"\n");
			out.flush();
			String inputMessage= in.readLine();
			System.out.println(inputMessage);	
		}
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}finally {
			try {	
				socket.close();
			}
			catch(IOException e){
				System.out.println("채팅중 오류발생");	
			}
		}

	}

	
}
