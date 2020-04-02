package cn.smileyan.songci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongciApplication {

    public static void main(String[] args) {
        // 打包时使用
        SpringApplication.run(SongciApplicationWar.class, args);
    }

}
