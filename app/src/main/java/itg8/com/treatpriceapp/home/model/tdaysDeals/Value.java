
package itg8.com.treatpriceapp.home.model.tdaysDeals;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Value implements Parcelable
{

    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("count")
    @Expose
    private int count;
    public final static Parcelable.Creator<Value> CREATOR = new Creator<Value>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Value createFromParcel(Parcel in) {
            Value instance = new Value();
            instance.min = ((String) in.readValue((String.class.getClassLoader())));
            instance.max = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Value[] newArray(int size) {
            return (new Value[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The min
     */
    public String getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The min
     */
    public void setMin(String min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The max
     */
    public String getMax() {
        return max;
    }

    /**
     * 
     * @param max
     *     The max
     */
    public void setMax(String max) {
        this.max = max;
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(min);
        dest.writeValue(max);
        dest.writeValue(count);
    }

    public int describeContents() {
        return  0;
    }

}
