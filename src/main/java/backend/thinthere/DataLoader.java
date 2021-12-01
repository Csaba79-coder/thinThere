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
import java.util.HashSet;
import java.util.Set;
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

    TypeOfProduct lactoseFree = new TypeOfProduct("LACTOSE_FREE");
    typeOfProductRepository.save(lactoseFree);

    TypeOfProduct sugarFree = new TypeOfProduct("SUGAR_FREE");
    typeOfProductRepository.save(sugarFree);

    TypeOfProduct vegan = new TypeOfProduct("VEGAN");
    typeOfProductRepository.save(vegan);

    TypeOfProduct other = new TypeOfProduct("OTHER");
    typeOfProductRepository.save(other);

    Set<TypeOfProduct> typeListOther = new HashSet<>();
    typeListOther.add(other);


    Set<TypeOfProduct> typeListGLS = new HashSet<>();
    typeListGLS.add(glutenFree);
    typeListGLS.add(sugarFree);
    typeListGLS.add(lactoseFree);

    Product yogaBall = new Product( Category.SPORTS_EQUIPMENT, new HashSet<>(), "Yoga Ball", "1 piece", 7.99, "23-25 cm Soft Yoga Ball with Inflatable Straw for Pilates, Yoga, Full Body Workout, Improve Balance at Home in the Gym and Office.", 35);
    yogaBall.getTypeOfProductList().add(other);
    productRepository.save(yogaBall);

    Product fitnessBand = new Product( Category.SPORTS_EQUIPMENT, new HashSet<>(), "Fitness Band", "1 piece", 10.99, "Exercise Band 100% Latex Theraband with Exercise Instructions in German & Carry Bag for Muscle Building, Yoga, Crossfit, Gymnastics etc.", 20);
    fitnessBand.getTypeOfProductList().add(other);
    productRepository.save(fitnessBand);

    Product barbell = new Product(Category.SPORTS_EQUIPMENT, new HashSet<>(), "Barbell", "1 pair", 15.99, "Rubber hexagonal dumbbells. Easy-grip handle diameter 25 mm for dumbbells weighing 2.5 kg.", 25);
    barbell.getTypeOfProductList().add(other);
    productRepository.save(barbell);

    Product vitaminC1000 = new Product(Category.VITAMIN, new HashSet<>(), "Vitamin C 1000", "250 tablets", 16.10, "1000 mg vitamin C bioflavonoid dietary supplement tablet with rosehip, elderflower and lemon peel.", 500);
    vitaminC1000.getTypeOfProductList().add(glutenFree);
    vitaminC1000.getTypeOfProductList().add(sugarFree);
    vitaminC1000.getTypeOfProductList().add(lactoseFree);
    productRepository.save(vitaminC1000);

    Product multiVitamin = new Product( Category.VITAMIN, new HashSet<>(), "Multivitamin", "100 tablets", 11.30, "Dietary supplement tablet containing vitamins and minerals. Contains 12 vitamins (eg vitamin A, vitamin C, vitamin D). Contains 10 minerals.", 500);
    multiVitamin.getTypeOfProductList().add(glutenFree);
    multiVitamin.getTypeOfProductList().add(sugarFree);
    multiVitamin.getTypeOfProductList().add(lactoseFree);
    productRepository.save(multiVitamin);

    Product omega3 = new Product( Category.VITAMIN, new HashSet<>(), "Omega 3", "180 soft capsules", 15.80, "Omega 3 dietary supplement soft gelatin capsules with EPA and DHA.", 500);
    omega3.getTypeOfProductList().add(glutenFree);
    omega3.getTypeOfProductList().add(sugarFree);
    omega3.getTypeOfProductList().add(lactoseFree);
    productRepository.save(omega3);

    Product pureWhey = new Product( Category.PROTEIN_POWDER, new HashSet<>(), "100% Pure Whey Lactose free", "1000 g", 21.55, "Whey protein complex with added extra amino acids, sweeteners, lactose free.", 500);
    pureWhey.getTypeOfProductList().add(glutenFree);
    pureWhey.getTypeOfProductList().add(sugarFree);
    pureWhey.getTypeOfProductList().add(lactoseFree);
    productRepository.save(pureWhey);

    Product beefProtein = new Product( Category.PROTEIN_POWDER, new HashSet<>(), "Beef Protein", "500 g", 12.65, "Bovine hydrolysed protein peptide formula with a special amino acid base. Beef protein is a more easily digestible protein source than low-fat beef (e.g., steak), which is well absorbed and has great biological value as an animal protein.", 500);
    beefProtein.getTypeOfProductList().add(glutenFree);
    beefProtein.getTypeOfProductList().add(sugarFree);
    beefProtein.getTypeOfProductList().add(lactoseFree);
    productRepository.save(beefProtein);

    Product isoWhey = new Product( Category.PROTEIN_POWDER, new HashSet<>(), "Iso Whey Zero premium protein", "500 g", 12.65, "Special quality whey protein isolate from Native Whey Isolate with added BCAA and glutamine amino acids.", 500);
    isoWhey.getTypeOfProductList().add(glutenFree);
    isoWhey.getTypeOfProductList().add(sugarFree);
    isoWhey.getTypeOfProductList().add(lactoseFree);
    productRepository.save(isoWhey);

    Product energyGel = new Product( Category.PERFORMANCE_ENHANCING_SUPPLEMENT, new HashSet<>(), "Energy Gel PRO", "60 g", 1.10, "Energy Gel PRO replaces the energy lost during exhaustive test movements with low and high complexity macronutrients: triCARB and MCT (medium chain triglycerides).", 500);
    energyGel.getTypeOfProductList().add(glutenFree);
    energyGel.getTypeOfProductList().add(sugarFree);
    energyGel.getTypeOfProductList().add(lactoseFree);
    productRepository.save(energyGel);

    Product superNova = new Product( Category.PERFORMANCE_ENHANCING_SUPPLEMENT, new HashSet<>(), "SuperNova", "9,4 g", 1.20, "Concentrated pre-workout formula with 12 active ingredients, sugar-free!", 500);
    superNova.getTypeOfProductList().add(glutenFree);
    superNova.getTypeOfProductList().add(sugarFree);
    superNova.getTypeOfProductList().add(lactoseFree);
    productRepository.save(superNova);

    Product energyShot = new Product( Category.PERFORMANCE_ENHANCING_SUPPLEMENT, new HashSet<>(), "Energy Shot", "25 ml", 1.50, "A liquid energy source with long and short chain carbohydrates (glucose, fructose, maltodextrin, D-ribose) that can be consumed during training. Increased effect with taurine, guarana and l-arginine.", 500);
    energyShot.getTypeOfProductList().add(glutenFree);
    energyShot.getTypeOfProductList().add(sugarFree);
    energyShot.getTypeOfProductList().add(lactoseFree);
    productRepository.save(energyShot);

    Product fatBurner = new Product( Category.WEIGH_CONTROLLING_FORMULA, new HashSet<>(), "Super Fat Burner", "120 tablets", 16.99, "A super dietary supplement for your diet is this stimulant-free, lipotropic formula with choline, added amino acids and L-carnitine.", 500);
    fatBurner.getTypeOfProductList().add(glutenFree);
    fatBurner.getTypeOfProductList().add(sugarFree);
    fatBurner.getTypeOfProductList().add(lactoseFree);
    productRepository.save(fatBurner);

    Product carnitineChrome = new Product( Category.WEIGH_CONTROLLING_FORMULA, new HashSet<>(), "L - Carnitine + Chrome", "60 tablets", 9.99, "Weight control capsule with L-carnitine and chromium without stimulants.", 500);
    carnitineChrome.getTypeOfProductList().add(glutenFree);
    carnitineChrome.getTypeOfProductList().add(sugarFree);
    carnitineChrome.getTypeOfProductList().add(lactoseFree);
    productRepository.save(carnitineChrome);

    Product carnitineTablets = new Product( Category.WEIGH_CONTROLLING_FORMULA, new HashSet<>(), "L - Carnitine Effervescent tablets", "20 tablets", 3.99, "Effervescent tablets containing 500 Mg L-Carnitine L-tartrate.", 500);
    carnitineTablets.getTypeOfProductList().add(glutenFree);
    carnitineTablets.getTypeOfProductList().add(sugarFree);
    carnitineTablets.getTypeOfProductList().add(lactoseFree);
    productRepository.save(carnitineTablets);


    ArrayList<Product> sportProducts = new ArrayList<>();
    sportProducts.add(barbell);
    sportProducts.add(fitnessBand);

    ArrayList<Product> vitaminAndProteinProducts = new ArrayList<>();
    vitaminAndProteinProducts.add(multiVitamin);
    vitaminAndProteinProducts.add(beefProtein);
    vitaminAndProteinProducts.add(beefProtein);

    ArrayList<Product> looseWeightProducts = new ArrayList<>();
    looseWeightProducts.add(superNova);
    looseWeightProducts.add(superNova);
    looseWeightProducts.add(superNova);
    looseWeightProducts.add(energyShot);
    looseWeightProducts.add(fatBurner);


    User ubul = new User("ubi@gmail.com", "Ubul", "Reckless",
        passwordEncoder.encode("pass"), "Germany", "80333", "München",
        "Altstadt", "69", "+49 173 12345678", new HashSet<>());

    userRepository.save(ubul);

    User ursula = new User("ursi@gmail.com", "Ursula", "Tons",
        passwordEncoder.encode("word"), "England", "TA6 3ER", "Bridgwater",
        "Mount Street", "35", "+44 7911 123456", new HashSet<>());

    userRepository.save(ursula);

    User teofil =  new User("teo@gmail.com", "Teofil", "Jóságos",
        passwordEncoder.encode("password"), "Hungary", "6767", "Alosopicsarocsoge",
        "Óperencia utca", "666", "+36 1 123456", new HashSet<>());

    userRepository.save(teofil);


    Order ubiOrderDelivered = new Order(null, sportProducts, Status.DELIVERED, TypeOfPayment.BANKCARD);
    ubiOrderDelivered.setUser(ubul);
    ubul.getOrder().add(ubiOrderDelivered);
    orderRepository.save(ubiOrderDelivered);


    Order ubiOrderOrdered = new Order(null, vitaminAndProteinProducts, Status.ORDERED, TypeOfPayment.BANKCARD);
    ubiOrderOrdered.setUser(ubul);
    ubul.getOrder().add(ubiOrderOrdered);
    orderRepository.save(ubiOrderOrdered);


    Order ursiOrderDelivered = new Order(null, looseWeightProducts, Status.DELIVERED, TypeOfPayment.BANKCARD);
    ursiOrderDelivered.setUser(ursula);
    ursula.getOrder().add(ursiOrderDelivered);
    orderRepository.save(ursiOrderDelivered);

    Order ursiOrderOrdered = new Order(null, sportProducts, Status.ORDERED, TypeOfPayment.BANKCARD);
    ursiOrderOrdered.setUser(ursula);
    ursula.getOrder().add(ursiOrderOrdered);
    orderRepository.save(ursiOrderOrdered);


    Order teoOrderDelivered = new Order(null, vitaminAndProteinProducts, Status.DELIVERED, TypeOfPayment.BANKCARD);
    teoOrderDelivered.setUser(teofil);
    teofil.getOrder().add(teoOrderDelivered);
    orderRepository.save(teoOrderDelivered);

    Order teoOrderOrdered = new Order(null, looseWeightProducts, Status.ORDERED, TypeOfPayment.BANKCARD);
    teoOrderOrdered.setUser(teofil);
    teofil.getOrder().add(teoOrderOrdered);
    orderRepository.save(teoOrderOrdered);

  }

}
