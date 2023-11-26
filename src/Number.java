
import java.util.Scanner;
import java.util.Random;
class Guess{
    void guess(int rand)
    {
        int attempt = 0;
        Scanner sc=new Scanner(System.in);
        System.out.println("----------MAX ATTEMPTS 10----------");
        for (int i=0;i<10;i++){
            attempt++;
            System.out.println("Guess the number(integer):");
            int x=sc.nextInt();
            if (x==rand)
            {
                System.out.println("Guessed number is correct " + rand);
                break;
            }
            else if(x<rand)
            {
                System.out.println("Number guessed is too low!!!!");
            }
            else if(x>rand) {
                System.out.println("Number guessed is too high!!!!");
            }
        }
        if(attempt==9){
            System.out.println("Maximum attempt reached.");
        }
        else if(attempt<9){
            System.out.println("Attempted " + attempt +" times.");
        }
        sc.close();
    }
    public static void main(String[] args){
        Random ran=new Random();
        int rand=ran.nextInt(100);
        Guess g = new Guess();
        g.guess(rand);
    }
}