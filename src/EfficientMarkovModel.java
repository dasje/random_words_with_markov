import java.util.*;

/**
 * @author Ben Sweeney/dasje
 * @version 01/08/2021
 */

import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private int noChars;
    private HashMap<String, ArrayList> seenPrev;

    public EfficientMarkovModel(int chars) {
        noChars = chars;
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);

    }

    public void setTraining(String s){
        seenPrev = new HashMap<String, ArrayList>();
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - noChars);
        String key = myText.substring(index, index + noChars);
        sb.append(key);
        for(int k = 0; k < numChars - noChars; k++){
            buildMap(key);
            ArrayList<String> follows = seenPrev.get(key);
            if (follows == null) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        printHashMapInfo();
        return sb.toString();
    }

    public void buildMap(String key) {
        //check if key in dict
        if (! seenPrev.containsKey(key)) {
            //if key not in dict, call getfollows
            ArrayList<String> follows = getFollows(key);
            //if (follows.size() != 0) {
                //add key and follows to dict
            seenPrev.put(key, follows);
            //}
        }
    }

    public void printHashMapInfo(){
        //number of keys in HashMap
        System.out.println("seenPrev has " + seenPrev.size() + " keys");
        for (String key: seenPrev.keySet()) {
            System.out.println(key + " - " + seenPrev.get(key));
        }

        //maximum number of keys following a key
        String name = new String();
        ArrayList<String> largest = new ArrayList<>();
        for (String key: seenPrev.keySet()) {
            if (seenPrev.get(key).size() > largest.size()) {
                name = key;
                largest = seenPrev.get(key);
            }
        }
        System.out.println("largest value in seenPrev is " + largest.size());

        //print keys with largest arraylists
        ArrayList<String> largestKeys = new ArrayList<>();
        for (String key: seenPrev.keySet()) {
            if (seenPrev.get(key).size() == largest.size()) {
                largestKeys.add(key);
            }
        }
        System.out.println("Largest sized keys are: ");
        for (String key: largestKeys) {
            System.out.println(key);
        }
    }

    public String toString(){
        return "EfficientMarkovModel of order Model";
    }
}
