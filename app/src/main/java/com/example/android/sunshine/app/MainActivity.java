package com.example.android.sunshine.app;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceHolderFragment())
                    .commit();
        }
    }


    public static class PlaceHolderFragment extends Fragment {

        public PlaceHolderFragment(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main,container,false);

            String [] arrItens = {"Today - Sunny - 88/63", "Tomorrow - Foggy - 70/46","Weds - Cloudy - 72/63", "Thurs - Rainy - 64/51", "Fri - Froggy - 70/46"};

            List<String> listItens = new ArrayList<String>(Arrays.asList(arrItens));

            ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,R.id.list_item_forecast_textview,listItens);

            ListView listView = (ListView) view.findViewById(R.id.listview_forecast);
            listView.setAdapter(mAdapter);

            return view;
        }
    }
}
