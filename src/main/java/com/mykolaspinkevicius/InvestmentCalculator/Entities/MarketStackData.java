package com.mykolaspinkevicius.InvestmentCalculator.Entities;

import java.util.Objects;

public class MarketStackData {

    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String adj_high;
    private String adj_low;
    private String adj_close;
    private String adj_open;
    private String adj_volume;
    private String symbol;
    private String exchange;
    private String date;

    public MarketStackData(String open, String high, String low, String close, String volume, String adj_high, String adj_low, String adj_close, String adj_open, String adj_volume, String symbol, String exchange, String date) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adj_high = adj_high;
        this.adj_low = adj_low;
        this.adj_close = adj_close;
        this.adj_open = adj_open;
        this.adj_volume = adj_volume;
        this.symbol = symbol;
        this.exchange = exchange;
        this.date = date;
    }

    public MarketStackData() {}

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAdj_high() {
        return adj_high;
    }

    public void setAdj_high(String adj_high) {
        this.adj_high = adj_high;
    }

    public String getAdj_low() {
        return adj_low;
    }

    public void setAdj_low(String adj_low) {
        this.adj_low = adj_low;
    }

    public String getAdj_close() {
        return adj_close;
    }

    public void setAdj_close(String adj_close) {
        this.adj_close = adj_close;
    }

    public String getAdj_open() {
        return adj_open;
    }

    public void setAdj_open(String adj_open) {
        this.adj_open = adj_open;
    }

    public String getAdj_volume() {
        return adj_volume;
    }

    public void setAdj_volume(String adj_volume) {
        this.adj_volume = adj_volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketStackData that = (MarketStackData) o;
        return Objects.equals(open, that.open) && Objects.equals(high, that.high) && Objects.equals(low, that.low) && Objects.equals(close, that.close) && Objects.equals(volume, that.volume) && Objects.equals(adj_high, that.adj_high) && Objects.equals(adj_low, that.adj_low) && Objects.equals(adj_close, that.adj_close) && Objects.equals(adj_open, that.adj_open) && Objects.equals(adj_volume, that.adj_volume) && Objects.equals(symbol, that.symbol) && Objects.equals(exchange, that.exchange) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(open, high, low, close, volume, adj_high, adj_low, adj_close, adj_open, adj_volume, symbol, exchange, date);
    }

    @Override
    public String toString() {
        return "MarketStackData{" +
                "open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                ", adj_high='" + adj_high + '\'' +
                ", adj_low='" + adj_low + '\'' +
                ", adj_close='" + adj_close + '\'' +
                ", adj_open='" + adj_open + '\'' +
                ", adj_volume='" + adj_volume + '\'' +
                ", symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
