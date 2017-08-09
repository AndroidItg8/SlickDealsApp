package itg8.com.treatpriceapp.offer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;

/**
 * Created by Android itg 8 on 7/31/2017.
 */

public class MessageReplayAdapter extends RecyclerView.Adapter<MessageReplayAdapter.CommenstViewHolder> {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_comments)
    TextView txtComments;
    @BindView(R.id.txt_time)
    TextView txtTime;
    @BindView(R.id.lbl_help)
    TextView lblHelp;
    @BindView(R.id.img_helpful)
    ImageView imgHelpful;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.img_helpless)
    ImageView imgHelpless;
    private Context mContext;

    public MessageReplayAdapter(Context mContext) {

        this.mContext = mContext;
    }

    @Override
    public CommenstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comments, parent, false);
        CommenstViewHolder holder = new CommenstViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(CommenstViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class CommenstViewHolder extends RecyclerView.ViewHolder {
        public CommenstViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
