package com.mjc.school.controller.Impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.Dto.NewsDto;
import com.mjc.school.service.Impl.ServiceImpl;
import com.mjc.school.service.Service;

import java.util.List;

public class ControllerImpl implements Controller<NewsDto>{

    private Service<NewsDto> service;

    public ControllerImpl() {
        service = new ServiceImpl();
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        return service.create(newsDto);
    }

    @Override
    public List<NewsDto> getAll() {
        return service.getAll();
    }

    @Override
    public NewsDto getById(Long id) {
        return service.getById(id);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        return service.update(newsDto);
    }

    @Override
    public Boolean delete(Long id) {
        return service.delete(id);
    }
}
