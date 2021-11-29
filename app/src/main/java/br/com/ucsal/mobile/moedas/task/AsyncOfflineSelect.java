package br.com.ucsal.mobile.moedas.task;

import android.os.AsyncTask;

import java.util.List;

import br.com.ucsal.mobile.moedas.MainActivity;
import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.model.Moeda;

public class AsyncOfflineSelect extends AsyncTask<Integer, Integer, Boolean> {

    private List<Moeda> moedasDB;
    private MainActivity activity;

    public AsyncOfflineSelect(List<Moeda> moedasDB, MainActivity activity) {
        this.moedasDB = moedasDB;
        this.activity = activity;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        this.moedasDB = AppDatabase.getInstance(activity.getApplicationContext()).moedaDAO().buscaTodasMoedas();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        System.out.println("Tamanho da Lista: " + moedasDB.size());
        super.onPostExecute(aBoolean);
    }
}
