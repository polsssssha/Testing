import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class Tests {

    @Test(expected = NumberFormatException.class)
    public void Empty() {
        Program.Decode("");
    }

    @Test
    public void FirstPlus(){
        assertEquals(Integer.valueOf(14), Program.Decode("+14"));
    }

    @Test
    public void FirstMinus(){
        assertEquals(Integer.valueOf(-14), Program.Decode("-14"));
    }

    @Test(expected = NumberFormatException.class)
    public void TwoMinus(){
        Program.Decode("--2");
    }

    @Test
    public void NegativeNumber(){
        assertEquals(Integer.valueOf(-2), Program.Decode("-2"));
    }

    @Test
    public void StartsWithNullX(){
        assertEquals(Integer.valueOf(18), Program.Decode("0x12"));
    }

    @Test
    public void StartsWithSharp(){
        assertEquals(Integer.valueOf(18), Program.Decode("#12"));
    }

    @Test
    public void StartsWithNull(){
        assertEquals(Integer.valueOf(13), Program.Decode("015"));
    }

    @Test(expected = NumberFormatException.class)
    public void StrangeThings(){
        Program.Decode("00ss");
    }

    @Test
    public void IntMinValue(){
        String l = String.valueOf(Integer.MIN_VALUE);
        assert(Integer.MIN_VALUE == Program.Decode(l));
    }
}
