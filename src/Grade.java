
import java.util.Scanner;
class Grade{
    void complete(int sub[],int n) {
        int len = sub.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + sub[i];
        }
        int tot=sum;
        System.out.println("Total marks:" + tot);

        float avg;
        avg = tot / n;
        System.out.println("Average percentage:" + avg);

        String grade="";
        if (avg == 100) {
            grade = "O";
        } else if (avg > 90) {
            grade = "A+";
        } else if (avg > 80) {
            grade = "A";
        } else if (avg > 70) {
            grade = "B";
        } else if (avg > 60) {
            grade = "C";
        } else if (avg > 50) {
            grade = "D";
        } else if (avg <= 50) {
            grade = "F";
        }
        System.out.println("Grade:" + grade);
    }
    int[] input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of subjects:");
        int num=sc.nextInt();
        String[] sub=new String[num];
        int marks[]=new int[num];
        for(int i=0;i<num;i++){
            System.out.println("Enter the subject "+(i+1)+" name:");
            sub[i]=sc.next();
        }
        for(int i=0;i<num;i++){
            System.out.println("Enter the "+sub[i]+" marks(integer):");
            marks[i]=sc.nextInt();
        }
        return marks;
    }
    public static void main(String[] args){
        Grade g=new Grade();
        int marks[]=g.input();
        int len=marks.length;
        System.out.println("-------Student Marks Card-------");
        g.complete(marks,len);
    }
}
