package itg8.com.treatpriceapp.newcategory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.common.CommonMethod;
import itg8.com.treatpriceapp.newcategory.adapter.ChildClass;
import itg8.com.treatpriceapp.newcategory.adapter.ChildOne;
import itg8.com.treatpriceapp.newcategory.adapter.expandableListAdapter;

public class CategoriesActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    private ArrayList<String> middlePositionItem;
    private HashMap<String, List<String>> listDataChild;
    private ChildClass childClass;
    private ArrayList<String> lastPostionItem;
    private ChildOne childClass1;
    private List<CommonMethod.TopItem> genratedList;
    private SearchView searchView;
    private expandableListAdapter expAdapdter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        prepareListData();
        setListView();

    }

    private void setListView() {
        expAdapdter = new expandableListAdapter(getApplicationContext(), genratedList);
        expandableListView.setAdapter(expAdapdter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return true;
            }
        });
    }

    private void prepareListData() {
        CommonMethod c = new CommonMethod();
        genratedList = c.getGeneratedList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categories, menu);
        final MenuItem item = menu.findItem(R.id.action_search);


        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Toast like print
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                item.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                expAdapdter.filterData(s);
                return false;
            }
        });
        return true;
        //searchView.setMenuItem(item);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_search:
                break;
            default:

        }

        return super.onOptionsItemSelected(item);
    }


}
