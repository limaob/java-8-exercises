package open.maob.date.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description: LocalDate仅仅包含日期
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class LocalDateExample {

    public static void main(String[] args) {
        // 1。 获取当前时间   格式 2019-01-31
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        // 2. 根据年月日构建Date ----打印输出-----2019-01-30
        LocalDate localDate1 = LocalDate.of(2019, 01, 30);
        // 3. 字符串转换日期,默认按照yyyy-MM-dd格式，也可以自定义格式 -----打印输出-----2019-01-30
        LocalDate localDate2 = LocalDate.parse("2019-01-30");
        // 4. 获取本月第一天 -----打印输出-----2019-01-01
        LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        // 5. 获取本月第二天  -----打印输出-----2019-01-02
        LocalDate secondDayOfMonth = localDate.withDayOfMonth(2);
        // 6. 获取本月最后一天 -----打印输出-----2019-01-31
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        // 7. 明天 -----打印输出----- 2019-01-30
        LocalDate tomorrowDay = localDate.plusDays(1L);
        // 8. 昨天 -----打印输出----- 2019-01-28
        LocalDate yesterday = localDate.minusDays(1L);
        // 9. 获取本年第12天 -----打印输出----- 2019-04-30
        LocalDate day = localDate.withDayOfYear(120);
        // 10. 计算两个日期间的天数
        long days = localDate.until(localDate1, ChronoUnit.DAYS);
        System.out.println(days);
        // 11. 计算两个日期间的周数
        long weeks = localDate.until(localDate1, ChronoUnit.WEEKS);
        System.out.println(weeks);
    }
}
