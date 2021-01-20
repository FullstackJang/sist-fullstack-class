# 목표
-  입력한 값을 배열에 객체를 만들어서 추가해보자

<img src = "https://user-images.githubusercontent.com/69107255/105172988-bb779b80-5b63-11eb-89d2-61d41d0c13ae.png">

<img src = "https://user-images.githubusercontent.com/69107255/105173264-1e693280-5b64-11eb-90de-f651bcf82b1a.png">

사용자로 부터 `이름`,`나이`,`주소`,`전화`를 **<input*>**태그를 통하여 입력받습니다.
`등록`버튼을 클릭 하게 되면

## 배열에 추가하기
<img src ="https://user-images.githubusercontent.com/69107255/105174212-8f5d1a00-5b65-11eb-8fb4-1a2068640033.png">
**<input*>**태그의 id를 통하여 값을 가져온 후 각 변수에 값을 저장합니다.
`나이`의 경우에는 **<input*>**태그가 문자형태로 넘어오기 때문에 Number을 통하여 형변환이 필요하다.

```javascript
        let member = {name:userName,age:userAge,addr:userAddr,tel:userTel}
```
input으로 넘어온 값들의 변수들을 각 객체에 `속성명`과 `속성`으로 객체를 생성합니다.

**let member_list** 배열이 초기화 되어있습니다. 해당 배열에 `member`객체를 push합니다.