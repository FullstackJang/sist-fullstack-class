package day1117;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Work1117 {


    public List<String> methodA() {

        List<String> list = new ArrayList<String>();

        list.add("Java-James Gosling:1995");
        list.add("Oracle-Larry Ellison");
        list.add("Python-Guido van Rossum:1991");
        list.add("HTML-Tim Berners, LEE:1995");
        list.add("JavaScript-Brandan Eich");

        return list;
    }//methodA

    public void methodB(List<String> list) {

        String[] listarr = new String[list.size()];
        String[] listarr1 = new String[list.size()];

        list.toArray(listarr);
        System.out.printf("?•­ëª?\t?•µ?‹¬ê°œë°œ?\tê°œë°œ?…„?„\n");
        for(int i = 0; i < list.size(); i++) {
            listarr1[i] = listarr[i].replace("-","\t").replace(":","\t");
        }

        for(int i = 0; i < list.size(); i++){

            if(i == 1){
                System.out.print(listarr1[i].concat("\t?•Œ?ˆ˜?—†?Œ\n"));
            }
            else if(i == 4) {
                System.out.print(listarr1[i].concat("?•Œ?ˆ˜?—†?Œ\n"));
            }
            else
            System.out.println(listarr1[i]);
        }

    }//methodB

    public static void main(String[] args) {

        Work1117 wk = new Work1117();

        List<String> list = new ArrayList<String>();

        list = wk.methodA();

        wk.methodB(list);

    }
}
