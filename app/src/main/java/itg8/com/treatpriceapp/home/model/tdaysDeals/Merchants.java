
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
public class Merchants implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("merchant")
    @Expose
    @Valid
    private List<Merchant> merchant = new ArrayList<Merchant>();
    public final static Parcelable.Creator<Merchants> CREATOR = new Creator<Merchants>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Merchants createFromParcel(Parcel in) {
            Merchants instance = new Merchants();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.merchant, (itg8.com.treatpriceapp.home.model.tdaysDeals.Merchant.class.getClassLoader()));
            return instance;
        }

        public Merchants[] newArray(int size) {
            return (new Merchants[size]);
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
     *     The merchant
     */
    public List<Merchant> getMerchant() {
        return merchant;
    }

    /**
     * 
     * @param merchant
     *     The merchant
     */
    public void setMerchant(List<Merchant> merchant) {
        this.merchant = merchant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(merchant);
    }

    public int describeContents() {
        return  0;
    }

}
