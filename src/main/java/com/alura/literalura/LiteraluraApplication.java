package com.alura.literalura;

import com.alura.literalura.controller.ApplicationController;
import com.alura.literalura.service.GutendexService;
import com.alura.literalura.view.InterfaceView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		GutendexService service = new GutendexService();
		InterfaceView view = new InterfaceView();
		ApplicationController controller = new ApplicationController(service, view);
		controller.init();
	}

}
