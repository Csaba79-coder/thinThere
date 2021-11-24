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

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TypeOfProductRepository typeOfProductRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;


  public DataLoader(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void run(ApplicationArguments arguments) {

    typeOfProductRepository.save(new TypeOfProduct("GLUTEN_FREE"));
    typeOfProductRepository.save(new TypeOfProduct("LACTOSE_FREE"));
    typeOfProductRepository.save(new TypeOfProduct("SUGAR_FREE"));
    typeOfProductRepository.save(new TypeOfProduct("VEGAN"));
    typeOfProductRepository.save(new TypeOfProduct("OTHER"));

    typeOfProductRepository.findByName("OTHER").orElseThrow();

    ArrayList<TypeOfProduct> typeListOther = new ArrayList<>();
    typeListOther.add(typeOfProductRepository.findByName("OTHER").orElseThrow());

    ArrayList<TypeOfProduct> typeListGLS = new ArrayList<>();
    typeListOther.add(typeOfProductRepository.findByName("GLUTEN_FREE").orElseThrow());
    typeListOther.add(typeOfProductRepository.findByName("LACTOSE_FREE").orElseThrow());
    typeListOther.add(typeOfProductRepository.findByName("SUGAR_FREE").orElseThrow());

    productRepository.save(new Product(1L, Category.SPORTS_EQUIPMENT, typeListOther, "Yoga Ball", "1 piece", 7.99, "23-25 cm Soft Yoga Ball with Inflatable Straw for Pilates, Yoga, Full Body Workout, Improve Balance at Home in the Gym and Office.", 35));
    productRepository.save(new Product(2L, Category.SPORTS_EQUIPMENT, typeListOther, "Fitness Band", "1 piece", 10.99, "Exercise Band 100% Latex Theraband with Exercise Instructions in German & Carry Bag for Muscle Building, Yoga, Crossfit, Gymnastics etc.", 20));
    productRepository.save(new Product(3L, Category.SPORTS_EQUIPMENT, typeListOther, "Barbell", "1 pair", 15.99, "Rubber hexagonal dumbbells. Easy-grip handle diameter 25 mm for dumbbells weighing 2.5 kg.", 25));

    productRepository.save(new Product(4L, Category.VITAMIN, typeListGLS, "Vitamin C 1000", "250 tablets", 16.10, "1000 mg vitamin C bioflavonoid dietary supplement tablet with rosehip, elderflower and lemon peel.", 500));
    productRepository.save(new Product(5L, Category.VITAMIN, typeListGLS, "Multivitamin", "100 tablets", 11.30, "Dietary supplement tablet containing vitamins and minerals. Contains 12 vitamins (eg vitamin A, vitamin C, vitamin D). Contains 10 minerals.", 500));
    productRepository.save(new Product(6L, Category.VITAMIN, typeListGLS, "Omega 3", "180 soft capsules", 15.80, "Omega 3 dietary supplement soft gelatin capsules with EPA and DHA.", 500));

    productRepository.save(new Product(7L, Category.PROTEIN_POWDER, typeListGLS, "100% Pure Whey Lactose free", "1000 g", 21.55, "Whey protein complex with added extra amino acids, sweeteners, lactose free.", 500));
    productRepository.save(new Product(8L, Category.PROTEIN_POWDER, typeListGLS, "Beef Protein", "500 g", 12.65, "Bovine hydrolysed protein peptide formula with a special amino acid base. Beef protein is a more easily digestible protein source than low-fat beef (e.g., steak), which is well absorbed and has great biological value as an animal protein.", 500));
    productRepository.save(new Product(9L, Category.PROTEIN_POWDER, typeListGLS, "Iso Whey Zero premium protein", "500 g", 12.65, "Special quality whey protein isolate from Native Whey Isolate with added BCAA and glutamine amino acids.", 500));

    productRepository.save(new Product(10L, Category.PERFORMANCE_ENHANCING_SUPPLEMENT, typeListGLS, "Energy Gel PRO", "60 g", 1.10, "Energy Gel PRO replaces the energy lost during exhaustive test movements with low and high complexity macronutrients: triCARB and MCT (medium chain triglycerides).", 500));
    productRepository.save(new Product(11L, Category.PERFORMANCE_ENHANCING_SUPPLEMENT, typeListGLS, "SuperNova", "9,4 g", 1.20, "Concentrated pre-workout formula with 12 active ingredients, sugar-free!", 500));
    productRepository.save(new Product(12L, Category.PERFORMANCE_ENHANCING_SUPPLEMENT, typeListGLS, "Energy Shot", "25 ml", 1.50, "A liquid energy source with long and short chain carbohydrates (glucose, fructose, maltodextrin, D-ribose) that can be consumed during training. Increased effect with taurine, guarana and l-arginine.", 500));

    productRepository.save(new Product(13L, Category.WEIGH_CONTROLLING_FORMULA, typeListGLS, "Super Fat Burner", "120 tablets", 16.99, "A super dietary supplement for your diet is this stimulant-free, lipotropic formula with choline, added amino acids and L-carnitine.", 500));
    productRepository.save(new Product(14L, Category.WEIGH_CONTROLLING_FORMULA, typeListGLS, "L - Carnitine + Chrome", "60 tablets", 9.99, "Weight control capsule with L-carnitine and chromium without stimulants.", 500));
    productRepository.save(new Product(15L, Category.WEIGH_CONTROLLING_FORMULA, typeListGLS, "L - Carnitine Effervescent tablets", "20 tablets", 3.99, "Effervescent tablets containing 500 Mg L-Carnitine L-tartrate.", 500));

    ArrayList<Product> sportProducts = new ArrayList<>();
    sportProducts.add(productRepository.findById(3L).orElseThrow());
    sportProducts.add(productRepository.findById(2L).orElseThrow());

    ArrayList<Product> vitaminAndProteinProducts = new ArrayList<>();
    vitaminAndProteinProducts.add(productRepository.findById(5L).orElseThrow());
    vitaminAndProteinProducts.add(productRepository.findById(8L).orElseThrow());
    vitaminAndProteinProducts.add(productRepository.findById(8L).orElseThrow());

    ArrayList<Product> looseWeightProducts = new ArrayList<>();
    looseWeightProducts.add(productRepository.findById(11L).orElseThrow());
    looseWeightProducts.add(productRepository.findById(11L).orElseThrow());
    looseWeightProducts.add(productRepository.findById(11L).orElseThrow());
    looseWeightProducts.add(productRepository.findById(12L).orElseThrow());
    looseWeightProducts.add(productRepository.findById(13L).orElseThrow());

    ArrayList<Order> orderListUbi = new ArrayList<>();

    ArrayList<Order> orderListUrsi = new ArrayList<>();

    ArrayList<Order> orderListTeo = new ArrayList<>();

    userRepository.save(new User(16L,"ubi@gmail.com", "Ubul", "Reckless",
        passwordEncoder.encode("pass"), "Germany", "80333", "München",
        "Altstadt", "69", "+49 173 12345678", orderListUbi));

    userRepository.save(new User(17L,"ursi@gmail.com", "Ursula", "Tons",
        passwordEncoder.encode("word"), "England", "TA6 3ER", "Bridgwater",
        "Mount Street", "35", "+44 7911 123456", orderListUrsi));

    userRepository.save(new User(18L, "teo@gmail.com", "Teofil", "Jóságos",
        passwordEncoder.encode("password"), "Hungary", "6767", "Alosopicsarocsoge",
        "Óperencia utca", "666", "+36 1 123456", orderListTeo));

    orderRepository.save(new Order(19L, userRepository.findByUsername("ubi@gmail.com").orElseThrow(), sportProducts, Status.DELIVERED, TypeOfPayment.BANKCARD));
    orderRepository.save(new Order(20L, userRepository.findByUsername("ubi@gmail.com").orElseThrow(), vitaminAndProteinProducts, Status.ORDERED, TypeOfPayment.BANKCARD));

    orderRepository.save(new Order(21L, userRepository.findByUsername("ursi@gmail.com").orElseThrow(), looseWeightProducts, Status.DELIVERED, TypeOfPayment.BANKCARD));
    orderRepository.save(new Order(22L, userRepository.findByUsername("ursi@gmail.com").orElseThrow(), sportProducts, Status.ORDERED, TypeOfPayment.BANKCARD));

    orderRepository.save(new Order(23L, userRepository.findByUsername("teo@gmail.com").orElseThrow(), vitaminAndProteinProducts, Status.DELIVERED, TypeOfPayment.BANKCARD));
    orderRepository.save(new Order(24L, userRepository.findByUsername("teo@gmail.com").orElseThrow(), looseWeightProducts, Status.ORDERED, TypeOfPayment.BANKCARD));

    orderListUbi.add(orderRepository.findById(19L).orElseThrow());
    orderListUbi.add(orderRepository.findById(20L).orElseThrow());

    orderListUrsi.add(orderRepository.findById(21L).orElseThrow());
    orderListUrsi.add(orderRepository.findById(22L).orElseThrow());

    orderListTeo.add(orderRepository.findById(23L).orElseThrow());
    orderListTeo.add(orderRepository.findById(24L).orElseThrow());

  }

}
