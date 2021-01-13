# 디자인

## float
- 대상을 왼쪽이나 오른쪽으로 구분하여 보낼 때 사용
```css
    clear:both를 사용하여 윗줄에 적용된 디자인 설정을 초기화 시켜야한다.

    float:left;
    float:right;
```

## position
- 좌표를 설정하여 원하는 위치에 보내기
```css
    position:형식;

    형식의 종류는 relative, absolute, fixed
    left: x좌표
    top: y좌표

    absolute - 브라우저의 좌상단에서 좌표가 시작된다. 브라우저의 스크롤바가 이동하더라도 설정한 좌표는 변하지 않는다.

    fixed - 브라우저의 좌상단에서 좌표가 시작된다. 브라우저의 스크롤바가 이동하면 설정된 좌표를 변경한다.

    relative - absolute의 시작 좌표를 변경할 때 사용

```

# 그림자 설정
- 문자그림자
    ```css
        text-shadow: x좌표 y좌표 번짐값 색;
    ```
- 박스그림자
    ```css
        box-shadow: x좌표 y좌표 번짐값 색;
    ```

- 둥근테두리만들기
    ```css
        border-radius:값; 모든 모서리가 깍인다.
        border-radius: 값 값 값 값;

        border-radius: 10px;
    ```