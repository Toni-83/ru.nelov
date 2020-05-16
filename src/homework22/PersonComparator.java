package homework22;

class Person{
    String name;
    int eag;
    public Person(String name, int eag){
        this.name=name;
        this.eag=eag;
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
}


public class PersonComparator {
    static Person[] persons = new Person[5];

    public static void main(String[] args){
        persons[0]=new Person("Толик", 30);
        persons[4]=new Person("Толик", 25);
        persons[2]=new Person("Николай", 35);
        persons[1]=new Person("Денис", 25);
        persons[3]=new Person("Игорь", 20);
        for (int i=0;i<persons.length;i++){
            for (int ii=1;ii<persons.length;ii++) {
                if (i==ii)break;
                switch (new Comparator().Comparator(persons[i], persons[ii])) {
                    case 1:
                        System.out.println("элемент " + i + " больще элемента " + ii + ".\n" +
                                persons[i].name + " возраст " + persons[i].eag + ">" + persons[ii].name + " возраст " + persons[ii].eag + ".");
                        break;
                    case -1:
                        System.out.println("элемент " + ii + " больще элемента " + i + ".\n" +
                                persons[i].name + " возраст " + persons[i].eag + "<" + persons[ii].name + " возраст " + persons[ii].eag + ".");
                        break;
                    case 0:
                        System.out.println("элемент " + i + " равен элементу " + ii + ".\n" +
                                persons[i].name + " возраст " + persons[i].eag + "=" + persons[ii].name + " возраст " + persons[ii].eag + ".");
                        break;
                }
            }
        }
    }
}
