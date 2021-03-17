# **Network**
- 컴퓨터끼리 데이터를 주고 받기 위해 만들어진 통신망
- 컴퓨터에 의해 작동한다.

# **C/S프로그래밍 (Client/Server)**
> 원격지에 존재하는 컴퓨터 끼리 자원을 주고 받는 프로그램을 작성하는 것(Network위에서 동작)

- OSI7Layer(실제는 3단계모델인 TCP/IP Model)를 사용
  Reference Model: 단계를 세분화하여 네트워크 계층을 이해하기 좋게 만든 모델
  (물리계층,데이터링크,네트워크계층,전송계층,세션계층,표현계층,응용계층)

Open Systems Interconnection Reference Model
|||
|----|----|
|응용계층(Application Layer)| 사용자가 사용하는 프로그램|
|표현계층(Presentaion Layer)| 입력값이 어떻게 변화되어 컴퓨터에게 어떻게 보여질지(암호화)|
|세션계층(Session Layer)|어떻게 연결할 지(호단위): 가상 연결|
|전송계층(Transprot Layer)|실제 연결 P2P TCP/UDP|
|네트워크계층(Network Layer)|길 찾기|
|데이터링크계층(Datalink Layer)|MAC, Data를 media에 어떻게 link해줄 것인지|
|물리계층(Physical Layer)|media로 연결(유/무선)|

# Protocol(전송규약)
> 데이터를 정송하기위해 미리 정의해둔 형식 자바에서는 TCP와 UDP를 사용할 수 있음

# **TCP(Transmission Control Protocol) : java.net.Socket, ServerSocket**
- 전화로 많이 비교
- 속도 느리다.(체크 - 오류 검출)
- 한 번에 전송하는 `크기가 일정하다.`(1Packet : 8bit) 따라서 과금이 편하다.
- 데이터 전달이 확실하다.
- 금융,웹 사이트
netstat -ao

# **UDP(User Datagram Protocol) : java.net.DatagramPacket, DataGramSocket**
- 우편으로 많이 비교
- 속도 빠르다.(체크X - 오류 검출하지않음)
- 패킷의 크기를 개발자가 설정할 수 있다.(과금이 어렵다.)
- 데이터가 전달되지 않을 수 있다.(패킷이 꼬일 수 있다.)
- 화상채팅,영상,게임 보낼 때 주로 사용

# **Java Network 프로그램**
> 정의: 컴퓨터끼리 연결하는 프로그램`

java.net 패키지에 관련 클래스가 제공
- TCP / UDP 프로토콜을 사용하는 프로그램만 작성할 수 있다.
  - (Protocol 자체의 개발은 자바에서 할 수 없다.)
- `Socket 프로그램`: 컴퓨터끼리 연결만 수행: 데이터를 주고 받기위해서는 `IOStream`을 사용
- 자바에서는 전송계층 까지만 할수있음