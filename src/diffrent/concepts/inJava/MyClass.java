package diffrent.concepts.inJava;

public class MyClass {

    /*
    * The Order of running is static block, then instance block ,and constructor
    * Static block: is executed auto when the class is loaded in memory, and it has priority of 1.
    * Instance block: is defined as the name-less method, is executed only once for each object during its creation, and priority of 2.
    * The class can have multiple static blocks, and instance of blocks.
    * */

    public void myMethod()
    {
        System.out.println("Method");
    }

    {
        System.out.println("Instance Block");
    }

    {
        System.out.println("Instance Block2");
    }

    public void MyClass()
    {
        System.out.println("Constructor ");
    }
    static {
        System.out.println("static block");
    }

    static {
        System.out.println("static block2");
    }


    public static void main(String[] args) {
        MyClass c = new MyClass();
        c.MyClass();
        c.myMethod();
    }



}
