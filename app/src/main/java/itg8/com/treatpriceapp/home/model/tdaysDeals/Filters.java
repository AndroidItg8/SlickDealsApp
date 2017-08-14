
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
public class Filters implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("filter")
    @Expose
    @Valid
    private List<Filter> filter = new ArrayList<Filter>();
    public final static Parcelable.Creator<Filters> CREATOR = new Creator<Filters>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Filters createFromParcel(Parcel in) {
            Filters instance = new Filters();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.filter, (itg8.com.treatpriceapp.home.model.tdaysDeals.Filter.class.getClassLoader()));
            return instance;
        }

        public Filters[] newArray(int size) {
            return (new Filters[size]);
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
     *     The filter
     */
    public List<Filter> getFilter() {
        return filter;
    }

    /**
     * 
     * @param filter
     *     The filter
     */
    public void setFilter(List<Filter> filter) {
        this.filter = filter;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(filter);
    }

    public int describeContents() {
        return  0;
    }

}
