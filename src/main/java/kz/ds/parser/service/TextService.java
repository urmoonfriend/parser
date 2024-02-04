package kz.ds.parser.service;

import kz.ds.parser.model.entity.Text;

import java.util.List;
import java.util.Optional;

public interface TextService {
    Optional<Text> findById(Long id);

    Optional<Text> create(Text text);

    Optional<Text> update(Text text);

    List<String> getSentences(Text text);

    void deleteById(Long id);
}
