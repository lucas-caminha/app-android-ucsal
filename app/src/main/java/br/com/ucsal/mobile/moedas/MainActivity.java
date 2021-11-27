package br.com.ucsal.mobile.moedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.ucsal.mobile.moedas.infra.MoedasEndpoint;
import br.com.ucsal.mobile.moedas.infra.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RetrofitBuilder builder = new RetrofitBuilder();
        Retrofit retrofit = builder.build();

    }
}