package ra.exercise_session08.exercise03;

public class AudioPlayer implements Playeble {

    String content;

    public AudioPlayer() {
    }

    public AudioPlayer(String content) {
        this.content = content;
    }

    @Override
    public void play() {
        this.content = "Đang phát Audio";
        System.out.println(content);
    }

//    public void play() {
//        System.out.println("Đang phát Audio" + content);
//    }
}
