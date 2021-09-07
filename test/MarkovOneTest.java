import edu.duke.FileResource;
import org.junit.jupiter.api.Test;

import java.util.*;

class MarkovOneTest {

    @Test
    void getFollowsTest() {
        MarkovOne mk1 = new MarkovOne();
        mk1.setTraining("this is a test yes this is a test.");
        ArrayList<String> first = mk1.getFollows("t");
        ArrayList<String> second = mk1.getFollows("e");
        ArrayList<String> third = mk1.getFollows("es");
        ArrayList<String> thurd = mk1.getFollows(".");
        ArrayList<String> fourth = mk1.getFollows("t.");
        for (String x: fourth) {
            System.out.println(x);
        }
    }

    @Test
    void getFollowsWithFileTest() {
        MarkovOne mk1 = new MarkovOne();
        FileResource fr = new FileResource();
        mk1.setTraining(fr.asString());
        ArrayList<String> al = mk1.getFollows("t");
        System.out.println(al.size());
    }
}