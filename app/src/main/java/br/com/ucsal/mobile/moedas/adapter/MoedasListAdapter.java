package br.com.ucsal.mobile.moedas.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ucsal.mobile.moedas.R;
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

        TextView codigo = v.findViewById(R.id.cod_name);
        TextView cotacao = v.findViewById(R.id.cotacao);
        TextView var = v.findViewById(R.id.variacao);
        TextView dtUltimaAtualizacao = v.findViewById(R.id.data_ultima_atualizacao);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);

        codigo.setText("Moeda: " + moeda.getCode() + " - " + moeda.getName());

        if (moedas.get(i).getVarBid() >= 0.00){
            cotacao.setText("Cotação: " + df.format(moeda.getHigh()));
            var.setText("Variação: +" + df.format(moeda.getVarBid()));
            var.setTextColor(Color.parseColor("#008000"));
        } else {
            cotacao.setText("Cotação: " +  df.format(moeda.getLow()));
            var.setText("Variação: " + df.format(moeda.getVarBid()));
            var.setTextColor(Color.parseColor("#FF0000"));
        }

        dtUltimaAtualizacao.setText("Atualização: " + moeda.getCreate_date());

        return v;
    }

}
