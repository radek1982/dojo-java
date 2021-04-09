import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicJava {

/* printing functions */

    public void printArray(ArrayList arr) {

        for (Object el: arr) {
            System.out.println(el);
        }
    }
    public void print1to255() {
        for (int n = 1; n<=255; n++) {
            System.out.println(n);
        }
    }

    public void printOdd1to255() {
        for (int n = 1; n <= 255; n += 2) {
            System.out.println(n);
        }
    }

        public void printSum() {
        int sum = 0;

        for (int i =0; i<256; i++) {

            sum+=i;
            System.out.println("New number" + i + " Sum " + sum);
        }
    }

    /** Find max **/
    public int findMax(ArrayList<Integer> arr) {

        int max = Integer.MIN_VALUE;

        for (int el: arr) {
            if (el > max) max = el;
        }

        return max;
    }
    public int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;

        for (int el: arr) {
            if (el < min) min = el;
        }

        return min;
    }

    public int[] getMaxMinAvg(ArrayList<Integer> numbers) {

        return new int[] {findMax(numbers), findMin(numbers), getAverage(numbers)};
    }
    public int getAverage(ArrayList<Integer> numbers) {

        // if there are no numbers return -1
        if (numbers.size() == 0) return -1;

        return sum(numbers)/numbers.size();

    }

    public ArrayList<Integer> eliminateNegatives(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {

            int x = numbers.get(i);

            if (x < 0) {
                x = 0;

            }
            numbers.set(i, x);


        }
        return numbers;
    }
    public ArrayList<Integer> square(ArrayList<Integer> numbers) {

        for (int i =0; i<numbers.size(); i++ ){
            int x = numbers.get(i);
            numbers.set(i,x*x);
        }

        return numbers;
    }
    public ArrayList<Integer> arrayWithOddNumbers() {
        return range(1,255,2);
    }
    public int countGreaterThanY(ArrayList<Integer> numbers, int y) {
        int count = 0;
        for (int n : numbers) {
            if (n>y) {
                count++;
            }
        }
        return count;
    }
/** Helper function to sum up an array / list used by getAverage **/
    private int sum(ArrayList<Integer> nums) {


        int total = 0;
        for (int n : nums) {
            total += n;

        }

        return total;
    }

    /** Helper Methods to generate ranges **/
    private ArrayList<Integer> range(int from, int to) {
        return range(from, to, 1);
    }
    private ArrayList<Integer> range(int from, int to, int step) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = from; i<=to; i+=step) {
            result.add(i);

        }

        return result;
    }


    public ArrayList<Integer> shiftArray(ArrayList<Integer> numbers) {

        numbers.remove(0);
        numbers.add(0);


        return numbers;
    }

    public static void main(String[] args) {

        BasicJava basicJava = new BasicJava();
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2,3,4,5));
        ArrayList<Integer> negatives = new ArrayList<>(Arrays.asList(-2, -5, 0, 1));
        ArrayList<Integer> shifted= new ArrayList<>(Arrays.asList(1,5,10,7,-2));


        System.out.println(basicJava.square(al));
        System.out.println(basicJava.shiftArray(shifted));
        System.out.println(basicJava.eliminateNegatives(negatives));
        System.out.println(basicJava.arrayWithOddNumbers());
        System.out.println(Arrays.toString(basicJava.getMaxMinAvg(al)));
        System.out.println(basicJava.countGreaterThanY(al,10));

        basicJava.print1to255();
        basicJava.printOdd1to255();
        basicJava.printArray(al);
        basicJava.printSum();

    }
}