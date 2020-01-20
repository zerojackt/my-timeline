package net.timeline;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import net.timeline.controller.UserPostController;

@SpringBootApplication
public class MyTimelineApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MyTimelineApplication.class, args);
	}

}
