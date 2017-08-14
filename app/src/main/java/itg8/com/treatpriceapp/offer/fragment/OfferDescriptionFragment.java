package itg8.com.treatpriceapp.offer.fragment;


import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Offer;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Product;
import itg8.com.treatpriceapp.offer.OfferActivity;
import itg8.com.treatpriceapp.offer.adapter.OfferDescriptionAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfferDescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferDescriptionFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.lbl_offer_desc)
    TextView lblOfferDesc;

    @BindView(R.id.txt_like_value)
    TextView txtLikeValue;
    @BindView(R.id.txt_comments_value)
    TextView txtCommentsValue;
    @BindView(R.id.recyclerViewOffer)
    RecyclerView recyclerViewOffer;
    Unbinder unbinder;


    @BindView(R.id.btn_addComment)
    TextView btnAddComment;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.btn_activate)
    Button btnActivate;
    @BindView(R.id.scrollViewMain)
    RelativeLayout scrollViewMain;
    @BindView(R.id.val_percent_off)
    TextView valPercentOff;
    @BindView(R.id.lbl_price)
    TextView lblPrice;
    @BindView(R.id.val_price)
    TextView valPrice;
    @BindView(R.id.lbl_original_price)
    TextView lblOriginalPrice;
    @BindView(R.id.val_original_price)
    TextView valOriginalPrice;
    @BindView(R.id.lbl_condition)
    TextView lblCondition;
    @BindView(R.id.val_condition)
    TextView valCondition;
    @BindView(R.id.offer_price_details)
    TableLayout offerPriceDetails;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerViewScrollListener listener;
    private Product product;
    private Context context;


    public OfferDescriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param product
     * @return A new instance of fragment OfferDescriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OfferDescriptionFragment newInstance(Product product) {
        OfferDescriptionFragment fragment = new OfferDescriptionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, product);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            product = getArguments().getParcelable(ARG_PARAM1);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer_description, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();

        scrollViewMain.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(getClass().getSimpleName(), "Offset:ScrollY: " + scrollY + " oldScrollY: " + oldScrollY);
                listener.onScroll(scrollY);
            }
        });
        if (product != null) {
            initProductInfo();
        }
        setRecyclerView();
        return view;
    }

    private void initProductInfo() {
        final String url = product.getOfferCount() > 0 ? product.getOffers().getOffer().get(0).getImageUrlLarge() : product.getImageUrlLarge();
        Picasso.with(context)
                .load(Uri.parse(url))
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        // Try again online if cache failed
                        Picasso.with(context)
                                .load(Uri.parse(url))
                                .placeholder(R.drawable.flipkart)
                                .into(image);
                    }
                });
        lblOfferDesc.setText(Html.fromHtml(product.getOfferCount() > 0 ? product.getOffers().getOffer().get(0).getDescription() : product.getDescription()));
        Offer offer=product.getOfferCount()>0?product.getOffers().getOffer().get(0):null;
        if(offer!=null){
            valCondition.setText(offer.getCondition());
            String dollar=offer.getCurrencyIso().equalsIgnoreCase("USD")?"$":"";
            valOriginalPrice.setText(dollar+offer.getPriceRetail());
            valPrice.setText(dollar+offer.getPriceMerchant());
            valPercentOff.setText(offer.getPercentOff()+" %");
        }
    }

    private void init() {
        btnAddComment.setOnClickListener(this);

    }

    private void setRecyclerView() {
        OfferDescriptionAdapter adapter = new OfferDescriptionAdapter(getActivity());
        recyclerViewOffer.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewOffer.setNestedScrollingEnabled(false);
        recyclerViewOffer.addItemDecoration(new
                DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        recyclerViewOffer.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (RecyclerViewScrollListener) context;
            ((OfferActivity) context).setListener(new OfferActivity.FetchBehaviorListener() {
                @Override
                public void onBehaviorGot(CoordinatorLayout.Behavior behavior) {
//                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) scrollViewMain.getLayoutParams();
//                    layoutParams.setBehavior(behavior);
                }
            });
            this.context = context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addComment:
                openBottomSheetForReply();
                break;
        }

    }

    private void openBottomSheetForReply() {
        final Dialog mBottomSheetDialog = new Dialog(getActivity(),
                R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(R.layout.layout_bottom_sheet_reply);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);


        mBottomSheetDialog.show();
    }


    public interface RecyclerViewScrollListener {
        void onScroll(int offset);

    }

    public interface OnClickListener {
        void onClick();
    }


}
