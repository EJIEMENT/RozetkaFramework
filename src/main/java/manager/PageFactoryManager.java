package manager;

import pages.*;

public class PageFactoryManager {

    public PageFactoryManager() {
    }

    public HomePage geTHomePage() {
        return new HomePage();
    }

    public ProductPage getProductPage() {
        return new ProductPage();
    }

    public CatalogPage getCatalogPage() {
        return new CatalogPage();
    }

    public BucketPage getBucketPage() {
        return new BucketPage();
    }

    public ComputersAndLaptops getComputersAndLaptops() {
        return new ComputersAndLaptops();
    }
}
