package com.nology.musicplayer;

import com.nology.musicplayer.controller.MusicController;
import com.nology.musicplayer.database.DBUtils;
import com.nology.musicplayer.database.DatabaseInitialiser;
import com.nology.musicplayer.database.JdbcTrackService;
import com.nology.musicplayer.frontend.ConsoleTrackDisplayer;
import com.nology.musicplayer.frontend.TrackDisplayer;
import com.nology.musicplayer.player.TextTrackPlayer;
import com.nology.musicplayer.player.TrackPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicPlayer {

    enum RendererType {
        console, web;
    }

    enum PlayerType {
        text, audio;
    }


    //    DB Utils
    //    DB initialiser
    //    Track service
    //    Track player
    //    Track displayer
    //    Music controller
    //    Music player
    private void buildAndStart() {
        // MOVED OUR CONFIGURATION INTO XML -> SETUP
        // APPLICATION CONTEXT -> GIVING CONTROL TO SPRING TO SET UP CLASSES
        // INVERSION OF CONTROL / DEPENDENCY INJECTION
        ApplicationContext context = new ClassPathXmlApplicationContext("data-services.xml", "services.xml");
        // GETBEAN RETURNS TYPE OBJECT -> CAST IT TO TYPE OF CONTROLLER
        //
        MusicController musicController = (MusicController) context.getBean("musicController");
        musicController.run();

    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.buildAndStart();
    }

}
