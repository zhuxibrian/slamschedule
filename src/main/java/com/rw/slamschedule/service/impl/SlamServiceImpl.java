package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.bean.SlamMap;
import com.rw.slamschedule.domain.Slam;
import com.rw.slamschedule.repository.SlamRepository;
import com.rw.slamschedule.service.SlamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SlamServiceImpl implements SlamService{

    private SlamMap slamMap;
    private SlamRepository slamRepository;

    @Autowired
    public SlamServiceImpl(SlamRepository repository, SlamMap list) {
        this.slamMap = list;
        this.slamRepository = repository;
    }

    @Override
    public void addSlam(Slam slam) {
        slamRepository.saveAndFlush(slam);
        slamMap.addOrUpdateSlam(slam);
    }

    @Override
    @Transactional
    public void updateSlam(Slam slam) {
        if (slamMap.isNeedUpdateDao(slam))
            slamRepository.saveAndFlush(slam);

        slamMap.addOrUpdateSlam(slam);
    }

    @Override
    public void removeSlam(Slam slam) {
        slamMap.removeSlam(slam.getId());
        slamRepository.delete(slam);
    }

    @Override
    public Slam findOne(String id) {
        return slamMap.findOneById(id);
    }

    @Override
    public List<Slam> findByGroupId(String groupId) {
        return slamMap.findByGroupId(groupId);
    }

    @Override
    public List<Slam> findAll() {
        return slamMap.findAll();
    }

    @Override
    public List<Slam> findByState(String state) {
        return slamMap.findByState(state);
    }


}
