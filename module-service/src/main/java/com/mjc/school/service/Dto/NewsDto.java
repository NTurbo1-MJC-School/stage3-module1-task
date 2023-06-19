package com.mjc.school.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewsDto {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
}
