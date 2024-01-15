package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.*;
public interface ContactDao extends JpaRepository<Contact,Integer>{

}
