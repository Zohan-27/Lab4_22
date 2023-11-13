import java.util.Locale;
import java.util.Scanner;

class Device {
    private String brand;
    protected double price;

    public Device(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Device [brand=" + brand + ", price=" + price + "]";
    }
}


class Cable extends Device {
    private int length;

    public Cable(String brand, double price, int length) {
        super(brand, price);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Cable [brand=" + getBrand() + ", price=" + getPrice() + ", length=" + length + "]";
    }
}


class Capability extends Device {
    private String feature;

    public Capability(String brand, double price, String feature) {
        super(brand, price);
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


    @Override
    public String toString() {
        return "Capability [brand=" + getBrand() + ", price=" + getPrice() + ", feature=" + feature + "]";
    }
}


class Case extends Device {
    private String material;

    public Case(String brand, double price, String material) {
        super(brand, price);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    @Override
    public String toString() {
        return "Case [brand=" + getBrand() + ", price=" + getPrice() + ", material=" + material + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Device[] devices = new Device[3];


        for (int i = 0; i < devices.length; i++) {
            System.out.println("Введите данные для устройства " + (i + 1) + ":");
            System.out.print("Бренд: ");
            String brand = scanner.nextLine();
            System.out.print("Цена: ");
            double price = scanner.nextDouble();
            scanner.nextLine();


            System.out.println("Выберите тип устройства:");
            System.out.println("1. Кабель");
            System.out.println("2. Возможность");
            System.out.println("3. Корпус");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.print("Длина кабеля: ");
                    int length = scanner.nextInt();
                    scanner.nextLine();
                    devices[i] = new Cable(brand, price, length);
                    break;
                case 2:
                    System.out.print("Возможность: ");
                    String feature = scanner.nextLine();
                    devices[i] = new Capability(brand, price, feature);
                    break;
                case 3:
                    System.out.print("Материал корпуса: ");
                    String material = scanner.nextLine();
                    devices[i] = new Case(brand, price, material);
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите от 1 до 3.");
                    i--;
            }

            System.out.print("Хотите ввести еще данные? (y/n): ");
            String continueInput = scanner.nextLine();

            if (!continueInput.equalsIgnoreCase("y")) {
                break;
            }
        }


        System.out.println("Данные устройств:");
        for (Device device : devices) {
            if (device != null) {
                System.out.println(device);
            }
        }

        scanner.close();
    }
}
