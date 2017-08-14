
package itg8.com.treatpriceapp.home.model.tdaysDeals;

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

    @SerializedName("products")
    @Expose
    @Valid
    private Products products;
    @SerializedName("deals")
    @Expose
    @Valid
    private Deals deals;
    public final static Parcelable.Creator<Results> CREATOR = new Creator<Results>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Results createFromParcel(Parcel in) {
            Results instance = new Results();
            instance.products = ((Products) in.readValue((Products.class.getClassLoader())));
            instance.deals = ((Deals) in.readValue((Deals.class.getClassLoader())));
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
     *     The products
     */
    public Products getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The products
     */
    public void setProducts(Products products) {
        this.products = products;
    }

    /**
     * 
     * @return
     *     The deals
     */
    public Deals getDeals() {
        return deals;
    }

    /**
     * 
     * @param deals
     *     The deals
     */
    public void setDeals(Deals deals) {
        this.deals = deals;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(products);
        dest.writeValue(deals);
    }

    public int describeContents() {
        return  0;
    }

}
