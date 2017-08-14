package Task04_LogParser;

/**
 * Created by mbikov on 10.08.2017.
 */

import java.io.*;
import java.util.*;

class MultiThread extends Thread implements FilePaths {
    private BufferedReader br;
    private static File file;
    private int start;
    private int num;
    private List<String> endList;

    MultiThread(File file, int num, int start) {
        try {
            this.file = file;
            br = new BufferedReader(new FileReader(file));
            this.start = start;
            this.num = num;
            endList = new ArrayList<>();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized List<String> getEndList() {
        return endList;
    }

    public void run() {
        String line;
        long count = 0;
        try {
            if(start > 0 && start < num)
                br.skip(start * (file.length() / num));
            else if(num == 1) {
                while ((line = br.readLine()) != null && count < file.length()) {
                    endList.add(line);
                    count += line.length();
                }
            }
            while ((line = br.readLine()) != null && count < file.length() / num) {
                if(line.startsWith("["))
                    endList.add(line);
                count += line.length();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

}

