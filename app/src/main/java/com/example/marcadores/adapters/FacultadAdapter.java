package com.example.marcadores.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marcadores.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

public class FacultadAdapter implements GoogleMap.InfoWindowAdapter {

    private final View windowAdapter;
    private Context context;

    public FacultadAdapter(Context context) {
        this.context = context;
        windowAdapter = LayoutInflater.from(context).inflate(R.layout.card_map_info_window, null);
    }

    private void renderWindowData(Marker marker, View view){
        ImageView logoImage = (ImageView) view.findViewById(R.id.fac_img);
        TextView facultadName = (TextView) view.findViewById(R.id.facult_name);
        TextView decanoName = (TextView) view.findViewById(R.id.deca_name);
        TextView direccionName = (TextView) view.findViewById(R.id.dir_name);
        TextView telefonoNum = (TextView) view.findViewById(R.id.telf_num);
        String[] results = marker.getSnippet().split(",");
        if(results.length > 0) {
            facultadName.setText(results[0]);
            decanoName.setText("Decano: " + results[1]);
            direccionName.setText(results[2]);
            telefonoNum.setText(results[3]);
            Picasso.get().load(results[4])
                    .placeholder(R.drawable.logo_uteq)
                    .into(logoImage);
        }
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        renderWindowData(marker, windowAdapter);
        return windowAdapter;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        renderWindowData(marker, windowAdapter);
        return windowAdapter;
    }
}
