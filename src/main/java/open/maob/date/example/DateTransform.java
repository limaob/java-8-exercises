package open.maob.date.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Description:  java.util.Date与LocalDate，LocalTime，LocalDateTime替换
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class DateTransform {


    public static void main(String[] args) {
        dateToLocal();
        localToDate();
    }

    private static void localToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: " + localDateTime);

        // LocalDateTime -> Date
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime -> current date: " + date);

        // LocalDate -> Date，时间默认都是00
        LocalDate localDate = LocalDate.now();
        date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDate -> current date: " + date);
    }


    public static void dateToLocal(){
        Date date = new Date();
        System.out.println("current date: " + date);

        // Date -> LocalDateTime
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime by Instant: " + localDateTime);

        // Date -> LocalDate
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("localDate by Instant: " + localDate);
        // Date -> LocalTime
        LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        System.out.println("localTime by Instant: " + localTime);

        //2. Date -> LocalDateTime
        localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("localDateTime by ofInstant: " + localDateTime);

    }
}
