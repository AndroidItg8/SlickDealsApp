
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
public class DealTypes implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("deal_type")
    @Expose
    @Valid
    private List<DealType> dealType = new ArrayList<DealType>();
    public final static Parcelable.Creator<DealTypes> CREATOR = new Creator<DealTypes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DealTypes createFromParcel(Parcel in) {
            DealTypes instance = new DealTypes();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.dealType, (itg8.com.treatpriceapp.home.model.tdaysDeals.DealType.class.getClassLoader()));
            return instance;
        }

        public DealTypes[] newArray(int size) {
            return (new DealTypes[size]);
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
     *     The dealType
     */
    public List<DealType> getDealType() {
        return dealType;
    }

    /**
     * 
     * @param dealType
     *     The deal_type
     */
    public void setDealType(List<DealType> dealType) {
        this.dealType = dealType;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(dealType);
    }

    public int describeContents() {
        return  0;
    }

}
