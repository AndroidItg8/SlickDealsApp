
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
public class MerchantTypes implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("merchant_type")
    @Expose
    @Valid
    private List<MerchantType> merchantType = new ArrayList<MerchantType>();
    public final static Parcelable.Creator<MerchantTypes> CREATOR = new Creator<MerchantTypes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MerchantTypes createFromParcel(Parcel in) {
            MerchantTypes instance = new MerchantTypes();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.merchantType, (itg8.com.treatpriceapp.home.model.tdaysDeals.MerchantType.class.getClassLoader()));
            return instance;
        }

        public MerchantTypes[] newArray(int size) {
            return (new MerchantTypes[size]);
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
     *     The merchantType
     */
    public List<MerchantType> getMerchantType() {
        return merchantType;
    }

    /**
     * 
     * @param merchantType
     *     The merchant_type
     */
    public void setMerchantType(List<MerchantType> merchantType) {
        this.merchantType = merchantType;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(merchantType);
    }

    public int describeContents() {
        return  0;
    }

}
