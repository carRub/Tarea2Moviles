package com.example.sesion9.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sesion9.AdapterProduct;
import com.example.sesion9.R;
import com.example.sesion9.beans.ItemProduct;

import java.util.ArrayList;

public class FragmentTechnology extends Fragment implements AdapterProduct.OnPhoneClickListener{

    private RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentTechnology() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_technology, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){

        //View view = inflater.inflate(R.layout.fragment_activity_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_technology_recycler_view);

        //mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<ItemProduct> myDataSet = new ArrayList<ItemProduct>();

        ItemProduct itemProduct = new ItemProduct(0, "MacBook Pro 17\"", "BestBuy", "Zapopan, Jalisco", "33 12345678",
                "Llevate esta Mac con un 30% de descuento para que puedas programar para XCode y Android sin tener que batallar tanto como en tu Windows\"");

        ItemProduct itemProduct1 = new ItemProduct(1, "Alienware\"", "BestBuy", "Zapopan, Jalisco", "33 87654321",
                "Llevate esta Alienware con 10% de descuento para que puedas correr cualquier juego que quieras en donde quieras");

        myDataSet.add(itemProduct);
        myDataSet.add(itemProduct1);


        mAdapter = new AdapterProduct(myDataSet, this);
        recyclerView.setAdapter(mAdapter);

    }

    public void onPhoneClick(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phone));
        getContext().startActivity(intent);
    }

    @Override
    public void onTabItem(String item) {
        Toast.makeText(getContext(), item,
                Toast.LENGTH_LONG).show();
    }

}
