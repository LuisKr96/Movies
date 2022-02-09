package com.example.tsi.krumbacher.luis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class SakilaDatabaseApplication {

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public SakilaDatabaseApplication(LanguageRepository languageRepository,
									 FilmRepository filmRepository, PaymentRepository paymentRepository, CategoryRepository categoryRepository){

		this.languageRepository = languageRepository;
		this.filmRepository = filmRepository;
		this.paymentRepository = paymentRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(SakilaDatabaseApplication.class, args);}

		@GetMapping("/AllLanguages")
		public @ResponseBody
		Iterable <Language> getAllLanguages (){
			return languageRepository.findAll();
		}

		@GetMapping("/AllFilm")
		public @ResponseBody
		Iterable <Film> getAllFilmTitles (){
		return filmRepository.findAll();
		}

		@GetMapping("/AllPayment")
		public @ResponseBody
		Iterable <Payment> getAllPayments (){
		return paymentRepository.findAll();
		}

		@GetMapping("/AllCategories")
		public @ResponseBody
		Iterable <Category> getAllCategories (){
		return categoryRepository.findAll();
	}
	}



