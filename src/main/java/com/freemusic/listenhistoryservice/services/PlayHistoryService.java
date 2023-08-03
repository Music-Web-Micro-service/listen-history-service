package com.freemusic.listenhistoryservice.services;

import com.freemusic.listenhistoryservice.models.PlayHistory;

import java.util.List;

public interface PlayHistoryService {
    PlayHistory savePlayHistory(PlayHistory playHistory);

    List<PlayHistory> getPlayHistoriesByUserId(Integer userId);

    PlayHistory updatePlayHistory(PlayHistory playHistory);

    void deletePlayHistory(PlayHistory playHistoryId);
    void removeUserAllHistories(String userId);
}