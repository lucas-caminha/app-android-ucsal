package br.com.ucsal.mobile.moedas.task;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ucsal.mobile.moedas.MainActivity;
import br.com.ucsal.mobile.moedas.infra.AppDatabase;
import br.com.ucsal.mobile.moedas.model.Moeda;

public class AsyncMoedaSelect extends AsyncTask<Integer, Integer, Boolean> {

    private MainActivity activity;
    private List<Moeda> moedasAPI;
    private List<Moeda> moedasDB;

    public AsyncMoedaSelect(MainActivity activity, List<Moeda> moedasAPI){
        this.activity = activity;
        this.moedasAPI = moedasAPI;
    }

    @SuppressLint("WrongThread")
    @Override
    protected Boolean doInBackground(Integer... integers) {
        this.moedasDB = AppDatabase.getInstance(activity.getApplicationContext()).moedaDAO().buscaTodasMoedas();

        if (this.moedasDB == null){
             for(Moeda moeda : moedasAPI){
                new AsyncMoedaInsert(activity, moeda).execute();
             }
        }

        for(int i = 0; i < moedasDB.size(); i++){

            for(int j = 0; j < moedasAPI.size(); j++) {

                if (moedasDB.get(i).getCode().equals(moedasAPI.get(j).getCode()) &&
                        moedasDB.get(i).getCodein().equals(moedasAPI.get(j).getCodein())) {

                    if (comparaDatas(moedasDB.get(i).getCreate_date(), moedasAPI.get(j).getCreate_date())) {
                        // Atualizar a moeda no banco
                        new AsyncMoedaUpdate(activity, moedasAPI.get(j)).execute();
                    }
                }
            }

        }

        return true;
    }

    public boolean comparaDatas(String dataDB, String dataAPI){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dataDBconvertida = sdf.parse(dataDB);
            Date dateAPIconvertida = sdf.parse(dataAPI);

            if (dataDBconvertida.after(dateAPIconvertida)){
                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
