package backend.thinthere.model;

import backend.thinthere.enums.Category;
import backend.thinthere.enums.Status;
import backend.thinthere.enums.TypeOfPayment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order dummyOrder = new Order();
    public Order setDummyOrder(Order dummyOrder) {
        this.dummyOrder = dummyOrder;

        List<Product> productList = new ArrayList<>();
        TypeOfProduct glutenFree = new TypeOfProduct("GLUTEN_FREE");
        TypeOfProduct sugarFree = new TypeOfProduct("SUGAR_FREE");
        TypeOfProduct lactoseFree = new TypeOfProduct("LACTOSE_FREE");

        Product multiVitamin = new Product( Category.VITAMIN,
                new HashSet<>(), "Multivitamin", "100 tablets",
                11.30, "Dietary supplement tablet containing vitamins and minerals. Contains 12 vitamins (eg vitamin A, vitamin C, vitamin D). Contains 10 minerals.", 500);
        multiVitamin.getTypeOfProductList().add(glutenFree);
        multiVitamin.getTypeOfProductList().add(sugarFree);
        multiVitamin.getTypeOfProductList().add(lactoseFree);

        Product omega3 = new Product( Category.VITAMIN, new HashSet<>(),
                "Omega 3", "180 soft capsules", 15.80, "Omega 3 dietary supplement soft gelatin capsules with EPA and DHA.", 500);
        omega3.getTypeOfProductList().add(glutenFree);
        omega3.getTypeOfProductList().add(sugarFree);
        omega3.getTypeOfProductList().add(lactoseFree);

        productList.add(multiVitamin);
        productList.add(omega3);

        dummyOrder.setUser(new User());
        dummyOrder.setProduct(productList);
        dummyOrder.setStatus(Status.DELIVERED);
        dummyOrder.setTypeOfPayment(TypeOfPayment.BANK_TRANSFER);

        return dummyOrder;
    }

    @Test
    void totalPriceSumTest() {
        double expected = 27.10; //11.30 + 15.80

        double result = setDummyOrder(dummyOrder).totalPriceSum();
        assertEquals(expected, result);
    }
}