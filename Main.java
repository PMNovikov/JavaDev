import ru.geekbrains.animals.*;

public class Main {

    public static void main(String[] args) {
    	doTestAnimals();
    }

    public static void doTestAnimals(){
		Animal[] animals = {new Dog("Bobik"), new Cat("Simon"), new Cat("Freddy")};

		for (int i=0; i<animals.length; i++)
		{
			animals[i].run(300);
			animals[i].swim(100);
		}
		Animal.showCounter();
		Dog.showCounter();
		Cat.showCounter();

	}
}
