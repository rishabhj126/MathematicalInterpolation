package com.rishabhjain.interpolatorvisualizer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.rishabhjain.interpolators.DecelerateAccelerateInterpolator;
import com.rishabhjain.interpolators.PulseInterpolator;
import com.rishabhjain.interpolators.RepeatInterpolator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public final class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements AdapterView.OnItemSelectedListener {

        List<Interpolator> ls = new ArrayList<>();
        List<String> names = new ArrayList<>();
        private LinearLayout lv;
        private Spinner spinner;
        private View rootView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);

            lv = rootView.findViewById(R.id.listView1);
            spinner = rootView.findViewById(R.id.spinner);

            ls.add(new CycleInterpolator(1));
            names.add("CycleInterpolator");
            ls.add(new AccelerateDecelerateInterpolator());
            names.add("AccelerateDecelerateInterpolator");
            ls.add(new AccelerateInterpolator());
            names.add("AccelerateInterpolator");
            ls.add(new AnticipateInterpolator());
            names.add("AnticipateInterpolator");
            ls.add(new AnticipateOvershootInterpolator());
            names.add("AnticipateOvershootInterpolator");
            ls.add(new BounceInterpolator());
            names.add("BounceInterpolator");
            ls.add(new CycleInterpolator(3));
            names.add("CycleInterpolator3");
            ls.add(new DecelerateInterpolator());
            names.add("DecelerateInterpolator");
            ls.add(new LinearInterpolator());
            names.add("LinearInterpolator");
            ls.add(new OvershootInterpolator());
            names.add("OvershootInterpolator");

            //Custom ones:
            ls.add(new DecelerateAccelerateInterpolator());
            names.add("DecelerateAccelerateInterpolator");
            ls.add(new PulseInterpolator(2, 1));
            names.add("PulseInterpolator");
            ls.add(new RepeatInterpolator(2.5));
            names.add("RepeatInterpolator");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(container.getContext(), android.R.layout.simple_spinner_item, names);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            return rootView;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            InterpolatorView iv = lv.findViewById(R.id.interpolatorView1);
            iv.setInterpolator(ls.get(names.indexOf(spinner.getSelectedItem().toString())));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}
