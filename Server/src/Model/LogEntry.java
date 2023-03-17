package Model;

public class LogEntry {
  private String logText;
  private Date dateTime;

  public LogEntry(String logText) {
    this.logText = logText;
    this.dateTime = new Date();
  }

  public String getLogText() {
    return logText;
  }

  public Date getDateTime() {
    return dateTime;
  }

  @Override
  public String toString() {
    return dateTime + ": " + logText;
  }
}
