# 구글 메일 보내기 설정 

## 1. 구글 계정으로 접속 후 로그인
- https://myaccount.google.com/

## 2. [ 보안 ] > [ Google에 로그인 ] > [ 2단계 인증 ]을 클릭 후 등록
- https://myaccount.google.com/signinoptions/two-step-verification


## 3. [ 보안 ] > [ Google에 로그인 ] > [ 앱 비밀번호 ]을 클릭
- https://myaccount.google.com/apppasswords

## 4. 앱 비밀번호를 생성할 앱 및 기기를 선택
- [ 앱 선택 ]은 '메일'을 선택
- [ 기기 선택 ]은 아무거나 선택

## 5. 생성 클릭
- 발급된 패스워드가 팝업에 패스워드가 발급되며
- 발급 받은 패스워드는 따로 저장(코드에서 사용)

## pom.xml에 Maven dependency설정
```
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>5.2.5.RELEASE</version>
		</dependency>
		<!-- Java Mail API -->
		<dependency>
			<groupId>javax.mail</groupId>
			<artifactId>mail</artifactId>
			<version>1.4.7</version>
		</dependency>
```
