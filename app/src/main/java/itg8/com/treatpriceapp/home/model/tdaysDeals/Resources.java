
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

    @SerializedName("deal_types")
    @Expose
    @Valid
    private DealTypes dealTypes;
    @SerializedName("brands")
    @Expose
    @Valid
    private Brands brands;
    @SerializedName("merchants")
    @Expose
    @Valid
    private Merchants merchants;
    @SerializedName("categories")
    @Expose
    @Valid
    private Categories categories;
    public final static Parcelable.Creator<Resources> CREATOR = new Creator<Resources>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Resources createFromParcel(Parcel in) {
            Resources instance = new Resources();
            instance.dealTypes = ((DealTypes) in.readValue((DealTypes.class.getClassLoader())));
            instance.brands = ((Brands) in.readValue((Brands.class.getClassLoader())));
            instance.merchants = ((Merchants) in.readValue((Merchants.class.getClassLoader())));
            instance.categories = ((Categories) in.readValue((Categories.class.getClassLoader())));
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
     *     The brands
     */
    public Brands getBrands() {
        return brands;
    }

    /**
     * 
     * @param brands
     *     The brands
     */
    public void setBrands(Brands brands) {
        this.brands = brands;
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
     *     The categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dealTypes);
        dest.writeValue(brands);
        dest.writeValue(merchants);
        dest.writeValue(categories);
    }

    public int describeContents() {
        return  0;
    }

}
