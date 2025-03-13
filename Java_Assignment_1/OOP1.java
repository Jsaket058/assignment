class Student {
    private String name;
    private int rollNumber;
    private double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

class GraduateStudent extends Student {
    private String specialization;

    public GraduateStudent(String name, int rollNumber, double marks, String specialization) {
        super(name, rollNumber, marks);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
    }
}


public class OOP1 {
    public static void main(String[] args) {
        Student s1 = new Student("Saket", 101, 85.5);
        System.out.println("Student Details:");
        s1.displayInfo();

        System.out.println();

        GraduateStudent g1 = new GraduateStudent("Vaseem", 102, 90.2, "Computer Science");
        System.out.println("Graduate Student Details:");
        g1.displayInfo();
    }
}
