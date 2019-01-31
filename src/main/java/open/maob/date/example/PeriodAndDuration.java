package open.maob.date.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @Description: Period是基于ISO-8601标准的日期系统，用于计算两个日期间的年，月，日的差值
 *               而Duration和Period很像，但Duration计算的是两个日期间的秒，纳秒的值，是一种更为精确的计算方式；
 *               而ISO-8601系统是当今世界大部分地区采用的现代日历的阳历系统。
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class PeriodAndDuration {


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 1, 31);
        LocalDate localDate1 = LocalDate.of(2018, 3, 28);
        LocalDate localDate2 = LocalDate.of(2019, 1, 26);
        //Period localDate1 - localDate  天计算直接相减
        Period period = Period.between(localDate, localDate1);
        // 注意getDays()方法
        System.out.println(period.getDays());  // -3
        System.out.println(period.getMonths());// -10

        Period p = Period.between(localDate1, localDate2);
        System.out.println(p.getDays());  // 29
        System.out.println(p.getMonths());// 9

        // 计算两个日期之间的天数
        System.out.println(localDate1.until(localDate2, ChronoUnit.DAYS));      // 304
        System.out.println(ChronoUnit.DAYS.between(localDate1, localDate2));    // 304

        // Duration
        LocalTime localTime1 = LocalTime.of(12, 12, 12, 111);
        LocalTime localTime2 = LocalTime.of(12, 13, 27, 256);
        Duration duration = Duration.between(localTime1, localTime2);
        System.out.println(duration.getSeconds());  // 75
        System.out.println(duration.getNano());  // 145

    }
}
