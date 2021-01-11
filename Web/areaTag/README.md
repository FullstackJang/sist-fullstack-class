# 영역태그
- `*<div*>`, `*<span*>`

- `*<div*>`
    - 사이트의 전체 디자인을 설정할 때 사용
    - width = "100%"가 기본 설정(div사용하면 줄이 변경된다.)
- `*<span*>
    - 데이터가 보여지는 영역을 설정할 때 사용
    - 데이터가 존재하는 영역만 설정(span 사용하면 줄이 변경되지 않는다.)

# HTML5에서 제공하는 태그
디자인 관련

- *<mark*>
    - 형광펜효과

- *<em*>
    - 이탤릭(음성서비스용)

- *<code*>
    - 코드 기술

- *<header*>
    - 디자인 구조에서 section중 상단영역임을 설정할 때

- *<main*>
    - 디자인 구조에서 내용을 부분의 영역임을 설정할 때

- *<footer*>
    - 디자인 구조에서 아랫부분의 영역임을 설정할 때
- *<nav*>
    - 사이트를 사용하기위한 navigation bar영역을 설정할 때

- *<aside>
    - 하나의 영역을 나타낼 때

- *<article*>
    - 게시물의 목록을 나타낼 때


## meta태그
> 검색엔진에 정보를 제공, 페이지 이동, charset의 설정, viewport설정

- *<head*>태그 사이에서 사용

- 검색엔진에 정보 제공 : keyword, description, author
```html
<meta name="keyword" content="java, javaSE, oracle, HTML">
<meta name="description" content="국비지원 취업과정">
<meta name="author" content="쌍용교육센터>
```
## HTML문서 내 charset의 설정
```html
    <meta charset="사용 할 charset">
```

## 페이지 이동
```html
    <meta http-equiv="refresh" content="초;rul=이동할url"> 
```

## viewport
> 다양한 device에서 페이지가 잘 보이도록 설정
```html
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
```
