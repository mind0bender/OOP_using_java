class Student {
    private final String name;
    private final int age;
    private static String university;

    Student(String n, int a) {
        name = n;
        age = a;
        university = "Chandigarh University";
    }

    public static void setUniversity(String u) {
        university = u;
    }

    public void display() {
        System.out.println("University: " + university);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class exp3 {
    public static void main(String[] args) {
        Student yash = new Student("Yash Gupta", 21);
        Student faddy = new Student("Fahadullah Salim", 21);
        Student avisekh = new Student("Avisekh Sabi", 21);
        Student[] students = { yash, faddy, avisekh };
        for (Student student : students) {
            student.display();
        }
        System.out.println();
        Student.setUniversity("Chitkara University");
        for (Student student : students) {
            student.display();
        }
    }
}