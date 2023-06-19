package com.mjc.school.service.impl;

import com.mjc.school.repository.impl.RepositoryImpl;
import com.mjc.school.repository.Repository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.Dto.NewsDto;
import com.mjc.school.service.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service<NewsDto> {

    private Repository repository;

    public ServiceImpl() {
        repository = RepositoryImpl.getRepoInstance();
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        ModelMapper modelMapper = new ModelMapper();
        NewsModel newsModel = modelMapper.map(newsDto, NewsModel.class);
        repository.create(newsModel);

        return newsDto;
    }

    @Override
    public List<NewsDto> getAll() {
        List<NewsModel> newsModelList = repository.readAll();
        List<NewsDto> newsDtoList = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        for (NewsModel newsModel : newsModelList) {
            newsDtoList.add(modelMapper.map(newsModel, NewsDto.class));
        }

        return newsDtoList;
    }

    @Override
    public NewsDto getById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(repository.readById(id), NewsDto.class);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        repository.update(new ModelMapper().map(newsDto, NewsModel.class));

        return newsDto;
    }

    @Override
    public Boolean delete(Long id) {
        return repository.delete(id);
    }
}
