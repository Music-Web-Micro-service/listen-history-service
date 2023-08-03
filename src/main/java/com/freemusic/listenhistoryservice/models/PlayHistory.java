package com.freemusic.listenhistoryservice.models;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jackson Chen
 * @version 1.0
 * @date 2023/7/10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class PlayHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String playHistoryId;

    private Integer userId;
    private int musicId;
    private String musicName;

}
