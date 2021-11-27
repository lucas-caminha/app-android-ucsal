package br.com.ucsal.mobile.moedas.endpoint;

import com.google.gson.JsonObject;

import java.util.List;

import br.com.ucsal.mobile.moedas.model.Moeda;
import br.com.ucsal.mobile.moedas.model.Moedas;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoedasEndpoint {

    @GET("json/all")
    public Call<JsonObject> getMoedas();


}
