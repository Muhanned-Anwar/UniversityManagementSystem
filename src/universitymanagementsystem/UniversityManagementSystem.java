package universitymanagementsystem;

import java.util.Scanner;

public class UniversityManagementSystem {

    static Scanner input;
    static int selected;

    // Admin authentication
    static String adminName = "m";
    static String adminPassword = "m";

    // Arrayes length 
    final static int length = 100;

    // Department information
    static int[] departmentIds = new int[length];
    static String[] departmentNames = new String[length];
    static int departmentIdsItemsNumber = 0;
    static int departmentNamesItemsNumber = 0;

    // Course information
    static int[] courseIds = new int[length];
    static String[] courseNames = new String[length];
    static String[] courseCode = new String[length];
    static double[] courseNumberHours = new double[length];
    static int courseIdsItemsNumber = 0;
    static int courseNamesItemsNumber = 0;
    static int courseCodeItemsNumber = 0;
    static int courseNumberHoursItemsNumber = 0;

    // Instructor information
    static int[] instructorIds = new int[length];
    static String[] instructorNames = new String[length];
    static String[] instructorPasswords = new String[length];
    static int[] instructorDepartmentIds = new int[length];
    static int instructorIdsItemsNumber = 0;
    static int instructorNamesItemsNumber = 0;
    static int instructorPasswordsItemsNumber = 0;
    static int instructorDepartmentIdsItemsNumber = 0;

    // Start app in this fnction
    public static void main(String[] args) {
        while (true) {
            if (mainFunction() == 4) {
                break;
            }
        }
    }

    // mainFunction will container all main app elements
    public static int mainFunction() {
        input = new Scanner(System.in);

        welcoming("User");
        do {
            selected = selection(textFirstSelection());
            switch (selected) {
                case 1: {
                    adminAuth();
                }
                case 2: {
                    instructor();
                }
                case 3: {
                    student();
                }
            }
            System.out.println("\n\n---------------------------------------------\n\n");
        } while (selected != 4);
        return selected;
    }

    // This function taken name and return message welcoming with email
    public static void welcoming(String name) {
        System.out.println("\n=========== Welcome " + name + " ===========\n");
    }

    // This function taken name and return message welcoming with email
    public static int selection(String text) {
        System.out.println(text);
        int s = input.nextInt();
        System.out.println("\n\n");
        return s;
    }

    // Returned first options to selection
    public static String textFirstSelection() {
        return "1. Admin.\n"
                + "2. Instructor.\n"
                + "3. Student.\n"
                + "4. Exit.\n"
                + "Please select your choice[1, 2 or 3]:";
    }

    // Check authientication
    public static void adminAuth() {
        welcoming("Admin");
        System.out.print("Enter username: ");
        String name = input.next();
        System.out.print("\nEnter password: ");
        String password = input.next();
        if (name.equalsIgnoreCase(adminName)
                && password.equalsIgnoreCase(adminPassword)) {
            admin();
        } else {
            System.out.println("\n  ^_^ Sorry, the data is incorrect ^_^  ");
            System.out.println("  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  ");
        }
    }

