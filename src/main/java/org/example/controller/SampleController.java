package org.example.controller;

import lombok.extern.log4j.Log4j;
import org.example.domain.SampleDTO;
import org.example.domain.SampleDTOList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@RequestMapping("/sample")
@Controller
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic..............");
	}

	@GetMapping("/doA")
	public void doA(){
		log.info("doA called..........");
		log.info("--------------------");
	}

	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get............");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2(){
		log.info("basic get only get............");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto){
		log.info("" + dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
					   @RequestParam("age") int age){
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("id")ArrayList<String> ids){
		log.info("ids: " + ids);
		return "ex02List";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("id")String[] ids){
		log.info("ids: " + Arrays.toString(ids));
		return "ex02Array";
	}

	// localhost:8080/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=BBB
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: " + list);
		return "ex02Bean";
	}

}
