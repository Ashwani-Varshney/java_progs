import java.util.*; 
import java.util.Collections;
import java.util.Formatter;
import java.lang.Math;
import Heap_Sort.*;

class Student2Ques4
{ 
    public int studentid=19000 , id=0; 
    public static int min=0 , max=0;
    public int test1=0 ,test2=0 ,test3=0 ,test4=0 ,test5=0 ,maintest=0;
  
    Random rand = new Random(); 
    
    public void dataentry(int j)
	{
	   id = studentid + j;
	   test1 = (int)(rand.nextInt(21));	//Max. marks =20
	   test2 = (int)(rand.nextInt(21));
	   test3 = (int)(rand.nextInt(21));
	   test4 = (int)(rand.nextInt(21));
	   test5 = (int)(rand.nextInt(21));
	   maintest = (int)(rand.nextInt(76));	  //Max. marks=75
	}

    public static void marks_out_of_100(Student[] ar)
	{
	  int norm_marks=0;
	  int marks_100=0;
	  String grade=" ";
	  System.out.format("%6s%36s%22s%11s","ID","Normalized Test Marks out of 25","Marks out of 100","Grade");
	  System.out.println();
	  for(int i=0;i<ar.length;i++)
	     {
		norm_marks=(ar[i].test1 + ar[i].test2 + ar[i].test3 + ar[i].test4 +ar[i].test5)/4;
		marks_100=norm_marks + ar[i].maintest;
		if(marks_100>=90)
		    grade="A";
		else if(marks_100>=80)
		    grade="B";
		else if(marks_100>=70)
		    grade="C";
		else if(marks_100>=60)
		    grade="D";
		else
		    grade="F";
		System.out.format("%8d%22d%25d%18s",ar[i].id,norm_marks,marks_100,grade);
		System.out.println();
	    }
		
	}

    public static void printdata(Student[] stud_arr)
	{  
	  System.out.println();
	  System.out.format("%14s%12s%11s%10s%9s%10s%12s","ID","Test1","Test2","Test3","Test4","Test5","Main Test");
	  System.out.println();
	  for(int i=0; i<stud_arr.length; i++)
		{	
		System.out.format("%1s%1s%1d%10d%10d%10d%10d%10d%10d","Student "," : ",stud_arr[i].id, stud_arr[i].test1, stud_arr[i].test2, stud_arr[i].test3, stud_arr[i].test4, stud_arr[i].test5 ,stud_arr[i].maintest); 
		System.out.println();
		}	
	}

    public static void main (String[] args) 
    {   
	int mini=0 , maxi=0 , sum=0 , count=0;
        Student[] arr = new Student[20]; 

	ArrayList<Integer>  al = new ArrayList<Integer>();
	for(int i=0;i<100;i++)
	     al.add(i);
	Collections.shuffle(al);

/************************ To print Student Data ************************************/


  	for(int i=0 ; i<arr.length;i++)
	    {
		int a = al.get(i);
		arr[i]=new Student();
		arr[i].dataentry(a);
	    }	 

	printdata(arr);
	System.out.println();
/***********************To print marks out of 100 and grade***************************/	
	marks_out_of_100(arr);
    } 
}      