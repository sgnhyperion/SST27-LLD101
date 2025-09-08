package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		

		
		Beverage coffee = new Cappuccino();
		System.out.println(coffee.cost());
		Beverage chocoCoffee = new ChocolateDecorator(coffee);
		System.out.println("Cappuccino with Chocolate: " + chocoCoffee.cost());

		Beverage creamChocoCoffee = new WhippedCreamDecorator(chocoCoffee);
		System.out.println("Cappuccino with Chocolate & Whipped Cream: " + creamChocoCoffee.cost());

		Beverage latte = new Latte();
		System.out.println("Latte: " + latte.cost());
		Beverage fancyLatte = new WhippedCreamDecorator(new ChocolateDecorator(latte));
		System.out.println("Latte with Chocolate & Whipped Cream: " + fancyLatte.cost());
	}

}