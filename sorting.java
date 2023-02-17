// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

package Homeworks.homework2;
import java.io.IOException;
import java.util.logging.*;
import java.util.Random;

public class sorting {

    private static Random random = new Random();

    public static int[] fillArray(int size) {
        int[] array = new int [size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        return array;
    }

    public static void print(int[] data) {
        int count = data.length;
        
        int index = 0;
        while (index < count) {
            System.out.print(data[index] + " ");
            index = index + 1;
            }
        System.out.println("");
    }

    public static int[] bubbleSortingLog (int[] arr) throws IOException {
        int[] sortArr = arr;
        Logger logger = Logger.getLogger(sorting.class.getName());
        FileHandler fh = new FileHandler("C:/Users/zaplo/Desktop/2term/java_progi/Homeworks/homework2/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        
        for (int i = 0; i < sortArr.length-1; i++) {
            for (int j = 0; j < sortArr.length-i-1; j++) {
                if (sortArr[j+1] < sortArr[j]) {
                    int temp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                }
            }
        String logMsg = fromArrToString(sortArr);
        logger.info(logMsg);
        }
        return sortArr;
    }

        public static String fromArrToString (int[] arr) {
        String logString = "";
        for (int i = 0; i < arr.length; i++) {
            logString += arr[i] + " ";
        }
        return logString;
    }

    public static void main(String[] args) throws IOException {
        int[] massive = fillArray(10);
        print(massive);
        int[] newMassive = bubbleSortingLog(massive);
        print(newMassive);
        
    }
}
