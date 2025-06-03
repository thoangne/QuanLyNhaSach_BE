package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.Publisher;
import com.example.quanlynhasach.repository.PublisherRepository;
import com.example.quanlynhasach.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updatePublisher(int id, Publisher publisher) {
        return publisherRepository.findById(id).map(existingPublisher -> {
            if (publisher.getName() != null) {
                existingPublisher.setName(publisher.getName());
            }
            if (publisher.getAddress() != null) {
                existingPublisher.setAddress(publisher.getAddress());
            }
            if (publisher.getContact() != null) {
                existingPublisher.setContact(publisher.getContact());
            }
            return publisherRepository.save(existingPublisher);
        }).orElse(null);
    }

    @Override
    public boolean deletePublisher(int id) {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}