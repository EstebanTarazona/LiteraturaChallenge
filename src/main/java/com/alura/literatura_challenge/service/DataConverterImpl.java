package com.alura.literatura_challenge.service;

public interface DataConverterImpl {
    public <T> T convertData(String json, Class<T> tClass);
}
