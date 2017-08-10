package itg8.com.treatpriceapp.offer;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.offer.fragment.OfferDescriptionFragment;

public class OfferActivity extends AppCompatActivity implements OfferDescriptionFragment.RecyclerViewScrollListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //    @BindView(R.id.lbl_name)
//    TextView lblName;
//    @BindView(R.id.lbl_category)
//    TextView lblCategory;
    @BindView(R.id.offerFrameLayout)
    FrameLayout offerFrameLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    FetchBehaviorListener behaviorListener;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.lbl_category)
    TextView lblCategory;
    @BindView(R.id.lbl_name)
    TextView lblName;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.floatingActionButton)
    ImageButton floatingActionButton;
    @BindView(R.id.btn_share)
    ImageButton btnShare;

    public void setListener(FetchBehaviorListener listener) {
//        this.behaviorListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsing.setCollapsedTitleTextColor(Color.TRANSPARENT);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                lblName.setTranslationY(verticalOffset);
            }
        });
        setFragment();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) offerFrameLayout.getLayoutParams();
//                behaviorListener.onBehaviorGot(layoutParams.getBehavior());


            }
        }, 100);
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.offerFrameLayout, OfferDescriptionFragment.newInstance("", "")).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
           /* overridePendingTransition(R.animator.slid_down, R.animator.slid_up);*/
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onScroll(int offset) {
        fab.setTranslationY(offset);

        Log.d(getClass().getSimpleName(), "Offset:" + offset);
    }

    public interface FetchBehaviorListener {
        void onBehaviorGot(CoordinatorLayout.Behavior behavior);
    }
}
