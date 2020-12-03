package day1203;

import java.io.Serializable;

/**
 * 개인정보
 */
public class MyData implements Serializable {

    /**
     *  이 아이디는 2021년 12월 4일 00:00:00에 다른 값으로 변경
     */
    private static final long serialVersionUID = 1170817135076325435L;
    
    private transient String name; //직렬화 방지
    private int age;
    private double height;
    private transient double weight;

    public MyData() {

    }//MyData

    public MyData(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }//MyData


    public String getName() {
        return name;
    }//getName

    public int getAge() {
        return age;
    }//getAge

    public double getHeight() {
        return height;
    }//getHeight

    public double getWeight() {
        return weight;
    }//getWeight

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }//toString
}//class
