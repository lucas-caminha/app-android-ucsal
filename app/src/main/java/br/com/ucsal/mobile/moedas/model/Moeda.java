package br.com.ucsal.mobile.moedas.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.sql.Date;

@Entity(tableName = "emoeda")
public class Moeda {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "code")
    @SerializedName("code")
    private String code;
    @ColumnInfo(name = "codein")
    @SerializedName("codein")
    private String codein;
    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;
    @ColumnInfo(name = "high")
    @SerializedName("high")
    private float high;
    @ColumnInfo(name = "low")
    @SerializedName("low")
    private float low;
    @ColumnInfo(name = "varBid")
    @SerializedName("varBid")
    private float varBid;
    @ColumnInfo(name = "pctChange")
    @SerializedName("pctChange")
    private float pctChange;
    @ColumnInfo(name = "big")
    @SerializedName("big")
    private float big;
    @ColumnInfo(name = "ask")
    @SerializedName("ask")
    private float ask;
    @ColumnInfo(name = "timestamp")
    @SerializedName("timestamp")
    private String timestamp;
    @ColumnInfo(name = "create_date")
    @SerializedName("create_date")
    private String create_date;

    public Moeda(){
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getVarBid() {
        return varBid;
    }

    public void setVarBid(float varBid) {
        this.varBid = varBid;
    }

    public float getPctChange() {
        return pctChange;
    }

    public void setPctChange(float pctChange) {
        this.pctChange = pctChange;
    }

    public float getBig() {
        return big;
    }

    public void setBig(float big) {
        this.big = big;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Moeda{" +
                "code='" + code + '\'' +
                ", codein='" + codein + '\'' +
                ", name='" + name + '\'' +
                ", high=" + high +
                ", low=" + low +
                ", varBid=" + varBid +
                ", pctChange=" + pctChange +
                ", big=" + big +
                ", ask=" + ask +
                ", timestamp='" + timestamp + '\'' +
                ", create_date=" + create_date +
                '}';
    }

}
