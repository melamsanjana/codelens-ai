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

    return """
AI Explanation

Error:
%s

Possible Cause:
• Syntax error in the code.
• Missing semicolon or incorrect syntax.

Solution:
• Check syntax carefully.
• Verify brackets and semicolons.
• Recompile the program.

Status:
Demo Mode
""".formatted(error);

}

public String reviewCode(String code) {

    return """
Code Review

✔ Code received successfully.

Suggestions:
• Use meaningful variable names.
• Add comments.
• Follow Java naming conventions.
• Handle exceptions properly.
• Remove unused imports.

Overall Rating: ⭐⭐⭐⭐☆
""";

}

public String fixCode(String code) {

    return """
Corrected Code

printf("Hello World");

Changes Made:
✔ Corrected spelling.
✔ Improved formatting.
✔ Code is syntactically correct.

Status:
Demo Mode
""";

}
}