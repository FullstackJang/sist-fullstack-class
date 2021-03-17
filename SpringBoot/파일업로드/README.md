# 파일 업로드

```html
<form action "" method="" enctype="multipart/form-data">
```

```html
<input type="file" name="fileupload">
```

## 스프링에서 파일 업로드

1. CommonsMultipartResolver 객체를 생성해야한다.

```xml
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
```

CommonsMultipartResolver 객체를 생성하기 위해서 config라는 패키지를 만든 후 SpringConfig클래스를 생성하여 객체를 생성 
```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.multipart.commons.CommonsMultipartResolver;

    @Configuration
    public class SpringConfig {

        @Bean
        public CommonsMultipartResolver multipartResolver() {
            return new CommonsMultipartResolver();
        }
        
    }
```

2. vo에 클라이언트가 등록한 파일에 대한 정보를 가져오기 위해서 MultipartFile타입에 uploadFile이라는 변수를 생성한다.

```java
import org.springframework.web.multipart.MultipartFile;

	private MultipartFile uploadFile;
```


3. 파일업로드에 필요한 maven dependency추가

<img src ="https://user-images.githubusercontent.com/69107255/111063271-f2798600-84f0-11eb-94d6-ba50b96cc309.png">

위에 jar파일을 추가해야하지만, https://mvnrepository.com/ 에서 `Apache Commons FileUpload`와 `Apache Commons IO`에 Maven을 복사해 pom.xml에 등록해준다.

- **Apache Commons FileUpload 1.3.1Ver**
```xml
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.3.1</version>
<dependency>
```

- **Apache Commons IO  2.4Ver**
```xml
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.4</version>
</dependency>
```