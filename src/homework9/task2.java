package homework9;

abstract class Animal{
    abstract public String getName();
}
interface Fly {
    String doing = "Fly";
    String DoActive();
}
interface Run {
    String doing = "Run";
    String DoActive();
}
interface Swim {
    String doing = "Swim";
    String DoActive();
}
class Panda extends Animal implements Swim {
    static final String name="Panda";
    @Override
    public String getName (){
        return name;
    }
    @Override
    public String DoActive(){
        return doing;
    }
}
class Tiger extends Animal implements Run,Swim {
    static final String name= "Tiger";
    @Override
    public String getName () {
        return name;
    }
    @Override
    public String DoActive(){
        return Run.doing.concat(" and ").concat(Swim.doing);
    }
}
class Duck extends Animal implements Fly,Swim,Run{
    static final String name="Duck";
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String DoActive(){
        return Fly.doing.concat(", ").concat(Swim.doing).concat(" and ").concat(Run.doing);
    }
}

public class task2 {
    public static void main(String[] args){
        System.out.println(new Panda().getName() + " can " + new Panda().DoActive());
        System.out.println(new Tiger().getName() + " can " + new Tiger().DoActive());
        System.out.println(new Duck().getName() + " can " + new Duck().DoActive());
    }
}
