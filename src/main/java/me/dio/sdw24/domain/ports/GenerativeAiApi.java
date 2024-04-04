package me.dio.sdw24.domain.ports;

public interface GenerativeAiApi {
    String generateContent(String objective, String context);
}
