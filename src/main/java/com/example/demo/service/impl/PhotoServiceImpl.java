/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.Photo;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service

public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    
    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }
    
}
