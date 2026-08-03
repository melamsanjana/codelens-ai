package com.codelens.backend.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AIService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public AIService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private String askAI(String prompt) {

        String body = """
        {
          "model":"meta-llama/llama-3.1-8b-instruct",
          "messages":[
            {
              "role":"user",
              "content":%s
            }
          ]
        }
        """.formatted(toJson(prompt));

        String response = webClient.post()
        .uri("/chat/completions")
        .header("Authorization", "Bearer " + apiKey)
        .header("Referer", "http://localhost:5173")
        .header("X-Title", "CodeLens AI")
        .bodyValue(body)
        .retrieve()
        .bodyToMono(String.class)
        .block();

System.out.println(response);

return response;
    }

    private String toJson(String text) {
        return "\"" +
                text.replace("\\", "\\\\")
                        .replace("\"", "\\\"")
                        .replace("\n", "\\n")
                        .replace("\r", "") +
                "\"";
    }

  public String explainError(String error) {
    String prompt = """
Explain the following error message and suggest a fix:
%s
""".formatted(error);

    return askAI(prompt);
  }

  public String reviewCode(String code) {
    String prompt = """
Review the following Java code and provide constructive suggestions:
%s
""".formatted(code);

    return askAI(prompt);
  }

  public String fixCode(String code) {
    String prompt = """
Fix the following Java code and return the corrected version:
%s
""".formatted(code);

    return askAI(prompt);
  }
}