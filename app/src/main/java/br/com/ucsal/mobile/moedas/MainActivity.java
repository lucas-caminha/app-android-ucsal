package br.com.ucsal.mobile.moedas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.mobile.moedas.DAO.MoedaDAO;
import br.com.ucsal.mobile.moedas.adapter.MoedasListAdapter;
import br.com.ucsal.mobile.moedas.endpoint.MoedasEndpoint;
import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.infra.RetrofitBuilder;
import br.com.ucsal.mobile.moedas.model.Moeda;
import br.com.ucsal.mobile.moedas.task.AsyncMoedaInsert;
import br.com.ucsal.mobile.moedas.task.AsyncMoedaSelect;
import br.com.ucsal.mobile.moedas.task.AsyncOfflineSelect;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Moeda> moedasDB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Retrofit retrofit = new RetrofitBuilder().build();
        MoedasEndpoint apiMoedas = retrofit.create(MoedasEndpoint.class);

        Call<JsonObject> call = apiMoedas.getMoedas();

        call.enqueue(new Callback<JsonObject>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT);
                    return;
                }

                JsonObject moedasJSON = response.body();
                List<Moeda> moedas = converteJSonToObject(moedasJSON);

                MoedasListAdapter adapter = new MoedasListAdapter(moedas,MainActivity.this);
                listView.setAdapter(adapter);

                new AsyncMoedaSelect(MainActivity.this, moedas).execute();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                //new AsyncOfflineSelect(moedasDB, MainActivity.this).execute();
                List<Moeda> moedasDB = AppDatabase.getInstance(MainActivity.this).moedaDAO().buscaTodasMoedas();

                MoedasListAdapter adapter = new MoedasListAdapter(moedasDB,MainActivity.this);
                listView.setAdapter(adapter);

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