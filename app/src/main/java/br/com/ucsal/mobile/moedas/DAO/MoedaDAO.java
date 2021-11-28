package br.com.ucsal.mobile.moedas.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import br.com.ucsal.mobile.moedas.model.Moeda;

@Dao
public interface MoedaDAO {

    @Insert
    void insereMoeda(Moeda moeda);

}
