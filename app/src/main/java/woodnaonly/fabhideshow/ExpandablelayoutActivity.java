package woodnaonly.fabhideshow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.Arrays;

import woodnaonly.expandablelayout.ExpandableLinearLayout;

public class ExpandablelayoutActivity extends AppCompatActivity {
    private static String[] data = new String[]{
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan", "Coke",
            "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE", "Haskell", "C++",
            "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh", "C", "Groovy", "Kotlin"
    };
    RecyclerView recyclerView;
    MainAdapter mMainAdapter;
    FloatingActionButton fab;
    int fabBottomMargin;
    LinearLayout top;
    LinearLayout buttom;
    ExpandableLinearLayout mExpandableLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        mExpandableLinearLayout= (ExpandableLinearLayout) findViewById(R.id.ExpandableLinearLayout);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        top = (LinearLayout) findViewById(R.id.top);
        buttom = (LinearLayout) findViewById(R.id.buttom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainAdapter = new MainAdapter();
        mMainAdapter.AddAll(Arrays.asList(data));
        recyclerView.setAdapter(mMainAdapter);
        recyclerView.addOnScrollListener(new HidingScrollListener() {

            @Override
            public void onHide() {
//                Resources resources = ExpandablelayoutActivity.this.getResources();
//                DisplayMetrics dm = resources.getDisplayMetrics();
//                float density = dm.density;
//                int width = dm.widthPixels;
//                int height = dm.heightPixels;
//                fab.animate()
//                        .translationY(height - fab.getHeight())
//                        .setInterpolator(new AccelerateInterpolator(2))
//                        .start();
//                buttom.animate()
//                        .translationY(height - buttom.getHeight())
//                        .setInterpolator(new AccelerateInterpolator(2))
//                        .setDuration(800)
//                        .start();
//                top.animate()
//                        .translationY(-height)
//                        .setDuration(800)
//                        .setInterpolator(new AccelerateInterpolator(2))
//                        .start();
                mExpandableLinearLayout.collapse();
            }

            @Override
            public void onShow() {
//                fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
//                buttom.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).setDuration(800).start();
//                top.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).setDuration(800).start();
                mExpandableLinearLayout.expand();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
