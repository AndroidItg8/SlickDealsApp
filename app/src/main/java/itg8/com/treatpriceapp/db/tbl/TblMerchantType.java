package itg8.com.treatpriceapp.db.tbl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import static itg8.com.treatpriceapp.db.tbl.TblMerchantType.TABLE_MERCHANT_TYPE;

@DatabaseTable(tableName = TABLE_MERCHANT_TYPE)
public class TblMerchantType {
    static final String TABLE_MERCHANT_TYPE = "TBL_MERCHANT_TYPE";

    private static final String FIELD_ID = "PID";
    private static final String FIELD_NAME = "NAME";

    @DatabaseField(columnName = FIELD_ID, id = true)
    private String pId;

    @DatabaseField(columnName = FIELD_NAME)
    private String name;


    public TblMerchantType() {
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

