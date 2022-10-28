import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.fail;

public class TestOne {
    @Test
    public void testsValidInputs() {
        try {
            System.out.println("====== Labdhi Jain == TEST ONE EXECUTED =======");
            ReadInput readInputObj = new ReadInput();
        } catch (IOException e){
            System.out.println(e);
        }
    }



}
