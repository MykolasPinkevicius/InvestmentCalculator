package com.mykolaspinkevicius.InvestmentCalculator.Market.Stack;

import java.util.Objects;

public class Pagination {
    private String limit;
    private String offset;
    private String count;
    private String total;

    public Pagination(String limit, String offset, String count, String total) {
        this.limit = limit;
        this.offset = offset;
        this.count = count;
        this.total = total;
    }

    public Pagination() {}

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagination that = (Pagination) o;
        return Objects.equals(limit, that.limit) && Objects.equals(offset, that.offset) && Objects.equals(count, that.count) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, offset, count, total);
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "limit='" + limit + '\'' +
                ", offset='" + offset + '\'' +
                ", count='" + count + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
