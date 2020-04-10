package server;
import java.io.*; 
import java.net.*;
import java.util.*;

public class server2 {
	
	
	public static String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp, " ");
		if (st.countTokens() != 3) 
			return "빈칸으로 나누어 다시 입력하세요, 예 20 * 32"; 
		
		String res ="";
		int op1 = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		
		switch (opcode) {
			
		case "+" :res=Integer.toString(op1 + op2);  
			break;
		case "-" :res=Integer.toString(op1 - op2); 
			break;
		case "*" :res=Integer.toString(op1 * op2); 
			break;

		default : res="+,-,* 중에 입력하세요";
			}
		return res;
		}
	
	public static void main(String[] args) 
			throws IOException { 
	 
		BufferedReader in=null;
		BufferedWriter out=null;
		ServerSocket listener=null;
		Socket socket =null;
		
		try {
			listener =new ServerSocket(9999);
			System.out.println("시스템 연결 기다리는 중");
			socket = listener.accept();
			System.out.println("연결 됨");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String inputMessage;
		while(true) {
			inputMessage=in.readLine();
			if(inputMessage.equalsIgnoreCase("bye")) {
				System.out.println("클라이언트 에서 연결을 종료 하였음.");
				break;
				}
			System.out.println(inputMessage); //받은 메시지 화면에 출력
			String res = calc(inputMessage);
			out.write(res+"\n");
			out.flush();
		}
			
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}finally {
			try {	
				if(socket != null)socket.close();
				if(listener != null) listener.close();	
			}
			catch(IOException e){
				System.out.println("채팅중 오류발생");
				
			}
		}

	}

	
}
