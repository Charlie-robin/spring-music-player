package com.nology.musicplayer;

import com.nology.musicplayer.config.AppConfig;
import com.nology.musicplayer.controller.MusicController;
import com.nology.musicplayer.database.DBUtils;
import com.nology.musicplayer.database.DatabaseInitialiser;
import com.nology.musicplayer.database.JdbcTrackService;
import com.nology.musicplayer.frontend.ConsoleTrackDisplayer;
import com.nology.musicplayer.frontend.TrackDisplayer;
import com.nology.musicplayer.player.TextTrackPlayer;
import com.nology.musicplayer.player.TrackPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

// @Component -> General annotation for a Spring Bean / Component -> Spring controlled class
@Component
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
        // AnnotationConfigApplicationContext -> SETTING UP CONFIGURATION USING ANNOTATIONS
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MusicController musicController = (MusicController) context.getBean("controller");
        musicController.run();

    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.buildAndStart();
    }

}
