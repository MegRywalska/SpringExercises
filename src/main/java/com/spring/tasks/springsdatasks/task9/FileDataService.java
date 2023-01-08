package com.spring.tasks.springsdatasks.task9;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public List<FileDataDTO> findAll() {
        return fileDataRepository.findAll()
                .stream()
                .map(FileDataDTO::fromFileDto)
                .collect(Collectors.toList());
    }

    public FileDataDTO findById(Integer id) {
        return FileDataDTO.fromFileDto(fileDataRepository.findById(id).orElseThrow());
    }

    public FileDataDTO saveFile(FileDataDTO fileDataDTO) {
        fileDataRepository.save(FileDataDTO.fromFileData(fileDataDTO));
        return fileDataDTO;
    }
}
