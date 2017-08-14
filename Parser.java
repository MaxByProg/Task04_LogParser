package Task04_LogParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbikov on 14.08.2017.
 */
public class Parser {
    private static List<Line> lines = new ArrayList<>();

    public static void parseLine(List<String> list) {
        String timestamp;
        String logger;
        String body;
        for (String s: list
             ) {
            timestamp = s.trim().substring(s.indexOf('[') + 1, s.indexOf(']'));
            s = s.substring(s.indexOf(']')+1);
            logger = s.trim().substring(s.indexOf('['), s.indexOf(']') - 1);
            s = s.substring(s.indexOf(']')+1);
            body = s.trim();
            lines.add(new Line(timestamp, logger, body));
        }
    }

    public static String parseToXML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<result>\n");
        for (Line l : lines) {
            builder.append("  <element>\n");
            builder.append("    <timestamp>");
            builder.append(l.getTimestamp());
            builder.append("</timestamp>\n");
            builder.append("    <logger>");
            builder.append(l.getLogger());
            builder.append("</logger>\n");
            builder.append("    <body>");
            builder.append(l.getBody());
            builder.append("</body>\n");
            builder.append("  </element>\n");
        }
        builder.append("</result>\n");
        return builder.toString();
    }

    public static List<Line> getLines() {
        return lines;
    }
}
