
package itg8.com.treatpriceapp.home.model.tdaysDeals;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Deal implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("merchant")
    @Expose
    private int merchant;
    @SerializedName("deal_type")
    @Expose
    private String dealType;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("site_wide")
    @Expose
    private String siteWide;
    @SerializedName("start_on")
    @Expose
    private String startOn;
    @SerializedName("end_on")
    @Expose
    private String endOn;
    public final static Parcelable.Creator<Deal> CREATOR = new Creator<Deal>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Deal createFromParcel(Parcel in) {
            Deal instance = new Deal();
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.merchant = ((int) in.readValue((int.class.getClassLoader())));
            instance.dealType = ((String) in.readValue((String.class.getClassLoader())));
            instance.sku = ((String) in.readValue((String.class.getClassLoader())));
            instance.siteWide = ((String) in.readValue((String.class.getClassLoader())));
            instance.startOn = ((String) in.readValue((String.class.getClassLoader())));
            instance.endOn = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Deal[] newArray(int size) {
            return (new Deal[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
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
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The merchant
     */
    public int getMerchant() {
        return merchant;
    }

    /**
     * 
     * @param merchant
     *     The merchant
     */
    public void setMerchant(int merchant) {
        this.merchant = merchant;
    }

    /**
     * 
     * @return
     *     The dealType
     */
    public String getDealType() {
        return dealType;
    }

    /**
     * 
     * @param dealType
     *     The deal_type
     */
    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    /**
     * 
     * @return
     *     The sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * 
     * @param sku
     *     The sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * 
     * @return
     *     The siteWide
     */
    public String getSiteWide() {
        return siteWide;
    }

    /**
     * 
     * @param siteWide
     *     The site_wide
     */
    public void setSiteWide(String siteWide) {
        this.siteWide = siteWide;
    }

    /**
     * 
     * @return
     *     The startOn
     */
    public String getStartOn() {
        return startOn;
    }

    /**
     * 
     * @param startOn
     *     The start_on
     */
    public void setStartOn(String startOn) {
        this.startOn = startOn;
    }

    /**
     * 
     * @return
     *     The endOn
     */
    public String getEndOn() {
        return endOn;
    }

    /**
     * 
     * @param endOn
     *     The end_on
     */
    public void setEndOn(String endOn) {
        this.endOn = endOn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(url);
        dest.writeValue(merchant);
        dest.writeValue(dealType);
        dest.writeValue(sku);
        dest.writeValue(siteWide);
        dest.writeValue(startOn);
        dest.writeValue(endOn);
    }

    public int describeContents() {
        return  0;
    }

}
