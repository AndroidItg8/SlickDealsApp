package itg8.com.treatpriceapp.home;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.category.CategoryActivity;

import itg8.com.treatpriceapp.home.fragment.OfferFragment;
import itg8.com.treatpriceapp.newcategory.CategoriesActivity;
import itg8.com.treatpriceapp.offer.OfferActivity;
import itg8.com.treatpriceapp.registration.RegistrationActivity;

import itg8.com.treatpriceapp.common.CommonMethod;
import itg8.com.treatpriceapp.common.MyApplication;
import itg8.com.treatpriceapp.db.DBHelper;
import itg8.com.treatpriceapp.home.fragment.DealsFragment;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Product;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Resources;
import itg8.com.treatpriceapp.offer.OfferActivity;
import itg8.com.treatpriceapp.registration.RegistrationActivity;
import itg8.com.treatpriceapp.service.BaseService;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class HomeActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks,DealsFragment.DealSelectedListner {

    private static final int RC_STORAGE = 12;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.homeFrameLayout)
    FrameLayout homeFrameLayout;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
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
                    fragment= DealsFragment.newInstance("","");
                    setFragment(fragment);
                    return true;

                case R.id.action_stores:
//                    fragment= DealsFragment.newInstance("","");
//                    setFragment(fragment);
                    startActivity(new Intent(new Intent(getApplicationContext(), OfferActivity.class)));
                    return true;
            }

            return false;
        }
    };
    private boolean extported=false;
    private FragmentManager fm;

    private void setFragment(Fragment fragment) {
         fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.homeFrameLayout,fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        startService(new Intent(this, BaseService.class));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            viewPager.setPagingEnabled(true);


    }

//    private void hashmapTest() {
//        NetworkCall call=new NetworkCall();
//        call.printList();
//    }


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
                    checkPermissionToWrite();
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


    @AfterPermissionGranted(RC_STORAGE)
    private void checkPermissionToWrite() {
        if(EasyPermissions.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)){
            extported=true;
            CommonMethod.exportDatabse(DBHelper.DB_NAME,this);
        }else {
            EasyPermissions.requestPermissions(this,getString(R.string.rationale_storage_permission),RC_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    public void callRegistrationActvity(String from , Intent intent){
         intent.putExtra(CommonMethod.FromRegistration,"");

       //  Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom_up);
         startActivity(intent);
     }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
            if(!extported){
                CommonMethod.exportDatabse(DBHelper.DB_NAME,this);
            }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @Override
    public void onDealSelected(Product product, Resources resources) {
        Intent intent=new Intent(this,OfferActivity.class);
        intent.putExtra(CommonMethod.PRODUCT_DESC,product);
        intent.putExtra(CommonMethod.PRODUCT_RESOURCE,resources);
        startActivity(intent);
    }

    @Override
    public void onResourcesAvaiable(Resources resources) {
        MyApplication.getInstance().storeAllResources(resources);
    }
}
