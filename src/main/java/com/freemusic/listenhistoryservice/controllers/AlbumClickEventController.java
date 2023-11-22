package com.freemusic.listenhistoryservice.controllers;

import com.freemusic.listenhistoryservice.models.AlbumClickEvent;
import com.freemusic.listenhistoryservice.requests.AlbumListenRequest;
import com.freemusic.listenhistoryservice.services.AlbumClickEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history/album")
public class AlbumClickEventController {

    private final AlbumClickEventService albumClickEventService;

    @Autowired
    public AlbumClickEventController(AlbumClickEventService albumClickEventService) {
        this.albumClickEventService = albumClickEventService;
    }

    @GetMapping("/listen")
    public List<AlbumClickEvent> getListenAlbum(@RequestBody AlbumListenRequest request) {
        return albumClickEventService.getListenAlbum(request.getRequireNumAlbum(), request.getOverNumberPlayed(), request.getWithInDay());
    }

    @GetMapping("/top/{numberAlbum}")
    public List<AlbumClickEvent> getTopNumberAlbum(@PathVariable("numberAlbum") int numberAlbum) {
        return albumClickEventService.getTopNumberAlbum(numberAlbum);
    }

    @PutMapping("/update")
    public List<AlbumClickEvent> updateAlbumClickEvent(@RequestBody List<AlbumClickEvent> albumClickEvents) {

        return albumClickEventService.updateAlbumClickEvents(albumClickEvents);
    }
}
