package itg8.com.treatpriceapp.newcategory.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android itg 8 on 8/11/2017.
 */

public class ChildClass {

    public String getSecondHeader() {
        return secondHeader;
    }

    public void setSecondHeader(String secondHeader) {
        this.secondHeader = secondHeader;
    }

    public List<String> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<String> secondList) {
        this.secondList = secondList;
    }

    private  String secondHeader;
    private List<String> secondList = new ArrayList<>();
}
