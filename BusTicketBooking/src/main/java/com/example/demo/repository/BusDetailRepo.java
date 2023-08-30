package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.BusDetails;

import jakarta.transaction.Transactional;

public interface BusDetailRepo extends JpaRepository<BusDetails, Integer> {

	@Query(value="select * from BusInfo where id=:s or boardingpoint=:sn",nativeQuery=true)
	public List<BusDetails>getBusDetailsinfo(@Param("s") int id,@Param("sn") String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from BusInfo where id=:s",nativeQuery=true)
	public int deleteBusDetailsinfo(@Param("s") int id);
	
	@Modifying
	@Transactional
	@Query(value="update BusInfo  set boardingpoint=?1 where id=?2",nativeQuery=true)
	public int updateBusDetailsinfo(String newname, int oldid);
	
}
