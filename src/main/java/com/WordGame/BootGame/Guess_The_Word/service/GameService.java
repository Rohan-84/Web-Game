package com.WordGame.BootGame.Guess_The_Word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@Scope("prototype")      //To reload the application i want the new instance of gameservice every time so that i can get new and different String
public class GameService {


  private String randomlyChoosenword = null;

  private String[] randomwords={"father","mother","child","sister","hello","java","string","earth","planet","animals","lord"};

  private char[] allCharactersoftheword;
      Random random= new Random();

      public GameService(){
        randomlyChoosenword=randomwords[random.nextInt(randomwords.length)];
        allCharactersoftheword=new char[randomlyChoosenword.length()];
      }
  @Override
    public String toString(){
    String ret="";
    for (char c : allCharactersoftheword) {
      if (c == '\u0000') {
        ret = ret + "_";
      }
      else {
        ret = ret + c;
      }
        ret = ret +' ';
       }
      return ret;
    }

    public boolean addGuess(char guessedchar) {
        boolean isGuessCorrect = false;
        for(int i = 0 ;i<randomlyChoosenword.length() ;i++) {
          if (guessedchar == randomlyChoosenword.charAt(i)) {
                    allCharactersoftheword[i]=guessedchar;
                     isGuessCorrect=true;
          }
        }
        return isGuessCorrect;
    }
}
