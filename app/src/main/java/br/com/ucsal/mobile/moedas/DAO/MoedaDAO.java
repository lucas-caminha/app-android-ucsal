package br.com.ucsal.mobile.moedas.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.ucsal.mobile.moedas.model.Moeda;

@Dao
public interface MoedaDAO {

    @Insert
    void insereMoeda(Moeda moeda);

   @Query(value = "SELECT * FROM emoeda")
    List<Moeda> buscaTodasMoedas();

   @Delete
    void deletaMoeda(Moeda moeda);

   @Update
    void atualizaMoeda(Moeda moeda);

}
