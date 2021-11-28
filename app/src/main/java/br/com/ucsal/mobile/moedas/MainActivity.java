package br.com.ucsal.mobile.moedas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.mobile.moedas.adapter.MoedasListAdapter;
import br.com.ucsal.mobile.moedas.endpoint.MoedasEndpoint;
import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.infra.RetrofitBuilder;
import br.com.ucsal.mobile.moedas.model.Moeda;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        RetrofitBuilder builder = new RetrofitBuilder();
        Retrofit retrofit = builder.build();

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


                //ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,moedas);
                MoedasListAdapter adapter = new MoedasListAdapter(moedas,MainActivity.this);
                listView.setAdapter(adapter);

                AppDatabase db = AppDatabase.getInstance(MainActivity.this);

                for(Moeda moeda : moedas){
                    db.moedaDAO().insereMoeda(moeda);
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT);
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
            System.out.println("Moeda: " + moeda.toString());
            moedas.add(moeda);
        }

        return moedas;
    }
}