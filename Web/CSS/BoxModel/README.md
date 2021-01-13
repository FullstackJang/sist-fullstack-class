# 여백
- 에이터를 보여주기 전에 생기는 간격
- `margin`,`padding`을 제공

## **margin**
- 기준선 밖 여백

**사용법**
```css
    /* 모든 여잭 설정할 때 */
    margin: 값px;  /*  왼쪽,오른쪽,위,아래 모두 여백생성 */

    /* 특정 여백 설정 */
    margin-top:값px; 
    margin-left:값px; 
    margin-right:값px; 
    margin-bottom:값px; 
    
```

## **padding**
- 기준선 내 여백

**사용법**
```css
    /* 모든 여잭 설정할 때 */
    padding: 값px;  /*  왼쪽,오른쪽,위,아래 모두 여백생성 */

    /* 특정 여백 설정 */
    padding-top:값px; 
    padding-left:값px; 
    padding-right:값px; 
    padding-bottom:값px; 
```

# 선

## 전체 선 설정
- 선 종류 4가지 제공
    - solid: 실선
    - dotted: 점선
    - dashed: 긴 점선
    - double: 이중선

```css
    border: 선의 두께 선종류 선색;
```

- 특정위치의 선 설정
```css
    border-top: 선의 두께 선종류 선색;
    border-left: 선의 두께 선종류 선색;
    border-right: 선의 두께 선종류 선색;
    border-bottom: 선의 두께 선종류 선색;
```

# scrollbar
- 지정된 크기보다 데이터의 양이 많을 때 스크롤바를 붙여 지정된 크기안으로 데이터를 넣을 때 사용
```css
 overflow: auto;
```

