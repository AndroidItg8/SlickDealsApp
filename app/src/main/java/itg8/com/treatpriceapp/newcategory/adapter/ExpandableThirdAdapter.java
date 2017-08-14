package itg8.com.treatpriceapp.newcategory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import itg8.com.treatpriceapp.R;

/**
 * Created by Android itg 8 on 8/11/2017.
 */

public class ExpandableThirdAdapter extends BaseExpandableListAdapter  {
    private final ArrayList<String> headerList;
    private Context applicationContext;
    private final HashMap<String, List<String>> childList;

    public ExpandableThirdAdapter(Context applicationContext, ArrayList<String> headerList, HashMap<String, List<String>> childList) {

        this.applicationContext = applicationContext;
        this.headerList = headerList;
        this.childList = childList;
    }



    @Override
    public int getGroupCount() {
        return headerList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerList.size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(headerList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition ;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.applicationContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_textview, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lbl_categoryName);
        //  lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition,childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.applicationContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_child_second, null);
        }

//        TextView txtListChild = (TextView) convertView
//                .findViewById(R.id.lblListItem);
        final ExpandableListView expandableListView = (ExpandableListView) convertView
                .findViewById(R.id.expandableListSecondView);
        //  txtListChild.setText(childText);
        String[] product = {"Last Category", "Last Category", "Last Category"};
        expandableListView.setAdapter(new ArrayAdapter<String>(applicationContext,R.layout.item_child,product));
        return  convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
