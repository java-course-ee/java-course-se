package edu.javacourse.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class Main {

   public static void main(String[] args) throws ParseException {

      dateRepresentation();
      calendarManupulation();
      parseDate();
      formatDate();
      compareTwoDates();
      dateEquals();

   }

   private static void dateRepresentation() {
      System.out.println("\n\ndateRepresentation: ");
      Date now = new Date();
      System.out.println("Date.toString: " + now);
      System.out.println("Date internal data: " + now.getTime());
   }

   private static void calendarManupulation() {
      System.out.println("\n\ncalendarManupulation: ");
      Date now = new Date();
      System.out.println("Now: " + now);

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(now);

      calendar.add(Calendar.DAY_OF_MONTH, 1);
      System.out.println("Add one day: " + calendar.getTime());

      calendar.add(Calendar.DAY_OF_MONTH, -2);
      System.out.println("Subtract two days: " + calendar.getTime());
   }

   private static void parseDate() throws ParseException {
      System.out.println("\n\nparseDate: ");
      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

      System.out.println("Parsing date '01.02.2019 12:23:41' using pattern 'dd.MM.yyyy HH:mm:ss' assuming it is in UTC");

      Date parsedDate = sdf.parse("01.02.2019 12:23:41");
      System.out.println("Parsed date: " + parsedDate);
   }

   private static void formatDate() {
      System.out.println("\n\nformatDate: ");
      SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
      SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM 'year:'yy HH.mm ss 'sec'");

      Date now = new Date();
      System.out.println("Now date: " + now);
      System.out.println("Formatted date using pattern 'dd.MM.yyyy HH:mm:ss': " + sdf1.format(now));
      System.out.println("Formatted date using pattern 'dd-MM-yyyy': " + sdf2.format(now));
      System.out.println("Formatted date using pattern 'dd.MM 'year:'yy HH.mm ss 'sec'': " + sdf3.format(now));
   }

   private static void compareTwoDates() {
      System.out.println("\n\ncompareTwoDates: ");
      Date now = new Date();
      System.out.println("Now date: " + now);

      Calendar future = Calendar.getInstance();
      future.setTime(now);
      future.add(Calendar.SECOND, 30);
      final Date futureDate = future.getTime();

      Calendar past = Calendar.getInstance();
      past.setTime(now);
      past.add(Calendar.SECOND, -30);
      final Date pastDate = past.getTime();

      System.out.println("Past date: " + pastDate);
      System.out.println("Future date: " + futureDate);

      if (pastDate.before(futureDate)) {
         System.out.println(pastDate + " is before " + futureDate);
      } else {
         System.out.println("Nope");
      }
   }

   private static void dateEquals() {
      System.out.println("\n\ndateEquals: ");
      final Date d1 = new Date(1559918835269L);
      final Date d2 = new Date(1559918835269L);

      if (d1.equals(d2)) {
         System.out.println("Date " + d1 + " is equal to date " + d2);
      } else {
         System.out.println("Nope");
      }
   }

}
