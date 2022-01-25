package com.example.marcadores;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

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

        List<Facultad> facultadList = getFacultades();

        this.googleMap = googleMap;
        this.googleMap.setInfoWindowAdapter(new FacultadAdapter(this));
        LatLng defaultLat = new LatLng(-1.01289,-79.469265);
        facultadList.forEach((e)-> {
            LatLng direccion = new LatLng(e.getLat(), e.getAlt());
            this.googleMap.addMarker(new MarkerOptions().position(direccion)
                    .title("Algo Aqui")
                    .snippet(e.toString()));
        });

        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLat));
    }

    private List<Facultad> getFacultades(){
        List<Facultad> facultades = new ArrayList<>();
        //Campus la maria
        facultades.add(new Facultad("Facultad de Ciencias de la Ingeniería",
                "Ing. Washington Chiriboga Casanova",
                "Campus “La María” - km 7 vía Quevedo-El Empalme",
                "(+593) 5 3702-220 Ext. 8052",
                "https://www.uteq.edu.ec/images/about/logo_fci.jpg", -1.080257,-79.501652));

        facultades.add(new Facultad("Facultad de Ciencias Agropecuarias",
                "Ing. Rolando López Tobar",
                "Campus “La María” - km 7 vía Quevedo-El Empalme",
                "(+593) 5 3702-220 Ext. 8067",
                "https://www.uteq.edu.ec/images/about/logo_fcagrop.jpg", -1.080316,-79.502389));

        facultades.add(new Facultad("Facultad de Ciencias de la Industria y Producción",
                "Ing. Henry Nelson Aguilera Vidal",
                "Campus “La María” - km 7 vía Quevedo-El Empalme",
                "(+593) 5 3702-220 Ext. 8025",
                "https://www.uteq.edu.ec/images/about/logo_fcip.jpg", -1.080802,-79.501709));

        //Campus central
        facultades.add(new Facultad("Facultad de Ciencias Empresariales",
                "Ing. Magali Gioconda Calero Lara",
                "Campus Ingeniero Manuel Agustín Haz Álvarez - Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas",
                "(+593) 5 3702-220 Ext. 8038",
                "https://www.uteq.edu.ec/images/about/logo_fce.jpg", -1.012214,-79.469327));

        facultades.add(new Facultad("Facultad de Ciencias de la Salud",
                "Ing. Magali Gioconda Calero Lara",
                "Campus Ingeniero Manuel Agustín Haz Álvarez - Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas",
                " (+593) 5 3702-220 Ext. 8001",
                "https://www.uteq.edu.ec/images/about/logo_enf1.jpg", -1.012407,-79.469925));

        facultades.add(new Facultad("Facultad de Ciencias de la Educación",
                "Psi. Pablo Alberto Parra Silva",
                "Campus Ingeniero Manuel Agustín Haz Álvarez - Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas",
                "(+593) 5 3702-220 Ext. 8066",
                "https://www.uteq.edu.ec/images/escudouteq.png", -1.012761,-79.470806));

        return facultades;
    }
}