/*
 * package com.zee.zee5app.controller;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.zee.zee5app.dto.Movie; import com.zee.zee5app.dto.Register; import
 * com.zee.zee5app.exception.AlreadyExistsException; import
 * com.zee.zee5app.service.MovieService;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/movies") public class MovieController {
 * 
 * @Autowired MovieService movieService;
 * 
 * @PostMapping("/addMovie") public ResponseEntity<?> addMovie(@RequestBody
 * Movie movie) throws AlreadyExistsException {
 * 
 * Movie result = movieService.addMovie(movie); System.out.println(result);
 * return ResponseEntity.status(201).body(result);
 * 
 * } }
 */