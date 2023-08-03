package com.freemusic.listenhistoryservice.controllers;

import com.freemusic.listenhistoryservice.models.PlayHistory;
import com.freemusic.listenhistoryservice.services.PlayHistoryService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/play-history")
public class PlayHistoryController {

    private final PlayHistoryService playHistoryService;

    @Autowired
    public PlayHistoryController(PlayHistoryService playHistoryService) {
        this.playHistoryService = playHistoryService;
    }

    @PostMapping
    public ResponseEntity<PlayHistory> savePlayHistory(@RequestBody PlayHistory playHistory) {
        PlayHistory savedPlayHistory = playHistoryService.savePlayHistory(playHistory);
        return new ResponseEntity<>(savedPlayHistory, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PlayHistory>> getPlayHistoriesByUserId(@PathVariable Integer userId) {
        List<PlayHistory> playHistory = playHistoryService.getPlayHistoriesByUserId(userId);
        return ResponseEntity.ok(playHistory);
    }

    @PutMapping
    public ResponseEntity<PlayHistory> updatePlayHistory(@RequestBody PlayHistory playHistory) {
        PlayHistory updatedPlayHistory = playHistoryService.updatePlayHistory(playHistory);
        return ResponseEntity.ok(updatedPlayHistory);
    }

    @DeleteMapping("/{playHistoryId}")
    public ResponseEntity<Void> deletePlayHistory(@PathVariable String playHistoryId) {
        PlayHistory playHistoryToDelete = new PlayHistory();
        playHistoryToDelete.setPlayHistoryId(playHistoryId);
        playHistoryService.deletePlayHistory(playHistoryToDelete);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> removeUserAllHistories(@PathVariable String userId) {
        playHistoryService.removeUserAllHistories(userId);
        return ResponseEntity.noContent().build();
    }
}
