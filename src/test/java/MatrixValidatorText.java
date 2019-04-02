import junit.framework.Assert;
import org.junit.Test;

public class MatrixValidatorText {
    @Test
    public void only_two_items_are_allowed(){
        Assert.assertEquals(false, MatrixValidator.has_two_number(new String[]{}));
        Assert.assertEquals(false, MatrixValidator.has_two_number(new String[]{"1"}));
        Assert.assertEquals(false, MatrixValidator.has_two_number(new String[]{"1","w","r"}));
        Assert.assertEquals(true, MatrixValidator.has_two_number(new String[]{"1","w"}));
    }
    @Test
    public void only_between_0to100_are_allowed(){
        Assert.assertEquals(false,MatrixValidator.isSizeInRange(new String[]{"108","808"}));
        Assert.assertEquals(true,MatrixValidator.isSizeInRange(new String[]{"10","80"}));
    }
    @Test
    public void only_number_are_allowed(){
        Assert.assertEquals(false,MatrixValidator.isNumeric("www"));
        Assert.assertEquals(true,MatrixValidator.isNumeric("20"));
    }
}
