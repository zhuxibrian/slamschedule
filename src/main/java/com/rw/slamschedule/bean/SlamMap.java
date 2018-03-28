package com.rw.slamschedule.bean;

import com.rw.slamschedule.domain.Slam;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SlamMap {

    private Map<String, Slam> slamMap;

    public SlamMap() {
        this.slamMap = new ConcurrentHashMap<>();
    }
    
    public void addOrUpdateSlam(Slam slam) {
        slamMap.put(slam.getId(), slam);
    }

    public void removeSlam(String id) {
        slamMap.remove(id);
    }

    public Slam findOneById(String id) {
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
        if (slamMap.get(slam.getId()) == null)
            return true;

        if (slam.getState().equals(slamMap.get(slam.getId()).getState())
                && Objects.equals(slam.getGroupId(), slamMap.get(slam.getId()).getGroupId()))
            return false;
        else
            return true;

    }

    public List<Slam> findByGroupId(String groupId) {
        List<Slam> slams = new ArrayList<>();
        for (Slam slam : slamMap.values()) {
            if (slam.getGroupId().equals(groupId)) {
                slams.add(slam);
            }
        }
        return slams;
    }
}
