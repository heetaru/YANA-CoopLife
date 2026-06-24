package org.example.yanacooplife.exception;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String massage,
        String detailedMassage,
        LocalDateTime errorTime
) {

}
