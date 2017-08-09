
package itg8.com.treatpriceapp.registration.model;

import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SignUpModel implements Parcelable
{

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("userid")
    @Expose
    @Valid
    private Userid userid;
    public final static Parcelable.Creator<SignUpModel> CREATOR = new Creator<SignUpModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SignUpModel createFromParcel(Parcel in) {
            SignUpModel instance = new SignUpModel();
            instance.msg = ((String) in.readValue((String.class.getClassLoader())));
            instance.flag = ((String) in.readValue((String.class.getClassLoader())));
            instance.userid = ((Userid) in.readValue((Userid.class.getClassLoader())));
            return instance;
        }

        public SignUpModel[] newArray(int size) {
            return (new SignUpModel[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * @param msg
     *     The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 
     * @return
     *     The flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 
     * @param flag
     *     The flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 
     * @return
     *     The userid
     */
    public Userid getUserid() {
        return userid;
    }

    /**
     * 
     * @param userid
     *     The userid
     */
    public void setUserid(Userid userid) {
        this.userid = userid;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(msg);
        dest.writeValue(flag);
        dest.writeValue(userid);
    }

    public int describeContents() {
        return  0;
    }

}
