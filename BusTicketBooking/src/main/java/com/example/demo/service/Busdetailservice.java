package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BusDetails;
import com.example.demo.repository.BusDetailRepo;

@Service
public class Busdetailservice {
	@Autowired
	BusDetailRepo  br;
	
	//post
	public BusDetails add(BusDetails bd) {
		return br.save(bd);
	}
	
	
	
	public BusDetails addmapbus(BusDetails bd) {
		return br.save(bd);
	}
	
	
	
	
	public List<BusDetails> addn(List<BusDetails> bd){
		return (List<BusDetails>)br.saveAll(bd);
	}
	
	//get
	public List<BusDetails> print(BusDetails bd){
		return br.findAll();
	}
	
	
	public List<BusDetails> showmapdetails(BusDetails bd){
		return br.findAll();
	}
	
	
	
	public Optional<BusDetails> printid(int id){
		return br.findById(id);
	}
	
	//update
	public BusDetails update(BusDetails bd) {
		return br.saveAndFlush(bd);
	}
	
	public String updateinfo(int id,BusDetails bd) {
		br.saveAndFlush(bd);
		if(br.existsById(id)) {
			return "UPDATED";
		}else {
			return "Enter valid id";
		}
	}
	
	//delete
	public void deleteinfo(BusDetails bd) {
		br.delete(bd);
	}
	
	public void delete(int id) {
		br.deleteById(id);
	}
	
	//GETBYID AND NAME BY SQL
	
		public List<BusDetails> getBusDetails(int i,String s){
			return br.getBusDetailsinfo(i, s);
		}
			
	//Deletebyid by SQL
			
		public int delBusDetails(int id) {
			return br.deleteBusDetailsinfo(id);
		}
			
	//UPDATEID BY SQL
			
		public int updateBusDetails(String s,int id1) {
			return br.updateBusDetailsinfo(s, id1);
		}
}
