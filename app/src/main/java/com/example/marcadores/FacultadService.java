package com.example.marcadores;

import com.example.marcadores.models.Facultad;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FacultadService {
    @GET("facultad")
    Call<List<Facultad>> getFacultades();
}
