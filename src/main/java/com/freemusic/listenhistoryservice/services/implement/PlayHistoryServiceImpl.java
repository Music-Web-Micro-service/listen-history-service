package com.freemusic.listenhistoryservice.services.implement;

import com.freemusic.listenhistoryservice.models.PlayHistory;
import com.freemusic.listenhistoryservice.repositories.PlayHistoryRepository;
import com.freemusic.listenhistoryservice.services.PlayHistoryService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.ws.rs.NotFoundException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoCollectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayHistoryServiceImpl implements PlayHistoryService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PlayHistoryServiceImpl(PlayHistoryRepository playHistoryRepository, MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PlayHistory savePlayHistory(PlayHistory playHistory) {
        return mongoTemplate.save(playHistory, String.valueOf(playHistory.getUserId()));
    }

    @Override
    public List<PlayHistory> getPlayHistoriesByUserId(Integer userId) {
        return mongoTemplate.findAll(PlayHistory.class, String.valueOf(userId));
    }


    @Override
    public PlayHistory updatePlayHistory(PlayHistory playHistory) {
        return mongoTemplate.save(playHistory, String.valueOf(playHistory.getUserId()));
    }

    @Override
    public void deletePlayHistory(PlayHistory playHistory) {
        Query query = new Query();
        query.addCriteria(Criteria.where("playHistoryId").is(playHistory.getPlayHistoryId()));
        mongoTemplate.findAndRemove(query, PlayHistory.class, String.valueOf(playHistory.getUserId()));
    }

    @Override
    public void removeUserAllHistories(String userId) {
        mongoTemplate.dropCollection(String.valueOf(userId));
    }
}
