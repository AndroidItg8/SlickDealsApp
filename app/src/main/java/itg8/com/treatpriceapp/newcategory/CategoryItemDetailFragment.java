package itg8.com.treatpriceapp.newcategory;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.category.adapter.CategorylistAdapter;
import itg8.com.treatpriceapp.newcategory.dummy.DummyContent;

/**
 * A fragment representing a single CategoryItem detail screen.
 * This fragment is either contained in a {@link CategoryItemListActivity}
 * in two-pane mode (on tablets) or a {@link CategoryItemDetailActivity}
 * on handsets.
 */
public class CategoryItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    @BindView(R.id.categoryitem_list)
    RecyclerView categoryitemList;
    Unbinder unbinder;

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;
    private android.content.Context mContext;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoryItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categoryitem_detail, container, false);

        unbinder = ButterKnife.bind(this, rootView);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            // ((TextView) rootView.findViewById(R.id.categoryitem_detail)).setText(mItem.details);
            categoryitemList.setLayoutManager(new LinearLayoutManager(mContext));
            categoryitemList.setAdapter(new CategorylistAdapter(mContext));
        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mContext != null)
        {
            mContext=null;
        }
    }
}
