package com.freemusic.listenhistoryservice.requests;

import lombok.Data;

@Data
public class GetNumberTrackRequest {
    Integer requireNumTrack = 10;
    Integer played = 50;
    Integer withIndDate = 180;

}
