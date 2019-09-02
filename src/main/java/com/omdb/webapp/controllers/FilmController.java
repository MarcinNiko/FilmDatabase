package com.omdb.webapp.controllers;

import com.omdb.webapp.dao.FilmRepo;
import com.omdb.webapp.model.Film;
import com.omdb.webapp.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FilmController {

    @Autowired
    FilmRepo repo;

    @RequestMapping("home")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("/getFilm")
    public ModelAndView getFilm(@RequestParam String title)
    {
        OmdbService omdb = new OmdbService();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showFilm");
        //Film film = (Film) repo.findByName(title);
        Film film = omdb.handleOmdb(title);
        mv.addObject(film);
        return mv;
    }
}
