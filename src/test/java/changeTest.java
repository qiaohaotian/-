import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class changeTest {
    @Test
    public void assertChangeToChar() {

        List<String> input = new ArrayList<String>();
        input.add("11");
        input.add("22");
        char[][] result = Change.changeToChar(input);
        assertEquals('2', result[1][1]);
    }
    @Test
    public void replaceW_Test(){
        List<String> input = new ArrayList<String>();
        input.add("GGGG");
        input.add("GGGG");
        input.add("GGDG");
        input.add("GGGG");
        assertEquals("GWWW",Change.replaceW(input).get(3));
    }
    @Test
    public void get_D_test(){
        List<String> input = new ArrayList<String>();
        input.add("GGGG");
        input.add("GGGG");
        input.add("GGDG");
        input.add("GGGG");
        char[][] result=Change.changeToChar(input);
        List<Pair> pair = new ArrayList<Pair>();
        assertEquals(2,Change.get_D_coordinate(result).get(0).getValue());

    }
    @Test
    public void normalreplacetest(){
        List<String> input = new ArrayList<String>();
        input.add("GRRGGG");
        input.add("FFRDGG");
        input.add("FFRGGF");
        input.add("FFRRGF");
        char[][] result=Change.changeToChar(input);
        List<Pair> pairList = new ArrayList<Pair>();
        pairList = Change.get_D_coordinate(result);

        assertEquals('W',Change.nomalreplace(result,pairList)[1][2]);
    }

}
