import java.util.HashMap;
import java.util.Scanner;

class Student{
   public String name ;
   public int rollNo;
   public int age;
   public int marks;


   //constructors are the methods those have same name as class, and they do not have return type
    public Student(String name, int rollNo, int age, int marks){
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }

    public void viewStudent(){
        System.out.println("Name : " + name);
        System.out.println("Roll No. : " + rollNo);
        System.out.println("Age : " + age);
        System.out.println("Marks : " + marks);
    }
}


public class StudentDataBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Student> database = new HashMap<>();

        while(true){

            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Roll No. : ");
                    int rollNo = sc.nextInt();

                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Student Marks: ");
                    int marks = sc.nextInt();

                    Student std = new Student(name, rollNo, age, marks);

                    //store the values in Hashmap by key(rollNo) and value(std object)
                    //so that multiple student can be stored by hashmap
                    database.put(rollNo, std);
                    System.out.println("Successfully added!!");
                    break;


                case 2:
                    System.out.println("List of Students: ");
                    for(Student i:database.values()) {
                        i.viewStudent();
                    }
                    break;


                case 3:
                    System.out.println("Enter you Roll no. : ");
                    int roll = sc.nextInt();
                    Student data = database.get(roll);
                    if(data != null){
                        data.viewStudent();
                    }else{
                        System.out.println("Student not found.");
                    }
                    System.out.println("**************************");
                    break;


                case 4:
                    int totalStudents = database.size();
                    int totalMarks = 0;
                    for(Student j:database.values()){
                        totalMarks = totalMarks + j.marks;
                    }
                    double average= (double) totalMarks/totalStudents;
                    System.out.println("Average Marks: " + average);
                    break;


                case 5:
                    //terminate the loop
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
