package Myassignment;

import java.util.Random;

class student_records
    {
        int ID;
        int test[] = new int[5];
        int mainExam;

    
        void set_Credentials_ID(int x)
            {
                ID = (19045+x) ;
            }
        //------------------------
        void set_Credentials_TESTS()
            {
                int rn=0;   //to store the random number generated in each iteration
                Random r=new Random(); //generating the numbers to be sorted randomly

                for(int i=0;i<5;i++)
                    {
                        rn=r.nextInt(26);
                        test[i]=rn;
                    }
            }
    
        void set_Credentials_MAINEXAM()
            {
                int rn=0;
                Random r = new Random();

                rn=r.nextInt(101);
                mainExam=rn;
            }

        int get_ID()
            {
                return ID;
            }
        int get_test(int n)
            {
                return test[n-1];   //5th test is test[4];
            }
        int get_mainExam()
            {
                return mainExam;
            }
        void display_credentials()
            {
                System.out.print("  "+ID+"    ");
                for(int i=0;i<5;i++)
                    {
                        if(test[i]<10)
                        System.out.print("0"+test[i]+"       ");
                        else
                        System.out.print(test[i]+"       ");
                    }
                System.out.println(mainExam);
                System.out.println("----------------------------------------------------------------");
            }

    }

class student_data_analysis
    {
        void display_information(student_records s[], int student_count)
            {
                System.out.println("   ID    TEST1    TEST2    TEST3    TEST4    TEST5    MAIN_EXAM  ");
                for(int i=0;i<student_count;i++)
                    {
                        s[i].display_credentials();
                    }
            }
    
        void calculate_max_marks(student_records s[], int student_count)
            {
                int max_test[]=new int[5];
                for(int i=0;i<5;i++)
                    {
                        max_test[i]=0;
                    }
                int max_main=0;

                for(int i=0;i<5;i++)
                    {
                        for(int j=0;j<student_count;j++)
                            {
                                int x=s[j].get_test(i+1);
                                if(x>max_test[i])
                                    {
                                        max_test[i]=x;
                                    }
                                if(i==0)
                                    {   int y=s[j].get_mainExam();
                                        if(y>max_main)
                                            {
                                                max_main=y;
                                            }
                                    }
                             }
                    }
                System.out.println("-------------------------------");
                System.out.println("MAXIMUM MARKS IN MAIN EXAM:   "+max_main);
                for(int i=0;i<5;i++)
                    {
                        System.out.println("MAXIMUM MARKS IN TEST "+(i+1)+":   "+max_test[i]);
                    }
                System.out.println("-------------------------------");
            }

        void calculate_min_marks(student_records s[], int student_count)
            {
                int min_test[]=new int[5];
                for(int i=0;i<5;i++)
                    {
                        min_test[i]=25;
                    }
                int min_main=100;

                for(int i=0;i<5;i++)
                    {
                        for(int j=0;j<student_count;j++)
                            {
                                int x=s[j].get_test(i+1);
                                if(x<min_test[i] && x!=0)
                                    {
                                        min_test[i]=x;
                                    }
                                if(i==0)
                                    {   int y=s[j].get_mainExam();
                                        if(y<min_main && y!=0)
                                            {
                                                min_main=y;
                                            }
                                    }
                             }
                    }
                System.out.println("-------------------------------");
                System.out.println("MINIMUM MARKS IN MAIN EXAM:   "+min_main);
                for(int i=0;i<5;i++)
                    {
                        System.out.println("MINIMUM MARKS IN TEST "+(i+1)+":   "+min_test[i]);
                    }
                System.out.println("-------------------------------");
            }

        void calculate_avg_marks(student_records s[], int student_count)
            {
                int avg_test[]=new int[5];
                for(int i=0;i<5;i++)
                    {
                        avg_test[i]=0;
                    }
                int avg_main=0;

                for(int i=0;i<5;i++)
                    {
                        for(int j=0;j<student_count;j++)
                            {
                                int x=s[j].get_test(i+1);
                                avg_test[i]+=x;
                                if(i==0)
                                    {   
                                        int y=s[j].get_mainExam();
                                        avg_main+=y;
                                    }
                             }
                    }
                System.out.println("-------------------------------");
                System.out.println("AVERAGE MARKS IN MAIN EXAM (rounded off to the greatest integer):   "+(avg_main/5));
                for(int i=0;i<5;i++)
                    {
                        System.out.println("AVERAGE MARKS IN TEST "+(i+1)+" (rounded off to the greatest integer):   "+(avg_test[i]/5));
                    }
                System.out.println("-------------------------------");
            }

        void heapSort(student_records s[], int student_count)
            {
                int main_Exam[]=new int[student_count];
                int student_ID[]=new int[student_count];
                HeapSort hs = new HeapSort();
        
                for(int i=0;i<student_count;i++)
                    {
                        main_Exam[i]=s[i].get_mainExam();
                        student_ID[i]=s[i].get_ID();
                    }
                System.out.print("The original list of Main Exam marks (UNSORTED) : ");
                for(int i=0;i<student_count;i++)
                System.out.print(main_Exam[i]+"   ");
                System.out.println("");
                System.out.println("-----------------------------");
                hs.heapSort(main_Exam);
                System.out.print("The new list of Main Exam marks (SORTED) : ");
                for(int i=0;i<student_count;i++)
                System.out.print(main_Exam[i]+"   ");
                System.out.println("");
                System.out.println("-----------------------------");
        
                System.out.print("The original list of student IDs (UNSORTED) : ");
                for(int i=0;i<student_count;i++)
                System.out.print(student_ID[i]+"   ");
                System.out.println("");
                System.out.println("-----------------------------");
                hs.heapSort(student_ID);
                System.out.print("The new list of student IDs (SORTED) : ");
                for(int i=0;i<student_count;i++)
                System.out.print(student_ID[i]+"   ");
                System.out.println("");
                System.out.println("-----------------------------");
        
            } 
        

    }

class final_class
    {
        public static void main(String args[])
            {
                int student_count=5; //assumption

                student_records[] s = new student_records[student_count];
                for(int i=0;i<student_count;i++)
                    {
                        s[i]=new student_records();
                    }
                student_data_analysis S = new student_data_analysis();

                for(int i=0;i<student_count;i++)
                    {
                        s[i].set_Credentials_ID(i);
                        s[i].set_Credentials_TESTS();
                        s[i].set_Credentials_MAINEXAM();
                    }
                                
                S.display_information(s,student_count);
                S.calculate_max_marks(s,student_count);
                S.calculate_min_marks(s,student_count);
                S.calculate_avg_marks(s,student_count);
                S.heapSort(s,student_count);
                
            }
    }