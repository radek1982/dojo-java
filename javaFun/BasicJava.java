import javax.management.ObjectName;
import java.util.ArrayList;

public class BasicJava {
    public void print0To255() {

        for (int i=0; i<=255; i++) {
            System.out.println(i);
        }
    }
    public void printOdd() {
        for (int i=0; i<=255; i+=2) {
            System.out.println(i);
        }
    }
    public void printSum(){

        int total = 0;
        for (int i=1; i<=255; i++) {
            total+=i;
            System.out.println("New number:  " + i + " Sum: " + total);
        }
    }
    public void printArray(ArrayList arr){

        for (Object el: arr ) {

            System.out.println(el);
        }
    }

    public int findMax(int [] arr) {

        int maxValue = Integer.MIN_VALUE;

        for ( int n: arr) {
            if (n > maxValue) {
                maxValue = n;
            }
        }

        return maxValue;

    }

    public int findMax(ArrayList<Integer> arr) {

        int maxValue = Integer.MIN_VALUE;

        for ( int n: arr) {
            if (n > maxValue) {
                maxValue = n;
            }
        }

        return maxValue;

    }

    public int findMin(ArrayList<Integer> arr) {

        int minValue = Integer.MAX_VALUE;

        for ( int n: arr) {
            if (n < minValue) {
                minValue= n;
            }
        }

        return minValue;

    }




    public double getAvg(int [] arr) {

        double sum = getSum(arr);


        if (arr.length > 0) {
            return sum / arr.length;
        }
        else {
            return -1.0;
        }
    }

    public double getAvg(ArrayList<Integer> arr) {

        double sum = getSum(arr);


        if (arr.size()> 0) {
            return sum / arr.size();
        }
        else {
            return -1.0;
        }
    }


    private ArrayList<Integer> range(int from, int to, int step) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = from; i<=to;i+=step ){
            res.add(i);
        }

        return res;
    }
    private ArrayList<Integer> range(int from, int to) {
        int step = 1;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = from; i<=to;i+=step ){
           res.add(i);
        }

        return res;
    }

    private double getSum(ArrayList<Integer> arr) {
        int total = 0;
        for (int a: arr) {
            total+=a;
        }

        return total;
    }
    private double getSum(int [] arr) {
        int total = 0;
        for (int a: arr) {
            total+=a;
        }

        return total;
    }
    public ArrayList<Integer> arrayWithOddNumbers() {

        return range(1, 255,2);
    }
    public int greaterThanY(int [] arr, int y){

        int count = 0;

        for (int n:arr) {

           if (n > y ) { count++;}
        }

        return count;
    }

    public ArrayList<Integer> square(int [] arr) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int a: arr) {
            res.add(a*a);

        }

        return res;
    }

    public ArrayList<Integer> removeNegatives(int[] arr) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int a: arr) {
            if (a>=0) {
                res.add(a);
            }

        }
        return res;
    }

    public int[] maxMinAvg(ArrayList<Integer> e) {


        return new int[]{
                findMax(e), findMax(e), (int) getAvg(e)};



    }

    public ArrayList shiftValues(ArrayList e) {

        return e;
    }

    public static void main(String[] args) {

        BasicJava basic = new BasicJava();

        System.out.println(basic.findMax(new int[]{1, 2, 3}));
        System.out.println(basic.findMax(new int[]{1, -2, 3}));
    }

}
