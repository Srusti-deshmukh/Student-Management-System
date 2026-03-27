import java.util.Scanner;

class Student {
    int id;
    String name;
    float marks;
}

public class StudentManagementSystem {

    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Student s = new Student();
                    System.out.print("Enter ID: ");
                    s.id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    s.name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    s.marks = sc.nextFloat();

                    students[count++] = s;
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No records found.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println(students[i].id + " " +
                                    students[i].name + " " +
                                    students[i].marks);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == id) {
                            System.out.println("Found: " +
                                    students[i].name + " " +
                                    students[i].marks);
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == id) {
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            students[i].name = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            students[i].marks = sc.nextFloat();
                            System.out.println("Record updated!");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == id) {
                            for (int j = i; j < count - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            count--;
                            System.out.println("Record deleted!");
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}