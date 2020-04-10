# Socket_Programming
Socket을 이용해 TCP, UDP 로 서버와 클라이언트 연결    
JAVA socket API 사용    
데이터 통신 수업 때 배운 내용 활용

# Socket
- 네트워크 상에서 수행되는 두 프로그램 간의 양방향 통신 링크 의 한쪽 끝 단을 의미 
- 특정 포트 번호와 연결되어 있음 

# TCP vs UDP
TCP
- 연결형 통신
- 높은 신뢰성
- UDP보다 속도 느림
- 3-way handshaking 으로 목적지 수신지 확실히함

UDP
- 비연결 통신
- 낮은 신뢰성
- TCP보다 속도 빠름
- 서로 다른 경로로 독립적으로 처리
