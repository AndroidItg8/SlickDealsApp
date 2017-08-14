package itg8.com.treatpriceapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.category.CategoryActivity;
import itg8.com.treatpriceapp.home.fragment.OfferFragment;
import itg8.com.treatpriceapp.newcategory.CategoriesActivity;
import itg8.com.treatpriceapp.offer.OfferActivity;
import itg8.com.treatpriceapp.registration.RegistrationActivity;

public class HomeActivity extends AppCompatActivity  {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.homeFrameLayout)
    FrameLayout homeFrameLayout;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.viewPager)
    itg8.com.treatpriceapp.widget.CustomViewPager viewPager;
    @BindView(R.id.navigationView)
    BottomNavigationView navigationView;
    private Intent intent;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment = null;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_category:
//                    fragment= CategoryFragment.newInstance("","");
//                    setFragment(fragment);
                    startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                    return true;
                case R.id.action_offer:
                    fragment= OfferFragment.newInstance("","");
                    setFragment(fragment);
                    return true;

                case R.id.action_stores:
//                    fragment= OfferFragment.newInstance("","");
//                    setFragment(fragment);
                    startActivity(new Intent(new Intent(getApplicationContext(), OfferActivity.class)));
                    return true;
            }

            return false;
        }
    };

    private void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.homeFrameLayout,fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            viewPager.setPagingEnabled(true);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       switch (item.getItemId())
       {
           case R.id.action_settings:
               break;

           case R.id.action_login:
          intent = new Intent(getApplicationContext(), RegistrationActivity.class);
               callRegistrationActvity("fromRegistration", intent);
               break;
           case R.id.action_category:
           intent = new Intent(getApplicationContext(), CategoriesActivity.class);
               callRegistrationActvity("fromRegistration", intent);
               break;
           default:

       }

        return super.onOptionsItemSelected(item);
    }
     public void callRegistrationActvity(String from , Intent intent){
       //  intent.putExtra(CommonMethod.FromRegistration,"");
       //  Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom_up);
         startActivity(intent);
     }


}
