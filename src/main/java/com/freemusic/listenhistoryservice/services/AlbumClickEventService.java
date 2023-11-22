package com.freemusic.listenhistoryservice.services;

import com.freemusic.listenhistoryservice.models.AlbumClickEvent;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AlbumClickEventService {
    List<AlbumClickEvent> getListenAlbum(int requireNumAlbum, int overNumberPlayed, int withInDay);
    List<AlbumClickEvent> getTopNumberAlbum(int numberAlbum);

    List<AlbumClickEvent> updateAlbumClickEvents(List<AlbumClickEvent> albumClickEvent);
}
