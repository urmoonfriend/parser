package kz.ds.parser.clients.reddit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RedditClient", url = "${clients.reddit.url}")
public interface RedditClient {

}
