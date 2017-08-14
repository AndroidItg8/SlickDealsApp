
package itg8.com.treatpriceapp.merchants.model;

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
public class MerchantTypeModel implements Parcelable
{

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("parameters")
    @Expose
    @Valid
    private List<Parameter> parameters = new ArrayList<Parameter>();
    @SerializedName("results")
    @Expose
    @Valid
    private Results results;
    public final static Parcelable.Creator<MerchantTypeModel> CREATOR = new Creator<MerchantTypeModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MerchantTypeModel createFromParcel(Parcel in) {
            MerchantTypeModel instance = new MerchantTypeModel();
            instance.status = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.parameters, (itg8.com.treatpriceapp.merchants.model.Parameter.class.getClassLoader()));
            instance.results = ((Results) in.readValue((Results.class.getClassLoader())));
            return instance;
        }

        public MerchantTypeModel[] newArray(int size) {
            return (new MerchantTypeModel[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     *     The parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     *     The results
     */
    public Results getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(Results results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(parameters);
        dest.writeValue(results);
    }

    public int describeContents() {
        return  0;
    }

}
