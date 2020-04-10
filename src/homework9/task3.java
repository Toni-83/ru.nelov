package homework9;

interface HumanRun {
    String slow = "Slow";
    String fast = "Fast";
    String can = "can";
    String getRun();
    String getSwim();
}
interface HumanSwim{
    String slow = "Slow";
    String fast = "Fast";
    String can = "can";
    String getRun();
    String getSwim();
}
class Human implements HumanRun,HumanSwim {
    @Override
    public String getRun(){
        return HumanRun.can;
    }
    @Override
    public String getSwim(){
        return HumanSwim.can;
    }
}
class Runner extends Human{
    public String getRun(){
        return HumanRun.fast;
    }
    public String getSwim(){
        return HumanSwim.slow;
    }
}
class Swimmer extends Human{
    public String getRun(){
        return HumanRun.slow;
    }
    public String getSwim(){
        return HumanSwim.fast;
    }
}

public class task3 {
    public static void main(String[] args){
        System.out.println("Human " +new Human().getRun()+" run and "+new Human().getSwim()+" swim.");
        System.out.println("Runner "+new Runner().getRun()+" run and "+new Runner().getSwim()+" swim.");
        System.out.println("Swimmer "+new Swimmer().getRun()+" run and "+new Swimmer().getSwim()+" swim.");
    }
}
