package itg8.com.treatpriceapp.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

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





    public class LastModel{
        String lastItem;

        public LastModel(String lastItem) {
            this.lastItem = lastItem;
        }

        public String getLastItem() {
            return lastItem;
        }

        public void setLastItem(String lastItem) {
            this.lastItem = lastItem;
        }
    }

    public class MiddleItem{
        String middleHeader;
        List<String> models;

        public boolean isMiddleHeader() {
            return isMiddleHeader;
        }

        public void setMiddleHeader(boolean middleHeader) {
            isMiddleHeader = middleHeader;
        }

        boolean isMiddleHeader;

        public String getMiddleHeader() {
            return middleHeader;
        }

        public void setMiddleHeader(String middleHeader) {
            this.middleHeader = middleHeader;
        }

        public List<String> getModels() {
            return models;
        }

        public void setModels(List<String> models) {
            this.models = models;
        }
    }

    public class TopItem{
        String topHeader;
        List<MiddleItem> models;

        public TopItem() {
        }

        public TopItem(String topHeader, List<MiddleItem> models) {
            this.topHeader = topHeader;
            this.models = models;
        }

        public String getTopHeader() {
            return topHeader;
        }

        public void setTopHeader(String topHeader) {
            this.topHeader = topHeader;
        }

        public List<MiddleItem> getModels() {
            return models;
        }

        public void setModels(List<MiddleItem> models) {
            this.models = models;
        }
    }


    public List<TopItem> getGeneratedList(){
        List<TopItem> items=new ArrayList<>();
        for(int i=1; i<=5; i++){
            TopItem item=new TopItem();
            item.setTopHeader("TopHeader "+i);
            List<MiddleItem> middleItems=new ArrayList<>();
            for(int j=1; j<=5; j++){
                MiddleItem middleItem=new MiddleItem();
                middleItem.setMiddleHeader("TopHeader"+i+"-"+"MiddleHeader "+j);
                List<String> lastItems=new ArrayList<>();
                for(int k=1; k<5; k++){
                    lastItems.add("TopHeader"+i+"-"+"MiddleHeader "+j+" lastItem "+k);
                }
                middleItem.setModels(lastItems);
                middleItems.add(middleItem);
            }
            item.setModels(middleItems);
            items.add(item);
        }
        return items;
    }
}
