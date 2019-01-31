package open.maob.date.example;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @Description: 这个是个枚举类型，实现功能类型Period和Duration,它的底层实现基本是基于Duration来实现的。
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class ChronoUnitExample {

    public static void main(String[] args) {

        LocalDateTime oldDate = LocalDateTime.of(2018,1,31,12,12,12);
        LocalDateTime newDate = LocalDateTime.of(2019, Month.JUNE,22,10,11,55);
        System.out.println(oldDate);
        System.out.println(newDate);
        // count between dates
        long years = ChronoUnit.YEARS.between(oldDate, newDate);
        long months = ChronoUnit.MONTHS.between(oldDate, newDate);
        long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
        long days = ChronoUnit.DAYS.between(oldDate, newDate);
        long hours = ChronoUnit.HOURS.between(oldDate, newDate);
        long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
        long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
        long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
        long nano = ChronoUnit.NANOS.between(oldDate, newDate);

        System.out.println("\n--- Total --- ");
        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milis + " milis");
        System.out.println(nano + " nano");
    }
}
