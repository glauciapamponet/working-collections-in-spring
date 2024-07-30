package com.project.fipecollectors.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosRetorno(@JsonAlias("codigo") String codigo,
                           @JsonAlias("nome") String nome) {
}
