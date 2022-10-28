import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInput {
    public List<String> listOfInputs = new ArrayList<String>();
    public List<Integer> listOfOutputs = new ArrayList<Integer>();

    ReadInput(String fileName) throws IOException {
        readInput(fileName);
    }

    public void readInput(String fileName) throws IOException {
        DataInputStream inputFile = null;
        try {
            inputFile = new DataInputStream(new FileInputStream(
                    fileName));
            do {
                String x = String.valueOf(inputFile.readLine());
                if (!x.contains("0") && !x.contains("1")) {
                    throw new IOException("Invalid input");
                }
                listOfInputs.add(x);
            } while (inputFile.available() > 0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No Input File Present");
        }
        try {
            inputFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(listOfInputs);
        countUrinals();
    }

    private void countUrinals() {
        int freeUrinals;
        for (String i : listOfInputs) {
            freeUrinals = 0;
            for (int j = 0; j < i.length(); j++) {
                if (i.charAt(j) == '0') {
                    if ((j - 1 >= 0 && i.charAt(j - 1) == '0') && (j + 1 < i.length() && i.charAt(j + 1) == '0')) {
                        freeUrinals++;
                    }
                } else {
                    if ((j - 1 >= 0 && i.charAt(j - 1) == '1') || (j + 1 < i.length() && i.charAt(j + 1) == '1')) {
                        freeUrinals = -1;
                        break;
                    }
                }
            }
            listOfOutputs.add(freeUrinals);
//            System.out.println(freeUrinals);
        }
        System.out.println(listOfOutputs);
        createFile();

    }

    private void createFile() {
        int count = 0;
        try {
            File myObj = new File("rule.txt");
            while (!myObj.createNewFile()) {
                count++;
                myObj = new File("rule" + count + ".txt");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        writeToFile(count);
    }

    private void writeToFile(int count) {
        FileWriter myWriter = null;
        try {
            if (count != 0) {
                myWriter = new FileWriter("rule" + count + ".txt");
            } else {
                myWriter = new FileWriter("rule.txt");
            }
            for (int k = 0; k < listOfOutputs.size(); k++) {
                myWriter.write(listOfOutputs.get(k).toString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
