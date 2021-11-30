package backend.thinthere;

import backend.thinthere.enums.Category;
import backend.thinthere.enums.Status;
import backend.thinthere.enums.TypeOfPayment;
import backend.thinthere.model.Order;
import backend.thinthere.model.Product;
import backend.thinthere.model.TypeOfProduct;
import backend.thinthere.model.User;
import backend.thinthere.repository.OrderRepository;
import backend.thinthere.repository.ProductRepository;
import backend.thinthere.repository.TypeOfProductRepository;
import backend.thinthere.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  private UserRepository userRepository;
  private TypeOfProductRepository typeOfProductRepository;
  private ProductRepository productRepository;
  private OrderRepository orderRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public DataLoader(UserRepository userRepository,
                    TypeOfProductRepository typeOfProductRepository,
                    ProductRepository productRepository,
                    OrderRepository orderRepository,
                    PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.typeOfProductRepository = typeOfProductRepository;
    this.productRepository = productRepository;
    this.orderRepository = orderRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void run(ApplicationArguments arguments) {

    TypeOfProduct glutenFree = new TypeOfProduct("GLUTEN_FREE");
    typeOfProductRepository.save(glutenFree);

    typeOfProductRepository.save(new TypeOfProduct("LACTOSE_FREE"));
    typeOfProductRepository.save(new TypeOfProduct("SUGAR_FREE"));
    typeOfProductRepository.save(new TypeOfProduct("VEGAN"));

    TypeOfProduct other = new TypeOfProduct("OTHER");
    typeOfProductRepository.save(other);

    ArrayList<TypeOfProduct> typeListOther = new ArrayList<>();
    typeListOther.add(typeOfProductRepository.findByName("OTHER").orElseThrow());


    ArrayList<TypeOfProduct> typeListGLS = new ArrayList<>();
    typeListGLS.add(typeOfProductRepository.findByName("GLUTEN_FREE").orElseThrow());
    typeListGLS.add(typeOfProductRepository.findByName("LACTOSE_FREE").orElseThrow());
    typeListGLS.add(typeOfProductRepository.findByName("SUGAR_FREE").orElseThrow());

    Product yogaBall = new Product( Category.SPORTS_EQUIPMENT, new ArrayList<>(), "Yoga Ball", "1 piece", 7.99, "23-25 cm Soft Yoga Ball with Inflatable Straw for Pilates, Yoga, Full Body Workout, Improve Balance at Home in the Gym and Office.", 35);
    yogaBall.getTypeOfProductList().add(other);
    productRepository.save(yogaBall);


    productRepository.save(new Product( Category.SPORTS_EQUIPMENT, typeListOther, "Fitness Band", "1 piece", 10.99, "Exercise Band 100% Latex Theraband with Exercise Instructions in German & Carry Bag for Muscle Building, Yoga, Crossfit, Gymnastics etc.", 20));
    productRepository.save(new Product(Category.SPORTS_EQUIPMENT, typeListOther, "Barbell", "1 pair", 15.99, "Rubber hexagonal dumbbells. Easy-grip handle diameter 25 mm for dumbbells weighing 2.5 kg.", 25));

    productRepository.save(new Product( Category.VITAMIN, typeListGLS, "Vitamin C 1000", "250 tablets", 16.10, "1000 mg vitamin C bioflavonoid dietary supplement tablet with rosehip, elderflower and lemon peel.", 500));
    productRepository.save(new Product( Category.VITAMIN, typeListGLS, "Multivitamin", "100 tablets", 11.30, "Dietary supplement tablet containing vitamins and minerals. Contains 12 vitamins (eg vitamin A, vitamin C, vitamin D). Contains 10 minerals.", 500));
    productRepository.save(new Product( Category.VITAMIN, typeListGLS, "Omega 3", "180 soft capsules", 15.80, "Omega 3 dietary supplement soft gelatin capsules with EPA and DHA.", 500));

    productRepository.save(new Product( Category.PROTEIN_POWDER, typeListGLS, "100% Pure Whey Lactose free", "1000 g", 21.55, "Whey protein complex with added extra amino acids, sweeteners, lactose free.", 500));
    productRepository.save(new Product( Category.PROTEIN_POWDER, typeListGLS, "Beef Protein", "500 g", 12.65, "Bovine hydrolysed protein peptide formula with a special amino acid base. Beef protein is a more easily digestible protein source than low-fat beef (e.g., steak), which is well absorbed and has great biological value as an animal protein.", 500));
    productRepository.save(new Product( Category.PROTEIN_POWDER, typeListGLS, "Iso Whey Zero premium protein", "500 g", 12.65, "Special quality whey protein isolate from Native Whey Isolate with added BCAA and glutamine amino acids.", 500));

    productRepository.save(new Product( Category.PERFORMANCE_ENHANCING_SUPPLEMENT, typeListGLS, "Energy Gel PRO", "60 g", 1.10, "Energy Gel PRO replaces the energy lost during exhaustive test movements with low and high complexity macronutrients: triCARB and MCT (medium chain triglycerides).", 500));
    productRepository.save(new Product( Category.PERFORMANCE_ENHANCING_SUPPLEMENT, typeListGLS, "SuperNova", "9,4 g", 1.20, "Concentrated pre-workout formula with 12 active ingredients, sugar-free!", 500));
    productRepository.save(new Product( Category.PERFORMANCE_ENHANCING_SUPPLEMENT, typeListGLS, "Energy Shot", "25 ml", 1.50, "A liquid energy source with long and short chain carbohydrates (glucose, fructose, maltodextrin, D-ribose) that can be consumed during training. Increased effect with taurine, guarana and l-arginine.", 500));

    productRepository.save(new Product( Category.WEIGH_CONTROLLING_FORMULA, typeListGLS, "Super Fat Burner", "120 tablets", 16.99, "A super dietary supplement for your diet is this stimulant-free, lipotropic formula with choline, added amino acids and L-carnitine.", 500));
    productRepository.save(new Product( Category.WEIGH_CONTROLLING_FORMULA, typeListGLS, "L - Carnitine + Chrome", "60 tablets", 9.99, "Weight control capsule with L-carnitine and chromium without stimulants.", 500));
    productRepository.save(new Product( Category.WEIGH_CONTROLLING_FORMULA, typeListGLS, "L - Carnitine Effervescent tablets", "20 tablets", 3.99, "Effervescent tablets containing 500 Mg L-Carnitine L-tartrate.", 500));

    ArrayList<Product> sportProducts = new ArrayList<>();
    sportProducts.add(productRepository.findByProductName("Barbell").orElseThrow());
    sportProducts.add(productRepository.findByProductName("Fitness Band").orElseThrow());

    ArrayList<Product> vitaminAndProteinProducts = new ArrayList<>();
    vitaminAndProteinProducts.add(productRepository.findByProductName("Multivitamin").orElseThrow());
    vitaminAndProteinProducts.add(productRepository.findByProductName("Beef Protein").orElseThrow());
    vitaminAndProteinProducts.add(productRepository.findByProductName("Beef Protein").orElseThrow());

    ArrayList<Product> looseWeightProducts = new ArrayList<>();
    looseWeightProducts.add(productRepository.findByProductName("SuperNova").orElseThrow());
    looseWeightProducts.add(productRepository.findByProductName("SuperNova").orElseThrow());
    looseWeightProducts.add(productRepository.findByProductName("SuperNova").orElseThrow());
    looseWeightProducts.add(productRepository.findByProductName("Energy Shot").orElseThrow());
    looseWeightProducts.add(productRepository.findByProductName("Super Fat Burner").orElseThrow());

    ArrayList<Order> orderListUbi = new ArrayList<>();

    ArrayList<Order> orderListUrsi = new ArrayList<>();

    ArrayList<Order> orderListTeo = new ArrayList<>();

    userRepository.save(new User("ubi@gmail.com", "Ubul", "Reckless",
        passwordEncoder.encode("pass"), "Germany", "80333", "München",
        "Altstadt", "69", "+49 173 12345678", orderListUbi));

    userRepository.save(new User("ursi@gmail.com", "Ursula", "Tons",
        passwordEncoder.encode("word"), "England", "TA6 3ER", "Bridgwater",
        "Mount Street", "35", "+44 7911 123456", orderListUrsi));

    userRepository.save(new User("teo@gmail.com", "Teofil", "Jóságos",
        passwordEncoder.encode("password"), "Hungary", "6767", "Alosopicsarocsoge",
        "Óperencia utca", "666", "+36 1 123456", orderListTeo));

    orderRepository.save(new Order( userRepository.findByUsername("ubi@gmail.com").orElseThrow(), sportProducts, Status.DELIVERED, TypeOfPayment.BANKCARD));
    orderRepository.save(new Order(userRepository.findByUsername("ubi@gmail.com").orElseThrow(), vitaminAndProteinProducts, Status.ORDERED, TypeOfPayment.BANKCARD));

    orderRepository.save(new Order(userRepository.findByUsername("ursi@gmail.com").orElseThrow(), looseWeightProducts, Status.DELIVERED, TypeOfPayment.BANKCARD));
    orderRepository.save(new Order( userRepository.findByUsername("ursi@gmail.com").orElseThrow(), sportProducts, Status.ORDERED, TypeOfPayment.BANKCARD));

    orderRepository.save(new Order(userRepository.findByUsername("teo@gmail.com").orElseThrow(), vitaminAndProteinProducts, Status.DELIVERED, TypeOfPayment.BANKCARD));
    orderRepository.save(new Order(userRepository.findByUsername("teo@gmail.com").orElseThrow(), looseWeightProducts, Status.ORDERED, TypeOfPayment.BANKCARD));

  }

}
