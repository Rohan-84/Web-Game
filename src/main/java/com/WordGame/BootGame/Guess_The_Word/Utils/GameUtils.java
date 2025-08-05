package com.WordGame.BootGame.Guess_The_Word.Utils;

import com.WordGame.BootGame.Guess_The_Word.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    @Autowired
    ConfigurableApplicationContext Context;

    private int MAX_TRIES=5;
    public int reduceTry(){
        MAX_TRIES=MAX_TRIES-1;
        return MAX_TRIES;
    }
    public int getTriesRemaining(){
        return MAX_TRIES;
    }
    public void resetTries(){
        MAX_TRIES=5;
    }
    public GameService reload(){
        GameService gameservice=Context.getBean(GameService.class);
        return gameservice;

    }
}
