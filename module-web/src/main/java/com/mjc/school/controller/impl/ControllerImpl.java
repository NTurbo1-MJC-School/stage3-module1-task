package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.Dto.NewsDto;
import com.mjc.school.service.impl.ServiceImpl;
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
    public List<NewsDto> readAll() {
        return service.readAll();
    }

    @Override
    public NewsDto readById(Long id) {
        return service.readById(id);
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
