public class StringManipulator {
    public String trimAndConcat(String a, String b) {
        return a.trim()+b.trim();
    }
    public Integer getIndexOrNull(String s, char c) {

        if (s.indexOf(c) >= 0)  {
            return s.indexOf(c);
        }
        else {
            return null;
        }
    }

    public String concatSubstring(String one, int start, int end, String two){

        return one.substring(start,end).concat(two);
    }
    public static void main(String[] args) {
        StringManipulatorTest test = new StringManipulatorTest();
        test.run();
    }
    
}

class StringManipulatorTest {
    public void run() {
        StringManipulator sm = new StringManipulator();
        System.out.println(sm.getIndexOrNull("aaa", 'z'));
        System.out.println(sm.trimAndConcat("  Hello ", " World"));
        System.out.println(sm.concatSubstring("Hello", 1,2,"world"));
    }
}