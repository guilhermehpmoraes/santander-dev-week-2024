package me.dio.sdw24.adapters.out;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import me.dio.sdw24.domain.ports.GenerativeAiApi;

@FeignClient(name = "openAiChatApi", url = "${openai.base-url}")
public interface OpenAiChatApi extends GenerativeAiApi {

    @PostMapping("/v1/chat/completions")
    OpenAiChatCompletionResp chatCompletion(OpenAiChatCompletionReq req);

    @Override
    default String generateContent(String objective, String context) {
        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(
                new Message("system", objective),
                new Message("user", context));
        OpenAiChatCompletionReq req = new OpenAiChatCompletionReq(model, messages);
        return null;
    }

    record OpenAiChatCompletionReq(String model, List<Message> massages) {
    }

    record Message(String role, String content) {
    }

    record OpenAiChatCompletionResp(List<Choice> choices) {
    }

    record Choice(Message message) {
    }
}
