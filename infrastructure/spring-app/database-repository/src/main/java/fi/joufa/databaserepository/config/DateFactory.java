package fi.joufa.databaserepository.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFactory {

  /**
   * Converts a Date object to LocalDateTime object
   *
   * @param dateToConvert Date
   * @return date as LocalDateTime
   */
  public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  /**
   * Converts a LocalDateTime object to Date object
   *
   * @param dateToConvert LocalDateTime
   * @return Date Date object
   */
  public Date convertToDate(LocalDateTime dateToConvert) {
    return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }
}
