package com.dddd.croom.demo.repository;

import com.dddd.croom.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.hand_up FROM User u WHERE u.name=:name")
    boolean getHand_state(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.name=:name")
    void deleteByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE User u set u.hand_up=:hand WHERE u.name=:name")
    void setHand_upByName(@Param("name") String name, @Param("hand") boolean hand);
}
