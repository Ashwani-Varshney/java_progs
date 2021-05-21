import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class StudentPoll {

    public static void main(String[] args) throws Exception {
        System.out.print("Number of Candidates: ");
        Scanner in = new Scanner(System.in);
        final int NUM = in.nextInt();
        if (NUM <= 0)
        {
            throw new Exception("Invalid Number of Candidates!");
        }
        Formatter file = new Formatter(new File("numbers.txt"));
        file.format("%d%n", NUM);
        System.out.printf("Start voting by pressing 1 to 5 rest will be considered invalid %n");
        int voter = 1;
        while(voter <= NUM)
        {
            System.out.printf("Voter %2d: ", voter);
            int vote = in.nextInt();
            file.format(" %d", vote);
            voter++;
        }
        in.close();
        file.format("%n");
        file.close();
        System.out.printf("%nTotal Votes Casted = %d%n", voter - 1);
    }
}
