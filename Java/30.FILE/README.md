# 입력의 근원이 HDD에 존재하는 File일 때

8bit Stream : FileInputStream - 모든 파일을 읽어들일 수 있다.(파일 복사)
16bit Stream : FileReader - 독자 포맷이 없는 텍스트 파일을 읽어 들일 때

# FileInputStream 생성자
```java
 public FileInputStream(File file) throws FileNotFoundException
```

# FileReader 생성자
```java
public FileReader(File file) throws FileNotFoundException
```

# File 클래스
> 파일의 정보를 얻을 때 사용
- 파일의 경로명을 저장하는 클래스
  - java.io 패키지에서 제공
  - 파일과 디렉터리 경로명의 추상적 표현
- 파일 이름 변경, 삭제, 디렉터리 생성,  크기 등 파일 관리
    - File 객체는 파일 읽고 쓰기 기능 없음
- 파일 입출력은  파일 입출력 스트림 이용

**사용법**

1. **생성**
```java
    File file = new File("경로");
```

2. **Method 호출**
```java
    파일이 존재 : file.	exists(); // 파일 or 디렉토리 존재여부
    파일의 크기 : file.length(); // byte단위로 반환
   
    파일의 절대경로 : file.getAbsolutePath(); // c:/dev/temp/java_read.txt or C:/dev/temp/java_read.txt
    파일의 규범 경로 : file.getCanonicalPath(); //c를 대문자로 변경해준다. try catch 해줘야함
    파일의 경로 : file.path(); //getAbsolutePath()와 동일하게 나옴
    파일의 디렉토리 : file.getParent(); //파일이 존재하는 경로명을 얻을 때
   
    파일명 얻기 : file.getName(); 
  
    파일인지? : file.isFile();
    폴더인지? : file.isDirectory();
    읽기가능한지? : file.canRead();
    쓰기가능한지? : file.canWrite();
    실행가능한지? : file.canExecute();

    숨김파일인지? : file.isHidden();


    -----조작
    - 폴더 생성(파일은 생성 할 수 없다.: 출력스트림을 사용해야함)
    1. 파일클래스 생성:
    File file = new File("생성할 폴더명");
    File file = new File("c:/dev/test");

    1-2. 디렉토리 생성
    file.mkdir(); //  하위폴더가 없는 하나의 폴더를 생성
    file.mkdirs(); // 여러 폴더를 동시 생성

    - 파일 삭제
    1. 삭제할 파일경로를 가진 File 클래스를 생성
    File file = new File("삭제할 파일의 경로");

    1-2. 파일 삭제
    file.delete();

    - 파일명 변경
    file.renameTo(변경할 이름을 가진 파일 객체); 

```

# File Stream 사용

1. 읽어들일 파일에 스트림을 연결
```java
try {
    FileInputStream fis = new FileInputStream(new File("c:/dev/temp/java_read.txt"));
```

2. 파일의 내용을 읽기.
```java
    fis.read();// 가장 처음 1byte를 읽어들인다. 읽어들인 내용이 없다면 -1 반환

}catch(FileNotFoundException fnfe){ // public FileInputStream(File file) throws FileNotFoundException

}catch(IOException ie) { //public int read(byte[] b) throws IOException


}//end catch
```

문법
1. File에 8bit스트림 연결
```java
    FileInputStream fis = new FilInputStream(new File("연결할 파일명"));
```

2. 8bit stream과 16bit stream을 연결하면서 charset을 encoding할 수 있는 stream연결
```java
    InputStreamReader isr = new InputStreamReader(fis,"charset");
```

3. 줄 단위로 읽어들이기 위한 스트림 연결
```java
    BufferedReader br = new BufferedReader(isr);
```

3. 줄 단위로 (\n)로 읽기
```java
   String str = br.readLine(); //읽어드린 내용이 없다면 null을 반환
   모든 줄 읽기
   String str = "";
   while( (str=br.readLine()) != null){
       
   }
```