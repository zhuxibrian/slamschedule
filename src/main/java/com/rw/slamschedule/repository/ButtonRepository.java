package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Button;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButtonRepository extends JpaRepository<Button, String>
{
    Button findByTerminal_IdAndId(String termId, String buttonId);

}
