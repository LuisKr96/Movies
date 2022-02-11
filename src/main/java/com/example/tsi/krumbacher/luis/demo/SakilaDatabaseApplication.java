package com.example.tsi.krumbacher.luis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class SakilaDatabaseApplication {

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private CustomerRepository customerRepository;

	private String save = "save";

	public SakilaDatabaseApplication(LanguageRepository languageRepository,
									 FilmRepository filmRepository,
									 CategoryRepository categoryRepository, ActorRepository actorRepository,
									 CustomerRepository customerRepository){

		this.languageRepository = languageRepository;
		this.filmRepository = filmRepository;
		this.categoryRepository = categoryRepository;
		this.actorRepository = actorRepository;
		this.customerRepository = customerRepository;

	}



	public static void main(String[] args) {

		SpringApplication.run(SakilaDatabaseApplication.class, args);}

		//Languages
		@GetMapping("/AllLanguages")
		public @ResponseBody
		Iterable <Language> getAllLanguages (){
			return languageRepository.findAll();
		}

		@PostMapping("/AddLanguage")
		public @ResponseBody
		String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}
		@DeleteMapping("/removelanguage/{language_id}")
		public @ResponseBody String deleteLanguageByID(@PathVariable int language_id){
		languageRepository.deleteById(language_id);
		return "The ID language "+language_id +" has been deleted";
	}

		//Films
		@GetMapping("/AllFilm")
		public @ResponseBody
		Iterable <Film> getAllFilm(){
		return filmRepository.findAll();
		}


		@PostMapping("/AddFilm")
		public @ResponseBody
		String addFilm(@RequestParam String title, String description, int release_year, int rental_duration, double rental_rate, int length, double replacement_cost, String rating){
		Film addFilm = new Film(title, description, release_year,
				rental_duration, rental_rate, length, replacement_cost, rating);
		filmRepository.save(addFilm);
		return save;
	}


		//Category
		@GetMapping("/AllCategories")
		public @ResponseBody
		Iterable <Category> getAllCategories () {
			return categoryRepository.findAll();
		}


		//Actor
		@GetMapping("/AllActors")
		public @ResponseBody
		Iterable <Actor> getAllActor () {
			return actorRepository.findAll();
		}


		//Customer
		@GetMapping("/AllCustomers")
		public @ResponseBody
		Iterable <Customer> getAllCustomers(){return customerRepository.findAll();}

		@PostMapping("/AddCustomer")
		public @ResponseBody
		String addCustomer(@RequestParam String first_name, String last_name, String email){
		Customer addCustomer = new Customer(first_name, last_name, email);
		customerRepository.save(addCustomer);
		return save;
	}
}



