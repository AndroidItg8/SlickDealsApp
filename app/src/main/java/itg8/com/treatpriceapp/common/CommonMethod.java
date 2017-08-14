package itg8.com.treatpriceapp.common;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;

import java.util.ArrayList;
import java.util.List;
import java.nio.channels.FileChannel;

import itg8.com.treatpriceapp.BuildConfig;

/**
 * Created by Android itg 8 on 8/2/2017.
 */

public class CommonMethod {


    public static final String BASE_URL = "http://192.168.1.13/coupon/";
    public static final String SHARED = "SHARED";
    public static final String FOR_EMAIL = "2";
    public static final String FOR_MOBILE = "1";
    public static final int P_SHOP = 1;
    public static final int O_SHOP = 2;
    public static final String P_BASE_URL = "http://api.popshops.com/v3/";
    public static final String APIA ="65og5t3ou58puelfx0g84mxto";
    public static final String APIC ="850dviorepytjfvesvgn2j5re";
    public static final String PRODUCT_DESC = "product_desc";
    public static final String PRODUCT_RESOURCE = "product_resources";
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


    public static void exportDatabse(String databaseName, Context context) {
        try {
//            completeFileStructure = new File(Environment.getExternalStorageDirectory() + File.separator + "nowzone", "sleep_cal.txt");

            File sd = new File(Environment.getExternalStorageDirectory() , "treatPrice");
            if(!sd.exists()){
                sd.mkdir();
                sd = new File(Environment.getExternalStorageDirectory() , "treatPrice"+ File.separator + "db");
                if(!sd.exists()){
                    sd.mkdir();
                }
            }
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//" + context.getPackageName() + "//databases//" + databaseName + "";
                String backupDBPath = "tp1.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
