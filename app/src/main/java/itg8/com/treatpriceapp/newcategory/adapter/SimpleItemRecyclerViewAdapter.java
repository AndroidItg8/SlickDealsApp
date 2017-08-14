package itg8.com.treatpriceapp.newcategory.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.newcategory.CategoryItemDetailFragment;
import itg8.com.treatpriceapp.newcategory.dummy.DummyContent;

/**
 * Created by Android itg 8 on 8/14/2017.
 */

public class SimpleItemRecyclerViewAdapter   extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolders> {

    private final List<DummyContent.DummyItem> mValues;
    private Context applicationContext;

    public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items, Context applicationContext) {
        mValues = items;
        this.applicationContext = applicationContext;
    }

    @Override
    public SimpleItemRecyclerViewAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categoryitem_list_content, parent, false);
        ViewHolders holders = new ViewHolders(view);
        return holders;
    }

    @Override
    public void onBindViewHolder(final ViewHolders holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mLinearLayout.setBackground(applicationContext.getResources().getDrawable(R.drawable.list_selector));




        holder.mView.setOnClickListener(new View.OnClickListener() {
            Fragment fragment= null;
            @Override
            public void onClick(View v) {

                switch (v.getId())
                {
                    case 0:
                        Bundle arguments = new Bundle();
                        arguments.putString(CategoryItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                         fragment = new CategoryItemDetailFragment();
                        fragment.setArguments(arguments);
                            setFragment(fragment);
                        break;
                    case 1:
                        //arguments.putString(CategoryItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                      //  fragment = new CategoryItemDetailFragment();
                        //fragment.setArguments(arguments);
                     //   setFragment(fragment);
                        break;


                }
//                    if (mTwoPane) {




//                    } else {
//                        Context context = v.getContext();
//                        Intent intent = new Intent(context, CategoryItemDetailActivity.class);
//                        intent.putExtra(CategoryItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
//
//                        context.startActivity(intent);
//                    }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        ((FragmentActivity)applicationContext).getSupportFragmentManager().beginTransaction()
                .replace(R.id.categoryitem_detail_container, fragment)
                .commit();
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }



    public class ViewHolders extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final LinearLayout mLinearLayout;
        public DummyContent.DummyItem mItem;

        public ViewHolders(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mLinearLayout = (LinearLayout) view.findViewById(R.id.ll_item);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }


    }
}