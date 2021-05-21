import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
 
class SwingGUI implements ActionListener
{
 
    private static JTextField text;
    String response = "";
    static int freq[] = new int[11];
    static int responses[] = new int[100];
    static int choice = 0;
    static int POLL_COUNT = 0;
 
    SwingGUI()
    {
        for(int i=0;i<11;i++)
        freq[i]=0;
 
        for(int i=0;i<100;i++)
          responses[i]=0;
 
        JPanel p = new JPanel();
        JFrame j = new JFrame();
        j.setSize(1920,900);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(p);
        p.setLayout(null);
 
        JLabel j1 = new JLabel("WELCOME TO STUDENT'S POLL RESPONSE PORTAL.",SwingConstants.CENTER);
        j1.setBounds(10,20,1500,50);
        j1.setFont(new Font("Sans Serif", Font.BOLD, 35));
        j1.setForeground(Color.RED);
 
        JLabel j2 = new JLabel("Kindly enter the poll responses in the below INPUT FIELD.",SwingConstants.CENTER);
        j2.setFont(new Font("Sans Serif", Font.BOLD, 13));
        j2.setBounds(10,60,1500,50);
        JLabel label;
 
        p.add(label = new JLabel());
        label.setForeground(Color.red);
        label.setBounds(930,340,700,50);
 
        text = new JTextField();
        text.setBounds(800,350,100,30);
        text.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent ke)
            {
                char now = ke.getKeyChar();
                if (now >= '0' && now <= '9')
                {
                    text.setEditable(true);
                    label.setText("");
                    response += now;
                }
                else
                {
                    text.setEditable(false);
                    label.setText(" Enter only numeric digits greater than 0 ");
                }
            }
        });
 
        JButton button = new JButton("SUBMIT");
        button.setBounds(440,400,190,40);
        button.setBackground(Color.GREEN);
        button.addActionListener(this);
 
        JButton stop = new JButton("STOP");
        stop.setBackground(Color.RED);
        stop.setForeground(Color.WHITE);
        stop.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                text.setEditable(false);
                choice = 1;
                response = "";
            }
        });
        stop.setBounds(640,400,190,40);
 
        JButton reset = new JButton("CLEAR");
        reset.setForeground(Color.BLUE);
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                text.setText("");
            }
        });
        reset.setBounds(840,400,190,40);
 
        JButton exit_GUI = new JButton("EXIT");
        exit_GUI.setForeground(Color.RED);
        exit_GUI.setFont(new Font("Arial", Font.BOLD, 25));
        exit_GUI.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                j.dispatchEvent(new WindowEvent(j, WindowEvent.WINDOW_CLOSING));
            }
        });
        exit_GUI.setBounds(660,600,190,40);
 
        p.add(j1);
        p.add(j2);
        p.add(text);
        p.add(button);
        p.add(stop);
        p.add(reset);
        p.add(exit_GUI);
        j.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e)
    {

        text.setText("");
        if(response=="" || response==" " || response=="    ")
            return;
        int num = Integer.parseInt(response);
        if(num<=0)
            return;
        responses[POLL_COUNT] = num;
        POLL_COUNT++;
        response = "";
    }
    static void saveToFile() throws Exception
    {
        System.out.println("THE POLL: ");
        for(int i=0;i<POLL_COUNT;i++)
        System.out.println(responses[i]);
 
        Formatter formatter = new Formatter(new File("numbers.txt"));
        for(int i=0;i<POLL_COUNT;i++)
        {
            formatter.format("%d  ",responses[i]);
            System.out.println(formatter);
        }
        formatter.close();
        System.out.println("DONE");
    }
    public static void main(String[] args) throws Exception
    {
 
        System.setProperty("java.awt.headless", "false");
        Toolkit tk = Toolkit.getDefaultToolkit();
        GraphicsEnvironment ge =
        GraphicsEnvironment.getLocalGraphicsEnvironment();
 
        new SwingGUI();
        while(true)
        {
            System.out.print("");
            if(choice==1)
            break;
        }
        System.out.println("Hello!");
        saveToFile();
    }
}
 