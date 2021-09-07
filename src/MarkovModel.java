import java.util.*;

/**
 * @author Ben Sweeney/dasje
 * @version 01/08/2021
 */

import java.util.Random;

public class MarkovModel extends AbstractMarkovModel {
    private int noChars;

    public MarkovModel(int chars) {
        noChars = chars;
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
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
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();
    }

    public String toString(){
        return "MarkovModel of order Model";
    }
}
