package org.example.yanacooplife.security;

import tools.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.yanacooplife.exception.ErrorResponseDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                "Доступ заборонено",
                "У вас немає доступу до цього ресурсу. Будь ласка, авторизуйтесь (додайте JWT токен).",
                LocalDateTime.now()
        );
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
