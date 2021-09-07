
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected static String myText;
    protected static Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);

    protected static ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (myText.substring(pos).indexOf(key) > -1) {
            int index = myText.substring(pos).indexOf(key);
            if (index == -1) {
                break;
            } else {
                try {
                    follows.add(String.valueOf(myText.charAt(pos + index + key.length())));
                } catch (Exception e) {
                    ;
                }
            }
            pos = pos + index + key.length();
        }
        return follows;
    }

}
