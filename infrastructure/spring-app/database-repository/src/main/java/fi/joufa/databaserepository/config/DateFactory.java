package fi.joufa.databaserepository.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFactory {

  private DateFactory() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Converts a Date object to LocalDateTime object
   *
   * @param dateToConvert Date
   * @return date as LocalDateTime
   */
  public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  /**
   * Converts a LocalDateTime object to Date object
   *
   * @param dateToConvert LocalDateTime
   * @return Date Date object
   */
  public static Date convertToDate(LocalDateTime dateToConvert) {
    return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }
}
