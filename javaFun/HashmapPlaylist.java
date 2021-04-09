import java.util.HashMap;
import java.util.Locale;

public class HashmapPlaylist {
    private static String titleCase(String str ){
        String[] words = str.split(" ");
        for (int i = 0; i<words.length; i++) {
            words[i] = words[i].substring(0,1).toUpperCase().concat(words[i].substring(1).toLowerCase());
        }

        return String.join(" ", words);
    }
    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("yesterday", "Yesterday, all my troubles seemed so far away");
        trackList.put("norwegian wood", "I once had a girl, or should I say she once had me");
        trackList.put("blackbird", "Blackbird signing in the dead of night");
        trackList.put("help", "When i was younger so much younger than today");

        System.out.println(trackList.get("yesterday"));


        for (String title: trackList.keySet()) {

            System.out.printf("\n%s: %s", titleCase(title), titleCase(trackList.get(title)));
        }
    }
}
