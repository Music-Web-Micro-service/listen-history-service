package com.freemusic.listenhistoryservice.services.implement;

import com.freemusic.listenhistoryservice.models.AlbumClickEvent;
import com.freemusic.listenhistoryservice.repositories.AlbumClickEventRepository;
import com.freemusic.listenhistoryservice.services.AlbumClickEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("albumClickEventService")
public class AlbumClickEventServiceImpl implements AlbumClickEventService {
    @Autowired
    AlbumClickEventRepository albumClickEventRepository;
    @Override
    public List<AlbumClickEvent> getListenAlbum(int requireNumAlbum, int overNumberPlayed, int withInDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -withInDay);
        Date res = cal.getTime();
        List<AlbumClickEvent> musicsLists;
        musicsLists = albumClickEventRepository
                .findTopNByPlayedIsGreaterThanEqualAndPublishedDateAfter(overNumberPlayed, res, requireNumAlbum);
        return musicsLists;
    }

    @Override
    public List<AlbumClickEvent> getTopNumberAlbum(int numberAlbum) {
        return albumClickEventRepository.findTopNByPlayedOrderByPlayed(numberAlbum);
    }


    /**
     * update click event each time
     * @param albumClickEvent
     * @return
     */
    @Override
    public List<AlbumClickEvent> updateAlbumClickEvents(List<AlbumClickEvent> albumClickEvent) {
        return albumClickEventRepository.saveAll(albumClickEvent);
    }

}
