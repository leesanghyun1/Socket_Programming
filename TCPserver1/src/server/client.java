package server;
import java.io.*; import java.net.*;

public class client {
	public static void main(String argv[]) 
	
	throws Exception { 
		String sentence; 
		String modifiedSentence; 
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //들어온 스트링을 쓸수 있는 형태로 바꿈
				Socket clientSocket = new Socket("127.0.0.1", 6789); //다른 ip입력하면 글로감 ,port는 서버랑 같게
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //서버에 보냄
				
		BufferedReader inFromServer = new BufferedReader(
			new InputStreamReader(clientSocket.getInputStream())//서버에서온 메시지 읽을때
			); 
		
			sentence = inFromUser.readLine();  //유저 한테 입력받아서
			outToServer.writeBytes(sentence + '\n');  //서버에 보내줌
			modifiedSentence = inFromServer.readLine(); //서버에서온 메시지 담고있음 
			System.out.println("FROM SERVER: " + modifiedSentence); //modifiedSentence(서버에서온 대문자 메시지)
			clientSocket.close(); 
	} 
}
