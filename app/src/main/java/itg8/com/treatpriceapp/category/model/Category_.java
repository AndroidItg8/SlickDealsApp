
package itg8.com.treatpriceapp.category.model;

import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Category_ implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("categories")
    @Expose
    @Valid
    private Categories__ categories;
    @SerializedName("leaf")
    @Expose
    private String leaf;
    public final static Parcelable.Creator<Category_> CREATOR = new Creator<Category_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category_ createFromParcel(Parcel in) {
            Category_ instance = new Category_();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.categories = ((Categories__) in.readValue((Categories__.class.getClassLoader())));
            instance.leaf = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Category_[] newArray(int size) {
            return (new Category_[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

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
     *     The categories
     */
    public Categories__ getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(Categories__ categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The leaf
     */
    public String getLeaf() {
        return leaf;
    }

    /**
     * 
     * @param leaf
     *     The leaf
     */
    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(categories);
        dest.writeValue(leaf);
    }

    public int describeContents() {
        return  0;
    }

}
