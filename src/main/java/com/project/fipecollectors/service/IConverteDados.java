package com.project.fipecollectors.service;

public interface IConverteDados {
    <T> T colecaoDados(String json, Class<T> classe);
}
