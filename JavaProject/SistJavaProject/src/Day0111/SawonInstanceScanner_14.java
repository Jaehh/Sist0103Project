import java.util.Scanner;

class Emp {
    // 이하 코드 생략

    public static void showTitle() {
        System.out.println("*** 쌍용 01월 직원 급여현황 ***");
        System.out.println();
        System.out.println("사원명\t기본급\t자녀수\t초과근무시간\t가족수당\t시간수당\t총급여");
        System.out.println("===================================================================");
    }
}

public class SawonInstanceScanner_14 {

    public static void writeEmp(Emp[] emp) {
        Emp.showTitle();
        for (Emp e : emp) {
            System.out.println(e.getsName() + "\t" + e.getgPay() + "\t" + e.getfSu() +
                    "\t\t" + e.gettSu() + "\t" + e.getFamilySudang() +
                    "\t" + e.getTimeSudang() + "\t" + e.getTotalPay());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inwon;
        Emp[] emp;

        System.out.println("입력할 직원수는?");
        inwon = Integer.parseInt(sc.nextLine());

        // 배열 할당 및 초기화
        emp = new Emp[inwon];

        // 인원수만큼 데이터를 입력
        for (int i = 0; i < inwon; i++) {
            emp[i] = new Emp();

            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("기본급?");
            int pay = Integer.parseInt(sc.nextLine());
            System.out.println("자녀수 입력");
            int fs = Integer.parseInt(sc.nextLine());
            System.out.println("초과근무시간");
            int ts = Integer.parseInt(sc.nextLine());

            emp[i] = new Emp(name, pay, fs, ts);

            System.out.println();
        }

        // 출력
        writeEmp(emp);
    }
}
