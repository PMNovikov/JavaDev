public class Main {

    public static void main(String[] args) {
        task2();
        task3();
        boolean resultTask4 = task4(10,20);
        System.out.println("Result task4: " + resultTask4);
        task5(-4);
        boolean resultTask6 = task6(-5);
        System.out.println("Result task6: " + resultTask6);
        task7("Maksim");
        task8(2100);
    }

    public static void task2(){
        char ch = 'c';
        byte b = 127;
        short sh = 255;
        int i = 512;
        long l = 1024l;
        float f = 2048.5f;
        double d = 1.4096;
        boolean bool = true;
    }

    public static void task3(){
        float a, b, c, d;
        a = 1.0f;
        b = 2.0f;
        c = 3.0f;
        d = 4.0f;
        float result = 0;
        if (d != 0.0) {
            result = a * (b + (c / d));
        } else {
            System.out.println("Division by zero.");
        }
        System.out.println("Result for " + a + " * (" + b + " + (" + c + " / " + d + " )) = " + result);
    }

    public static boolean task4(int a, int b){
        int result = a + b;
        return (result >=10 && result <=20);
    }

    public static void task5(int a){
        if (a >= 0)
            System.out.println("Variable [" + a + "] is positive.");
        else
            System.out.println("Variable [" + a + "] is negative.");
    }

    public static boolean task6(int a){
        return a < 0;
    }

    public static void task7(String name){
        System.out.println("Hello, " + name + "!");
    }

    public static void task8(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
            System.out.println("Year " + year + " is leap.");
        else
            System.out.println("Year " + year + " is not leap.");
    }
}
