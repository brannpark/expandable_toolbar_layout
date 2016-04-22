package com.example.brannpark.testapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by brannpark on 2015. 12. 29..
 */


public class ItemListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemListFragment newInstance() {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    List<String> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list2, container, false);

        ListView listView = (ListView)view.findViewById(R.id.list);
        SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipelayout);
        swipeLayout.setOnRefreshListener(this);

        // Set the adapter
        ItemListAdapter adapter = new ItemListAdapter(getActivity());

//        this.items = new ArrayList<>();
//        for (int i = 0; i < 200; i++) {
//            items.add("TEST - " + (i + 1));
//        }
//
//        adapter.setItems(items);
        listView.setAdapter(adapter);


        return view;
    }





    @Override
    public void onRefresh() {
        SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout)getView().findViewById(R.id.swipelayout);
        swipeLayout.setRefreshing(false);
    }
}
