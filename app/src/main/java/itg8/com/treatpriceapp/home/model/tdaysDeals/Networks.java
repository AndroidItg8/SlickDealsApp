
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
public class Networks implements Parcelable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("network")
    @Expose
    @Valid
    private List<Network> network = new ArrayList<Network>();
    public final static Parcelable.Creator<Networks> CREATOR = new Creator<Networks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Networks createFromParcel(Parcel in) {
            Networks instance = new Networks();
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.network, (itg8.com.treatpriceapp.home.model.tdaysDeals.Network.class.getClassLoader()));
            return instance;
        }

        public Networks[] newArray(int size) {
            return (new Networks[size]);
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
     *     The network
     */
    public List<Network> getNetwork() {
        return network;
    }

    /**
     * 
     * @param network
     *     The network
     */
    public void setNetwork(List<Network> network) {
        this.network = network;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(network);
    }

    public int describeContents() {
        return  0;
    }

}
