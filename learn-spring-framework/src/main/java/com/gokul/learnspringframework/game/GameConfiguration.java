package com.gokul.learnspringframework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {
	
	@Bean
	public GamingConsole game() {
		return new MarioGame();
	}
	
	@Bean
	public GameRunner gameRunner() {
		return new GameRunner(game());
	}

}
