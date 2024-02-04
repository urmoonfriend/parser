package kz.ds.parser.service.impl;

import kz.ds.parser.model.entity.Text;
import kz.ds.parser.repository.TextRepository;
import kz.ds.parser.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TextServiceImpl implements TextService {
    private final TextRepository textRepository;

    @Override
    public Optional<Text> findById(Long id) {
        return textRepository.findById(id);
    }

    @Override
    public Optional<Text> create(Text text) {
        return Optional.of(textRepository.save(text));
    }

    @Override
    public Optional<Text> update(Text text) {
        Optional<Text> result = Optional.empty();
        var textOpt = textRepository.findById(text.getId());
        if (textOpt.isPresent()) {
            Text textToUpdate = textOpt.get();
            textToUpdate.setSentence(text.getSentence());
            result = Optional.of(textRepository.save(textToUpdate));
        }
        return result;
    }

    @Override
    public List<String> getSentences(Text text) {
        return Arrays.stream(
                text.getSentence().split("."))
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        textRepository.deleteById(id);
    }
}
