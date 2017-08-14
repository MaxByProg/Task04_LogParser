package Task04_LogParser;

/**
 * Created by mbikov on 14.08.2017.
 */

public class Line {
    private String timestamp;
    private String logger;
    private String body;

    public Line(String timestamp, String logger, String body) {
        this.timestamp = timestamp;
        this.logger = logger;
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLogger() {
        return logger;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Line{" +
                "timestamp='" + timestamp + '\'' +
                ", logger='" + logger + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
