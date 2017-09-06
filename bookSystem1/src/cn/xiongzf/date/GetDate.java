package cn.xiongzf.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brks on 2017/9/5.
 */
public class GetDate {
    //获取当前时间
    public static String getNowDate() {
        String date;
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.format(nowDate);
        return date;
    }
}
