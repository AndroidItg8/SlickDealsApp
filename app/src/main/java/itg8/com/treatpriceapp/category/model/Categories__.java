
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
public class Categories__ implements Parcelable
{

    @SerializedName("category")
    @Expose
    @Valid
    private List<Category__> category = new ArrayList<Category__>();
    public final static Parcelable.Creator<Categories__> CREATOR = new Creator<Categories__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Categories__ createFromParcel(Parcel in) {
            Categories__ instance = new Categories__();
            in.readList(instance.category, (itg8.com.treatpriceapp.category.model.Category__.class.getClassLoader()));
            return instance;
        }

        public Categories__[] newArray(int size) {
            return (new Categories__[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The category
     */
    public List<Category__> getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(List<Category__> category) {
        this.category = category;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(category);
    }

    public int describeContents() {
        return  0;
    }

}
