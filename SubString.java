package Task04_LogParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbikov on 10.08.2017.
 */
public class SubString {
    private static List<String> errorList = new ArrayList<>();

    public void lookingForErrors(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains("error"))
                errorList.add(list.get(i));
            else
                continue;
        }
    }

    public List<String> getErrorList() {
        return errorList;
    }
}
