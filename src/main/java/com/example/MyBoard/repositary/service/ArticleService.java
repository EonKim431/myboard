package com.example.MyBoard.repositary.service;

import com.example.MyBoard.dto.ArticleDto;
import com.example.MyBoard.entity.Article;
import com.example.MyBoard.repositary.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;


    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public List<ArticleDto> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(x -> ArticleDto.fromEntity(x))
                .toList();
    }

    public void add(ArticleDto dto) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        articleRepository.save(article);
    }

    public ArticleDto findById(Long id) {
        return ArticleDto.fromEntity(articleRepository.findById(id).orElse(null));
    }

    public void update(ArticleDto dto) {
        Article article = ArticleDto.fromDto(dto);
        articleRepository.save(article);
    }

    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
}
