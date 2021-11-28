package br.com.ucsal.mobile.moedas.task;

import android.app.Activity;
import android.os.AsyncTask;

import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.model.Moeda;

public class AsyncMoedaInsert extends AsyncTask<Integer, Integer, Boolean> {

    private Activity activity;
    private Moeda moeda;

    public AsyncMoedaInsert(Activity activity, Moeda moeda) {
        this.activity = activity;
        this.moeda = moeda;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        System.out.println("INSERINDO MOEDA");
        AppDatabase.getInstance(activity.getApplicationContext()).moedaDAO().insereMoeda(moeda);
        return true;
    }
}
