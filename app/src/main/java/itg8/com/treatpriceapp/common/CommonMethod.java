package itg8.com.treatpriceapp.common;

import java.net.InetAddress;

/**
 * Created by Android itg 8 on 8/2/2017.
 */

public class CommonMethod {


    public static final String BASE_URL = "http://192.168.1.13/coupon/";
    public static final String SHARED = "SHARED";
    public static final String FOR_EMAIL = "2";
    public static final String FOR_MOBILE = "1";

    public static String FromRegistration="FromRegistration";

    /** check Internet Connection**/

    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }

    }
}
