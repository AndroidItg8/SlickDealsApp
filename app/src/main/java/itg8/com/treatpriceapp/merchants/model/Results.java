
package itg8.com.treatpriceapp.merchants.model;

import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Results implements Parcelable
{

    @SerializedName("merchant_types")
    @Expose
    @Valid
    private MerchantTypes merchantTypes;
    public final static Parcelable.Creator<Results> CREATOR = new Creator<Results>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Results createFromParcel(Parcel in) {
            Results instance = new Results();
            instance.merchantTypes = ((MerchantTypes) in.readValue((MerchantTypes.class.getClassLoader())));
            return instance;
        }

        public Results[] newArray(int size) {
            return (new Results[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The merchantTypes
     */
    public MerchantTypes getMerchantTypes() {
        return merchantTypes;
    }

    /**
     * 
     * @param merchantTypes
     *     The merchant_types
     */
    public void setMerchantTypes(MerchantTypes merchantTypes) {
        this.merchantTypes = merchantTypes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(merchantTypes);
    }

    public int describeContents() {
        return  0;
    }

}
