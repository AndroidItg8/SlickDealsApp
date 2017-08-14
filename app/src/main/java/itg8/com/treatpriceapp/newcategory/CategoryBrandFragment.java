package itg8.com.treatpriceapp.newcategory;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.category.adapter.CategorylistAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryBrandFragment extends Fragment {


    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.lbl_topBrand)
    TextView lblTopBrand;
    @BindView(R.id.recyclerViewBrand)
    RecyclerView recyclerViewBrand;
    Unbinder unbinder;
    private android.content.Context mContext;
    private List<String> listOfBrand = new ArrayList<>();
    private String isFrom= "Brand";

    public CategoryBrandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_brand, container, false);

        unbinder = ButterKnife.bind(this, view);
        prepareData();
        recyclerViewBrand.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerViewBrand.setAdapter(new CategorylistAdapter(mContext));
        return view;
    }

    private void prepareData() {
        for (int i=0; i<5 ;i++)
        {
            listOfBrand.add("Top Brand"+i);
        }
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
            mContext = null;
        }
    }
}
