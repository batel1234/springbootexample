package com.javatpoint.controller;

import com.javatpoint.model.Category;
import com.javatpoint.model.Renting;
import com.javatpoint.model.User;
import com.javatpoint.service.CategoryRepository;
import com.javatpoint.service.RentingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/renting")
public class RentingController {



        private final RentingRepository rentingRepository;

        @Autowired
        public RentingController(RentingRepository rentingRepository) {
            this.rentingRepository = rentingRepository;
        }

        @GetMapping("/rentings") // הצגת ההשכרות
        public List<Renting> getAllCategory(){ // מציג את כול הקטגוריות
            return rentingRepository.findAll();
        }


//        @GetMapping("/{id}")//  ID הצגת ההשכרות לפי
//        public ResponseEntity<Renting> getCategory(@PathVariable Long id){
//            Optional<Renting> r= rentingRepository.findById(id); // אם זה קיים תחזיר אם זה לא קיים השכרה לא נימצא
//            return r.map(renting1 -> ResponseEntity.ok().body(renting1))
//                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        }
        @PostMapping
        public ResponseEntity<Renting> creatRenting(@RequestBody Renting r)  throws URISyntaxException { //הוספה של השכרה חדשה
            Renting newRenting=rentingRepository.save(r);
            return ResponseEntity.created(new URI("/api/renting/"+newRenting.getId())).body(newRenting);
        }
        @PutMapping("/{id}")
        // עדכון של השכרה
        public ResponseEntity<?> updateCategory(@PathVariable Long id ,@RequestBody Renting r)throws URISyntaxException{
            if(id!=r.getId())
                return ResponseEntity.badRequest().build();
            Renting updateRenting= rentingRepository.save(r);
            return ResponseEntity.created(new URI("/api/renting/"+updateRenting.getId())).body(updateRenting);
        }

        @DeleteMapping("/{id}") //  ID מחיקה לפי
        public ResponseEntity<Void> deleteRenting(@PathVariable Long id){// מחיקת קטגוריה
            rentingRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }
}
