package hello;

import org.joda.time.LocalTime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hello {

    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
        Set<String> lang = new HashSet<String>();
        lang.add("HTML");
        lang.add("CSS");
        lang.add("JAVA");
        System.out.println(lang.size());


        Set<String> frontEnd = new HashSet<>(Arrays.asList("HTML", "CSS", "JS"));
        Set<String> backEnd = new HashSet<>(Arrays.asList("JAVA", "C++", "Ruby", "JS"));

        Set<String> intersection = new HashSet<>(backEnd);
        intersection.retainAll(frontEnd);
        for (String langDisplay : intersection)
            System.out.println("Inter set: " + langDisplay);

        Set<String> union = new HashSet<>(backEnd);
        union.addAll(frontEnd);

        System.out.println("all set: " + union);

        //Tree set
        Set<String> combinedSet = new TreeSet<>(Arrays.asList("JAVA", "C++", "Ruby", "JS"));

        System.out.println("combined set: " + combinedSet);
        combinedSet.addAll(frontEnd);
        System.out.println("combined set 2: " + combinedSet);

        //Map
        Map<String, Integer> langCount = new HashMap<>();
        langCount.put("HTML", 5);
        langCount.put("Java", 2);
        langCount.put("CSS", 4);

        if (langCount.containsKey("HTML")) {
            System.out.println("Has HTML course");
        } else {
            System.out.println("No HTML course");
        }

        //Tree Map
        Map<String, Integer> morelangCount = new TreeMap<>();
        morelangCount.put("HTML", 5);
        morelangCount.put("Java", 2);
        morelangCount.put("CSS", 4);
        morelangCount.put("JavaScript", 10);

        for (Map.Entry<String, Integer> entry : morelangCount.entrySet())
            System.out.format("%d %s courses%n", entry.getValue(), entry.getKey());

        //LinkedHashMap
        Map<String, Integer> linkedTreeelangCount = new LinkedHashMap<>();
        linkedTreeelangCount.put("HTML", 5);
        linkedTreeelangCount.put("Java", 2);
        linkedTreeelangCount.put("CSS", 4);
        linkedTreeelangCount.put("JavaScript", 10);

        for (Map.Entry<String, Integer> entry : linkedTreeelangCount.entrySet())
            System.out.format("%d %s courses%n", entry.getValue(), entry.getKey());

        //ArrayList
        List<String> langLists = new ArrayList<>();
        langLists.add("Java");
        langLists.add("HTML");
        langLists.add("CSS");
        langLists.add("GoLang");

        for (String langList : langLists)
            System.out.println("LangList: " + langList);

        System.out.println("LangLists index: " + langLists.indexOf("Java"));
        System.out.println("LangLists getindex: " + langLists.get(2));


        boolean removedMedium = langLists.remove("Java");
        System.out.println("Removed lang result: " + removedMedium);
        System.out.println(langLists);

        List<String> urlList = new ArrayList<>();
        urlList.add("https://pluralsight.com/search?q=java");
        urlList.add("https://medium.com/search?q=java");
        urlList.add("https://stackoverflow.com/questions/tagged/java");
        urlList.add("https://stackoverflow.com/search?q=java+list");
        urlList.add("https://reddit.com/r/java");
        urlList.add("https://reddit.com/r/javahelp");
        urlList.sort(null);

        List<String> firstTwo = urlList.subList(0, 2);
        int remaining = urlList.size() - 2;
        System.out.println(firstTwo);
        System.out.println("And " + remaining + " more.");
        List<String> remainingUrls = urlList.subList(2, urlList.size());
        System.out.println(remainingUrls);


        //File read and filter;
        BufferedReader bufferedReader = null;
        String fileName = "test/filename.txt";
        String line = "";
        List<String> hashTags = new ArrayList<String>();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.contains("#")) {
                        word = word.replaceAll("^[^#]*", "");
                        if (!hashTags.contains(word)) {
                            hashTags.add(word);
                        }
                    }
                }
            }

            hashTags.sort(String::compareTo);

            System.out.println(hashTags.size());
            for (String hashTag : hashTags) {
                System.out.println(hashTag);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
