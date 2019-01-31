package open.maob.date.example;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Description:  时钟系统，用于查找当前时刻。通过指定一个时区，我们可以获取到当前的时刻，日期，时间 可使用代替：System.currenttimemillis() 和 TimeZone.getDefault()。
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class ClockExample {


    public static void main(String[] args) {
        // 系统默认
        Clock systemDefaultClock = Clock.systemDefaultZone();
        System.out.println("Current DateTime with system default clock: " + LocalDateTime.now(systemDefaultClock));
        System.out.println(systemDefaultClock.millis());

        // 世界协调时UTC
        Clock systemUTCClock = Clock.systemUTC();
        System.out.println("Current DateTime with UTC clock: " + LocalDateTime.now(systemUTCClock));
        System.out.println(systemUTCClock.millis());

        // paris
        Clock clock = Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
        System.out.println("Current DateTime with ECT clock: " + LocalDateTime.now(clock));
        System.out.println(clock.millis());
    }
}
