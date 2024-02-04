package kz.ds.parser.service.impl;

import kz.ds.parser.model.entity.Source;
import kz.ds.parser.repository.SourceRepository;
import kz.ds.parser.service.SourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SourceServiceImpl implements SourceService {
    private final SourceRepository sourceRepository;

    @Override
    public Optional<Source> create(Source source) {
        return Optional.of(sourceRepository.save(source));
    }

    @Override
    public Optional<Source> update(Source source) {
        Optional<Source> result = Optional.empty();
        var sourceOpt = sourceRepository.findById(source.getId());
        if (sourceOpt.isPresent()) {
            Source sourceToUpdate = sourceOpt.get();
            sourceToUpdate.setUrl(source.getUrl());
            result = Optional.of(sourceRepository.save(sourceToUpdate));
        }
        return result;
    }

    @Override
    public Optional<Source> findById(Long id) {
        return sourceRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        sourceRepository.deleteById(id);
    }
}
