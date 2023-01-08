package com.spring.tasks.springsdatasks.task9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FileDataDTO {

    private Integer id;
    private String filename;
    private String extension;
    private int sizeIdKb;
    private String content;

    public static FileDataDTO fromFileDto(FileData fileData){
        return FileDataDTO.builder()
                .id(fileData.getId())
                .filename(fileData.getFilename())
                .extension(fileData.getExtension())
                .sizeIdKb(fileData.getSizeIdKb())
                .content(fileData.getContent())
                .build();
    }

    public static FileData fromFileData(FileDataDTO fileDataDTO){
        return FileData.builder()
                .id(fileDataDTO.getId())
                .filename(fileDataDTO.getFilename())
                .extension(fileDataDTO.getExtension())
                .sizeIdKb(fileDataDTO.getSizeIdKb())
                .content(fileDataDTO.getContent())
                .build();
    }
}
