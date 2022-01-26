package com.example.marcadores;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marcadores.adapters.FacultadAdapter;
import com.example.marcadores.models.Facultad;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        this.googleMap = googleMap;
        this.googleMap.setInfoWindowAdapter(new FacultadAdapter(this));
        LatLng defaultLat = new LatLng(-1.01289,-79.469265);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://my-json-server.typicode.com/neoshock/fakeonlinerestserver/").
                addConverterFactory(GsonConverterFactory.create()).build();

        FacultadService facultadService = retrofit.create(FacultadService.class);
        Call<List<Facultad>> callData = facultadService.getFacultades();

        callData.enqueue(new Callback<List<Facultad>>() {

            @Override
            public void onResponse(Call<List<Facultad>> call, Response<List<Facultad>> response) {
                List<Facultad> facultadList = response.body();
                facultadList.forEach((e)-> {
                    LatLng direccion = new LatLng(e.getLat(), e.getAlt());
                    googleMap.addMarker(new MarkerOptions().position(direccion)
                            .title("Algo Aqui")
                            .snippet(e.toString()));
                });
            }
            @Override
            public void onFailure(Call<List<Facultad>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLat, 16.0f));
    }
}