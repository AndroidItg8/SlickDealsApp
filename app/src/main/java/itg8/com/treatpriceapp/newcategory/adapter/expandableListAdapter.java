package itg8.com.treatpriceapp.newcategory.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.common.CommonMethod;

/**
 * Created by Android itg 8 on 8/11/2017.
 */

public class expandableListAdapter extends BaseExpandableListAdapter {


    private final Context applicationContext;
    public MainCategoryClicked listener;
    //    private final ArrayList<String> listDataHeader;
    private List<CommonMethod.TopItem> childOne;
    private int childPosition;
    private List<CommonMethod.TopItem>  continentList;

    public expandableListAdapter(Context applicationContext, List<CommonMethod.TopItem> childOne) {

        this.applicationContext = applicationContext;
        this.childOne = childOne;

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        //return listDataChild.get(.get(groupPosition)).get(childPosititon);
        return childOne.get(childPosititon).getModels().get(childPosititon);
        //return childPosititon;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        this.childPosition = childPosition;


        CustExpListview expandableListView = new CustExpListview(applicationContext);
        expandableListView.setBackgroundResource(R.drawable.list_selector);
        expandableListView.setDividerHeight(5);
      //  expandableListView.setGroupIndicator(R.drawable.group_indicator);
        expandableListView.setHeaderDividersEnabled(true);
//        expandableListView.setIndicatorBounds(5,5);
        expandableListView.setPadding(40,40,40,40);
        expandableListView.setElevation(8);

        expandableListView.setDivider(applicationContext.getResources().getDrawable(R.drawable.line_divider));

        expandableListView.setAlpha(0.9F);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return true;
            }
        });


        expandableListView.setAdapter(new expandableSecondListAdapter(applicationContext, childOne.get(childPosition).getModels()));
        return expandableListView;
     }

    @Override
    public int getChildrenCount(int groupPosition) {
//        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
//                .size();
        return 1;
        //childOne.get(this.childPosition).getModels().size();
        //get(groupPosition).getModels().
    }


    @Override
    public Object getGroup(int groupPosition) {
        // this.listDataHeader.get(groupPosition);
        return childOne.get(this.childPosition);
    }

    @Override
    public int getGroupCount() {
        // return this.listDataHeader.size();
        return childOne.size();
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
            convertView = infalInflater.inflate(R.layout.item_child, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lbl_categoryName);
        lblListHeader.setTextColor(Color.WHITE);
        lblListHeader.setTextSize(16F);
        //  lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(childOne.get(groupPosition).getTopHeader());


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public interface MainCategoryClicked {
        void onMainCategoryItemClickedListener(View ParentView, int grpposition, int childposition, long id);
    }


    public void filterData(String query){
        query = query.toLowerCase();
        ArrayList<CommonMethod.TopItem> newList = new ArrayList<CommonMethod.TopItem>();
        if(query.isEmpty()){
            continentList.addAll(childOne);
        }
        else {
            continentList = childOne;
            for(CommonMethod.TopItem continent: continentList) {
                if (continent.getModels().get(continent.getModels().size()).toString().contains(query)) {
                    newList.add(continent);
                }
            }
//                if (newList.size() > 0) {
//                    CommonMethod.TopItem nContinent = new CommonMethod.TopItem(continen, newList);
//                    continentList.add(nContinent);
//                }

            }


        notifyDataSetChanged();

    }


}
