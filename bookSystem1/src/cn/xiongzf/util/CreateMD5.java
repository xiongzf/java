package cn.xiongzf.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by brks on 2017/9/6.
 */
public class CreateMD5 {
//    MD5加密
    public static String getMD5(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte b[] = md.digest();

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];

                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            return buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

            return null;
        }
    }
}
