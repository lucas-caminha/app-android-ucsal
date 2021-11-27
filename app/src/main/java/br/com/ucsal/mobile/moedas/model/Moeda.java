package br.com.ucsal.mobile.moedas.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Moeda {

    @SerializedName("code")
    private String code;
    @SerializedName("codein")
    private String codein;
    @SerializedName("name")
    private String name;
    @SerializedName("high")
    private BigDecimal high;
    @SerializedName("low")
    private BigDecimal low;
    @SerializedName("varBid")
    private BigDecimal varBid;
    @SerializedName("pctChange")
    private BigDecimal pctChange;
    @SerializedName("big")
    private BigDecimal big;
    @SerializedName("ask")
    private BigDecimal ask;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("createDate")
    private Date createDate;

    public Moeda(){
    }

    public Moeda(String code, String codein, String name,
                 BigDecimal high, BigDecimal low, BigDecimal varBid,
                 BigDecimal pctChange, BigDecimal big, BigDecimal ask,
                 String timestamp, Date createDate) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.big = big;
        this.ask = ask;
        this.timestamp = timestamp;
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getVarBid() {
        return varBid;
    }

    public void setVarBid(BigDecimal varBid) {
        this.varBid = varBid;
    }

    public BigDecimal getPctChange() {
        return pctChange;
    }

    public void setPctChange(BigDecimal pctChange) {
        this.pctChange = pctChange;
    }

    public BigDecimal getBig() {
        return big;
    }

    public void setBig(BigDecimal big) {
        this.big = big;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
                ", createDate=" + createDate +
                '}';
    }

}
