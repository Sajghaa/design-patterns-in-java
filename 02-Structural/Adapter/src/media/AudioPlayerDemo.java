package media;

public class AudioPlayerDemo {
    public static void main(String[] args){
        MediaPlayer player = new MediaAdapter("mp4");
            player.play("mp4", "avengers_endgame.mp4");

            player = new MediaAdapter("vlc");
            player.play("vlc", "rick_astley_never_gonna_give_you_up.vlc");

            player = new MediaAdapter("mp3");
            player.play("vlc", "song.mp3");
        }
    }
    

