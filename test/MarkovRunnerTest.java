import org.junit.jupiter.api.Test;

class MarkovRunnerTest {

    @Test
    void runMarkovZeroTest() {
        MarkovRunner.runMarkovZero();
    }

    @Test
    void runMarkovOneTest() {
        MarkovRunner.runMarkovOne();
    }

    @Test
    void runMarkovFourTest() {
        MarkovRunner.runMarkovFour();
    }

    @Test
    void runMarkovModelTest() {
        MarkovRunner.runMarkovModel();
    }
}