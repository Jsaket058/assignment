public class Advanced1 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
        d.eat();
        d.sleep();
    }
}
interface Animal {
    void makeSound();  // Abstract method
}

abstract class Mammal {
    abstract void eat(); // Abstract method
    void sleep() { // Concrete method
        System.out.println("Sleeping...");
    }
}

class Dog extends Mammal implements Animal {
    public void makeSound() { 
        System.out.println("Bark!");
    }

    void eat() {
        System.out.println("Eating dog food.");
    }
}
