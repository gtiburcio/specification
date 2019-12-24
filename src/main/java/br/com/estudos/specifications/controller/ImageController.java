package br.com.estudos.specifications.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @CrossOrigin
    @PostMapping("/uploads")
    public ResponseEntity<Void> receiveImage(@RequestParam("imageType") Integer imageType, @RequestParam("file") MultipartFile file) {
        System.out.println(file.getName());
        return ResponseEntity.noContent().build();
    }
}
