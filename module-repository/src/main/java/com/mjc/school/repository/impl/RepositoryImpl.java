package com.mjc.school.repository.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.utils.DataSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RepositoryImpl implements Repository<NewsModel> {

    private final DataSource dataSource;
    private RepositoryImpl() {
        dataSource = new DataSource();
    }

    private static RepositoryImpl repoInstance;

    public static RepositoryImpl getRepoInstance() {
        if (repoInstance == null) {
            repoInstance = new RepositoryImpl();
        }

        return repoInstance;
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        dataSource.getNewsModelList().add(newsModel);
        return newsModel;
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNewsModelList();
    }

    @Override
    public NewsModel readById(Long id) {
        for (NewsModel newsModel : dataSource.getNewsModelList()) {
            if (newsModel.getId().equals(id)) {
                return newsModel;
            }
        }
        return null;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        for (NewsModel n : dataSource.getNewsModelList()) {
            if (newsModel.getId().equals(n.getId())) {
                dataSource.getNewsModelList().remove(n);
                dataSource.getNewsModelList().add(newsModel);

                return newsModel;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        for (NewsModel newsModel : dataSource.getNewsModelList()) {
            if (newsModel.getId().equals(id)) {
                dataSource.getNewsModelList().remove(newsModel);
                return true;
            }
        }
        return false;
    }
}
