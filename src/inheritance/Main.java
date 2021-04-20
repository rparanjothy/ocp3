package inheritance;

class Base {
    public Base(){
        System.out.println("I am the base constructor");
    }

    public void run(double i){
        System.out.println("I am run from Base:"+i);

    }
}

class Level1 extends Base{
    public Level1(){
        System.out.println("I am level1 const");
    }
    public void run(int i){
        System.out.println("I am run from Level1:"+i);
        super.run(Double.valueOf(i));

    }
}

public class Main {

    public static void main(String[] args) {
        Level1 l1 = new Level1();
        System.out.println("Starting..");
//        native to Level1
        l1.run(1);
//        from Base
        l1.run(Double.valueOf(1));

    }
}
