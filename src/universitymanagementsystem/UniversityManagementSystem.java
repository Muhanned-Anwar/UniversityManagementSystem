package universitymanagementsystem;

import java.util.Random;
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
    static String[] courseCodes = new String[length];
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
    static String[] instructorAddresses = new String[length];
    static double[] instructorAges = new double[length];
    static String[] instructorPhones = new String[length];
    static int instructorIdsItemsNumber = 0;
    static int instructorNamesItemsNumber = 0;
    static int instructorPasswordsItemsNumber = 0;
    static int instructorDepartmentIdsItemsNumber = 0;
    static int instructorAddressesItemsNumber = 0;
    static int instructorAgesItemsNumber = 0;
    static int instructorPhonesItemsNumber = 0;

    // Link instructor with courses
    static int[] instructorCourseIds = new int[length];
    static int instructorCourseIdsItemsNumber = 0;
    static int[] courseInstructorIds = new int[length];
    static int courseInstructorIdsItemsNumber = 0;

    // Link student with courses
    static int[] studentCourseIds = new int[length];
    static int studentCourseIdsItemsNumber = 0;
    static int[] courseStudentIds = new int[length];
    static int courseStudentIdsItemsNumber = 0;
    static double[] grades = new double[length];

    // Student information
    static int[] studentIds = new int[length];
    static String[] studentNames = new String[length];
    static String[] studentPasswords = new String[length];
    static int[] studentDepartmentIds = new int[length];
    static String[] studentAddresses = new String[length];
    static double[] studentAges = new double[length];
    static String[] studentPhones = new String[length];
    static int studentIdsItemsNumber = 0;
    static int studentNamesItemsNumber = 0;
    static int studentPasswordsItemsNumber = 0;
    static int studentDepartmentIdsItemsNumber = 0;
    static int studentAddressesItemsNumber = 0;
    static int studentAgesItemsNumber = 0;
    static int studentPhonesItemsNumber = 0;

    // Start app in this fnction
    public static void main(String[] args) {
        addFakeData();
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
                    break;
                }
                case 2: {
                    instructor();
                    break;
                }
                case 3: {
                    student();
                    break;
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
            messageIncorrectData();
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
                case 7:
                    System.out.println("Logout Successfully");
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
        messageAdminOptions("Choose the thing you want to add to it");
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

    // Create new deprtment
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

    // Create new course
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
        courseCodes[courseCodeItemsNumber] = code;
        courseNumberHours[courseNumberHoursItemsNumber] = numHours;
        courseIdsItemsNumber++;
        courseNamesItemsNumber++;
        courseCodeItemsNumber++;
        courseNumberHoursItemsNumber++;
        successProcess();
    }

    // Create new instructor
    public static void addInstructor() {
        System.out.print("Enter Instructor ID: ");
        int id = input.nextInt();
        System.out.print("\nEnter Instructor Name: ");
        String name = input.next();
        System.out.print("\nEnter Instructor Password: ");
        String password = input.next();
        int departmentId;
        while (true) {
            if (departmentIdsItemsNumber != 0) {
                while (true) {
                    System.out.println("\nSelect Department: ");
                    showDepartments();
                    departmentId = input.nextInt();
                    if (checkDepartmentIdExist(departmentId)) {
                        instructorDepartmentIds[instructorDepartmentIdsItemsNumber] = departmentId;
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
        System.out.print("\nEnter Instructor Address: ");
        String address = input.next();
        System.out.print("\nEnter Instructor Age: ");
        double age = input.nextDouble();
        System.out.print("\nEnter Instructor Phone: ");
        String phone = input.next();

        instructorIds[instructorIdsItemsNumber] = id;
        instructorNames[instructorNamesItemsNumber] = name;
        instructorPasswords[instructorPasswordsItemsNumber] = password;
        instructorAddresses[instructorAddressesItemsNumber] = address;
        instructorAges[instructorAgesItemsNumber] = age;
        instructorPhones[instructorPhonesItemsNumber] = phone;
        instructorIdsItemsNumber++;
        instructorNamesItemsNumber++;
        instructorPasswordsItemsNumber++;
        instructorDepartmentIdsItemsNumber++;
        instructorAddressesItemsNumber++;
        instructorAgesItemsNumber++;
        instructorPhonesItemsNumber++;
        successProcess();
    }

    // Show All Departments
    public static void showDepartments() {
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            System.out.println(i + "-" + departmentNames[i] + ".");
        }
    }

    // Check if department is exist return true else return false
    public static boolean checkDepartmentIdExist(int departmentId) {
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            if (i == departmentId) {
                return true;
            }
        }
        return false;
    }

    // Add logic to add student function
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        System.out.print("\nEnter Student Name: ");
        String name = input.next();
        System.out.print("\nEnter Student Password: ");
        String password = input.next();
        int departmentId = 0;
        while (true) {
            if (departmentIdsItemsNumber != 0) {
                while (true) {
                    System.out.println("\nSelect Department: ");
                    showDepartments();
                    departmentId = input.nextInt();
                    if (checkDepartmentIdExist(departmentId)) {
                        studentDepartmentIds[studentDepartmentIdsItemsNumber] = departmentId;
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
        System.out.print("\nEnter Student Address: ");
        String address = input.next();
        System.out.print("\nEnter Student Age: ");
        double age = input.nextDouble();
        System.out.print("\nEnter Student Phone: ");
        String phone = input.next();

        studentIds[studentIdsItemsNumber] = id;
        studentNames[studentNamesItemsNumber] = name;
        studentPasswords[studentPasswordsItemsNumber] = password;
        studentAddresses[instructorAddressesItemsNumber] = address;
        studentAges[instructorAgesItemsNumber] = age;
        studentPhones[instructorPhonesItemsNumber] = phone;
        studentIdsItemsNumber++;
        studentNamesItemsNumber++;
        studentPasswordsItemsNumber++;
        studentDepartmentIdsItemsNumber++;
        studentAddressesItemsNumber++;
        studentAgesItemsNumber++;
        studentPhonesItemsNumber++;
        successProcess();
    }

    // Assgin Course to instructor
    public static void assgin() {
        messageAdminOptions("Assgin Course To Instructor");
        int instructorId;
        while (true) {
            System.out.print("Enter Instructor Id: ");
            instructorId = input.nextInt();
            if (checkInstructorIdExist(instructorId)) {
                break;
            } else {
                System.out.println("Error, Enter Instructor Id corrected!");
            }
        }

        while (true) {
            System.out.println("......... Select Course .........");
            showAllCourses();
            System.out.print("Enter Course ID:");
            int courseId;
            courseId = input.nextInt();
            if (checkCourseIdExistAndNotAssigned(courseId, instructorId)) {
                courseInstructorIds[courseInstructorIdsItemsNumber] = instructorId;
                instructorCourseIds[instructorCourseIdsItemsNumber] = courseId;
                courseInstructorIdsItemsNumber++;
                instructorCourseIdsItemsNumber++;
                successProcess();
                break;
            }
        }

    }

    // Check if instructor is exist return true else return false
    public static boolean checkInstructorIdExist(int instructorId) {
        for (int i = 0; i < instructorIdsItemsNumber; i++) {
            if (instructorIds[i] == instructorId) {
                return true;
            }
        }
        return false;
    }

    // Check if course is exist and not assigned return true else return false
    public static boolean checkCourseIdExistAndNotAssigned(int courseId, int instructorId) {
        boolean result = false;
        result = checkCourseIdExist(courseId);

        if (result) {
            for (int i = 0; i < instructorCourseIdsItemsNumber; i++) {
                if (instructorCourseIds[i] == courseId) {
                    if (courseInstructorIds[i] == instructorId) {
                        System.out.println("Has been previously assigned");
                        return false;
                    }
                    System.out.println("  !!!!! Sorry, course is Assgined !!!!!");
                    return false;
                }
            }
        } else {
            System.out.println("  !!!!! Sorry, Course is not exist, Enter correct course id !!!!!");
            return false;
        }

        return result;
    }

    // Show all item in system
    public static void show() {
        messageAdminOptions("Choose the thing you want to Show All to it");
        int select = 0;
        do {
            select = selection(textSelectionAdminShow());
            switch (select) {
                case 1: {
                    showAllDepartments();
                    break;
                }
                case 2: {
                    showAllCourses();
                    break;
                }
                case 3: {
                    showAllInstructors();
                    break;
                }
                case 4: {
                    showAllStudents();
                    break;
                }
            }
        } while (select != 5);
    }

    public static String textSelectionAdminShow() {
        return "\n"
                + "1. Show All Departments.\n"
                + "2. Show All Courses.\n"
                + "3. Show All Instructors.\n"
                + "4. Show All Students.\n"
                + "5. Exit.\n"
                + "Please select your choice[1, 2, 3, 4 or 5]:";
    }

    // Show All Departments
    public static void showAllDepartments() {
        if (departmentIdsItemsNumber > 0) {
            for (int i = 0; i < departmentIdsItemsNumber; i++) {
                System.out.println(i + "- [" + "Department ID:" + departmentIds[i] + " | Name:" + departmentNames[i] + "].");
            }
        } else {
            System.out.println("Not found any department, Add Departments!!");
        }
    }

    // Show All Courses
    public static void showAllCourses() {
        if (courseIdsItemsNumber > 0) {
            for (int i = 0; i < courseIdsItemsNumber; i++) {
                System.out.println(i + "- [" + "Course ID:" + courseIds[i] + " | Name:" + courseNames[i] + " | Code:" + courseCodes[i] + " | Hour:" + courseNumberHours[i] + "].");
            }
        } else {
            System.out.println("Not found any course, Add Courses!!");
        }
    }

    // Show All Instructors
    public static void showAllInstructors() {
        if (instructorIdsItemsNumber > 0) {
            for (int i = 0; i < instructorIdsItemsNumber; i++) {
                System.out.println(i + "- ["
                        + "Instructor ID:" + instructorIds[i]
                        + " | Department:" + searchDepartmentName(instructorDepartmentIds[i])
                        + " | Instructor Name:" + instructorNames[i]
                        + " | Password:" + instructorPasswords[i]
                        + " | Address:" + instructorAddresses[i]
                        + " | Phone:" + instructorPhones[i]
                        + "].");
            }
        } else {
            System.out.println("Not found any instructor, Add Instructors!!");
        }
    }

    // Taken department id and return department name
    public static String searchDepartmentName(int id) {
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            if (departmentIds[i] == id) {
                return departmentNames[i];
            }
        }
        return "Not Has Name";
    }

    // Show All Students
    public static void showAllStudents() {
        if (studentIdsItemsNumber > 0) {
            for (int i = 0; i < studentIdsItemsNumber; i++) {
                System.out.println(i + "- ["
                        + "Student ID:" + studentIds[i]
                        + " | Department:" + searchDepartmentName(studentDepartmentIds[i])
                        + " | Name:" + studentNames[i]
                        + " | Password:" + studentPasswords[i]
                        + " | Address:" + studentAddresses[i]
                        + " | Age:" + studentAges[i]
                        + " | Phone:" + studentPhones[i]
                        + " | Average:" + calculateAvg(studentIds[i])
                        + "].");
            }
        } else {
            System.out.println("Not found any student, Add Students!!");
        }
    }

    public static double calculateAvg(int studentId) {
        double sum = 0;
        int index = 0;
        for (int i = 0; i < courseStudentIdsItemsNumber; i++) {
            if (courseStudentIds[i] == studentId) {
                if (grades[i] != 0.0) {
                    sum += grades[i];
                    index++;
                }
            }
        }
        if(index == 0){
            return 0.0;
        }
        return sum / index;
    }

    // Update any items in system
    public static void update() {
        messageAdminOptions("Choose the thing you want to Update to it");
        int select = 0;
        do {
            select = selection(textSelectionAdminUpdate());
            switch (select) {
                case 1: {
                    updateDepartment();
                    break;
                }
                case 2: {
                    updateCourse();
                    break;
                }
                case 3: {
                    updateInstructor();
                    break;
                }
                case 4: {
                    updateStudent();
                    break;
                }
            }
        } while (select != 5);
    }

    public static String textSelectionAdminUpdate() {
        return "\n"
                + "1. Update Departments.\n"
                + "2. Update Courses.\n"
                + "3. Update Instructors.\n"
                + "4. Update Students.\n"
                + "5. Exit.\n"
                + "Please select your choice[1, 2, 3, 4 or 5]:";
    }

    public static void updateDepartment() {
        messageUpdate("Departments");
        System.out.print("Enter Departments ID: ");
        int id = input.nextInt();
        int index = searchDepartment(id);
        if (index != -1) {
            System.out.print("\nEnter Department Name: ");
            String name = input.next();
            departmentNames[index] = name;
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static int searchDepartment(int id) {
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            if (departmentIds[i] == id) {
                return i;
            }
        }
        return -1;
    }

    public static void updateCourse() {
        messageUpdate("Course");
        System.out.print("Enter Course ID: ");
        int id = input.nextInt();
        int index = searchCourse(id);
        if (index != -1) {
            System.out.print("\nEnter Course Name: ");
            String name = input.next();
            System.out.print("\nEnter Course Code: ");
            String code = input.next();
            System.out.print("\nEnter Course Number of Hours: ");
            double numHours = input.nextDouble();
            courseNames[index] = name;
            courseCodes[index] = code;
            courseNumberHours[index] = numHours;
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static int searchCourse(int id) {
        for (int i = 0; i < courseIdsItemsNumber; i++) {
            if (courseIds[i] == id) {
                return i;
            }
        }
        return -1;
    }

    public static void updateInstructor() {
        messageUpdate("Instructor");
        System.out.print("Enter Instructor ID: ");
        int id = input.nextInt();
        int index = searchInstructor(id);
        if (index != -1) {
            System.out.print("\nEnter Instructor Name: ");
            String name = input.next();
            int departmentId;
            while (true) {
                if (departmentIdsItemsNumber != 0) {
                    while (true) {
                        System.out.println("\nSelect Department: ");
                        showDepartments();
                        departmentId = input.nextInt();
                        if (checkDepartmentIdExist(departmentId)) {
                            instructorDepartmentIds[index] = departmentId;
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
            System.out.print("\nEnter Instructor Address: ");
            String address = input.next();
            System.out.print("\nEnter Instructor Age: ");
            double age = input.nextDouble();
            System.out.print("\nEnter Instructor Phone: ");
            String phone = input.next();
            instructorNames[index] = name;
            instructorAddresses[index] = address;
            instructorAges[index] = age;
            instructorPhones[index] = phone;
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static int searchInstructor(int id) {
        for (int i = 0; i < instructorIdsItemsNumber; i++) {
            if (instructorIds[i] == id) {
                return i;
            }
        }
        return -1;
    }

    public static void updateStudent() {
        messageUpdate("Student");
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        int index = searchStudent(id);
        if (index != -1) {
            System.out.print("\nEnter Student Name: ");
            String name = input.next();
            int departmentId;
            while (true) {
                if (departmentIdsItemsNumber != 0) {
                    while (true) {
                        System.out.println("\nSelect Department: ");
                        showDepartments();
                        departmentId = input.nextInt();
                        if (checkDepartmentIdExist(departmentId)) {
                            instructorDepartmentIds[index] = departmentId;
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
            System.out.print("\nEnter Student Address: ");
            String address = input.next();
            System.out.print("\nEnter Student Age: ");
            double age = input.nextDouble();
            System.out.print("\nEnter Student Phone: ");
            String phone = input.next();
            studentNames[index] = name;
            studentAddresses[index] = address;
            studentAges[index] = age;
            studentPhones[index] = phone;
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static int searchStudent(int id) {
        for (int i = 0; i < studentIdsItemsNumber; i++) {
            if (studentIds[i] == id) {
                return i;
            }
        }
        return -1;
    }

    // Delete any item in system
    public static void delete() {
        messageAdminOptions("Choose the thing you want to Delete to it");
        int select = 0;
        do {
            select = selection(textSelectionAdminDelete());
            switch (select) {
                case 1: {
                    deleteDepartment();
                    break;
                }
                case 2: {
                    deleteCourse();
                    break;
                }
                case 3: {
                    deleteInstructor();
                    break;
                }
                case 4: {
                    deleteStudent();
                    break;
                }
            }
        } while (select != 5);
    }

    public static String textSelectionAdminDelete() {
        return "\n"
                + "1. Delete Department.\n"
                + "2. Delete Courses.\n"
                + "3. Delete Instructor.\n"
                + "4. Delete Students.\n"
                + "5. Exit.\n"
                + "Please select your choice[1, 2, 3, 4 or 5]:";
    }

    public static void deleteDepartment() {
        messageDelete("Departments");
        System.out.print("Enter Departments ID: ");
        int id = input.nextInt();
        boolean isExist = false;
        for (int i = 0; i < departmentIdsItemsNumber; i++) {
            if (departmentIds[i] == id) {
                departmentIdsItemsNumber--;
                isExist = true;
            }
            if (isExist) {
                departmentIds[i] = departmentIds[i + 1];
                departmentNames[i] = departmentNames[i + 1];
            }
        }

        if (isExist) {
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static void deleteCourse() {
        messageDelete("Course");
        System.out.print("Enter Course ID: ");
        int id = input.nextInt();

        boolean isExist = false;
        for (int i = 0; i < courseIdsItemsNumber; i++) {
            if (courseIds[i] == id) {
                courseIdsItemsNumber--;
                isExist = true;
            }
            if (isExist) {
                courseIds[i] = courseIds[i + 1];
                courseNames[i] = courseNames[i + 1];
                courseCodes[i] = courseCodes[i + 1];
                courseNumberHours[i] = courseNumberHours[i + 1];
            }
        }

        if (isExist) {
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static void deleteInstructor() {
        messageDelete("Instructor");
        System.out.print("Enter Instructor ID: ");
        int id = input.nextInt();

        boolean isExist = false;
        for (int i = 0; i < instructorIdsItemsNumber; i++) {
            if (instructorIds[i] == id) {
                instructorIdsItemsNumber--;
                isExist = true;
            }
            if (isExist) {
                instructorIds[i] = instructorIds[i + 1];
                instructorNames[i] = instructorNames[i + 1];
                instructorPasswords[i] = instructorPasswords[i + 1];
                instructorDepartmentIds[i] = instructorDepartmentIds[i + 1];
                instructorAddresses[i] = instructorAddresses[i + 1];
                instructorAges[i] = instructorAges[i + 1];
                instructorPhones[i] = instructorPhones[i + 1];
            }
        }

        if (isExist) {
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static void deleteStudent() {
        messageDelete("Student");
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        boolean isExist = false;
        for (int i = 0; i < studentIdsItemsNumber; i++) {
            if (studentIds[i] == id) {
                studentIdsItemsNumber--;
                isExist = true;
            }
            if (isExist) {
                studentIds[i] = studentIds[i + 1];
                studentNames[i] = studentNames[i + 1];
                studentPasswords[i] = studentPasswords[i + 1];
                studentDepartmentIds[i] = studentDepartmentIds[i + 1];
                studentAddresses[i] = studentAddresses[i + 1];
                studentAges[i] = studentAges[i + 1];
                studentPhones[i] = studentPhones[i + 1];
            }
        }

        if (isExist) {
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    // Search for any item in system
    public static void search() {
        messageAdminOptions("Choose the thing you want to Search");
        int select = 0;
        do {
            select = selection(textSelectionAdminSearch());
            switch (select) {
                case 1: {
                    searchDepartment();
                    break;
                }
                case 2: {
                    searchCourse();
                    break;
                }
                case 3: {
                    searchInstructor();
                    break;
                }
                case 4: {
                    searchStudent();
                    break;
                }
            }
        } while (select != 5);
    }

    public static String textSelectionAdminSearch() {
        return "\n"
                + "1. Search Department.\n"
                + "2. Search Courses.\n"
                + "3. SearchInstructor.\n"
                + "4. SearchStudents.\n"
                + "5. Exit.\n"
                + "Please select your choice[1, 2, 3, 4 or 5]:";
    }

    public static void searchDepartment() {
        messageUpdate("Departments");
        System.out.print("Enter Departments ID: ");
        int id = input.nextInt();
        int index = searchDepartment(id);
        if (index != -1) {
            System.out.println("0" + "- [" + "Department ID:" + departmentIds[index] + " | Name:" + departmentNames[index] + "].");
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static void searchCourse() {
        messageUpdate("Course");
        System.out.print("Enter Course ID: ");
        int id = input.nextInt();
        int index = searchCourse(id);
        if (index != -1) {
            System.out.println("0" + "- [" + "Course ID:" + courseIds[index] + " | Name:" + courseNames[index] + " | Code:" + courseCodes[index] + " | Hour:" + courseNumberHours[index] + "].");
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static void searchInstructor() {
        messageUpdate("Instructor");
        System.out.print("Enter Instructor ID: ");
        int id = input.nextInt();
        int index = searchInstructor(id);
        if (index != -1) {
            System.out.println("0" + "- ["
                    + "Instructor ID:" + instructorIds[index]
                    + " | Department:" + searchDepartmentName(instructorDepartmentIds[index])
                    + " | Instructor Name:" + instructorNames[index]
                    + " | Password:" + instructorPasswords[index]
                    + " | Address:" + instructorAddresses[index]
                    + " | Phone:" + instructorPhones[index]
                    + "].");
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    public static void searchStudent() {
        messageUpdate("Student");
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        int index = searchStudent(id);
        if (index != -1) {
            System.out.println("0" + "- ["
                    + "Student ID:" + studentIds[index]
                    + " | Department:" + searchDepartmentName(studentDepartmentIds[index])
                    + " | Name:" + studentNames[index]
                    + " | Password:" + studentPasswords[index]
                    + " | Address:" + studentAddresses[index]
                    + " | Age:" + studentAges[index]
                    + " | Phone:" + studentPhones[index]
                    + " | Average:" + calculateAvg(studentIds[index])
                    + "].");
            successProcess();
        } else {
            messageIncorrectData();
        }
    }

    static int instructorId = -1;
    static String instructorName = null;

    public static void instructor() {
        if (instructorAuth()) {
            welcoming(instructorName);
            int select = 0;
            do {
                select = selection(textSelectionInstructor());
                switch (select) {
                    case 1: {
                        showAllStudentInAllCourse();
                        break;
                    }
                    case 2: {
                        showAllStudentInSpecificCourse();
                        break;
                    }
                    case 3: {
                        showCourse();
                        break;
                    }
                    case 4: {
                        searchStudent();
                        break;
                    }
                    case 5: {
                        setGrade();
                        break;
                    }
                    case 6: {
                        profileInstructor();
                        break;
                    }
                    case 7:
                        instructorId = -1;
                        instructorName = null;
                        System.out.println("Logout Successfully");
                }
            } while (select != 7);
        }
    }

    // Check authientication for instructor
    public static boolean instructorAuth() {
        welcoming("Instructor");
        System.out.print("Enter username: ");
        String name = input.next();
        System.out.print("\nEnter password: ");
        String password = input.next();
        for (int i = 0; i < instructorIdsItemsNumber; i++) {
            if (name.equalsIgnoreCase(instructorNames[i])
                    && password.equalsIgnoreCase(instructorPasswords[i])) {
                instructorName = instructorNames[i];
                instructorId = instructorIds[i];
                return true;
            }
        }
        messageIncorrectData();
        return false;

    }

    // Returned for show admin option
    public static String textSelectionInstructor() {
        return "\n"
                + "1. Show All Student In All Course.\n"
                + "2. Show All Student In Specific Course.\n"
                + "3. Show Course.\n"
                + "4. Search Student.\n"
                + "5. Set Grade.\n"
                + "6. Profile Instructor.\n"
                + "7. Exit.\n"
                + "Please select your choice[1, 2, 3, 4, 5, 6 or 7]:";
    }

    public static void showAllStudentInAllCourse() {
        messageInstructor("Show All Student In All Course");
        if (hasCourse()) {
            boolean hasCourse = false;
            for (int i = 0; i < instructorCourseIdsItemsNumber; i++) {
                if (courseInstructorIds[i] == instructorId) {
                    hasCourse = true;
                    if (courseHasStudent(instructorCourseIds[i])) {
                        int index = 0;
                        for (int j = 0; j < studentCourseIdsItemsNumber; j++) {
                            if (studentCourseIds[j] == instructorCourseIds[i]) {
                                index++;
                                showStudent(courseStudentIds[j], index);
                            }
                        }
                    } else {
                        System.out.println("Your courses not have any register student");
                    }
                }
            }
            successProcess();
        } else {
            System.out.println("No course has been assigned to you, "
                    + "please request to assign a course from the adminNo "
                    + "course has been assigned to you, please request to "
                    + "assign a course from the admin");
        }

    }

    // show spasific student
    public static int showStudent(int id, int j) {
        int index = searchStudent(id);
        if (index != -1) {
            System.out.println(j + "- ["
                    + "Student ID:" + studentIds[index]
                    + " | Department:" + searchDepartmentName(studentDepartmentIds[index])
                    + " | Name:" + studentNames[index]
                    + " | Password:" + studentPasswords[index]
                    + " | Address:" + studentAddresses[index]
                    + " | Age:" + studentAges[index]
                    + " | Phone:" + studentPhones[index]
                    + " | Average:" + calculateAvg(studentIds[index])
                    + "].");
            return index;
        } else {
            messageIncorrectData();
            return -1;
        }
    }

    // check if current instructor has course
    public static boolean hasCourse() {
        if (instructorCourseIdsItemsNumber == 0) {
            return false;
        } else {
            for (int i = 0; i < instructorCourseIdsItemsNumber; i++) {
                if (courseInstructorIds[i] == instructorId) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if course has student
    public static boolean courseHasStudent(int courseId) {
        if (studentCourseIdsItemsNumber == 0) {
            return false;
        } else {
            for (int i = 0; i < studentCourseIdsItemsNumber; i++) {
                if (studentCourseIds[i] == courseId) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void showAllStudentInSpecificCourse() {
        messageInstructor("Show All Student In Course");
        if (hasCourse()) {
            System.out.print("Enter course id: ");
            int courseId = input.nextInt();
            boolean hasCourse = false;
            if (checkCourseIdExist(courseId)) {
                for (int i = 0; i < instructorCourseIdsItemsNumber; i++) {
                    if (instructorCourseIds[i] == courseId && courseInstructorIds[i] == instructorId) {
                        hasCourse = true;
                        if (courseHasStudent(instructorCourseIds[i])) {
                            int index = 0;
                            boolean isHasStudent = false;
                            for (int j = 0; j < studentCourseIdsItemsNumber; j++) {
                                if (studentCourseIds[j] == instructorCourseIds[i]) {
                                    index++;
                                    isHasStudent = true;
                                    showStudent(courseStudentIds[j], index);
                                }
                            }
                            if (isHasStudent) {
                                successProcess();
                            } else {
                                messageIncorrectData();
                            }
                        } else {
                            System.out.println("Your courses not have any register student");
                        }
                    }
                    if (!hasCourse()) {
                        messageIncorrectData();
                    }
                }
            } else {
                messageIncorrectData();
            }
        } else {
            System.out.println("No course has been assigned to you, "
                    + "please request to assign a course from the adminNo "
                    + "course has been assigned to you, please request to "
                    + "assign a course from the admin");
        }
    }

    // Check if course is exist 
    public static boolean checkCourseIdExist(int courseId) {
        for (int i = 0; i < courseIdsItemsNumber; i++) {
            if (courseIds[i] == courseId) {
                return true;
            }
        }
        return false;
    }

    public static void showCourse() {
        messageInstructor("Show Courses");
        if (hasCourse()) {
            boolean hasCourse = false;
            int j = 0;
            for (int i = 0; i < instructorCourseIdsItemsNumber; i++) {
                if (courseInstructorIds[i] == instructorId) {
                    j++;
                    showCourseForInstructor(instructorCourseIds[i], j);
                }
            }
            successProcess();

        } else {
            System.out.println("No course has been assigned to you, "
                    + "please request to assign a course from the adminNo "
                    + "course has been assigned to you, please request to "
                    + "assign a course from the admin");
        }
    }

    public static void showCourseForInstructor(int id, int j) {
        int index = searchCourse(id);
        if (index != -1) {
            System.out.println(j + "- [" + "Course ID:" + courseIds[index] + " | Name:" + courseNames[index] + " | Code:" + courseCodes[index] + " | Hour:" + courseNumberHours[index] + "].");
        } else {
            messageIncorrectData();
        }
    }

    public static void setGrade() {
        messageInstructor("Grades");
        if (hasCourse()) {
            System.out.print("Enter course id: ");
            int courseId = input.nextInt();
            boolean hasCourse = false;
            if (checkCourseIdExist(courseId)) {
                for (int i = 0; i < instructorCourseIdsItemsNumber; i++) {
                    if (instructorCourseIds[i] == courseId && courseInstructorIds[i] == instructorId) {
                        hasCourse = true;
                        if (courseHasStudent(instructorCourseIds[i])) {
                            int index = 0;
                            boolean isHasStudent = false;
                            for (int j = 0; j < studentCourseIdsItemsNumber; j++) {
                                if (studentCourseIds[j] == instructorCourseIds[i]) {
                                    index++;
                                    isHasStudent = true;
                                    int id = showStudent(courseStudentIds[j], index);
                                    System.out.print("Enter Grade:");
                                    double grade = input.nextDouble();
                                    grades[j] = grade;
                                }
                            }
                            if (isHasStudent) {
                                successProcess();
                            } else {
                                messageIncorrectData();
                            }
                        } else {
                            System.out.println("Your courses not have any register student");
                        }
                    }
                    if (!hasCourse()) {
                        messageIncorrectData();
                    }
                }
            } else {
                messageIncorrectData();
            }
        } else {
            System.out.println("No course has been assigned to you, "
                    + "please request to assign a course from the adminNo "
                    + "course has been assigned to you, please request to "
                    + "assign a course from the admin");
        }
    }

    public static void profileInstructor() {
        messageInstructor("Instructor Profile");

        int index = searchInstructor(instructorId);
        System.out.println("0" + "- ["
                + "Instructor ID:" + instructorIds[index]
                + " | Department:" + searchDepartmentName(instructorDepartmentIds[index])
                + " | Instructor Name:" + instructorNames[index]
                + " | Password:" + instructorPasswords[index]
                + " | Address:" + instructorAddresses[index]
                + " | Phone:" + instructorPhones[index]
                + "].");
    }

    static int studentAuthId = -1;
    static String studentAuthName = null;

    public static void student() {
        if (studentAuth()) {
            welcoming(studentAuthName);
            int select = 0;
            do {
                select = selection(textSelectionStudent());
                switch (select) {
                    case 1: {
                        registerCourse();
                        break;
                    }
                    case 2: {
                        showAllRegisteredCourse(true);
                        break;
                    }
                    case 3: {
                        deleteStudentCourse();
                        break;
                    }
                    case 4: {
                        average();
                        break;
                    }
                    case 5: {
                        studentProfile();
                        break;
                    }
                    case 6:
                        studentAuthId = -1;
                        studentAuthName = null;
                        System.out.println("Logout Successfully");
                }
            } while (select != 6);
        }
    }

    // Check authientication for student
    public static boolean studentAuth() {
        welcoming("Student");
        System.out.print("Enter username: ");
        String name = input.next();
        System.out.print("\nEnter password: ");
        String password = input.next();
        for (int i = 0; i < studentIdsItemsNumber; i++) {
            if (name.equalsIgnoreCase(studentNames[i])
                    && password.equalsIgnoreCase(studentPasswords[i])) {
                studentAuthName = studentNames[i];
                studentAuthId = studentIds[i];
                return true;
            }
        }
        messageIncorrectData();
        return false;

    }

    public static String textSelectionStudent() {
        return "\n"
                + "1. Register Course.\n"
                + "2. Show All Registered Course.\n"
                + "3. Delete Course.\n"
                + "4. Average.\n"
                + "5. Student Profile.\n"
                + "6. Exit.\n"
                + "Please select your choice[1, 2, 3, 4, 5 or 6]:";
    }

    // Register course for current student(auth)
    public static void registerCourse() {
        messageStudent("Register Course");
        showAllCourses();
        System.out.print("Enter Course ID: ");
        int id = input.nextInt();
        if (checkCourseIdExistAndNotAlredayRegisteredStudent(id, studentAuthId)) {
            courseStudentIds[courseStudentIdsItemsNumber] = studentAuthId;
            studentCourseIds[studentCourseIdsItemsNumber] = id;
            courseStudentIdsItemsNumber++;
            studentCourseIdsItemsNumber++;
            successProcess();
        }
    }

    // Check if course is exist and not alredy registered to student return true else return false
    public static boolean checkCourseIdExistAndNotAlredayRegisteredStudent(int courseId, int studentId) {
        boolean result = false;
        result = checkCourseIdExist(courseId);

        if (result) {
            for (int i = 0; i < studentCourseIdsItemsNumber; i++) {
                if (courseStudentIds[i] == studentId && studentCourseIds[i] == courseId) {
                    System.out.println("!!!! Sorry, Course is alrady Registered! !!!");
                    return false;
                }
            }
        } else {
            System.out.println("  !!!!! Sorry, Course is not exist, Enter correct course id !!!!!");
            return false;
        }

        return result;
    }

    public static void showAllRegisteredCourse(boolean withMessages) {
        boolean isExist = false;
        int currentIndex = 0;
        if (studentCourseIdsItemsNumber > 0) {
            for (int i = 0; i < studentCourseIdsItemsNumber; i++) {
                if (courseStudentIds[i] == studentAuthId) {
                    int index = searchCourse(studentCourseIds[i]);
                    if (index != -1) {
                        isExist = true;
                        System.out.println(currentIndex + "- ["
                                + "Course ID:" + courseIds[index]
                                + " | Name:" + courseNames[index]
                                + " | Code:" + courseCodes[index]
                                + " | Hour:" + courseNumberHours[index]
                                + " | Grade: " + grades[i]
                                + "]."
                        );
                        currentIndex++;
                    }
                }
            }
        }

        if (isExist) {
            if (withMessages) {
                successProcess();
            }
        } else {
            System.out.println("You do not have any course, please register courses!!");
        }

    }

    public static void deleteStudentCourse() {
        messageStudent("Delete Course");
        showAllRegisteredCourse(false);
        System.out.print("Enter Course ID: ");
        int id = input.nextInt();

        boolean isDeleted = false;
        for (int i = 0; i < studentCourseIdsItemsNumber; i++) {
            if (studentCourseIds[i] == id && courseStudentIds[i] == studentAuthId) {
                courseStudentIdsItemsNumber--;
                studentCourseIdsItemsNumber--;
                isDeleted = true;
            }
            if (isDeleted) {
                courseStudentIds[i] = courseStudentIds[i + 1];
                studentCourseIds[i] = studentCourseIds[i + 1];
                grades[i] = grades[i + 1];
            }
        }
        if (isDeleted) {
            successProcess();
        } else {
            messageIncorrectData();
        }

    }

    // Check if course is exist and not alredy registered to student return true else return false
    public static int checkCourseIdExistAndAlredayRegisteredStudent(int courseId, int studentId) {
        boolean result = false;
        result = checkCourseIdExist(courseId);

        if (result) {
            for (int i = 0; i < studentCourseIdsItemsNumber; i++) {
                if (courseStudentIds[i] == studentId && studentCourseIds[i] == courseId) {
                    return i;
                }
            }
        } else {
            return -1;
        }

        return -1;
    }

    public static void average() {
        System.out.println("Average: " + calculateAvg(studentAuthId));
    }

    public static void studentProfile() {
        messageStudent("Student Profile");

        int index = searchStudent(studentAuthId);
        System.out.println("0" + "- ["
                + "Student ID:" + studentIds[index]
                + " | Department:" + searchDepartmentName(studentDepartmentIds[index])
                + " | Name:" + studentNames[index]
                + " | Address:" + studentAddresses[index]
                + " | Age:" + studentAges[index]
                + " | Phone:" + studentPhones[index]
                + " | Average:" + calculateAvg(studentAuthId)
                + "].");
    }

    public static void successProcess() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^     Success Process     ^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static void messageAdminOptions(String message) {
        System.out.println("~~~~~~~~~~~~~~ " + message + " ~~~~~~~~~~~~~~");
    }

    public static void messageUpdate(String message) {
        System.out.println("------------ Update " + message + "------------");
    }

    public static void messageDelete(String message) {
        System.out.println("------------ Update " + message + "------------");
    }

    public static void messageStudent(String message) {
        System.out.println("------------ " + message + "------------");
    }

    public static void messageInstructor(String message) {
        System.out.println("------------ " + message + "------------");
    }

    public static void messageIncorrectData() {
        System.out.println("^_^ Sorry, the data is incorrect ^_^");
        System.out.println("    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^    ");
    }

    public static void addFakeData() {
        String[] phones = {"0569873232", "0567423132",
            "0599732654", "0593421456",
            "0569745638", "0599876234",
            "0599921234", "05673234123",
            "0569123435", "0599232345"};
        for (int i = 0; i < 10; i++) {
            departmentIds[departmentIdsItemsNumber] = i;
            departmentNames[departmentNamesItemsNumber] = "departmentNames " + i;
            departmentIdsItemsNumber++;
            departmentNamesItemsNumber++;

            courseIds[courseIdsItemsNumber] = i;
            courseNames[courseNamesItemsNumber] = "courseNames " + i;
            courseCodes[courseCodeItemsNumber] = "100" + i;
            courseNumberHours[courseNumberHoursItemsNumber] = i + 5;
            courseIdsItemsNumber++;
            courseNamesItemsNumber++;
            courseCodeItemsNumber++;
            courseNumberHoursItemsNumber++;

            instructorIds[instructorIdsItemsNumber] = i;
            instructorNames[instructorNamesItemsNumber] = "instructorNames" + i;
            instructorPasswords[instructorPasswordsItemsNumber] = "instructorPasswords" + i;
            instructorDepartmentIds[i] = i;
            instructorAddresses[instructorAddressesItemsNumber] = "instructorAddresses" + i;
            instructorAges[instructorAgesItemsNumber] = 25 + i;
            instructorPhones[instructorPhonesItemsNumber] = phones[(int) Math.random() * 10];
            instructorIdsItemsNumber++;
            instructorNamesItemsNumber++;
            instructorPasswordsItemsNumber++;
            instructorDepartmentIdsItemsNumber++;
            instructorAddressesItemsNumber++;
            instructorAgesItemsNumber++;
            instructorPhonesItemsNumber++;

            studentIds[studentIdsItemsNumber] = i;
            studentNames[studentNamesItemsNumber] = "studentNames" + i;
            studentPasswords[studentPasswordsItemsNumber] = "studentPasswords" + i;
            studentAddresses[instructorAddressesItemsNumber] = "studentAddresses " + i;
            studentDepartmentIds[studentDepartmentIdsItemsNumber] = i;
            studentAges[instructorAgesItemsNumber] = 20 + 1;
            studentPhones[instructorPhonesItemsNumber] = phones[(int) Math.random() * 10];
            studentIdsItemsNumber++;
            studentNamesItemsNumber++;
            studentPasswordsItemsNumber++;
            studentDepartmentIdsItemsNumber++;
            studentAddressesItemsNumber++;
            studentAgesItemsNumber++;
            studentPhonesItemsNumber++;

            instructorCourseIds[instructorCourseIdsItemsNumber] = i;
            instructorCourseIdsItemsNumber++;
            courseInstructorIds[courseInstructorIdsItemsNumber] = i;
            courseInstructorIdsItemsNumber++;

            studentCourseIds[studentCourseIdsItemsNumber] = i;
            studentCourseIdsItemsNumber++;
            courseStudentIds[courseStudentIdsItemsNumber] = i;
            courseStudentIdsItemsNumber++;

        }

        instructorCourseIds[instructorCourseIdsItemsNumber] = 1;
        instructorCourseIdsItemsNumber++;
        courseInstructorIds[courseInstructorIdsItemsNumber] = 0;
        courseInstructorIdsItemsNumber++;

        studentCourseIds[studentCourseIdsItemsNumber] = 0;
        studentCourseIdsItemsNumber++;
        courseStudentIds[courseStudentIdsItemsNumber] = 3;
        courseStudentIdsItemsNumber++;

        studentCourseIds[studentCourseIdsItemsNumber] = 0;
        studentCourseIdsItemsNumber++;
        courseStudentIds[courseStudentIdsItemsNumber] = 4;
        courseStudentIdsItemsNumber++;
    }

}
