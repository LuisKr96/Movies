package com.example.tsi.krumbacher.luis.demo;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.regions.Region;


import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

//(origins = "*")

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
@RestController
@CrossOrigin
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

    @Autowired
    private Film_ActorRepository film_actorRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    private String save = "save";

    public SakilaDatabaseApplication(LanguageRepository languageRepository,
                                     FilmRepository filmRepository,
                                     CategoryRepository categoryRepository, ActorRepository actorRepository,
                                     CustomerRepository customerRepository, Film_ActorRepository film_actorRepository, ReviewRepository reviewRepository) {

        this.languageRepository = languageRepository;
        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
        this.actorRepository = actorRepository;
        this.customerRepository = customerRepository;
        this.film_actorRepository = film_actorRepository;
        this.reviewRepository = reviewRepository;
    }


    public static void main(String[] args) {

        SpringApplication.run(SakilaDatabaseApplication.class, args);
    }

    //Languages
    @GetMapping("/AllLanguages")
    public @ResponseBody
    Iterable<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @PostMapping("/AddLanguage")
    public @ResponseBody
    String addLanguage(@RequestParam String name) {
        Language addLanguage = new Language(name);
        languageRepository.save(addLanguage);
        return save;
    }

    @DeleteMapping("/removelanguage/{language_id}")
    public @ResponseBody
    String deleteLanguageByID(@PathVariable int language_id) {
        languageRepository.deleteById(language_id);
        return "The ID language " + language_id + " has been deleted";
    }

    //Films
    @GetMapping("/AllFilm")
    public @ResponseBody
    Iterable<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    @GetMapping("/Film/{film_id}")
    public @ResponseBody
    Optional<Film> getFilmByID(@PathVariable int film_id) {
        return filmRepository.findById(film_id);
    }

    @PostMapping("/AddFilm")
    public @ResponseBody
    String addFilm(@RequestParam String title, String description, int release_year, int rental_duration, double rental_rate, int length, double replacement_cost, String rating) {
        Film addFilm = new Film(title, description, release_year,
                rental_duration, rental_rate, length, replacement_cost, rating);
        filmRepository.save(addFilm);
        return save;
    }


    //Category
    @GetMapping("/AllCategories")
    public @ResponseBody
    Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/Category/{category_id}")
    public @ResponseBody
    Optional<Category> getCategoryByID(@PathVariable int category_id) {
        return categoryRepository.findById(category_id);
    }


    //Actor
    @GetMapping("/AllActors")
    public @ResponseBody
    Iterable<Actor> getAllActor() {
        return actorRepository.findAll();
    }

    @GetMapping("/Actor/{actor_id}")
    public @ResponseBody
    Optional<Actor> getActorByID(@PathVariable int actor_id) {
        return actorRepository.findById(actor_id);
    }


    //Customer
    @GetMapping("/Customers")
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/Customers/Add")
    public @ResponseBody
    String addCustomer(@RequestParam String first_name, String last_name, String email) {
        Customer addCustomer = new Customer(first_name, last_name, email);
        customerRepository.save(addCustomer);
        return save;

        //Review

    }


    @PostMapping("/Review/Add")
    public @ResponseBody
    String addReview(@RequestParam int review_id, int film_id, String consumer_review) {
        Review addReview = new Review(review_id, film_id, consumer_review);
        reviewRepository.save(addReview);
        return save;
    }
    @PutMapping("/Review/Update/{review_id}")
    public @ResponseBody
    String updateReview(@PathVariable int review_id, @RequestParam String consumer_review){
        Review updateReview = reviewRepository.findById(review_id).orElseThrow(() ->new ResourceNotFoundException("Review not found"));;

        updateReview.setConsumer_review(consumer_review);
        final Review updatedReview = reviewRepository.save(updateReview);
        return "updated";
    }

    @DeleteMapping("/Review/Delete/{review_id}")
    public @ResponseBody
    String deleteReviewByID(@PathVariable int review_id) {
        reviewRepository.deleteById(review_id);
        return "deleted";
    }
}



