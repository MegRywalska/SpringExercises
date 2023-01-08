package com.spring.tasks.springsdatasks.task9;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "file_data")
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_name")
    private String filename;

    private String extension;

    @Column(name = "size_id_kb")
    private int sizeIdKb;

    private String content;
}
