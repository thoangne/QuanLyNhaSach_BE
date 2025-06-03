package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Publisher;
import java.util.List;

public interface PublisherService {
    List<Publisher> getAllPublishers();

    Publisher getPublisherById(int id);

    Publisher createPublisher(Publisher publisher);

    Publisher updatePublisher(int id, Publisher publisher);

    boolean deletePublisher(int id);
}