package itg8.com.treatpriceapp.newcategory.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

/**
 * Created by Android itg 8 on 8/11/2017.
 */

public class CustExpListview extends ExpandableListView {

    int intGroupPosition, intChildPosition, intGroupid;

    public CustExpListview(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(1000,
                MeasureSpec.AT_MOST);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(12000,
                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}