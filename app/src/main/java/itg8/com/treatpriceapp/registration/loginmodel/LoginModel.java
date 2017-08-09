
package itg8.com.treatpriceapp.registration.loginmodel;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class LoginModel implements Parcelable
{

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("flag")
    @Expose
    private String flag;
    public final static Parcelable.Creator<LoginModel> CREATOR = new Creator<LoginModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LoginModel createFromParcel(Parcel in) {
            LoginModel instance = new LoginModel();
            instance.msg = ((String) in.readValue((String.class.getClassLoader())));
            instance.flag = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public LoginModel[] newArray(int size) {
            return (new LoginModel[size]);
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(msg);
        dest.writeValue(flag);
    }

    public int describeContents() {
        return  0;
    }

}
