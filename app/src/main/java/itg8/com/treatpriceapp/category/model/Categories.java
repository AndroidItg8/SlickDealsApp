
package itg8.com.treatpriceapp.category.model;

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
public class Categories implements Parcelable
{

    @SerializedName("category")
    @Expose
    @Valid
    private List<Category> category = new ArrayList<Category>();
    public final static Parcelable.Creator<Categories> CREATOR = new Creator<Categories>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Categories createFromParcel(Parcel in) {
            Categories instance = new Categories();
            in.readList(instance.category, (itg8.com.treatpriceapp.category.model.Category.class.getClassLoader()));
            return instance;
        }

        public Categories[] newArray(int size) {
            return (new Categories[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(category);
    }

    public int describeContents() {
        return  0;
    }

}
