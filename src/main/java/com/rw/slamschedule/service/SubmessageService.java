package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Point;
import com.rw.slamschedule.domain.Submessage;

public interface SubmessageService {
    Submessage removeSubmessage(Integer id);
    Submessage updateSubmessage(Submessage submessage);
    Submessage addPoint(Integer id, Point point);
    Submessage findById(Integer id);
}
