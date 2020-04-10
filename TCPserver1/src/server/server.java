package server;
import java.io.*; 
import java.net.*;

public class server {
	public static void main(String[] args) 
			throws IOException { 
		String clientSentence; 
		String capitalizedSentence; 
		ServerSocket welcomeSocket; 
	
		welcomeSocket = new ServerSocket(6789); //커넥션 맺어주는 소켓 //노란밑줄-> close 안시켯다는 메시지 작업프로세스 끄던가 eclipse 끄면 됌
		
		System.out.println("Server start..\n ");	//close 소스가 없어서
		
		while(true) { 
			//커넥션 맺어줌 before 연결되면(after)
			Socket connectionSocket = welcomeSocket.accept(); 
			//after 
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(
						connectionSocket.getInputStream() //들어오는 메시지 읽음
							)
					);
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream() //서버 -> 클라이언트 메시지 보냄
						); 
			clientSentence = inFromClient.readLine(); 
			System.out.println("FROM CLIENT: " + clientSentence ); 
			capitalizedSentence = clientSentence.toUpperCase() + '\n'; //대문자로 바꿈
			outToClient.writeBytes(capitalizedSentence);  //대문자로 바꾼 스트링을 Byte 형태로 다시씀
				} 
	}

	
}
