package com.musicstreamingplatform.musiclibraryservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstreamingplatform.musiclibraryservice.model.MusicFile;

@Repository
public interface MusicFileRepository extends CrudRepository<MusicFile, Long> {

}