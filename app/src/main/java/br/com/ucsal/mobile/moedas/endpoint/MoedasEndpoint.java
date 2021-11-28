package br.com.ucsal.mobile.moedas.endpoint;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoedasEndpoint {

    @GET("json/all")
    public Call<JsonObject> getMoedas();


}
