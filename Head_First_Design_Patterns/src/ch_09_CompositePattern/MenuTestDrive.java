package ch_09_CompositePattern;

/*
菜单结构：

allMenu 
    |-- pancakeHouseMenu
    	|-- MenuItem ...
    |-- dinerMenu
    	|-- MenuItem ...
    	|-- dessertMenu
    		|-- MenuItem ...
    |-- cafeMenu
    	|-- MenuItem ...
    	|-- coffeeMenu
    		|-- MenuItem ...
    		
 */
public class MenuTestDrive {

	public static void main(String[] args) {
		// 创建菜单
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
		MenuComponent coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");

		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

		// allMenus菜单拥有三个大类菜单(p\d\c)
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);

		// p菜单添加菜单项
		pancakeHouseMenu
				.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
		pancakeHouseMenu
				.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
		pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries, and blueberry syrup", true, 3.49));
		pancakeHouseMenu
				.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));

		// d菜单添加菜单项，并将甜点菜单作为其一个节点添加进来
		dinerMenu
				.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
		dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
		dinerMenu.add(new MenuItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad",
				false, 3.29));
		dinerMenu.add(
				new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
		dinerMenu.add(new MenuItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99));

		dinerMenu.add(
				new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));

		dinerMenu.add(dessertMenu);

		// 甜点菜单添加菜单项
		dessertMenu.add(
				new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));

		dessertMenu.add(
				new MenuItem("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust", true, 1.99));
		dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));

		// c菜单添加菜单项，并将咖啡菜单作为其一个节点添加进来
		cafeMenu.add(new MenuItem("Veggie Burger and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
		cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
		cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));

		cafeMenu.add(coffeeMenu);

		// 咖啡菜单添加菜单项
		coffeeMenu.add(new MenuItem("Coffee Cake", "Crumbly cake topped with cinnamon and walnuts", true, 1.59));
		coffeeMenu
				.add(new MenuItem("Bagel", "Flavors include sesame, poppyseed, cinnamon raisin, pumpkin", false, 0.69));
		coffeeMenu.add(new MenuItem("Biscotti", "Three almond or hazelnut biscotti cookies", true, 0.89));

		// 将allMenus传递给Waitress
		Waitress waitress = new Waitress(allMenus);

		waitress.printMenu();
		waitress.printVegetarianMenu();
	}

}
// output:
/*

ALL MENUS, All menus combined
-----------------------

PANCAKE HOUSE MENU, Breakfast
-----------------------
   K&B's Pancake Breakfast(V), 2.99
     -- Pancakes with scrambled eggs, and toast
   Regular Pancake Breakfast, 2.99
     -- Pancakes with fried eggs, sausage
   Blueberry Pancakes(V), 3.49
     -- Pancakes made with fresh blueberries, and blueberry syrup
   Waffles(V), 3.59
     -- Waffles, with your choice of blueberries or strawberries

DINER MENU, Lunch
-----------------------
   Vegetarian BLT(V), 2.99
     -- (Fakin') Bacon with lettuce & tomato on whole wheat
   BLT, 2.99
     -- Bacon with lettuce & tomato on whole wheat
   Soup of the day, 3.29
     -- A bowl of the soup of the day, with a side of potato salad
   Hotdog, 3.05
     -- A hot dog, with saurkraut, relish, onions, topped with cheese
   Steamed Veggies and Brown Rice(V), 3.99
     -- Steamed vegetables over brown rice
   Pasta(V), 3.89
     -- Spaghetti with Marinara Sauce, and a slice of sourdough bread

DESSERT MENU, Dessert of course!
-----------------------
   Apple Pie(V), 1.59
     -- Apple pie with a flakey crust, topped with vanilla icecream
   Cheesecake(V), 1.99
     -- Creamy New York cheesecake, with a chocolate graham crust
   Sorbet(V), 1.89
     -- A scoop of raspberry and a scoop of lime

CAFE MENU, Dinner
-----------------------
   Veggie Burger and Air Fries(V), 3.99
     -- Veggie burger on a whole wheat bun, lettuce, tomato, and fries
   Soup of the day, 3.69
     -- A cup of the soup of the day, with a side salad
   Burrito(V), 4.29
     -- A large burrito, with whole pinto beans, salsa, guacamole

COFFEE MENU, Stuff to go with your afternoon coffee
-----------------------
   Coffee Cake(V), 1.59
     -- Crumbly cake topped with cinnamon and walnuts
   Bagel, 0.69
     -- Flavors include sesame, poppyseed, cinnamon raisin, pumpkin
   Biscotti(V), 0.89
     -- Three almond or hazelnut biscotti cookies
*/

// 所有的素食
/*

VEGETARIAN MENU
----
   K&B's Pancake Breakfast(V), 2.99
     -- Pancakes with scrambled eggs, and toast
   Blueberry Pancakes(V), 3.49
     -- Pancakes made with fresh blueberries, and blueberry syrup
   Waffles(V), 3.59
     -- Waffles, with your choice of blueberries or strawberries
   Vegetarian BLT(V), 2.99
     -- (Fakin') Bacon with lettuce & tomato on whole wheat
   Steamed Veggies and Brown Rice(V), 3.99
     -- Steamed vegetables over brown rice
   Pasta(V), 3.89
     -- Spaghetti with Marinara Sauce, and a slice of sourdough bread
   Apple Pie(V), 1.59
     -- Apple pie with a flakey crust, topped with vanilla icecream
   Cheesecake(V), 1.99
     -- Creamy New York cheesecake, with a chocolate graham crust
   Sorbet(V), 1.89
     -- A scoop of raspberry and a scoop of lime
   Apple Pie(V), 1.59
     -- Apple pie with a flakey crust, topped with vanilla icecream
   Cheesecake(V), 1.99
     -- Creamy New York cheesecake, with a chocolate graham crust
   Sorbet(V), 1.89
     -- A scoop of raspberry and a scoop of lime
   Veggie Burger and Air Fries(V), 3.99
     -- Veggie burger on a whole wheat bun, lettuce, tomato, and fries
   Burrito(V), 4.29
     -- A large burrito, with whole pinto beans, salsa, guacamole
   Coffee Cake(V), 1.59
     -- Crumbly cake topped with cinnamon and walnuts
   Biscotti(V), 0.89
     -- Three almond or hazelnut biscotti cookies
   Coffee Cake(V), 1.59
     -- Crumbly cake topped with cinnamon and walnuts
   Biscotti(V), 0.89
     -- Three almond or hazelnut biscotti cookies
*/