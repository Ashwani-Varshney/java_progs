import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class StudentPoll2 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("numbers.txt"));
        if (!in.hasNext())
        {
            throw new Exception("Invalid Polling Data!");
        }
        final int NUM = in.nextInt();
        if (NUM <= 0)
        {
            throw new Exception("Invalid Candidate Count!");
        }
        Formatter file = new Formatter(new File("output.txt"));
        file.format("Number of Candidates = %d%n%n", NUM);
        final int[] frequency = new int[NUM];
        while (in.hasNext())
        {
            int vote = in.nextInt() - 1;
            try 
            {
                frequency[vote]++;
            } 
            catch (ArrayIndexOutOfBoundsException e) 
            {
       			System.err.printf("%n Invalid Candidate %n%n", vote + 1, NUM);
            }
        }
        in.close();
        file.format("%s%10s%n", "Rating", "Frequency");
        for (int rating = 0; rating < frequency.length; rating++)
        {
            file.format("%6d%10d%n", rating + 1, frequency[rating]);
        }
        System.out.printf("Poll has been written to output file. %n Check the output file for result of ratings. %n ");
        file.close();
    }

}
