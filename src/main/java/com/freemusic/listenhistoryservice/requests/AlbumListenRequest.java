package com.freemusic.listenhistoryservice.requests;


import lombok.Data;

@Data
public class AlbumListenRequest {
    private int requireNumAlbum;
    private int overNumberPlayed;
    private int withInDay;

}