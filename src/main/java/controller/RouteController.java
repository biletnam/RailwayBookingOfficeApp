package controller;

import model.Route;
import repository.RouteRepo;
import repository.RouteRepoImpl;

import java.io.*;
import java.util.List;

public class RouteController {

    RouteRepo routeRepo = new RouteRepoImpl();

    public void save(Route route) throws IOException {
        if(route == null){
            throw  new IllegalArgumentException();
        }else routeRepo.save(route);
    }

    public List<Route> findAll() throws IOException {
        return routeRepo.findAll();
    }
    public void delete(Integer id) throws IOException{
        routeRepo.delete(id);
    }
    public Route getById(Integer id) throws IOException {
        return routeRepo.getById(id);
    }






}
