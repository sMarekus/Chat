package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Logging {

  private ArrayList<LogEntry> logEntries;
  private static Logging logging;
  private static final Object lock = new Object();

  private Logging() {
    this.logEntries = new ArrayList<>();
  }

  public static Logging getInstance() {
    if (logging == null) {
      synchronized (lock) {
        if (logging == null) {
          logging = new Logging();
        }
      }
    }
    return logging;
  }

  public void addLogEntry(ChatMessage message) {
    String text = message.getUsername() + ": " + message.getText();
    LogEntry temp = new LogEntry(text);
    logEntries.add(temp);
    System.out.println("Logging: " + temp);
    writeLogToFile(temp);
  }

  public ArrayList<LogEntry> getAllLogs() {
    return logEntries;
  }

  @Override
  public String toString() {
    return "Logging{" + "logEntries=" + logEntries + '}';
  }

  private void writeLogToFile(LogEntry logEntry) {
    if (logEntry == null) {
      return;
    }
    BufferedWriter writer = null;
    try {
      String filename = "Log-" + logEntry.getDateTime().getSortableDate() + ".txt";
      writer = new BufferedWriter(new FileWriter(filename, true));
      writer.write(logEntry + "\n");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}