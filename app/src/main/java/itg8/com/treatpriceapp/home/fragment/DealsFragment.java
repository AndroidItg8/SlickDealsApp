package itg8.com.treatpriceapp.home.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.home.adapter.DealsAdapter;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Product;
import itg8.com.treatpriceapp.home.model.tdaysDeals.ProductsModel;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Resources;
import itg8.com.treatpriceapp.home.mvp.DealsPresenterImp;
import itg8.com.treatpriceapp.home.mvp.HomeMVP;
import itg8.com.treatpriceapp.widget.EndlessRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DealsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DealsFragment extends Fragment implements HomeMVP.DealsView, EndlessRecyclerView.Pager, DealsAdapter.DealSelectedListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final long DELAY = 1000L;
    private static int ITEMS_ON_PAGE = 20;
    private static int TOTAL_PAGES;
    @BindView(R.id.rv_deals)
    EndlessRecyclerView rvDeals;
    Unbinder unbinder;
    int pageNumber = 1;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private HomeMVP.DealsPresenter presenter;
    private DealsAdapter adapter;
    private Context context;
    private boolean loading = false;
    private List<Product> list;
    private Handler handler;
    DealSelectedListner listner;

    public DealsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DealsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DealsFragment newInstance(String param1, String param2) {
        DealsFragment fragment = new DealsFragment();
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
        View view = inflater.inflate(R.layout.fragment_deals, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRecyclerview();
        presenter = new DealsPresenterImp(this);
        presenter.onStartDownloadingDeals(pageNumber);
        return view;
    }

    private void initRecyclerview() {
        list = new ArrayList<>();
        adapter = new DealsAdapter(list, context,this);
        rvDeals.setLayoutManager(new LinearLayoutManager(context));
        rvDeals.setProgressView(R.layout.item_progressview);
        rvDeals.setAdapter(adapter);
        rvDeals.setPager(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    ProductsModel model = null;
    @Override
    public void onTopDealsAvaialable(Object o) {
        if (o != null) {
            model = (ProductsModel) o;
        }
        loading = false;
        rvDeals.setRefreshing(false);
        setRecyclerview(model);
        if (model != null && adapter != null) {
            addToRecyclerview(model);
        }
    }

    private void addToRecyclerview(ProductsModel model) {
        if (model.getResults().getProducts() != null && model.getResults().getProducts().getProduct() != null) {
            list.addAll(model.getResults().getProducts().getProduct());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner= (DealSelectedListner) context;
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
        presenter.onDetached();

    }

    private void setRecyclerview(ProductsModel model) {
        listner.onResourcesAvaiable(model.getResources());
        if (model.getResults().getProducts() != null && TOTAL_PAGES <= 0) {
            TOTAL_PAGES = model.getResults().getProducts().getCount() / ITEMS_ON_PAGE;
        }
    }

    @Override
    public void onError(Throwable t) {
        Toast.makeText(context, "error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean shouldLoad() {
        return !loading && adapter.getItemCount() / ITEMS_ON_PAGE < TOTAL_PAGES;
    }

    @Override
    public void loadNextPage() {
        loading = true;
        pageNumber++;
        presenter.onStartDownloadingDeals(pageNumber);
        rvDeals.setRefreshing(true);

    }

    @Override
    public void onDealSelected(Product product) {
            if(listner!=null){
                listner.onDealSelected(product,model.getResources());
            }
    }

    public interface DealSelectedListner{
        void onDealSelected(Product product, Resources resources);

        void onResourcesAvaiable(Resources resources);
    }
}
