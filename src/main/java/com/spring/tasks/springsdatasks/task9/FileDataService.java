package com.spring.tasks.springsdatasks.task9;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.spring.tasks.springsdatasks.task9.FileDataDTO.fromFileData;

@Service
@RequiredArgsConstructor
@Transactional
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
        fileDataRepository.save(fromFileData(fileDataDTO));
        return fileDataDTO;
    }

    public ResponseEntity updateFile(Integer id, FileDataDTO fileDataDTO) throws SampleException {
        Optional<FileData> fileDataOptional = fileDataRepository.findById(id);
        if (fileDataOptional.isEmpty()){
            throw new SampleException("File not exist");
        }else {
            FileData fileData = fileDataOptional.get();
            fileData.setFilename(fileDataDTO.getFilename());
            fileData.setExtension(fileDataDTO.getExtension());
            fileData.setSizeIdKb(fileData.getSizeIdKb());
            fileData.setContent(fileData.getContent());

            fileDataRepository.save(fileData);

            return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
        }
    }

    public ResponseEntity deleteFile(Integer id) {
        Optional<FileData> fileDataOptional = fileDataRepository.findById(id);
        if (fileDataOptional.isPresent()){
            fileDataRepository.deleteById(id);
            return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
        }else {
            throw new SampleException("File not exist");
        }
    }
}
