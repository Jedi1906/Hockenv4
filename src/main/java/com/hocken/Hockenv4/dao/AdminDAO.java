package com.hocken.Hockenv4.dao;

import com.hocken.Hockenv4.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<Admin,Integer> {
}
