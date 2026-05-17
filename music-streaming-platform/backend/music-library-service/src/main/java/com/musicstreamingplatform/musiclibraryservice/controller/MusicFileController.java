package com.musicstreamingplatform.musiclibraryservice.controller;

import com.musicstreamingplatform.musiclibraryservice.model.MusicFile;
import com.musicstreamingplatform.musiclibraryservice.service.MusicFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/music-files")
public class MusicFileController {

    private final MusicFileService musicFileService;

    @Autowired
    public MusicFileController(MusicFileService musicFileService) {
        this.musicFileService = musicFileService;
    }

    @GetMapping
    public ResponseEntity<List<MusicFile>> getAllMusicFiles() {
        return ResponseEntity.ok(musicFileService.getAllMusicFiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicFile> getMusicFileById(@PathVariable Long id) {
        return ResponseEntity.ok(musicFileService.getMusicFileById(id));
    }

    @PostMapping
    public ResponseEntity<MusicFile> createMusicFile(@RequestBody MusicFile musicFile) {
        return ResponseEntity.ok(musicFileService.createMusicFile(musicFile));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicFile> updateMusicFile(@PathVariable Long id, @RequestBody MusicFile musicFile) {
        return ResponseEntity.ok(musicFileService.updateMusicFile(musicFile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusicFile(@PathVariable Long id) {
        musicFileService.deleteMusicFile(id);
        return ResponseEntity.ok().build();
    }

}