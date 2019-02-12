package com.upp.upp.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.upp.upp.dto.OrderDTO;
import com.upp.upp.lucene.Article;
import com.upp.upp.service.ArticleService;

@Controller
@RequestMapping(value="/articles")
public class ArticleController {

	@Autowired
	private ArticleService aricleService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ResponseEntity<Iterable<Article>> findAll(HttpServletRequest request) {
		return new ResponseEntity<Iterable<Article>>(aricleService.findAll(),HttpStatus.OK);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String findOne(HttpServletRequest request,
											@PathVariable("id") Long id) {
		Optional<Article> article = aricleService.findOne(id);
		request.getSession().setAttribute("article", article.get());
		return "forward:/jsp/article.jsp";
	}
	@CrossOrigin
	@RequestMapping(value = "/createOrder/", method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(HttpServletRequest request,@RequestBody OrderDTO order,HttpServletResponse httpServletResponse) {
		String url = restTemplate.postForObject("https://localhost:1234/koncentrator/order/create", order, String.class);
	    return new ResponseEntity<String>(url,HttpStatus.OK);
	}
}
