
package itg8.com.treatpriceapp.home.model.tdaysDeals;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Deals implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("deal")
    @Expose
    @Valid
    private List<Deal> deal = new ArrayList<Deal>();
    public final static Parcelable.Creator<Deals> CREATOR = new Creator<Deals>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Deals createFromParcel(Parcel in) {
            Deals instance = new Deals();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.deal, (itg8.com.treatpriceapp.home.model.tdaysDeals.Deal.class.getClassLoader()));
            return instance;
        }

        public Deals[] newArray(int size) {
            return (new Deals[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The count
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The deal
     */
    public List<Deal> getDeal() {
        return deal;
    }

    /**
     * 
     * @param deal
     *     The deal
     */
    public void setDeal(List<Deal> deal) {
        this.deal = deal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(deal);
    }

    public int describeContents() {
        return  0;
    }

}
