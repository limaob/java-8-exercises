package open.maob.date.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class TemporalAdjustersExample {


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        // 1. 本月第一天
        LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        // 2. 本月最后一天
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        // 3. 本年第一天
        LocalDate firstDayOfYear = localDate.with(TemporalAdjusters.firstDayOfYear());
        // 4. 下个月第一天
        LocalDate firstDayOfNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        // 5. 本年度最后一天
        LocalDate lastDayOfYear = localDate.with(TemporalAdjusters.lastDayOfYear());
        // 6。 下周一
        LocalDate date = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(firstDayOfMonth);
        System.out.println(lastDayOfMonth);
        System.out.println(firstDayOfYear);
        System.out.println(firstDayOfNextMonth);
        System.out.println(lastDayOfYear);
        System.out.println(date);
    }
}
