package br.com.ucsal.mobile.moedas.infra;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import br.com.ucsal.mobile.moedas.DAO.MoedaDAO;
import br.com.ucsal.mobile.moedas.model.Moeda;

@Database(entities = Moeda.class, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "moedas_db";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract MoedaDAO moedaDAO();



}
