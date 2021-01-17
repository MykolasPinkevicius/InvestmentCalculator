package com.mykolaspinkevicius.InvestmentCalculator.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Stock {

    private @Id @GeneratedValue Long id;
    private BigDecimal lastPrice;
    private String tickerSymbol;
    private String name;
    private String stockExchange;

    public Stock(BigDecimal lastPrice, String tickerSymbol, String name, String stockExchange) {
        this.lastPrice = lastPrice;
        this.tickerSymbol = tickerSymbol;
        this.name = name;
        this.stockExchange = stockExchange;
    }

    public Stock() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(lastPrice, stock.lastPrice) && Objects.equals(tickerSymbol, stock.tickerSymbol) && Objects.equals(name, stock.name) && Objects.equals(stockExchange, stock.stockExchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastPrice, tickerSymbol, name, stockExchange);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", lastPrice=" + lastPrice +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                ", name='" + name + '\'' +
                ", stockExchange='" + stockExchange + '\'' +
                '}';
    }
}
