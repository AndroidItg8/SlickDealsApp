
package itg8.com.treatpriceapp.home.model.tdaysDeals;

import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Filter implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("parameter")
    @Expose
    private String parameter;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("values")
    @Expose
    @Valid
    private Values values;
    public final static Parcelable.Creator<Filter> CREATOR = new Creator<Filter>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Filter createFromParcel(Parcel in) {
            Filter instance = new Filter();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.resource = ((String) in.readValue((String.class.getClassLoader())));
            instance.parameter = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            instance.values = ((Values) in.readValue((Values.class.getClassLoader())));
            return instance;
        }

        public Filter[] newArray(int size) {
            return (new Filter[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * 
     * @param resource
     *     The resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * 
     * @return
     *     The parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * 
     * @param parameter
     *     The parameter
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
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

    /**
     * 
     * @return
     *     The values
     */
    public Values getValues() {
        return values;
    }

    /**
     * 
     * @param values
     *     The values
     */
    public void setValues(Values values) {
        this.values = values;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(resource);
        dest.writeValue(parameter);
        dest.writeValue(count);
        dest.writeValue(values);
    }

    public int describeContents() {
        return  0;
    }

}
