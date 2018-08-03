package shujujiegou.day2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/4
 * \* Time: 13:09
 */
//对象插入排序
class Person{
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }
    public void displayPerson(){
        System.out.println("lastName: "+lastName+", "
                +"firstName: "+firstName+", "+"ages: "+age);
    }
}

class ObjectSort{
    private Person[] p;
    private int nElems;

    public ObjectSort(int max) {
        p=new Person[max];
        nElems=0;
    }

    public void insert(String lastName, String firstName, int age){
        p[nElems]=new Person(lastName,firstName,age);
        nElems++;
    }

    public void display(){
        for(int i=0;i<nElems;i++)
            p[i].displayPerson();
        System.out.println();
    }


    public void objectSort(){
        int out,in;
        for(out=1;out<nElems;out++){
            Person temp=p[out];
            in=out;
            while(in>0&&
                    p[in-1].getLastName().compareTo(temp.getLastName())>0){
                p[in]=p[in-1];
                --in;
            }
            p[in]=temp;
        }

    }
}
public class ObjectSortApp {

    public static void main(String[] args) {
        int maxSize=15;
        ObjectSort o=new ObjectSort(maxSize);
        o.insert("wang","qiang",15);
        o.insert("wang","iang",16);
        o.insert("wang","ang",12);
        o.insert("lang","ang",19);
        o.insert("eang","iang",22);
        o.insert("uang","ng",20);
        o.display();
        o.objectSort();
        o.display();
    }


}
