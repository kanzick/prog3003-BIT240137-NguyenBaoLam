class TV {
    public void on() {
        System.out.println("Tivi đang bật...");
    }

    public void selectInput() {
        System.out.println("Chọn DVD...");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Loa đang bật...");
    }

    public void setVolume(int level) {
        System.out.println("Âm lượng được đặt thành: " + level);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("Đầu DVD đang bật...");
    }

    public void play(String movie) {
        System.out.println("Đang phát: " + movie);
    }
}

class Lights {
    public void dim(int level) {
        System.out.println("Giảm ánh sáng đèn xuống: " + level + "%");
    }
}

class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private DVDPlayer dvd;
    private Lights lights;

    public HomeTheaterFacade() {
        this.tv = new TV();
        this.sound = new SoundSystem();
        this.dvd = new DVDPlayer();
        this.lights = new Lights();
    }

    public void watchMovie(String movie) {
        System.out.println("=== Chuẩn bị xem phim ===");
        lights.dim(10);
        tv.on();
        tv.selectInput();
        sound.on();
        sound.setVolume(50);
        dvd.on();
        dvd.play(movie);
        System.out.println("=== Thưởng thức bộ phim! ===\n");
    }

    public void endMovie() {
        System.out.println("=== Kết thúc xem phim ===");
        dvd.on();
        tv.on();
        sound.on();
        lights.dim(100);
        System.out.println("Tất cả thiết bị đã tắt.\n");
    }
}

class ExThree {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie("Avengers: Endgame");
        homeTheater.endMovie();

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
