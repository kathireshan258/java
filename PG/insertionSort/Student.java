package PG.insertionSort;

import java.io.*;
class Student
{
    String name, rollNo,dept;
    void getDetails() throws IOException
    {
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Name: ");
        name=ob.readLine();
        System.out.print("Enter Roll Number: ");
        rollNo =ob.readLine();
        System.out.print("Enter Department: ");
        dept=ob.readLine();
    }
    void displayDetails()
    {
        System.out.print("\n"+name+"\t"+ rollNo +"\t"+dept);
    }
    public static void main(String arg[]) throws IOException
    {
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Number of Students ");
        int n=Integer.parseInt(ob.readLine());
        Student stu[]=new Student[n];
        int i,j;
        System.out.println("Enter Student details:");
        for(i=0;i<n;i++)
        {
            stu[i]=new Student();
            stu[i].getDetails();
        }
        System.out.println("Name \t Roll No \t Department:");
        for(i=0;i<n;i++)
        {
            stu[i].displayDetails();
        }
//Insertion Sorting...
        Student t;
        for(i=0;i<n;i++)
        {
            t=stu[i];
            for(j = i; j > 0 && t.name.compareTo(stu[j-1].name)<0; j--)
            {
                stu[j]=stu[j-1];
            }
            stu[j]=t;
        }
        System.out.println("\n Student details after Sorting");
        System.out.println("Name \t Roll No \t Department");
        for(i=0;i<n;i++)
        {
            stu[i].displayDetails();
        }
    }
}
