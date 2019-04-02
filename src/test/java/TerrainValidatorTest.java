import junit.framework.Assert;
import org.junit.Test;

public class TerrainValidatorTest {
    @Test
    public void only_GRF_allowed(){
        Assert.assertEquals(false, TerrainValidator.isValid_type("grf"));
        Assert.assertEquals(false, TerrainValidator.isValid_type("ASD"));
        Assert.assertEquals(true, TerrainValidator.isValid_type("GFR"));
    }
    @Test
    public void Data_must_match(){
        Assert.assertEquals(false, TerrainValidator.isValid_size("GRFGRFGRFG",new int[]{3,5}));
        Assert.assertEquals(true, TerrainValidator.isValid_size("GRFGRFGRFG",new int[]{2,5}));
    }
}
