
package itg8.com.treatpriceapp.home.model.tdaysDeals;

import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Resources implements Parcelable
{

    @SerializedName("countries")
    @Expose
    @Valid
    private Countries countries;
    @SerializedName("deal_types")
    @Expose
    @Valid
    private DealTypes dealTypes;
    @SerializedName("merchants")
    @Expose
    @Valid
    private Merchants merchants;
    @SerializedName("merchant_types")
    @Expose
    @Valid
    private MerchantTypes merchantTypes;
    @SerializedName("networks")
    @Expose
    @Valid
    private Networks networks;
    public final static Parcelable.Creator<Resources> CREATOR = new Creator<Resources>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Resources createFromParcel(Parcel in) {
            Resources instance = new Resources();
            instance.countries = ((Countries) in.readValue((Countries.class.getClassLoader())));
            instance.dealTypes = ((DealTypes) in.readValue((DealTypes.class.getClassLoader())));
            instance.merchants = ((Merchants) in.readValue((Merchants.class.getClassLoader())));
            instance.merchantTypes = ((MerchantTypes) in.readValue((MerchantTypes.class.getClassLoader())));
            instance.networks = ((Networks) in.readValue((Networks.class.getClassLoader())));
            return instance;
        }

        public Resources[] newArray(int size) {
            return (new Resources[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The countries
     */
    public Countries getCountries() {
        return countries;
    }

    /**
     * 
     * @param countries
     *     The countries
     */
    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    /**
     * 
     * @return
     *     The dealTypes
     */
    public DealTypes getDealTypes() {
        return dealTypes;
    }

    /**
     * 
     * @param dealTypes
     *     The deal_types
     */
    public void setDealTypes(DealTypes dealTypes) {
        this.dealTypes = dealTypes;
    }

    /**
     * 
     * @return
     *     The merchants
     */
    public Merchants getMerchants() {
        return merchants;
    }

    /**
     * 
     * @param merchants
     *     The merchants
     */
    public void setMerchants(Merchants merchants) {
        this.merchants = merchants;
    }

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

    /**
     * 
     * @return
     *     The networks
     */
    public Networks getNetworks() {
        return networks;
    }

    /**
     * 
     * @param networks
     *     The networks
     */
    public void setNetworks(Networks networks) {
        this.networks = networks;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(countries);
        dest.writeValue(dealTypes);
        dest.writeValue(merchants);
        dest.writeValue(merchantTypes);
        dest.writeValue(networks);
    }

    public int describeContents() {
        return  0;
    }

}
