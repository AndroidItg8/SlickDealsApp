package itg8.com.treatpriceapp.db.tbl;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import static itg8.com.treatpriceapp.db.tbl.TblCategory.TABLE_NAME;

/**
 * Created by itg_Android on 8/11/2017.
 */

@DatabaseTable(tableName = TABLE_NAME)
public class TblCategory implements Parcelable {
    static final String TABLE_NAME="CATEGORY";



    @DatabaseField(columnName = "m_id", id = true)
    private String originalId;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "p_id")
    private String parentCatId;

    public TblCategory() {
    }


    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCatId() {
        return parentCatId;
    }

    public void setParentCatId(String parentCatId) {
        this.parentCatId = parentCatId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.originalId);
        dest.writeString(this.name);
        dest.writeString(this.parentCatId);
    }

    protected TblCategory(Parcel in) {
        this.originalId = in.readString();
        this.name = in.readString();
        this.parentCatId = in.readString();
    }

    public static final Creator<TblCategory> CREATOR = new Creator<TblCategory>() {
        @Override
        public TblCategory createFromParcel(Parcel source) {
            return new TblCategory(source);
        }

        @Override
        public TblCategory[] newArray(int size) {
            return new TblCategory[size];
        }
    };
}
