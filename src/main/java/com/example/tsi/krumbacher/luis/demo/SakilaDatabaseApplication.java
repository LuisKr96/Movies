package com.example.tsi.krumbacher.luis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
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

	@Autowired
	private ActorRepository actorRepository;

	private String save = "save";

	public SakilaDatabaseApplication(LanguageRepository languageRepository,
									 FilmRepository filmRepository, PaymentRepository paymentRepository, CategoryRepository categoryRepository){

		this.languageRepository = languageRepository;
		this.filmRepository = filmRepository;
		this.paymentRepository = paymentRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(SakilaDatabaseApplication.class, args);}

		@PostMapping("/AddLanguage")
		public @ResponseBody
		String addLanguage(@RequestParam String name){
			Language addLanguage = new Language(name);
			languageRepository.save(addLanguage);
			return save;
		}
		/* Language createLanguage(@Validated @RequestBody Language newLanguage) {
		return languageRepository.save(newLanguage);
	}*/
		@GetMapping("/AllLanguages")
		public @ResponseBody
		Iterable <Language> getAllLanguages (){
			return languageRepository.findAll();
		}

		@GetMapping("/AllFilm")
		public @ResponseBody
		Iterable <Film> getAllFilm (){
		return filmRepository.findAll();
		}

		@GetMapping("/AllPayment")
		public @ResponseBody
		Iterable <Payment> getAllPayments (){
		return paymentRepository.findAll();
		}

		@GetMapping("/AllCategories")
		public @ResponseBody
		Iterable <Category> getAllCategories () {
			return categoryRepository.findAll();
		}
		@GetMapping("/AllActors")
		public @ResponseBody
		Iterable <Actor> getAllActor () {
			return actorRepository.findAll();
		}
}



