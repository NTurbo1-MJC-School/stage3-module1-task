package com.mjc.school.repository.utils;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class DataSource {

    private List<NewsModel> newsModelList;
    private List<AuthorModel> authorModelList;

    public DataSource() {
        newsModelList = generateNewsData();
    }

    public List<NewsModel> generateNewsData() {
        BufferedReader newsReader = null;
        BufferedReader contentReader = null;
        try {
            newsReader = new BufferedReader(new FileReader("./module-repository/src/main/resources/news.txt"));

            newsReader.lines().forEach(line -> {

                NewsModel newsModel = new NewsModel();
                newsModel.setId(Long.parseLong(String.valueOf(new Random().nextInt(21))));
                newsModel.setTitle(line);
                newsModel.setAuthorId(Long.parseLong(String.valueOf(new Random().nextInt(21))));
                newsModel.setCreateDate(LocalDateTime.parse("2023-06-18T14:00:00"));
                newsModel.setLastUpdateDate(LocalDateTime.parse("2023-06-18T16:45:00"));

                newsModelList.add(newsModel);
            });

            contentReader = new BufferedReader(new FileReader("./module-repository/src/main/resources/content.txt"));
            List<String> lines = contentReader.lines().toList();
            for (int i = 0; i < lines.size(); i++) {
                for (NewsModel newsModel : newsModelList) {
                    if (newsModel.getId().equals(Long.parseLong(String.valueOf(i+1)))) {
                        newsModel.setContent(lines.get(i));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (newsReader != null) {
                try {
                    newsReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

            if (contentReader != null) {
                try {
                    contentReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        return newsModelList;
    }
}
