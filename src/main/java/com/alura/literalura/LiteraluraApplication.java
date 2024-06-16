package com.alura.literalura;

import com.alura.literalura.controller.ApplicationController;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.service.GutendexService;
import com.alura.literalura.view.InterfaceView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);

		ApplicationController controller = context.getBean(ApplicationController.class);
		controller.init();
	}

}
