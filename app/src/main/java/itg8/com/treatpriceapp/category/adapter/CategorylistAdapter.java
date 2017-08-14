package itg8.com.treatpriceapp.category.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;

/**
 * Created by Android itg 8 on 8/1/2017.
 */

public class CategorylistAdapter extends RecyclerView.Adapter<CategorylistAdapter.ViewHolder> {
    private Context mContext;

    public CategorylistAdapter(Context mContext) {

        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     //   View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_brand,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
