package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Button;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButtonRepository extends JpaRepository<Button, Integer>
{
    public Button findByTerminal_IdAndAndButtonId(Integer termId, Integer buttonId);

}
