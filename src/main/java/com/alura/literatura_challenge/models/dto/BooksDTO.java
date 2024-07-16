package com.alura.literatura_challenge.models.dto;

import com.alura.literatura_challenge.entities.Authors;

public record BooksDTO(String title,
                       Authors author,
                       String language,
                       Long downloads) {
}
