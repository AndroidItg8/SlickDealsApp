package itg8.com.treatpriceapp.offer.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.offer.fragment.OfferDescriptionFragment;

/**
 * Created by Android itg 8 on 7/29/2017.
 */

public class OfferDescriptionAdapter extends RecyclerView.Adapter<OfferDescriptionAdapter.ViewHolder> {


    private Context mContext;
    private OfferDescriptionFragment.OnClickListener clickListener;
    private boolean isClicked=false;


    public OfferDescriptionAdapter(Context mContext) {

        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(isClicked)
        {
            holder.recyclerViewReply.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
            holder.recyclerViewReply.setAdapter(new MessageReplayAdapter(mContext));
        }




    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_comments)
        TextView txtComments;
        @BindView(R.id.txt_reply)
        TextView txtReply;
        @BindView(R.id.lbl_help)
        TextView lblHelp;
        @BindView(R.id.img_helpful)
        ImageView imgHelpful;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.img_helpless)
        ImageView imgHelpless;

        @BindView(R.id.recyclerViewReply)
        RecyclerView recyclerViewReply;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            txtReply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isClicked= true;
                }
            });

        }
    }
}
