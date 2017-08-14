
package itg8.com.treatpriceapp.category.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Category__ implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("leaf")
    @Expose
    private String leaf;
    public final static Parcelable.Creator<Category__> CREATOR = new Creator<Category__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category__ createFromParcel(Parcel in) {
            Category__ instance = new Category__();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.leaf = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Category__[] newArray(int size) {
            return (new Category__[size]);
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
        dest.writeValue(leaf);
    }

    public int describeContents() {
        return  0;
    }

}
