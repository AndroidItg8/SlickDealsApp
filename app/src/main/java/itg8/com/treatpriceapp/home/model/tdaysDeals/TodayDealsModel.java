
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
public class TodayDealsModel implements Parcelable
{

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("session")
    @Expose
    private String session;
    @SerializedName("parameters")
    @Expose
    @Valid
    private List<Parameter> parameters = new ArrayList<Parameter>();
    @SerializedName("results")
    @Expose
    @Valid
    private Results results;
    @SerializedName("filters")
    @Expose
    @Valid
    private Filters filters;
    @SerializedName("resources")
    @Expose
    @Valid
    private Resources resources;
    public final static Parcelable.Creator<TodayDealsModel> CREATOR = new Creator<TodayDealsModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TodayDealsModel createFromParcel(Parcel in) {
            TodayDealsModel instance = new TodayDealsModel();
            instance.status = ((int) in.readValue((int.class.getClassLoader())));
            instance.session = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.parameters, (itg8.com.treatpriceapp.home.model.tdaysDeals.Parameter.class.getClassLoader()));
            instance.results = ((Results) in.readValue((Results.class.getClassLoader())));
            instance.filters = ((Filters) in.readValue((Filters.class.getClassLoader())));
            instance.resources = ((Resources) in.readValue((Resources.class.getClassLoader())));
            return instance;
        }

        public TodayDealsModel[] newArray(int size) {
            return (new TodayDealsModel[size]);
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
     *     The session
     */
    public String getSession() {
        return session;
    }

    /**
     * 
     * @param session
     *     The session
     */
    public void setSession(String session) {
        this.session = session;
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

    /**
     * 
     * @return
     *     The filters
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    /**
     * 
     * @return
     *     The resources
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * 
     * @param resources
     *     The resources
     */
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(session);
        dest.writeList(parameters);
        dest.writeValue(results);
        dest.writeValue(filters);
        dest.writeValue(resources);
    }

    public int describeContents() {
        return  0;
    }

}
