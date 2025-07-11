package com.bmp.metadata.service;

import com.bmp.metadata.entity.Language;
import com.bmp.metadata.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }
}
