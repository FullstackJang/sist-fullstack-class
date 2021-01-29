현재 HTML 화면에는 많은 컨텐츠가 있다고 가정합니다. `등록 버튼`을 클릭하면 화면 전체를 전환하지 않고 DB서버에 추가를 하고 다시 오게 끔  Ajax통신을 해보고자 합니다. 

**member테이블**은 아래와 같이 정의 되어 있습니다.
<img src ="https://user-images.githubusercontent.com/69107255/106282533-10ae5e00-6284-11eb-9389-49e9d557610d.png">


# 회원 등록

**추가 버튼**에 이벤트를 걸어서 사용자가 입력한 값을 `let data = $("#input").serializeArray();`를 통해서 가져왔습니다.

**.serializeArray()** 는 *<form*>태그 내부의 값을 `JSON형태로 문자열을 배열`로 리턴합니다. 

`let data = $("#input").serializeArray();`에 data에 담긴 값을 console.log를 통해서 값을 출력했을 때 객체 문자열 형태로 저장되어 있는 것을 확인 할 수 있습니다.    

<img src = "https://user-images.githubusercontent.com/69107255/106280720-9bda2480-6281-11eb-894e-ac14dec1671f.png">

**index.html**
```javascript
	$('#btnInsert').click(function () {
	   		
		let data = $("#input").serializeArray();
			
		console.log(data);

		$.ajax({
			url : 'insertMember.jsp', //추가를 할 프로그램명
			data : data /*data속성 : data-> 서버로 보낼 데이터*/
                    
	   	}).done(function (data/*서버가 나에게 응답해준 데이터*/) {
			viewMemberList();
		});   		
	});
```

# 회원 읽기

추가된 회원들의 회원리스트를 읽어오고자 합니다.