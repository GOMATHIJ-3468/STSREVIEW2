package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Details;
import com.example.demo.service.Detailsser;

@RestController
public class Detailscon {
	@Autowired
	Detailsser se;
@PostMapping("add")
	public Details adddetails(@RequestBody Details d) {
		return se.add(d);
	}

@PostMapping("addmap")
	public Details adddetailsmapping(@RequestBody Details d) {
		return se.addmapbus(d);
	}

@PostMapping("addn")
	public List<Details> addn(@RequestBody List<Details> bd){
		return se.addn(bd);
	}


@GetMapping("disp")
	public List<Details> show( Details d) {
		return se.showdetails(d);
	}

@GetMapping("dispmap")
	public List<Details> showmapping( Details d) {
		return se.showmapdetails(d);
	}

@GetMapping("dispid/{id}")
	public Optional<Details> showid(@PathVariable int id){
		return se.printid(id);
	}


@PutMapping("mod")
	public Details change(@RequestBody Details d) {
		return se.modify(d);
	}
@PutMapping("update/{id}")
	public String modifyinfo(@PathVariable int id,@RequestBody Details d) {
		return se.updateinfo(id, d);
	}


@DeleteMapping("del")
	public void Del(@RequestBody Details d) {
		se.remove(d);
	}
@DeleteMapping("del/{id}")
	public String delete(@PathVariable int id) {
		se.delid(id);
		return "Deleted successfully";
	}

//SORTING

@GetMapping("sort/{name}")
	public List<Details>getsort(@PathVariable String name){
		return se.sortinfo2(name);
	}
	
//PAGINATION
	
@GetMapping("paging/{pageno}/{pagesize}")
	public List<Details>showpageinfo(@PathVariable int pageno,@PathVariable int pagesize){
		return se.getbypage(pageno, pagesize);
	}
	
//PAGINATION WITH SORTING
	
@GetMapping("paging/{pageno}/{pagesize}/{name}")
	public List<Details>Pagesort(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
		return se.getpagesort(pageno, pagesize,name);
	}

//GETSTUDENT BY ID AND NAME USING SQL

	@GetMapping("showquery/{id}/{name}")
	public List<Details> showdetails(@PathVariable int id,@PathVariable String name){
		return se.getDetails(id, name);
	}
	
//DELETEID BY USING SQL
	
	@DeleteMapping("deletequery/{id}")
	public String delstudent(@PathVariable int id) {
		return se.delDetails(id)+"DELETED";
	}
	
//UPDATEID BY USING SQLS
	@PutMapping("updatequery/{name}/{oldid}")
	public String updatestudent(@PathVariable String name,@PathVariable int oldid) {
		return se.updateDetails(name, oldid)+"UPDATED";
	}

}
