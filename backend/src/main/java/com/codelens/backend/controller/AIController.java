package com.codelens.backend.controller;

import com.codelens.backend.ai.AIService;
import com.codelens.backend.dto.ExplainRequest;
import com.codelens.backend.dto.ReviewRequest;
import com.codelens.backend.dto.FixRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/explain-error")
    public String explainError(@RequestBody ExplainRequest request) {
        return aiService.explainError(request.getError());
    }

    @PostMapping("/review-code")
    public String reviewCode(@RequestBody ReviewRequest request) {
        return aiService.reviewCode(request.getCode());
    }

    @PostMapping("/fix-code")
    public String fixCode(@RequestBody FixRequest request) {
        return aiService.fixCode(request.getCode());
    }
}