    // Show admin options
    public static void admin() {
        welcoming(adminName);
        int select = 0;
        do {
            select = selection(textSelectionAdmin());
            switch (select) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    assgin();
                    break;
                }
                case 3: {
                    show();
                    break;
                }
                case 4: {
                    update();
                    break;
                }
                case 5: {
                    delete();
                    break;
                }
                case 6: {
                    search();
                    break;
                }
            }
        } while (select != 7);

    }

    // Returned for show admin option
    public static String textSelectionAdmin() {
        return "\n"
                + "1. Add.\n"
                + "2. Assgin.\n"
                + "3. Show.\n"
                + "4. Update.\n"
                + "5. Delete.\n"
                + "6. Search.\n"
                + "7. Exit.\n"
                + "Please select your choice[1, 2, 3, 4, 5, 6 or 7]:";
    }

    // Show add options
    public static void add() {
        System.out.println("~~~~~~~~~~~~~~ Choose the thing you want to add to it ~~~~~~~~~~~~~~");
        int select = 0;
        do {
            select = selection(textSelectionAdminAdd());
            switch (select) {
                case 1: {
                    addDepartments();
                    break;
                }
                case 2: {
                    addCourse();
                    break;
                }
                case 3: {
                    addInstructor();
                    break;
                }
                case 4: {
                    addStudent();
                    break;
                }
            }
        } while (select != 5);

    }

    // Returned text for add 
    public static String textSelectionAdminAdd() {
        return "\n"
                + "1. Add Departments.\n"
                + "2. Add Course.\n"
                + "3. Add Instructor.\n"
                + "4. Add Student.\n"
                + "5. Exit.\n"
                + "Please select your choice[1, 2, 3, 4 or 5]:";
    }

    public static void addDepartments() {
        System.out.print("Enter Department ID: ");
        int id = input.nextInt();
        System.out.print("\nEnter Department Name: ");
        String name = input.next();
        departmentIds[departmentIdsItemsNumber] = id;
        departmentNames[departmentNamesItemsNumber] = name;
        departmentIdsItemsNumber++;
        departmentNamesItemsNumber++;
        successProcess();
    }

    public static void addCourse() {
        System.out.print("Enter Course ID: ");
        int id = input.nextInt();
        System.out.print("\nEnter Course Name: ");
        String name = input.next();
        System.out.print("\nEnter Course Code: ");
        String code = input.next();
        System.out.print("\nEnter Course Number of Hours: ");
        double numHours = input.nextDouble();
        courseIds[courseIdsItemsNumber] = id;
        courseNames[courseNamesItemsNumber] = name;
        courseCode[courseCodeItemsNumber] = code;
        courseNumberHours[courseNumberHoursItemsNumber] = numHours;
        courseIdsItemsNumber++;
        courseNamesItemsNumber++;
        courseCodeItemsNumber++;
        courseNumberHoursItemsNumber++;
        successProcess();
    }

    public static void addInstructor() {
        System.out.print("Enter Instructor ID: ");
        int id = input.nextInt();
        System.out.print("\nEnter Instructor Name: ");
        String name = input.next();
        System.out.print("\nEnter Instructor Password: ");
        String password = input.next();
        int departmentId = 0;
        while (true) {
            if (departmentIdsItemsNumber != 0) {
                while (true) {
                    System.out.println("\nSelect Department: ");
                    showDepartments();
                    departmentId = input.nextInt();
                    if (checkDepartmentIdExist(departmentId)) {
                        instructorIds[instructorIdsItemsNumber] = id;
                        break;
                    } else {
                        System.out.println("Error, Enter Department Id corrected!");
                    }
                }
                break;
            } else {
                addDepartments();
            }
        }
        instructorNames[instructorNamesItemsNumber] = name;
        instructorPasswords[instructorPasswordsItemsNumber] = password;
        instructorDepartmentIds[instructorDepartmentIdsItemsNumber] = departmentId;
        instructorIdsItemsNumber++;
        instructorNamesItemsNumber++;
        instructorPasswordsItemsNumber++;
        instructorDepartmentIdsItemsNumber++;
        successProcess();
    }

    public static void showDepartments() {
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            System.out.println(i + "-" + departmentNames[i] + ".");
        }
    }

    public static boolean checkDepartmentIdExist(int departmentId) {
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            if (i == departmentId) {
                return true;
            }
        }
        return false;
    }

    public static void addStudent() {

    }

    public static void assgin() {

    }

    public static void show() {

    }

    public static void update() {

    }

    public static void delete() {

    }

    public static void search() {

    }

    public static void instructor() {

    }

    public static void student() {

    }

    public static void successProcess() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^     Success Process     ^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

}
