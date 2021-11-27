package br.com.ucsal.mobile.moedas.infra;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoedasEndpoint {

    @GET("json/all")
    public Call<String> getAll();


}
