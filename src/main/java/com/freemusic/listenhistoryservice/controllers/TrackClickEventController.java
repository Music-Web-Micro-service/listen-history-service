package com.freemusic.listenhistoryservice.controllers;

import com.freemusic.listenhistoryservice.models.TrackClickEvent;
import com.freemusic.listenhistoryservice.requests.GetNumberTrackRequest;
import com.freemusic.listenhistoryservice.services.TrackClickEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/history/tracks")
public class TrackClickEventController {

    @Autowired
    TrackClickEventService trackClickEventService;

    /**
     * According to data response number of track we want
     * @param request
     * @return
     */
    @GetMapping("/listen")
    public ResponseEntity<?> getNumberTrack(@RequestBody GetNumberTrackRequest request) {
        return  ResponseEntity.ok(trackClickEventService.getListenMusic(request.getRequireNumTrack(), request.getPlayed(), request.getWithIndDate()));
    }

    @GetMapping("/top/{numberTrack}")
    public ResponseEntity<?> getTopNumberTrack(@PathVariable("numberTrack")  int numberTrack) {
        if(numberTrack < 0) {
            return ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.ok(trackClickEventService.getTopNumberTrack(numberTrack));
    }

    @PutMapping("/update")
    public List<TrackClickEvent> updateAlbumClickEvent(@RequestBody List<TrackClickEvent> trackClickEvents) {

        return trackClickEventService.updateTrackClickEvents(trackClickEvents);
    }
}
