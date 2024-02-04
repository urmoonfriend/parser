package kz.ds.parser.scheduler;

import kz.ds.parser.model.entity.Text;
import kz.ds.parser.service.SourceService;
import kz.ds.parser.service.TextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParseScheduler {

    private final TextService textService;
    private final SourceService sourceService;

    @Scheduled(cron = "${scheduler.parse}")
    public void parseFromWebsite() {
        sourceService.findById(1L).ifPresent(
                source -> {
                    try {
                        URL url = new URL(source.getUrl());
                        URLConnection con = url.openConnection();
                        InputStream is = con.getInputStream();

                        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                            String line = null;
                            String answer = null;
                            while ((line = br.readLine()) != null) {
                                if (line.contains("ref\"")) {
                                    answer = line;
                                }
                            }
                            // TODO operate with text
                            /*answer = answer.substring(answer.indexOf("ref\"") + 5);
                            answer = answer.substring(0, answer.indexOf("}],") + 3);
                            ObjectMapper objectMapper = new ObjectMapper();
                            List<?> list = objectMapper.readValue(answer, new TypeReference<List<?>>() {
                            });
                            textService.create(list);
                            */
                            textService.getSentences(
                                            new Text()
                                                    .setSentence(answer))
                                    .forEach(
                                            sentence -> textService.create(new Text().setSentence(sentence))
                                    );
                        }
                    } catch (IOException e) {
                        log.error(e.getMessage());
                    }
                }
        );
    }
}
