package br.com.ucsal.mobile.moedas;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.ucsal.mobile.moedas.model.Moeda;

public class MoedasListAdapter extends BaseAdapter {

    private List<Moeda> moedas;
    private Activity activity;

    public MoedasListAdapter(List<Moeda> moedas, Activity activity) {
        this.moedas = moedas;
        this.activity = activity;
    }

    @Override
    public int getCount() {

        return moedas.size();
    }

    @Override
    public Object getItem(int i) {
        return moedas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = activity.getLayoutInflater().inflate(R.layout.lista_moeda, viewGroup, false);
        Moeda moeda = moedas.get(i);

        TextView codigo = v.findViewById(R.id.text1);
        TextView nome = v.findViewById(R.id.text2);
        TextView high = v.findViewById(R.id.text3);
        TextView low = v.findViewById(R.id.text4);
        TextView var = v.findViewById(R.id.text5);



        codigo.setText("Código:" + moeda.getCode());
        nome.setText("Nome: " + moeda.getName());
        high.setText("Preço mais alto: " + moeda.getHigh());
        low.setText("Preço mais baixo : " + moeda.getLow());
        var.setText("Variação: " + moeda.getVarBid());

        return v;


       // View v = activity.getLayoutInflater().inflate(R.layout.)
       // return null;
    }

}
