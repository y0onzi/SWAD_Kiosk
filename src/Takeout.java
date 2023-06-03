import java.util.Scanner;

public class Takeout {
    public int checkTakeout() {
        Scanner sc = new Scanner(System.in);

        System.out.println("포장하신다면 0: \n 먹고가신다면 1: ");
        int takeout = sc.nextInt();
        return takeout;
    }


}
