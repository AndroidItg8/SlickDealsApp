
package itg8.com.treatpriceapp.home.model.tdaysDeals;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Countries implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("country")
    @Expose
    @Valid
    private List<Object> country = new ArrayList<Object>();
    public final static Parcelable.Creator<Countries> CREATOR = new Creator<Countries>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Countries createFromParcel(Parcel in) {
            Countries instance = new Countries();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.country, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Countries[] newArray(int size) {
            return (new Countries[size]);
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
     *     The country
     */
    public List<Object> getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(List<Object> country) {
        this.country = country;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(country);
    }

    public int describeContents() {
        return  0;
    }

}
