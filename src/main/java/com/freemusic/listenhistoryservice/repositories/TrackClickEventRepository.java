package com.freemusic.listenhistoryservice.repositories;

import com.freemusic.listenhistoryservice.models.TrackClickEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * the repository to store click event data
 *  for reach track:
 *      likes
 *      played
 *      comments_counts
 */
@Repository
public interface TrackClickEventRepository extends MongoRepository<TrackClickEvent, String> {
    List<TrackClickEvent> findTopNByPlayedIsGreaterThanEqualAndPublishedDateAfter(int played, Date publishDate, int topN);
    List<TrackClickEvent> findTopNByPlayedOrderByPlayed(int topN);
}
