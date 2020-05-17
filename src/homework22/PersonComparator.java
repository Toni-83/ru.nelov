package homework22;

import java.util.TreeSet;

class Person implements Comparable<Object> {
    String name;
    int eag;
    String TEMPLATE = "name=%s, eag=%d";

    Person(String name, int eag) {
        this.name = name;
        this.eag = eag;
    }

@Override
public int compareTo (Object obj){
        Person entr = (Person) obj;
        int result = name.compareTo(entr.name);
        if (result!=0) return result;
    if (eag<entr.eag) return -1;
    else if (eag>entr.eag) return 1;
    else return 0;
}
@Override
public String toString(){
        return String.format(TEMPLATE,name,eag);
}
/*    String getName(){
        return name;
    }
    int getEag(){
        return eag;
    }
}

class PersonNameComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().charAt(1)<o2.getName().charAt(1)) return 1;
        else if (o1.getName().charAt(1)>o2.getName().charAt(1)) return -1;
        else return 0;
        return o1.getName().compareTo(o2.getName());
    }
}
class PersonAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getEag()<o2.getEag()) return 1;
        else if (o1.getEag()>o2.getEag()) return -1;
        else return 0;
    }
}

class Comparator{
    public int Comparator(Person personFirst, Person personSecond){
        if (personFirst.name.charAt(1)<personSecond.name.charAt(1)) return 1;
        if (personFirst.name.charAt(1)>personSecond.name.charAt(1)) return -1;
        if (personFirst.name.charAt(1)==personSecond.name.charAt(1)){
            if (personFirst.eag<personSecond.eag) return 1;
            else if (personFirst.eag>personSecond.eag) return -1;
        }
        return 0;
    }
}*/
}


public class PersonComparator {
    //static Comparator<Person> pComparator = new PersonNameComparator().thenComparing(new PersonAgeComparator());
    static TreeSet<Person> people = new TreeSet<>();
    //static Person[] persons = new Person[5];

    public static void main(String[] args){
        people.add(new Person("Толик", 30));
        people.add(new Person("Толик", 25));
        people.add(new Person("Николай", 35));
        people.add(new Person("Денис", 25));
        people.add(new Person("Игорь", 20));
        for (Person p : people) System.out.println(p.toString());
        //Iterator ipeople = people.iterator();
        /*person[0]=new Person("Толик", 30);
        person[3]=new Person("Толик", 25);
        person[2]=new Person("Николай", 35);
        person[1]=new Person("Денис", 25);
        person[4]=new Person("Игорь", 20);
        for (int i=0;i<persons.length;i++){
            for (int ii=1;ii<persons.length;ii++) {
                if (i==ii)break;
                switch (new Comparator().Comparator(persons[i], persons[ii])) {
                    case 1:
                        System.out.println("элемент " + (i+1) + " больще элемента " + (ii+1) + ".\n" +
                                persons[i].name + " возраст " + persons[i].eag + ">" + persons[ii].name + " возраст " + persons[ii].eag + ".");
                        break;
                    case -1:
                        System.out.println("элемент " + (ii+1) + " больще элемента " + (i+1) + ".\n" +
                                persons[i].name + " возраст " + persons[i].eag + "<" + persons[ii].name + " возраст " + persons[ii].eag + ".");
                        break;
                    case 0:
                        System.out.println("элемент " + (i+1) + " равен элементу " + (ii+1) + ".\n" +
                                persons[i].name + " возраст " + persons[i].eag + "=" + persons[ii].name + " возраст " + persons[ii].eag + ".");
                        break;
                }
            }
        }*/
    }
}
