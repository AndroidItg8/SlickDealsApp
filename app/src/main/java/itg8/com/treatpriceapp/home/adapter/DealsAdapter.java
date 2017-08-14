package itg8.com.treatpriceapp.home.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Product;

/**
 * Created by itg_Android on 8/14/2017.
 */

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {

    private List<Product> list;
    private Context context;
    private DealSelectedListner listner;

    public DealsAdapter(List<Product> list, Context context, DealSelectedListner listner) {

        this.list = list;
        this.context = context;
        this.listner = listner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deals, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String url = list.get(position).getImageUrlLarge();
        if (url != null)
            Picasso.with(context)
                    .load(Uri.parse(url))
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.imgDeal, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            // Try again online if cache failed
                            Picasso.with(context)
                                    .load(Uri.parse(url))
                                    .placeholder(R.drawable.flipkart)
                                    .into(holder.imgDeal);
                        }
                    });

        holder.txtTitle.setText(list.get(position).getName());
        holder.txtDealDesc.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface DealSelectedListner {
        void onDealSelected(Product product);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.img_deal)
        ImageView imgDeal;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_deal_desc)
        TextView txtDealDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listner.onDealSelected(list.get(getAdapterPosition()));
        }
    }
}
