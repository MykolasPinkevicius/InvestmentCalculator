package com.mykolaspinkevicius.InvestmentCalculator.Market.Stack;

import java.util.List;
import java.util.Objects;

public class MarketStack {
    private Pagination pagination;
    private List<MarketStackData> data;

    public MarketStack(Pagination pagination, List<MarketStackData> data) {
        this.pagination = pagination;
        this.data = data;
    }

    public MarketStack() {}

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<MarketStackData> getData() {
        return data;
    }

    public void setData(List<MarketStackData> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketStack that = (MarketStack) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, data);
    }

    @Override
    public String toString() {
        return "MarketStack{" +
                "pagination=" + pagination +
                ", data=" + data +
                '}';
    }
}
