package br.com.ucsal.mobile.moedas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.mobile.moedas.endpoint.MoedasEndpoint;
import br.com.ucsal.mobile.moedas.infra.RetrofitBuilder;
import br.com.ucsal.mobile.moedas.model.Moeda;
import br.com.ucsal.mobile.moedas.model.Moedas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        RetrofitBuilder builder = new RetrofitBuilder();
        Retrofit retrofit = builder.build();

        MoedasEndpoint apiMoedas = retrofit.create(MoedasEndpoint.class);

        Call<JsonObject> call = apiMoedas.getMoedas();

        call.enqueue(new Callback<JsonObject>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                JsonObject moedasJSON = response.body();

                List<Moeda> moedas = converteJSonToObject(moedasJSON);

                System.out.println("Tamanho da Lista: " + moedas.size());

                textViewResult.setText(moedasJSON.toString());

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Moeda> converteJSonToObject(JsonObject moedasJSON) {

        List<Moeda> moedas = new ArrayList<>();
        Gson g = new Gson();

        for(String keyStr : moedasJSON.keySet()){
            Object keyValue = moedasJSON.get(keyStr);
            Moeda moeda = g.fromJson(keyValue.toString(), Moeda.class);
            moedas.add(moeda);
        }

        return moedas;
    }
}