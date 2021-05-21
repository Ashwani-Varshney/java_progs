import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
 
class SecondGUI{
 
    static int responses[] = new int[100];
    static int POLL_COUNT = 0;
    static int freq[] = new int[11];
    static int data[][] = new int[11][2];
    String sdata[][] = new String[11][2];
 
    SecondGUI()
    {
        for(int i=0;i<11;i++)
        freq[i]=0;
 
        for(int i=0;i<POLL_COUNT;i++)
        {
            if(responses[i]>10)
                freq[10]++;
            else
                freq[responses[i]-1]++;
        }
        for(int i=0;i<11;i++)
        {
            data[i][0] = (i+1);
            data[i][1] = freq[i];
        }
        for(int i=0;i<11;i++)
        {
            sdata[i][0] = Integer.toString(data[i][0]);
            sdata[i][1] = Integer.toString(data[i][1]);
        }
 
        JPanel p = new JPanel();
        JFrame j = new JFrame();
        j.setSize(800,600);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(p);
        p.setLayout(null);
 
        JLabel j1 = new JLabel("STUDENT'S POLL OUTPUT GENERATOR!",SwingConstants.CENTER);
        j1.setBounds(0,20,750,50);
        j1.setFont(new Font("Arial", Font.BOLD, 30));
        j1.setForeground(Color.BLUE);
 
        String values ="The POLL RESPONSES received are as follows:  ";
        for(int i=0;i<POLL_COUNT;i++)
        values = values+responses[i]+"   ";
        JLabel text = new JLabel(values);
        text.setBounds(20,220,1000,50);
        text.setVisible(false);
 
        JButton showValues = new JButton("Show Poll Values");
        showValues.setForeground(Color.BLUE);
        showValues.addActionListener(new ActionListener()
        {
 
            public void actionPerformed(ActionEvent e)
            {
                text.setVisible(true);
            }
        });
        showValues.setBounds(10,500,190,40);
 
        String[] heads = {"RESPONSE COUNT" , "FREQUENCY"};
        JTable table = new JTable(sdata,heads);
        table.setBounds(280,300,150,180);
        table.setFont(new Font("Arial", Font.BOLD, 10));
 
        table.setVisible(false);
 
        JLabel c1 = new JLabel("RESPONSE VALUE");
        JLabel c2 = new JLabel("RESPONSE FREQUENCY");
        c1.setBounds(240,250,150,80);
        c2.setBounds(375,250,150,80);
        c1.setFont(new Font("Sans Serif", Font.BOLD, 10));
        c1.setForeground(Color.BLUE);
        c2.setFont(new Font("Sans Serif", Font.BOLD, 10));
        c2.setForeground(Color.BLUE);
        c1.setVisible(false);
        c2.setVisible(false);
 
        JButton showResult = new JButton("Display the Results");
        showResult.setForeground(Color.WHITE);
        showResult.setBackground(Color.BLUE);
        showResult.addActionListener(new ActionListener()  {
 
        public void actionPerformed(ActionEvent e){
                table.setVisible(true);
                c1.setVisible(true);
                c2.setVisible(true);
 
 
          }
        });
        showResult.setBounds(200,500,190,40);
 
        JButton exit_GUI = new JButton("EXIT");
        exit_GUI.setForeground(Color.WHITE);
        exit_GUI.setBackground(Color.RED);
        exit_GUI.setFont(new Font("Arial", Font.BOLD, 25));
        exit_GUI.addActionListener(new ActionListener()  {
 
        public void actionPerformed(ActionEvent e){
            j.dispatchEvent(new WindowEvent(j, WindowEvent.WINDOW_CLOSING));
        }
        });
        exit_GUI.setBounds(580,500,190,40);
 
        p.add(j1);
        p.add(c1);
        p.add(c2);
        p.add(showValues);
        p.add(text);
        p.add(showResult);
        p.add(exit_GUI);
        p.add(table);
        j.setVisible(true);
    }
 
 
    public static void main(String[] args) throws IOException{
        for(int i=0;i<100;i++)
              responses[i]=0;
 
        Scanner input = null;
        try {
            input = new Scanner(new File("numbers.txt"));
        } catch (Exception ex) {
            System.out.println("Can not open file.");
            System.exit(0);
        }
 
 
        while(input.hasNextInt()) {
            int number = input.nextInt();
            responses[POLL_COUNT++] = number;
        }
 
        System.out.println("The numbers read from the file are: ");
        for(int i=0;i<POLL_COUNT;i++)
        System.out.println(responses[i]);
 
 
 
        new SecondGUI();
 
        Formatter h = new Formatter();
        FileWriter out = new FileWriter("D:\\MSc-CS 2nd Sem\\JAVA\\final\\output.txt",true);
        Formatter r;
        h.format("%s%10s%n", "Rating", "Frequency");
        out.write(h.toString());
 
        for (int rating = 0; rating < freq.length; rating++) {
            System.out.printf("%6d%10d%n", (rating+1), freq[rating]);
            r = new Formatter();
            r.format("%6d%10d%n", (rating+1), freq[rating]);
            out.write(r.toString());
         }
 
         out.close();
         h.close();
 
 
    }
}
 