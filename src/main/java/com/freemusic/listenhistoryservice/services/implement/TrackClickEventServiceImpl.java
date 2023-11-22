package com.freemusic.listenhistoryservice.services.implement;

import com.freemusic.listenhistoryservice.models.TrackClickEvent;
import com.freemusic.listenhistoryservice.repositories.TrackClickEventRepository;
import com.freemusic.listenhistoryservice.services.TrackClickEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("trackClickEventService")
public class TrackClickEventServiceImpl implements TrackClickEventService {

    @Autowired
    TrackClickEventRepository trackClickEventRepository;
    @Override
    public List<TrackClickEvent> getListenMusic(int requireNumMusic, int overNumberPlayed, int withInDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -withInDay);
        Date res = cal.getTime();
        List<TrackClickEvent> musicsLists;
        musicsLists = trackClickEventRepository
                .findTopNByPlayedIsGreaterThanEqualAndPublishedDateAfter(overNumberPlayed, res, requireNumMusic);
        return musicsLists;
    }

    @Override
    public List<TrackClickEvent> getTopNumberTrack(int numberMusic) {
        return trackClickEventRepository.findTopNByPlayedOrderByPlayed(numberMusic);
    }

    @Override
    public List<TrackClickEvent> updateTrackClickEvents(List<TrackClickEvent> trackClickEvents) {
        return trackClickEventRepository.saveAll(trackClickEvents);
    }
}
