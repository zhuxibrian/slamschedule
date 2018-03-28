package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Slam;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface SlamService {

    void addSlam(Slam slam);

    @Modifying
    void updateSlam(Slam slam);

    void removeSlam(Slam slam);

    Slam findOne(String id);

    List<Slam> findByGroupId(String groupId);

    List<Slam> findAll();

    List<Slam> findByState(String state);
}
