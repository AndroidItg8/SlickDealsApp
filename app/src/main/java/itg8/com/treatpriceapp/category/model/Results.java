
package itg8.com.treatpriceapp.category.model;

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

    @SerializedName("categories")
    @Expose
    @Valid
    private Categories categories;
    public final static Parcelable.Creator<Results> CREATOR = new Creator<Results>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Results createFromParcel(Parcel in) {
            Results instance = new Results();
            instance.categories = ((Categories) in.readValue((Categories.class.getClassLoader())));
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
     *     The categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(categories);
    }

    public int describeContents() {
        return  0;
    }

}
