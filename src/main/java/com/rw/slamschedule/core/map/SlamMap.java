package com.rw.slamschedule.core.map;

import com.rw.slamschedule.domain.Slam;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SlamMap {

    private Map<Integer, Slam> slamMap;

    public SlamMap() {
        this.slamMap = new ConcurrentHashMap<>();
    }
    
    public void addOrUpdateSlam(Slam slam) {
        slamMap.put(slam.getSlamId(), slam);
    }

    public void removeSlam(Integer id) {
        slamMap.remove(id);
    }

    public Slam findOneById(Integer id) {
        return slamMap.get(id);
    }
    
    public Slam findOneByState(String state) {
        for (Slam slam : slamMap.values()) {
            if (slam.getState().equals(state)) {
                return slam;
            }
        }
        return null;
    }

    public List<Slam> findByState(String state) {
        List<Slam> slams = new ArrayList<>();
        for (Slam slam : slamMap.values()) {
            if (slam.getState().equals(state)) {
                slams.add(slam);
            }
        }

        return slams;
    }

    public List<Slam> findAll() {
        List<Slam> slams = new ArrayList<Slam>(slamMap.values());
        return slams;

    }

    public boolean isNeedUpdateDao(Slam slam) {
        if (slamMap.get(slam.getSlamId()) == null)
            return true;

        if (slam.getState().equals(slamMap.get(slam.getSlamId()).getState()))
            return false;
        else
            return true;

    }
}
