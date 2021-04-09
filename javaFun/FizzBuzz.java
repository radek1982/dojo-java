public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzzTest fbt = new FizzBuzzTest();
        fbt.run();
    }
    public String fizzBuzz(int number) {

    String res = "";

    if (number % 3 == 0 || number % 5 == 0 ) {
        if (number % 3 == 0) {
            res = res + "Fizz";
        }

        if (number % 5 == 0 ) {
            res = res + "Buzz";
        
        }
 } else {
     res = "" + number;
 }

    return res;


    }
    
}


class FizzBuzzTest {
   FizzBuzz fb = new FizzBuzz();
    public void run() {
        System.out.println(fb.fizzBuzz(3));
        System.out.println(fb.fizzBuzz(5));
        System.out.println(fb.fizzBuzz(15));
        System.out.println(fb.fizzBuzz(2));
        
        
        


   }
}