
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Ben Sweeney/dasje
 * @version 15/07/2021
 */

import edu.duke.*;

public class MarkovRunner {
    public static void runMarkovZero() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(101);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public static void runMarkovOne() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		System.out.println("Runner - Converted to string");
		st = st.replace('\n', ' ');
		System.out.println("Runner - replaced new lines");
		MarkovOne markov = new MarkovOne();
		System.out.println("Runner - created markovone object");
		markov.setRandom(42);
		System.out.println("Runner - set random seed to 42");
		markov.setTraining(st);
		System.out.println("Runner - set training text");
		String text = markov.getRandomText(100);
		printOut(text);
	}

	public static void runMarkovFour() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		System.out.println("Runner - Converted to string");
		st = st.replace('\n', ' ');
		System.out.println("Runner - replaced new lines");
		MarkovFour markov = new MarkovFour();
		System.out.println("Runner - created markovone object");
		markov.setRandom(25);
		System.out.println("Runner - set random seed to 42");
		markov.setTraining(st);
		System.out.println("Runner - set training text");
		String text = markov.getRandomText(100);
		printOut(text);
	}

	public static void runMarkovModel() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		System.out.println("Runner - Converted to string");
		st = st.replace('\n', ' ');
		System.out.println("Runner - replaced new lines");
		MarkovModel markov = new MarkovModel(6);
		System.out.println("Runner - created markovone object");
		markov.setRandom(38);
		System.out.println("Runner - set random seed to 42");
		markov.setTraining(st);
		System.out.println("Runner - set training text");
		String text = markov.getRandomText(100);
		printOut(text);
	}

	private static void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
