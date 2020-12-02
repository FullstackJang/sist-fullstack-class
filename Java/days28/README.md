# 출력스트림

출력의 목적지 : File

FileStream사용
- FileOutputStream(8bit) : 모든 데이터를 파일에 기록할 수 있다.
- FileWriter(16bit) : 문자열 데이터만 파일에 기록할 수 있다.

# FileOutputStream

1. **생성**
같은 이름의 파일이 존재하면 덮어쓰고, 같은 이름의 파일이 없다면 파일만 생성(폴더는 생성하지 못한다.)
```java
    FileOutputStream fos = new FileOutputStream();
```

2. 데이터를 **스트림**에 쓴다.
```java
    fos.write(10);
```

3. 스트림기록된 내용을 목적지로 **분출**한다.
```java
    fos.flusth();
```

4. 스트림의 연결 끊기(가장중요. Flush를 하지않아도 close를 하면 stream에 내용이 분출되고 연결이 끊어진다.)
```java
    fos.close();
```


# FileWriter
> 16bit Stream 복합 사용: 속도향상
1. 스트림 **연결**
- 파일이 없다면 생성하고, 있다면 덮어 쓴다.
```java
    FileWriter fw = new FileWriter(new File("파일경로"));
    
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File"파일경로"));
    
    //16bit와 8bit를 OutputStreamWriter를 사용해서 연경
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File ("파일경로")));
```

2. 스트림에 목적지로 내보낼 데이터를 **기록**
```java
    fw.writer("안녕하세요.");
```

3. 스트림에 기록된 내용을 목적지로 **분출**
```java
    fw.flush();
```

4.  연결 **끊기**
```java
    fw.close();
```

# 파일 복사
> 대상파일을 자바에서 읽어 들여, 다른 이름의 파일에 그대로 내보내는 것

1. **읽기 스트림 연결**
```java
    FileInputStream fis = new FileInputStream(new File("경로"));
```

2. **쓰기 스트림 연결**
```java
    FileOutputStream fos = new FileOutputStream(new File("경로"));
```

3. **파일의 내용을 읽어와서**
```java
    int temp = 0;
    while((temp = fis.read()) != -1){
        4. 스트림에 기록
        fos.write(temp);

        5. 스트림의 내용을 목적지로 분출
        fos.flush();
    }
```

6. **연결 끊기**
```java
    fos.close();
    fis.close();
```
# 성능차이 개선

1. **읽기 스트림 연결**
```java
    FileInputStream fis = new FileInputStream(new File("경로"));
```

2. **쓰기 스트림 연결**
```java
    FileOutputStream fos = new FileOutputStream(new File("경로"));
```

3. **파일의 내용을 읽어와서**
```java
    int readSize = 0; //읽어들인 크기
    byte[] readData = new byte[512]; //HDD의 head가 한번에 읽어들여 저장한 크기와 같게 배열 생성

    while((readSize = fis.read(readData)) != -1){ //4. 값이 존재한다면 while문을 돌린다.
    //1.fis.read(readData) -> 스트림에서 읽어들인 
    //2 readData -> 데이터를 배열에 넣고
    //3.readSize-> 배열의 값이 있는 방의 개수를 저장 
    
        4. 스트림에 기록
        fos.write(readData,0,readSize);

        5. 스트림의 내용을 목적지로 분출
        fos.flush();
    }
```

6. **연결 끊기**
```java
    fos.close();
    fis.close();
```

# **ObjectStream(MarshallStream)**
> instance를 JVM외부로 내보내거나, JVM외부에 존재하는 instance를 JVM내부로 읽어들일 때 사용하는 스트림

- 직렬화(marshalling) - `Serializalbe interface`를 구현한 클래스는 Stream을 타고 나갈 수 있게 일정크기로 쪼개진다.
- 역직렬화(Unmarshalling) - 쪼개진 객체를 원래의 상태로 만드는 것
- 모든 객체는 Stream을 타고 외부 JVM외부로 나갈 수 없다.(보안과 객체크기를 모르기 때문)
- 기본형데이터형은 JVM을 타고 JVM외부로 나갈 수 있다.
    - (transien	직렬화 방지키워드(IO Stream)을 타고 나가지 못하도록 막는 일을 함)
- 객체를 읽을 때 `ObjectInputStream`, 객체를 내보낼 때 `ObjectOutputStream`을 사용
- 객체가 Stream을 타고 JVM외부로 나갈려면 `java.io.Searializable`인터페이스를 구현해야한다.

**객체스트림의 사용**

1. 직렬화가 가능한 객체 생성
```java
    public class Test implements Serializable {
            값

    }
```

2. 객체를 내보내는 스트림 생성
```java
    ObjectOutputStream oos = new ObjectOutputStream(new ObjectOutputStream(new FileOutputStream("파일명")));
```

3. 객체를 스트림 기록
```java
    Test t = new Test();
    oos.writeObject(t); //직렬화가 되어서 스트림까지밖에 안써진다.
```

4. 스트림에 직렬화되어 저장된 객체를 **목적지**로 분출
```java
    oos.flush();
```

5. 스트림연결 끊기
```java
    oos.close();
```

# JVM외부의 직렬화된 객체를 JVM내부로 읽어 들이기
1. 객체 스트림 생성
```java
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("경로"));
```

2. 객체 읽기
> 역직렬화: 조각난 객체가 합쳐져서 반환
```java
    클래스명 객체명 = (클래스명)ois.readObject();
```

3. 객체 사용
```java
    객체명.변수명 or 객체명.method명();   
```