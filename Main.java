package Task04_LogParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbikov on 10.08.2017.
 */

public class Main implements FilePaths {

    public static void main(String[] args) throws InterruptedException, IOException {

        final int num = 5;
        List<String> list = new ArrayList<>();
        List<String> newList;
        SubString sub = new SubString();
        File myFile = new File(dataFile);
        MultiThread[] threads = new MultiThread[num];

        for (int i = 0; i < num; i++) {
            threads[i] = new MultiThread(myFile, num, i);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        for (int i = 0; i < num; i++) {
            list.addAll(threads[i].getEndList());
        }

        sub.lookingForErrors(list);
        newList = sub.getErrorList();
        Parser.parseLine(newList);
        toXML(Parser.parseToXML());
    }

    private static void toXML(String text) throws IOException {
        FileWriter fr = new FileWriter(new File(xmlFile));
        fr.write(text);
        fr.close();
    }
}

