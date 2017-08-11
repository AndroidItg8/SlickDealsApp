
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
public class Categories_ implements Parcelable
{

    @SerializedName("category")
    @Expose
    @Valid
    private List<Category_> category = new ArrayList<Category_>();
    public final static Parcelable.Creator<Categories_> CREATOR = new Creator<Categories_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Categories_ createFromParcel(Parcel in) {
            Categories_ instance = new Categories_();
            in.readList(instance.category, (itg8.com.treatpriceapp.category.model.Category_.class.getClassLoader()));
            return instance;
        }

        public Categories_[] newArray(int size) {
            return (new Categories_[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The category
     */
    public List<Category_> getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(List<Category_> category) {
        this.category = category;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(category);
    }

    public int describeContents() {
        return  0;
    }

}
