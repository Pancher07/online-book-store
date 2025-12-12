package onlinebookstore.dto.error;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDto(
        LocalDateTime time, int status, String path, Map<String,String> errors
) {}
