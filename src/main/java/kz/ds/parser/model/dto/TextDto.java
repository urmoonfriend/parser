package kz.ds.parser.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TextDto {
    private Long id;
    private String sentence;
}
