package fi.joufa.databaserepository.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFactory {
  public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  public static Date convertToDate(LocalDateTime dateToConvert) {
    return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }
}
