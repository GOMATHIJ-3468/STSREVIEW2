package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Details;
import com.example.demo.repository.Detailsrep;

@Service
public class Detailsser {
	@Autowired
	Detailsrep re;

//post
	public Details add(Details d) {
		return re.save(d);
	}
	
	public Details addmapbus(Details d) {
		return re.save(d);
	}
	
	public List<Details> addn(List<Details> bd){
		return (List<Details>)re.saveAll(bd);
	}

//get
	public List<Details> showdetails(Details d){
		return re.findAll();
	}
	
	public List<Details> showmapdetails(Details d){
		return re.findAll();
	}
	
	public Optional<Details> printid(int id){
		return re.findById(id);
	}
//update
	public Details modify(Details d) {
		return re.saveAndFlush(d);
	}
	
	public String updateinfo(int id,Details d) {
		re.saveAndFlush(d);
		if(re.existsById(id)) {
			return "UPDATED";
		}else {
			return "Enter valid id";
		}
	}
//delete
	public void remove(Details d) {
		re.delete(d);
		
	}
	
	public void delid(int id) {
		re.deleteById(id);
	}
	
//SORTING
	
	
	public List<Details> sortinfo2(String s){
		return re.findAll(Sort.by(Sort.Direction.DESC,s));
	}
		
//PAGINATION
		
	public List<Details>getbypage(int pgno,int pgsize){
		Page<Details> p=re.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
		
		
//PAGINATION WITH SORTING
		
	public List<Details>getpagesort(int pgno,int pgsize,String s){
		Page<Details> p=re.findAll(PageRequest.of(pgno, pgsize,Sort.by(Sort.Direction.DESC,s)));
		return p.getContent();
	}

	
	
//GETBYID AND NAME BY SQL
	
	public List<Details> getDetails(int i,String s){
		return re.getDetailsinfo(i, s);
	}
		
//Deletebyid by SQL
		
	public int delDetails(int id) {
		return re.deleteDetailsinfo(id);
	}
		
//UPDATEID BY SQL
		
	public int updateDetails(String s,int id1) {
		return re.updateDetailsinfo(s, id1);
	}

}

