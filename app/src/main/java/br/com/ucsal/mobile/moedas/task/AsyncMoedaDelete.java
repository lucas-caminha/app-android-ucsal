package br.com.ucsal.mobile.moedas.task;

import android.app.Activity;
import android.os.AsyncTask;

import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.model.Moeda;

public class AsyncMoedaDelete extends AsyncTask<Integer, Integer, Boolean> {

    private Activity activity;
    private Moeda moeda;

    public AsyncMoedaDelete(Activity activity, Moeda moeda) {
        this.activity = activity;
        this.moeda = moeda;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        System.out.println("DELETANDO MOEDA");
        AppDatabase.getInstance(activity.getApplicationContext()).moedaDAO().deletaMoeda(moeda);
        return true;
    }
}
