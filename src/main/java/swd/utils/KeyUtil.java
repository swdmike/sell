package swd.utils;

import java.util.Random;

public class KeyUtil
{
    public static synchronized String genUniqueKey()
    {
        Random random = new Random();

        System.currentTimeMillis();
        Integer num = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(num);
    }



}
