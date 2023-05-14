package com.javatpoint.controller;

import com.javatpoint.model.Apartment;
import com.javatpoint.service.ApartmentRepository;
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
@RequestMapping("/api/apartment")
public class ApartmentController {
     private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentController(ApartmentRepository apartmentRepository){

        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping("/apartments")
    public List<Apartment>getAllApartment(){ // מציג את כול הדירות
        return apartmentRepository.findAll();
    }// מחזיר את כול הדירות

    @GetMapping("/apartments/{name}")
    public List<Apartment> getAllApartmentByName(@PathVariable String name){
        return apartmentRepository.findApartmentsByNameContains(name);
    }

    @GetMapping("/{id}")
    //ResponseEntity-  אוביקט שמכיל את התגובה כולל הדירה עצמה וכולל את הסטטוס
//    public ResponseEntity<Apartment> getApartment(@PathVariable Long id){
//        Optional<Apartment> A= apartmentRepository.findById(id); // אם זה קיים תחזיר אם זה לא קיים הדירה לא נמצאה
//        return A.map(apartment1 -> ResponseEntity.ok().body(apartment1))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
    @PostMapping
    public ResponseEntity<Apartment> creatApartment(@RequestBody Apartment a)  throws URISyntaxException{ //הוספה של דירה חדשה
        Apartment newApatrment=apartmentRepository.save(a);
        return ResponseEntity.created(new URI("/api/apatrment/"+newApatrment.getId())).body(newApatrment);
    }
    @PutMapping("/{id}")
    // עדכון של דירה
    public ResponseEntity<?> updateApartment(@PathVariable Long id ,@RequestBody Apartment a)throws URISyntaxException{
        if(id!=a.getId())
            return ResponseEntity.badRequest().build();
        Apartment updateApartment= apartmentRepository.save(a);
        return ResponseEntity.created(new URI("/api/apartment/"+updateApartment.getId())).body(updateApartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id){
        apartmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    // public List<Apartment> findApartmentByNameContains(String name); דוגמא - פונקציה שמחפשת דירה לפי השם שלה

}