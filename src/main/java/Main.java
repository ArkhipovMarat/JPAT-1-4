import ru.netology.services.ShopServiceImpl;
import ru.netology.services.StorageImpl;
import ru.netology.entity.Product;
import ru.netology.entity.TypeOfProduct;
import ru.netology.services.Storage;

public class Main {
    public static void main(String[] args) {

//      Программа "магазин товаров для животных"
//      Функционал:
//      1. Добавление товаров в каталог
//      2. Удаление товаров из каталога
//      3. Просмотр каталога товаров
//      4. Добавление товара в "корзину заказов"
//      5. Просмотр всей корзины заказов
//      6. Удаление товара из корзины

        Storage catalog = new StorageImpl("КАТАЛОГ МАГАЗИНА ТОВАРОВ ДЛЯ ЖИВОТНЫХ");
        Storage cart = new StorageImpl("КОРЗИНА ПОКУПОК");
        ShopServiceImpl shopService = new ShopServiceImpl(catalog, cart);

//        создание каталога
        showAction("1. СОЗДАНИЕ КАТАЛОГА");
        shopService.addToCatalog(new Product(TypeOfProduct.CAT, "meat1", "meat1", 1), 1);
        shopService.addToCatalog(new Product(TypeOfProduct.CAT, "meat2", "meat2", 2), 2);
        shopService.addToCatalog(new Product(TypeOfProduct.CAT, "meat3", "meat3", 3), 3);
        shopService.addToCatalog(new Product(TypeOfProduct.DOG, "meat1", "meat1", 1), 1);
        shopService.addToCatalog(new Product(TypeOfProduct.DOG, "meat2", "meat2", 2), 2);
        shopService.addToCatalog(new Product(TypeOfProduct.DOG, "meat3", "meat3", 3), 3);
        shopService.showCatalog();

//        добавление товаров в корзину
        showAction("2. ДОБАВЛЕНИЕ ТОВАРОВ В КОРЗИНУ");
        shopService.addToCart(new Product(TypeOfProduct.CAT, "meat3", "meat3", 3), 3);
        shopService.addToCart(new Product(TypeOfProduct.DOG, "meat3", "meat3", 3), 3);
        shopService.showCart();

//        просмотр каталога
        showAction("3. ПРОСМОТР КАТАЛОГА");
        shopService.showCatalog();

//        Удаление товаров из корзины
        showAction("4. УДАЛЕНИЕ ТОВАРОВ ИЗ КОРЗИНЫ");
        shopService.removeFromCart(new Product(TypeOfProduct.CAT, "meat3", "meat3", 3), 3) ;


//       просмотр каталога и корзины
        showAction("5. ПРОСМОТР КАТАЛОГА И КОРЗИНЫ");
        shopService.showCatalog();
        shopService.showCart();
}

    //    DRY - повторяющийся блок кода вынесен в отдельный метод
    public static void showAction(String text) {
        System.out.println("");
        System.out.println(text);
        System.out.println("");
    }
}
