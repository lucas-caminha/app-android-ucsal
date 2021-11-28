package br.com.ucsal.mobile.moedas.task;

import android.app.Activity;
import android.os.AsyncTask;

import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.model.Moeda;

public class AsyncMoedaUpdate extends AsyncTask<Integer, Integer, Boolean> {

    private Activity activity;
    private Moeda moeda;

    public AsyncMoedaUpdate(Activity activity, Moeda moeda) {
        this.activity = activity;
        this.moeda = moeda;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        System.out.println("Atualizando moeda " + moeda.getName());
        AppDatabase.getInstance(activity.getApplicationContext()).moedaDAO().atualizaMoeda(moeda);
        return true;
    }
}
