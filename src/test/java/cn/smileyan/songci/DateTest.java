package cn.smileyan.songci;

import java.util.Calendar;
import java.util.Random;

public class DateTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int seed = instance.get(Calendar.DAY_OF_YEAR);

        // 3.获得随机数
        Random random = new Random(seed);
        long id = (Math.abs(random.nextLong())%221) + 1;
        System.out.println(id);
    }
}
