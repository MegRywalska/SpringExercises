package com.spring.tasks.springsdatasks.task9;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/file-data")
@RequiredArgsConstructor
public class FileDataController {

    private final FileDataService fileDataService;

    @GetMapping("")
    public List<FileDataDTO> getAllFile(){
       return fileDataService.findAll();
    }

    @GetMapping("/{id}")
    public FileDataDTO getFile(@PathVariable Integer id){
        return fileDataService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity postFile(@RequestBody FileDataDTO fileDataDTO){
        FileDataDTO fileData = fileDataService.saveFile(fileDataDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(fileData)
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, location.toString())
                .body(fileData);
    }

    @PutMapping("/{id}")
    public





}
