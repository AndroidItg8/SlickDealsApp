package itg8.com.treatpriceapp.offer.fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.treatpriceapp.R;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerViewScrollListener listener;


    public OfferDescriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfferDescriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OfferDescriptionFragment newInstance(String param1, String param2) {
        OfferDescriptionFragment fragment = new OfferDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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
                Log.d(getClass().getSimpleName(), "Offset:ScrollY: " + scrollY+" oldScrollY: "+oldScrollY);
                listener.onScroll(scrollY);
            }
        });
        setRecyclerView();
        return view;
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
            ((OfferActivity)context).setListener(new OfferActivity.FetchBehaviorListener() {
                @Override
                public void onBehaviorGot(CoordinatorLayout.Behavior behavior) {
//                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) scrollViewMain.getLayoutParams();
//                    layoutParams.setBehavior(behavior);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
         switch (v.getId())
         {
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
     public  interface OnClickListener{
         void onClick();
     }


}
