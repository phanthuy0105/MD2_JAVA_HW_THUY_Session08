package ra.exercise_session08.exercise03;

public class VideoPlayer implements Playeble {

    String content;

    public VideoPlayer() {
    }

    public VideoPlayer(String content) {
        this.content = content;
    }

    @Override
    public void play() {
        this.content = "Đang phát Video";
        System.out.println(content);
    }
}
