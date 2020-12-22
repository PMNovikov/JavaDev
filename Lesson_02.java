import java.util.Arrays;

public class Lesson_02 {

    public static void main(String[] args) {
        System.out.println("Task1:");
        doTask1();
        System.out.println("Task2:");
        doTask2();
        System.out.println("Task3:");
        doTask3();
        System.out.println("Task4:");
        doTask4();
        System.out.println("Task5:");
        doTask5();
        System.out.println("Task6:");
        int[] arrayTask6 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean resultTask6 = doTask6(arrayTask6);
        System.out.println("Result task6: " + resultTask6);
        System.out.println("Task7:");
        int[] arrayTask7 = { 3, 5, 6, 1};
        doTask7(arrayTask7, 2);
        doTask7(arrayTask7, -2);
    }

    public static void doTask1(){
        int[] array = {0,1,0,1,1,0,0,1};
        printArray("Source massive", array);
        for (int i = 0; i < array.length; i++)
            array[i] = 1 - array[i];
        printArray("Result massive", array);
    }

    public static void doTask2(){
        int[] array = new int[8];
        printArray("Source massive", array);
        for (int i = 0; i < array.length; i++)
            array[i] = i * 3;
        printArray("Result massive", array);

    }

    public static void doTask3(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray("Source massive", array);
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
        printArray("Result massive", array);

    }

    public static void doTask4(){
        int[][] array = new int[5][5];
        printArrayN("Source massive", array);
        for (int i = 0; i < array.length; i++)
            array[i][i] = 1;
        printArrayN("Result massive left", array);
        array = new int[5][5];
        printArrayN("Source massive", array);
        for (int i = 0; i < array.length; i++)
            array[array.length - i - 1][i] = 1;
        printArrayN("Result massive right", array);

    }

    public static void doTask5(){
        int[] array = {11, 15, 3, 2, 11, 4, 15, 2, 4, 18, 9, 1};
        int maxVal = 0;
        int minVal = 0;
        printArray("Source massive", array);
        for (int i = 1; i < array.length; i++){
            if (array[maxVal] < array[i])
                maxVal = i;
            else if (array[minVal] > array[i])
                minVal = i;
        }
        System.out.println("Min value array: [" + (minVal + 1) + "] = " + array[minVal]);
        System.out.println("Max value array: [" + (maxVal + 1) + "] = " + array[maxVal]);
    }

    public static boolean doTask6(int[] array){
        printArray("Source array: ", array);
        int l = 0;
        int r = array.length - 1;
        int leftSum = array[l++];
        int rightSum = array[r--];
        while (l != r+1){
            if (leftSum + array[l] <= rightSum) {
                leftSum += array[l++];
            } else {
                rightSum += array[r--];
            }
        } ;
        return (leftSum == rightSum);
    }

    public static void doTask7(int[] array, int n) {
        //direction true - turn left
        //direction false - turn right
        boolean direction = (n < 0);
        int tmp;
        int count = n;
        printArray("Source array: ", array);
        if (direction)
            count *= -1;
        for (int i = 0; i < count; i++)
        {
            if (direction){
                tmp = array[0];
                for (int j = 1; j < array.length; j++)
                    array[j-1] = array[j];
                array[array.length-1] = tmp;
            } else {
                tmp = array[array.length-1];
                for (int j = array.length-1; j > 0; j--)
                    array[j] = array[j-1];
                array[0] = tmp;
            }
        }
        printArray("Result array: ", array);
    }

    public static void printArray(String text, int[] array){
        System.out.print(text + ": ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "\t");
        System.out.println("");
    }

    public static void printArrayN(String text, int[][] array){
        System.out.println(text + ": ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + "\t");
            System.out.println("");
        }
        System.out.println("");
    }

}
