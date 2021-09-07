import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkovRunnerWithInterfaceTest {

    @Test
    void runMarkovTest() {
        MarkovRunnerWithInterface.runMarkov();
    }

    @Test
    void hashMapTest() {
        String text = "yes-this-is-a-thin-pretty-pink-thistle";
        EfficientMarkovModel emm = new EfficientMarkovModel(2);
        MarkovRunnerWithInterface.runModel(emm, text, 50, 42);
    }
}