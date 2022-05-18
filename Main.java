class Bus {
    int maxPassenger = 20;
    int currentPassenger;
    int price = 1500;
    int busNumber;
    int gasAmount = 60;
    int speed;
    String status = "운행 중";

    Bus(int num) {
        this.busNumber = num;
    }

    void updateStatus() {
        if (gasAmount < 10) {
            this.status = "차고지행";
            System.out.println("주유가 필요합니다.");
        }
    }

    void getPassenger(int num) {
        if (this.currentPassenger + num <= this.maxPassenger && this.status == "운행 중") this.currentPassenger += num;
    }

    void changeSpeed(int num) {
        if (gasAmount < 10) {
            this.status = "차고지행";
            System.out.println("주유가 필요합니다.");
            return;
        }
        if (this.speed + num >= 0) this.speed += num;
        else this.speed = 0;
    }
}

class Taxi {
    int taxiNumber;
    int gasAmount = 60;
    int speed;
    int shortDistance = 10;
    int shortPrice = 3600;
    int fullPrice = 100;
    String status = "일반";

    Taxi(int num) {
        this.taxiNumber = num;
        }

    void startRunning() {
        if (this.gasAmount < 10) System.out.println("주유량이 부족해 운행이 불가능합니다.");
    }

    void getPassenger() {
        if (this.status == "일반") this.status = "운행 중";
        else System.out.println("탑승이 불가능합니다.");
    }

    void changeSpeed(int num) {
        if (this.speed + num >= 0) this.speed += num;
        else this.speed = 0;
    }

    void payPrice(String destination, int distance) {
        int finalPrice = 0;
        if (distance < this.shortDistance) finalPrice = this.shortPrice;
        else finalPrice = this.shortPrice + this.fullPrice * (distance - this.shortDistance);
        System.out.println(String.format("최종 요금은 %s원입니다.", finalPrice));

    }
}

public class Main {
    public static void main(String[] args) {
        Bus newBus = new Bus(123);
        Taxi newTaxi = new Taxi(456);
    }
}