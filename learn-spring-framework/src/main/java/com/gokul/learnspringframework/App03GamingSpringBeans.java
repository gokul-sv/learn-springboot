package com.gokul.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gokul.learnspringframework.game.GameConfiguration;
import com.gokul.learnspringframework.game.GameRunner;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try (var context =new AnnotationConfigApplicationContext(GameConfiguration.class)) {
			
			context.getBean(GameRunner.class).run();
		}
		
		

	}

}
