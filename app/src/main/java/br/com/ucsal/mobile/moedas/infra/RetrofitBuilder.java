package br.com.ucsal.mobile.moedas.infra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    public static final String BASE_URL = "https://economia.awesomeapi.com.br/";

    public Retrofit build(){

        Gson gson = new GsonBuilder()
                .setDateFormat(DateFormat.FULL)
                .create();

        //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

}
