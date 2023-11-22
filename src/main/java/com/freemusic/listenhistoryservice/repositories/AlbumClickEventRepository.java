package com.freemusic.listenhistoryservice.repositories;

import com.freemusic.listenhistoryservice.models.AlbumClickEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AlbumClickEventRepository extends MongoRepository<AlbumClickEvent, String> {
    List<AlbumClickEvent> findTopNByPlayedIsGreaterThanEqualAndPublishedDateAfter(int played, Date publishDate, int topN);
    List<AlbumClickEvent> findTopNByPlayedOrderByPlayed(int topN);
}
