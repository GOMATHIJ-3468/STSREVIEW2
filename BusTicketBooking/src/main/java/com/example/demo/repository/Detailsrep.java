package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Details;

import jakarta.transaction.Transactional;

public interface Detailsrep extends JpaRepository<Details, Integer>{

	@Query(value="select * from Personal_Details where id=:s or name=:sn",nativeQuery=true)
	public List<Details>getDetailsinfo(@Param("s") int id,@Param("sn") String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from Personal_Details where id=:s",nativeQuery=true)
	public int deleteDetailsinfo(@Param("s") int id);
	
	@Modifying
	@Transactional
	@Query(value="update Personal_Details  set name=?1 where id=?2",nativeQuery=true)
	public int updateDetailsinfo(String newname, int oldid);
	
}
