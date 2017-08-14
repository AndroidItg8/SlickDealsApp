package itg8.com.treatpriceapp.newcategory.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.common.CommonMethod;

/**
 * Created by Android itg 8 on 8/11/2017.
 */

public class expandableSecondListAdapter extends BaseExpandableListAdapter {
    private static final  String TAG = expandableSecondListAdapter.class.getSimpleName();
    private final Context applicationContext;
    private final List<CommonMethod.MiddleItem> childList;

    //    private final Context applicationContext;
//    private final HashMap<String, List<String>> listDataChild;
//    private final ArrayList<String> listDataHeader;
    public expandableListAdapter.MainCategoryClicked listener;



    public expandableSecondListAdapter(Context applicationContext, List<CommonMethod.MiddleItem> childList) {

        this.applicationContext = applicationContext;
        this.childList = childList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
//        listDataChild.get(listDataHeader.get(groupPosition)).get(childPosititon);
        return childList.get(groupPosition).getModels().get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.applicationContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_child_second, null);
        }

//        TextView txtListChild = (TextView) convertView
//                .findViewById(R.id.lblListItem);
        ListView expandableListView = (ListView) convertView
                .findViewById(R.id.listView);
        expandableListView.setBackgroundResource(R.drawable.list_item);
        expandableListView.setDividerHeight(5);
        expandableListView.setHeaderDividersEnabled(true);
        expandableListView.setAlpha(0.5F);

        expandableListView.setHeaderDividersEnabled(true);
        expandableListView.setDivider(applicationContext.getResources().getDrawable(R.drawable.list_divider));

        //  txtListChild.setText(childText);

        expandableListView.setAdapter(new ArrayAdapter<String>(applicationContext,R.layout.item_textview,childList.get(groupPosition).getModels()));

     //   expandableListView.setAdapter(new ExpandableThirdAdapter(applicationContext,childList.getSecondList()));
     //   Log.i(TAG,"ListData:"+listDataHeader +"ChildData:"+listDataChild);


               // expandableListView.setAdapter(new ArrayAdapter<String>(applicationContext,R.layout.item_child,product));




//        txtListChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                expandableListView.setAdapter( new expandableSecondListAdapter(applicationContext,listDataHeader, listDataChild));
//
//            }
//        });


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).getModels().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //return this.childList.get(groupPosition).getMiddleHeader();
        return groupPosition;
    }

    @Override
    public int getGroupCount() {
        return this.childList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
       // String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.applicationContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_textview, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lbl_categoryName);

        lblListHeader.setTextColor(Color.WHITE);
        lblListHeader.setTextSize(16F);

        lblListHeader.setElevation(4F);
        lblListHeader.setAlpha(0.4F);


        //  lblListHeader.setTypeface(null, Typeface.BOLD);

        lblListHeader.setText(childList.get(groupPosition).getMiddleHeader());


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public interface MainCategoryClicked{
        void onMainCategoryItemClickedListener(View ParentView,int grpposition, int childposition ,long id);
    }
}
