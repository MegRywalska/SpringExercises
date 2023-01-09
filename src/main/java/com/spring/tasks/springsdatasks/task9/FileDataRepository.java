package com.spring.tasks.springsdatasks.task9;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Integer> {

    List<Book>
    @Override
    List<FileData> findAll();
}
