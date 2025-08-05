package com.WordGame.BootGame.Guess_The_Word.Controllers;
import com.WordGame.BootGame.Guess_The_Word.Utils.GameUtils;
import com.WordGame.BootGame.Guess_The_Word.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    private GameService gameservice;

    @Autowired
    private GameUtils gameutils;

    @GetMapping("/Game--Home")
    public String showGameHomePage(@RequestParam(value="guessedchar",required = false) String guessedchar, Model model){
     String randomwrd = gameservice.toString();
     if(guessedchar != null) {
       boolean isGuessCorrect =  gameservice.addGuess(guessedchar.charAt(0));
         randomwrd=gameservice.toString();
         if(isGuessCorrect == false){
             gameutils.reduceTry();
         }
     }

        model.addAttribute("WordToDisplay",randomwrd);
       model.addAttribute("TriesLeft", gameutils.getTriesRemaining());
    return "Game-Home-Page";
 }
 @GetMapping("/reload")
 public String reloadGame(){
        gameservice=gameutils.reload();
        //reset the Tries
         gameutils.resetTries();;
        return  "redirect:/Game--Home";
 }
}
