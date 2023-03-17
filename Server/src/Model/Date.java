package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date
{
  private LocalDateTime customTime;

  public Date() {
    this.customTime = LocalDateTime.now();
  }

  public String getFormattedTimestamp() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return customTime.format(formatter);
  }

  public String getSortableDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return customTime.format(formatter);
  }

  @Override
  public String toString() {
    return getFormattedTimestamp();
  }
}
