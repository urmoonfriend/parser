package kz.ds.parser.service;

import kz.ds.parser.model.entity.Source;

import java.util.Optional;

public interface SourceService {
    Optional<Source> create(Source source);

    Optional<Source> update(Source source);

    Optional<Source> findById(Long id);

    void deleteById(Long id);
}
