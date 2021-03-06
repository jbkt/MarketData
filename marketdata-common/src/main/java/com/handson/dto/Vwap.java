package com.handson.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Vwap {

    public String code;
    public double vwap;
    public double volume;

    public Vwap() {
    }

    public Vwap(String code, double vwap, double volume) {
        this.code = code;
        this.vwap = vwap;
        this.volume = volume;
    }

    public Vwap addTrade(Trade t) {
        double volume = this.volume + t.quantity;
        double vwap = (this.volume * this.vwap + t.nominal) / volume;
        return new Vwap(t.code, vwap, volume);
    }

    public static Vwap fromJson(String input) {
        return new Gson().fromJson(input, Vwap.class);
    }


    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
