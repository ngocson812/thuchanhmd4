package com.example.thuchanhmd4.controller;

import com.example.thuchanhmd4.model.City;
import com.example.thuchanhmd4.model.Country;
import com.example.thuchanhmd4.service.ICityService;
import com.example.thuchanhmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CityController {

    @Autowired
    ICityService icityService;

    @Autowired
    ICountryService icountryService;


    @GetMapping("/home")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/city/home");
        modelAndView.addObject("city", icityService.findAll(PageRequest.of(page, 5)));
        modelAndView.addObject("country", icountryService.findAll());
        return modelAndView;
    }

    @ModelAttribute("city")
    public City city() {
        return new City();
    }

    @ModelAttribute("country")
    public List<Country> Country() {
        return icountryService.findAll();
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }


    @PostMapping("/create")
    public Object create(@ModelAttribute(value = "city") City city, @RequestParam int idCountry) {
        Country country = new Country();
        country.setIdCountry(idCountry);
        city.setCountry(country);
        icityService.save(city);
        return "redirect:/home";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable int id) {
        Optional<City> city = icityService.findById(id);
        List<Country> list = icountryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("edit", city);
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute(value = "city") City city, @RequestParam int idCountry) {
        Country country = new Country();
        country.setIdCountry(idCountry);
        city.setCountry(country);
        icityService.save(city);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id) {
        Optional<City> city = icityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        modelAndView.addObject("delete", city);
        return modelAndView;
    }

    @PostMapping("delete/{id}")
    public ModelAndView delete(@PathVariable int id, @ModelAttribute City city) {
        icityService.delete(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/search")
    public ModelAndView find(@RequestParam(defaultValue = "0") int page, @RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/city/home");
        modelAndView.addObject("city",icityService.findByName(PageRequest.of(page, 5), name));
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id){
        Optional<City> city = icityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/details");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

}
