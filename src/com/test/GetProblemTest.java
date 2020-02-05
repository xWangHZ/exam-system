package com.test;

import com.file.ObtainProblem;

public class GetProblemTest {
    private String problems;//问题
    private String[] options;//选项


    public GetProblemTest(){
        ObtainProblem test = new ObtainProblem(1);
        options = new String[4];

        problems = test.getProblems();
        options  = test.getOptions();
        System.out.println(problems);
        for(int i = 0;i<4;i++){
            System.out.println(options[i]);
        }
    }

    public static void main(String[] args) {
       new GetProblemTest();
    }
}
