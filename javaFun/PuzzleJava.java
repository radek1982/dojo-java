import java.util.*;

public class PuzzleJava {

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String vowels = "AEIOUY";

    public ArrayList<Integer> sumAndGreaterThan10(int... numbers) {

        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }

        System.out.printf("Sum: %d ", sum);

        for (int n : numbers) {
            if (n > 10) {
                res.add(n);
            }
        }

        return res;


    }

    public void tenRandomNumbers() {

        List<Integer> numbers = getRandomNumbers(10, 55, 100);
        Collections.sort(numbers);
        System.out.println(numbers);
        System.out.println("Smallest: " + numbers.get(0));
        System.out.println("Largest: " + numbers.get(numbers.size() - 2));
    }

    private ArrayList<Integer> getRandomNumbers(int count, int bottom, int top) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i< count; i++) {
            Random random = new Random();
            result.add(random.nextInt(top - bottom) + bottom);

        }

        return result;
    }

    public String randomStringOfLength(int length) {
        List<String> random = Arrays.asList(alphabet.split(""));
        String result = "";
        Collections.shuffle(random);

        for (int i =0; i<length; i++) {
            result+=random.get(i);
        }

        return result;

    }
    public ArrayList<String> tenRandom5CharStrings() {

        ArrayList<String> strings = new ArrayList<>();
        for (int i =0; i<10; i++) {

            strings.add(randomStringOfLength(5));

        }

        return strings;
    }
    public void randomAlphabet(){
        List<String> random = Arrays.asList(alphabet.split(""));
        Collections.shuffle(random);
        String first = random.get(0);
        String last = random.get(random.size()-1);

        if (vowels.contains(first)) {
            first = first + " - a vowel!";
        }
        System.out.printf("First: %s Last: %s count %d \n", first, last, random.size() );

    }
    public ArrayList<String> printShuffleAndReturnLongerThan5(ArrayList<String> names) {

        ArrayList<String> result = new ArrayList<>();
        Collections.shuffle(names);


        for (String n: names) {
            String name = n.trim();
            System.out.printf("%s:%d ", name, name.length());
            if (name.length() >5) {
                result.add(n);
            }
        }
        System.out.println("\n" + result);
        return result;
    }


    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>(Arrays.asList(" Nancy,Jinichi,Fujibayashi,Momochi,Ishikawa".split(",")));

        PuzzleJava puzzle = new PuzzleJava();
        puzzle.printShuffleAndReturnLongerThan5(names);
        puzzle.randomAlphabet();

        System.out.println( puzzle.sumAndGreaterThan10(3,5,1,2,7,9,8,13,25,32));
        puzzle.tenRandomNumbers();
        System.out.println(puzzle.randomStringOfLength(5));
        System.out.println(puzzle.tenRandom5CharStrings());




    }
}
