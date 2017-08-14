
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
public class Values implements Parcelable
{

    @SerializedName("value")
    @Expose
    @Valid
    private List<Value> value = new ArrayList<Value>();
    public final static Parcelable.Creator<Values> CREATOR = new Creator<Values>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Values createFromParcel(Parcel in) {
            Values instance = new Values();
            in.readList(instance.value, (itg8.com.treatpriceapp.home.model.tdaysDeals.Value.class.getClassLoader()));
            return instance;
        }

        public Values[] newArray(int size) {
            return (new Values[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The value
     */
    public List<Value> getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(List<Value> value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(value);
    }

    public int describeContents() {
        return  0;
    }

}
