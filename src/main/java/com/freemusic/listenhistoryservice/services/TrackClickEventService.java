package com.freemusic.listenhistoryservice.services;

import com.freemusic.listenhistoryservice.models.TrackClickEvent;

import java.util.List;


public interface TrackClickEventService {
    List<TrackClickEvent> getListenMusic(int requireNumMusic, int overNumberPlayed, int withInDay);
    List<TrackClickEvent> getTopNumberTrack(int numberMusic);

    List<TrackClickEvent> updateTrackClickEvents(List<TrackClickEvent> trackClickEvents);
}
