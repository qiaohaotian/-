import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExcutionTest {
    @Test
    public void testcase_1(){
        List<String> expected = getExpected();
        List<String> result=Main.execute( "4 6","GRRGGGGGDRFFFFRGGFFGRRDD");
        assertEqual(expected,result);
    }

    private void assertEqual(List<String> expected, List<String> result) {
        for(int i=0;i<result.size();i++)
            Assert.assertEquals(expected.get(i),result.get(i));
    }

    private List<String> getExpected() {
        List<String> result=new ArrayList<String>();
        result.add("GRWWWG");
        result.add("FFWDWG");
        result.add("WWWWWF");
        result.add("DDWRGF");
        return result;
    }

}
