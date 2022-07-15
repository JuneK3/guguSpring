package org.example.controller;

import lombok.extern.log4j.Log4j;
import org.example.domain.SampleDTO;
import org.example.domain.SampleDTOList;
import org.example.domain.TodoDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

@RequestMapping("/sample")
@Controller
@Log4j
public class SampleController {

//	@DateTimeFormat과 공존 불가능
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}

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

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo){
		log.info("todo: " + todo);
		return "ex03";
	}

	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
		log.info("dto: " + dto);
		// @ModelAttribute("page")가 있어야 ex04.jsp에 page값이 전달됨
		// Controller는 Java Beans 규칙에 맞는 객체는 다시 화면으로 전달하는데
		// Java Beans의 규칙은 생성자가 없거나 빈생성자를 가져야 하며
		// getter/setter를 가진 클래스의 객체들을 의미한다
		// page같은 기본자료형의 경우 파라미터로 선언하더라도 기본적으로 화면까지 전달되지는 않는다
		log.info("page: " + page);
		return "/sample/ex04";
	}

}
