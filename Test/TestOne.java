import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import static junit.framework.TestCase.fail;

public class TestOne {
    @Test
    public void testsValidInputs() throws IOException {
        System.out.println("====== Labdhi Jain == TEST ONE EXECUTED =======");
        ReadInput readInputObj = new ReadInput("urinal.dat");
    }

    @Test
    public void testInvalidInput() throws RuntimeException {
        try {
            System.out.println("====== Labdhi Jain == TEST TWO EXECUTED =======");
            ReadInput readInputObj = new ReadInput("./Test/urinalInvalidInput.dat");
        } catch (IOException e) {
            assert Objects.equals(e.getMessage(), "Invalid input");
        }
    }




}
