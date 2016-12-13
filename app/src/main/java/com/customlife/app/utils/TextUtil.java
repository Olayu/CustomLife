package com.customlife.app.utils;

import com.customlife.app.AppContext;

import java.io.InputStream;
import java.text.DecimalFormat;

import cz.msebera.android.httpclient.util.EncodingUtils;

/**
 * Created by zhangbin on 2016/10/20.
 */

public class TextUtil {
    /**
     * unicode转中文
     * @param unicodeStr
     * @return
     */
    public static String decode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuffer retBuf = new StringBuffer();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))
                    try {
                        retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        retBuf.append(unicodeStr.charAt(i));
                    }
                else
                    retBuf.append(unicodeStr.charAt(i));
            } else {
                retBuf.append(unicodeStr.charAt(i));
            }
        }
        return retBuf.toString();
    }

    public static DecimalFormat getDecimalFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
        return decimalFormat;
    }

    public static int IntWrapper(String s, int defaultn)
    {

        try
        {
            return Integer.parseInt(s);
        }
        catch(Exception e)
        {
            return defaultn;
        }
    }

    public static String readFromRaw(int fileInRaw) {
        String res = "";
        try {
            InputStream in = AppContext.context().getResources().openRawResource(fileInRaw);
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            res = EncodingUtils.getString(buffer, "UTF-8");
            // res = new String(buffer,"GBK");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
