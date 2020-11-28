package day1118;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * GridLayout: 격자 레이아웃
 * 모든 행, 모든 열의 컴포넌트 크기가 동일하게 설정되는 레이아웃
 * @author owner
 *
 */

@SuppressWarnings("serial")
//1. 윈도우 컴포넌트를 상속
public class TestGridLayout extends JFrame {

    //2. 생성자를 생성
    public TestGridLayout() {
        super("GridLayout 연습");

        setLayout(new GridBagLayout());
        
        //모든 데이터형은 배열을 만들 수 있다. 리스트로 만들수도있다.      
        //1. 리스트로 만드는 법
        List<JButton> list = new ArrayList<JButton>();
        for(int i = 1; i < 10; i++) {
        	list.add(new JButton(String.valueOf(i)));
        }
        //1-1. 배열로 만드는 법
        JButton [] arr = new JButton[9];
        for(int i = 0; i < arr.length; i++) {
        	//모든 방의 값이 null이므로 사용할 수 없어서 객체를 생성한다.
        	arr[i] = new JButton(String.valueOf(i)); //기본형 데이터형 값을 문자열로 바꿀 때에는 String클래스에valueOf를 사용하자 
//        	arr[i] = new JButton(Integer.valueOf(i+1).toString());
        }
        //3. 컴포넌트 생성
        JButton jbtn1 = new JButton("1");
        JButton jbtn2 = new JButton("2");
        JButton jbtn3 = new JButton("3");
        JButton jbtn4 = new JButton("4");
        JButton jbtn5 = new JButton("5");
        JButton jbtn6 = new JButton("6");
        JButton jbtn7 = new JButton("7");
        JButton jbtn8 = new JButton("8");
        JButton jbtn9 = new JButton("9");
        //4. 배치관리자 설정: BorderLayout => GridLayout
        setLayout(new GridLayout(3,3));

        //5. 컴포넌트 배치
        
        //5-1. 리스트
        for(int i = 0; i < list.size(); i++) {
        	add(list.get(i));
        }
        
        //5-2. 배열로 사용
        for(int i = 0; i < arr.length; i++) {
        	//JButton 배열의 각방에 생성된 JButton을 배치한다.
        	add(arr[i]);
        }
//        add(jbtn1);
//        add(jbtn2);
//        add(jbtn3);
//        add(jbtn4);
//        add(jbtn5);
//        add(jbtn6);
//        add(jbtn7);
//        add(jbtn8);
//        add(jbtn9);
        //6. 윈도우 컴포넌트의 크기 설정
        setSize(400,400);

        //7. 윈도우 컴포넌트를 사용자에게 보여주기
        setVisible(true);

        //8. 윈도우 컴포넌트의 종료이벤트 처리
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//TestGridLayout

    public static void main(String[] args) {
        new TestGridLayout();
    }
}
