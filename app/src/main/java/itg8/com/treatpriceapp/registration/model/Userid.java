
package itg8.com.treatpriceapp.registration.model;

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
public class Userid implements Parcelable
{

    @SerializedName("User")
    @Expose
    @Valid
    private itg8.com.treatpriceapp.registration.model.User User;
    @SerializedName("LoginToken")
    @Expose
    @Valid
    private List<Object> LoginToken = new ArrayList<Object>();
    public final static Parcelable.Creator<Userid> CREATOR = new Creator<Userid>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Userid createFromParcel(Parcel in) {
            Userid instance = new Userid();
            instance.User = ((itg8.com.treatpriceapp.registration.model.User) in.readValue((User.class.getClassLoader())));
            in.readList(instance.LoginToken, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Userid[] newArray(int size) {
            return (new Userid[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The User
     */
    public itg8.com.treatpriceapp.registration.model.User getUser() {
        return User;
    }

    /**
     * 
     * @param User
     *     The User
     */
    public void setUser(itg8.com.treatpriceapp.registration.model.User User) {
        this.User = User;
    }

    /**
     * 
     * @return
     *     The LoginToken
     */
    public List<Object> getLoginToken() {
        return LoginToken;
    }

    /**
     * 
     * @param LoginToken
     *     The LoginToken
     */
    public void setLoginToken(List<Object> LoginToken) {
        this.LoginToken = LoginToken;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(User);
        dest.writeList(LoginToken);
    }

    public int describeContents() {
        return  0;
    }

}
