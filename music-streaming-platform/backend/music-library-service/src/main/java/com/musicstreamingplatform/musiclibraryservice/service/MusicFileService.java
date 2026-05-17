package com.musicstreamingplatform.musiclibraryservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstreamingplatform.musiclibraryservice.model.MusicFile;
import com.musicstreamingplatform.musiclibraryservice.repository.MusicFileRepository;

@Service
public class MusicFileService {

    private final MusicFileRepository musicFileRepository;

    @Autowired
    public MusicFileService(MusicFileRepository musicFileRepository) {
        this.musicFileRepository = musicFileRepository;
    }

    public List<MusicFile> getAllMusicFiles() {
        return StreamSupport
            .stream(musicFileRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    public MusicFile getMusicFileById(Long id) {
        return musicFileRepository.findById(id).orElse(null);
    }

    public MusicFile createMusicFile(MusicFile musicFile) {
        return musicFileRepository.save(musicFile);
    }

    public MusicFile updateMusicFile(MusicFile musicFile) {
        MusicFile existingMusicFile = getMusicFileById(musicFile.getId());
        if (existingMusicFile != null) {
            existingMusicFile.setFileName(musicFile.getFileName());
            existingMusicFile.setFilePath(musicFile.getFilePath());
            return musicFileRepository.save(existingMusicFile);
        } else {
            return null;
        }
    }

    public void deleteMusicFile(Long id) {
        musicFileRepository.deleteById(id);
    }

}