public class PrimitiveAndReferenced{
    public static void main(String[] args) {
        int num = 10;  
        double pi = 3.14;
        char letter = 'A';
        boolean isJavaFun = true;

        System.out.println("Integer: " + num);
        System.out.println("Double: " + pi);
        System.out.println("Character: " + letter);
        System.out.println("Boolean: " + isJavaFun);

        Student1 s1 = new Student1("Saket", 101); 
        Student1 s2 = s1;

        s1.display();
        s2.display();

        s1.name = "Vaseem";

        System.out.println("After modification:");
        s1.display();
        s2.display();
    }
}
class Student1 {
    String name;
    int rollNo;

    Student1(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }
}