package com.omdb.webapp.controllers;

import com.omdb.webapp.dao.FilmRepo;
import com.omdb.webapp.model.Film;
import com.omdb.webapp.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FilmController {

    @Autowired
    FilmRepo repo;

    private OmdbService omdb = new OmdbService();
    private Film film = new Film();
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
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showFilm");
        film = omdb.handleOmdb(title);
        mv.addObject(film);
        return mv;
    }

    @GetMapping("/addFilm")
    public ModelAndView addAlien()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        repo.save(film);
        mv.addObject("list", repo.findAll());
        System.out.println(repo.findAll());
        return mv;
    }
}
