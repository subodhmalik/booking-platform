package com.bmp.metadata.controller;

import com.bmp.metadata.entity.Language;
import com.bmp.metadata.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public List<Language> getAll() {
        return languageService.getAllLanguages();
    }

    @PostMapping
    public Language create(@RequestBody Language language) {
        return languageService.saveLanguage(language);
    }
}
