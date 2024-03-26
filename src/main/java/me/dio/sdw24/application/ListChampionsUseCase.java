package me.dio.sdw24.application;

import java.util.List;

import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champions> findAll() {
        return repository.findAll();
    }
}
