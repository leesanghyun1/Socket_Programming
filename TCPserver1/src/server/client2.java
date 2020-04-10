package server;
import java.io.*; 
import java.net.*;
import java.util.*;

public class client2 {
	public static void main(String[] args) 
			throws IOException { 
	 
		BufferedReader in=null;
		BufferedWriter out=null;
		Socket socket =null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			socket=new Socket("localhost",9999);
			System.out.println("연결 됨");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String outputMessage;
			
			while(true) {
				System.out.print("계산식(빈칸으로 띄어 입력, 예 24 + 42)>>");
			outputMessage=scanner.nextLine();
			if(outputMessage.equalsIgnoreCase("bye")) {
				out.write(outputMessage + "\n");
				out.flush();
			break;
		}
			out.write(outputMessage+"\n");
			out.flush();
			String inputMessage= in.readLine();
			System.out.println("계산결과: "+inputMessage);	
		}
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}finally {
			try {	
				socket.close();
				if(socket !=null) socket.close();
			}
			catch(IOException e){
				System.out.println("채팅중 오류발생");	
			}
		}

	}

	
}
