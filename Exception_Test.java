// Made by Ashwani Varshney
import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exception_Test {
	static public void demo(int num) {
		Random r=null;
		int m;
		switch (num) {
		case 0: try {
					throw new ArithmeticException("Custom Exc 1 ");		// it will be caught by default handler
				}
				finally {
					// no catch-clause
				}
		case 1: r=new Random();
				m=r.nextInt(3);
				try {
					if(m==0)
						throw new ArrayIndexOutOfBoundsException("Custom Exc 2");
					if (m==1)
						throw new ArithmeticException("Custom Exc 3");
					if (m==2)
						throw new NullPointerException("Custom Exc 4");
				}catch(ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e){
					System.out.println("Caught " + e.getMessage());
				}
				break;		
		case 2: r=new Random();
				m=r.nextInt(5);
				try {
					if(m==0)
						throw new NullPointerException("Custom Exc 5");
					if (m==1)
						throw new ArithmeticException("Custom Exc 6");
					if (m==2)
						throw new ArrayIndexOutOfBoundsException("Custom Exc 7");
					if (m==3)
						throw new NumberFormatException("Custom Exc 8");
					if (m ==4)
						throw new UnsupportedOperationException("Custom Exc 9");
				} catch(Exception e) {
					System.out.println("Caught " + e.getMessage());
				}
				break;
		}
	}
	public static void main(String[] args) throws IOException {
		System.out.println("\nException Program\n");
		char ch='y';
		Random rnum=new Random();
		do {
			int x=rnum.nextInt(3);														// Generates Random no   0/1/2		
			Exception_Test2.demo(x);
			System.out.println("\nContinue Program? (y/n) ::");
			BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
			ch= (char) b.read();
		}while(ch=='y');
	}
}