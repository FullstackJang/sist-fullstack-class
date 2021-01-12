# CSS (Cascading Style Sheet)
- CSS3가 최신 표준으로 W3C에서 발표되었다.
- 1994년에 하콤 비움 리(Hakon Wium lie)처음 제안
- Web Page에서 통일성 있는 디자인을 하기위해 고안
- inline방식, embed방식, external file방식 3가지 방식으로 사용할 수 있다.
- selector를 사용하여 디자인을 적용받을 tag를 설정한다.

# 사용법
## inline방식
- 태그에 직접 CSS코드를 정의하는 방식
- 적용우선순위가 가장 높다
- 중복디자인 코드를 태그마다 정의해야한다.(중복성)
**문법**
```html
    <태그명 style="속성:값; 속성:값; ,,,">
```

## embed방식
- *<head*>태그 사이에 *<style*>태그를 정의하는 방식
- 한 페이지에서 사용되는 디자인을 모아서 정의하는 방식
- inline방식보다 중복성이 낮다.
- selector를 사용하여 이자인을 적용받을 태그를 설정한다.

**문법**
```html
    <style type="text/css">
        selector {
            속성:값;
            속성:값;
        }
```

## 외부파일방식(external file)
- CSS코드를 파일에 정의하고 필요한 HTML에서 참조하여 사용하는 방식
- 디자인 코드의 중복성은 낮으나, 적용 우선순위가 가장 낮다.
- 확장자가 .css인 파일을 생성하여 정의
- 필요한 곳에서 `*<link rel="stylesheet" type="text/css" href="css의 경로" *>`를 설정하여 정의된 디자인을 사용한다.

**문법**
1. **test.css파일 생성**
```html
    selector {
        속성:값;
        속성:값;   
    }
```

2. **공통디자인이 필요한 HTML에서 *<head*>태그 사이에 *<link*>를 정의**
```html
    <html>
        <head>
        <link rel="stylesheet" type="text/css" href="http://localhost/html_prj/common/css/test.css"> 
```

# 선택자(selector)
- embed방식과 외부파일방식에서 디자인을 적용 받을 태그를 선택하는 것
- `id selector`, `class selector`, `tag selector`, `multiple selector`, `sub selector`, `behabior selector`

## id selector
    - 디자인을 적용 받을 태그가 유일할 때(하나의 태그만 디자인을 적용할 때)
    - 아이디가 다르고 같은 디자인을 사용해야 한다면 `#아이디명, #아이디명 {속성 :값}`의 문법으로 사용할 수 있다.
**문법**
```html
    #아이디명 {
        속성:값; 
        .
        .
        .
    }

    <!-- 태그적용 - 해당페이지에서 유일하게 하나만 설정할 것
        에러는 안나지만 Javascript에서 문제 발생한다. -->
    <태그명 id="아이디명">
```

## class selector
- 정의된 디자인을 특정 여러 태그들에서 사용할 때

**문법**
```html
    .클래스명, .클래스명 {
        속성 : 값;
    }

    <!-- 태그적용-->
    <태그명 class="클래스명">
```

## tag selector
- 지정된 모든 태그가 디자인을 적용 받아야 할 때
**문법**
```html
    태그명 {
        속성:값;
    }

    태그적용
    <태그명>
```

## multiple selector
- 적용대상을 `,`로 구분하여 여러 개 정의한 것

**문법**
```html
    #아이디명, #아이디명,,,{

    }

    .클래스명, .클래스명,,,{

    }

    태그명, 태그명,,,{

    }
```

## sub selector
- 특정태그의 하위 태그만 디자인을 적용 받아야 할 때

**문법**
```html
    태그명 > 태그명 {속성:값; ,,,}
    태그명 > 태그명 > 태그명 {속성:값; ,,,}

    <!-- 태그적용 -->
        <태그명>
            <태그명>
```

# behavior selector
- 사용자의 동작이 있을 때에만 디자인을 적용할 때

**문법**
```html
    태그명:hover {
        속성 : 값;,,,
    }

    <!-- 태그적용 -->
        <태그명>
```