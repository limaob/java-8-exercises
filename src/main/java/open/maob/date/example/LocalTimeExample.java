package open.maob.date.example;

import java.time.LocalTime;

/**
 * @Description: LocalTime仅仅包含时间
 * @Author: limaob
 * @CreateDate: 2019/1/31
 */
public class LocalTimeExample {
    public static void main(String[] args) {
        // 1. 获取当前时间，包含毫秒数 -----打印输出----- 21:03:26.315
        LocalTime localTime = LocalTime.now();
        // 2. 构建时间 -----打印输出----- 12:15:30
        LocalTime localTime1 = LocalTime.of(12, 15, 30);
        // 3. 获取当前时间，不包含毫秒数 -----打印输出----- 21:01:56
        LocalTime localTime2 = localTime.withNano(0);
        // 4. 字符串转为时间，还可以有其他格式，比如12:15, 12:15:23.233
        // -----打印输出----- 12:15:30
        LocalTime localTime3 = LocalTime.parse("12:15:30");
    }
}
