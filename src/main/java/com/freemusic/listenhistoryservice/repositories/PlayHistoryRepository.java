package com.freemusic.listenhistoryservice.repositories;

import com.freemusic.listenhistoryservice.models.PlayHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jackson Chen
 * @version 1.0
 * @date 2023/7/10
 */
@Repository
public interface PlayHistoryRepository extends MongoRepository<PlayHistory, String> {
    PlayHistory getPlayHistoryByUserId(Integer userId);
}
