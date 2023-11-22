package com.freemusic.listenhistoryservice.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class AlbumClickEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String albumClickId;

    private String uniqueId;
    private Date publishedDate;
    private Long played;
    private Long commentsCount;
    private Long userLikes;
    private String albumName;
}
