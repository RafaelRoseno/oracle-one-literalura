package com.alura.literalura.controller;

import com.alura.literalura.service.GutendexService;
import com.alura.literalura.view.InterfaceView;

import java.util.Scanner;

public class ApplicationController {

    GutendexService service;
    InterfaceView view;
    Scanner scanner;

    public ApplicationController(GutendexService service, InterfaceView view) {
        this.service = service;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void init(){
        view.showMenu();
        var searchResponse = service.searchBookByTitle();
        view.showBooks(searchResponse);
    }




}
