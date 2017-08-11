
package itg8.com.treatpriceapp.category.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Parameter implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("value")
    @Expose
    private String value;
    public final static Parcelable.Creator<Parameter> CREATOR = new Creator<Parameter>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Parameter createFromParcel(Parcel in) {
            Parameter instance = new Parameter();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.kind = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Parameter[] newArray(int size) {
            return (new Parameter[size]);
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
     *     The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 
     * @param kind
     *     The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(kind);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
