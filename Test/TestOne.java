import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
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

    @Test
    public void testsFilePresent() throws RuntimeException, IOException {
        try {
            System.out.println("====== Labdhi Jain == TEST THREE EXECUTED =======");
            ReadInput readInputObj = new ReadInput("urinal.dat");
        } catch (RuntimeException e) {
            assert Objects.equals(e.getMessage(), "No Input File Present");
        }
    }


    @Test
    public void testFileNotPresent() throws IOException {
        try {
            System.out.println("====== Labdhi Jain == TEST FOUR EXECUTED =======");
            ReadInput readInputObj = new ReadInput("urinal1.dat");
        } catch (RuntimeException e) {
            assert Objects.equals(e.getMessage(), "No Input File Present");
        }
    }

    @Test
    public void outputFileCheck() throws IOException {
        List<String> listOfOutputs = new ArrayList<String>();
        List<String> expectedOp = new ArrayList<String>();
        ReadInput readInputObj = new ReadInput("urinal.dat");
        try {
            System.out.println("====== Labdhi Jain == TEST FIVE EXECUTED =======");
            File opFile = new File("rule.txt");
            Scanner sr = null;
            try{
                sr= new Scanner(new FileReader(opFile));

            } catch (FileNotFoundException e){
                System.out.println(e);
            }
            while (sr.hasNextLine()){
                String eachLine = sr.nextLine();
                listOfOutputs.add(eachLine);
            }
            expectedOp.add("-1");
            expectedOp.add("2");
            expectedOp.add("0");
            expectedOp.add("-1");
            assertEquals(expectedOp,listOfOutputs);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void checkDupFile() throws IOException {
        List<String> listOfOutputs = new ArrayList<String>();
        List<String> expectedOp = new ArrayList<String>();
        try {
            System.out.println("====== Labdhi Jain == TEST SIX EXECUTED =======");
            ReadInput readInputObj = new ReadInput("urinal.dat");
            ReadInput readInputObj2 = new ReadInput("urinal.dat");

            File opFile = new File("rule1.txt");
            Scanner sr = null;
            try{
                sr= new Scanner(new FileReader(opFile));

            } catch (FileNotFoundException e){
                System.out.println(e);
            }
            while (sr.hasNextLine()){
                String eachLine = sr.nextLine();
                listOfOutputs.add(eachLine);
            }
            expectedOp.add("-1");
            expectedOp.add("2");
            expectedOp.add("0");
            expectedOp.add("-1");
            assertEquals(expectedOp,listOfOutputs);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkUrinalCount() throws IOException {
        try {
            System.out.println("====== Labdhi Jain == TEST SEVEN EXECUTED =======");
            ReadInput readInputObj = new ReadInput("urinal.dat");
            List<Integer> expectedCount = new ArrayList<Integer>();
            expectedCount.add(-1);
            expectedCount.add(2);
            expectedCount.add(0);
            expectedCount.add(-1);
            assertEquals(expectedCount,readInputObj.listOfOutputs);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

}