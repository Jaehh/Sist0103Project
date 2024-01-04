/*
컴파일명령어 javac MyInfo.java
실행명령어  java MyInfo 영어영문 2

결과
----------------------
[학생 정보]
전공 : 영어영문학과
학년 : 2학년

*/



public class MyInfo{

    public static void main(String [] args){
/*
    System.out.println("[학생 정보]");
    System.out.println("전공 : "+args[0] +"학과");
    System.out.println("학년 : "+args[1] +"학년");

*/

     System.out.print("전공은 "+args[0]+"이며 학년은"+args[1]+"학년입니다");
   }
}



