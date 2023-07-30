package com.anapedra.commerce;

import com.anapedra.commerce.entities.*;
import com.anapedra.commerce.entities.enums.AddressType;
import com.anapedra.commerce.entities.enums.OrderStatus;
import com.anapedra.commerce.entities.enums.PaymentType;
import com.anapedra.commerce.entities.enums.PhoneType;
import com.anapedra.commerce.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CommerceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final AddressRepository addressRepository;
    private final PhonesRepository phonesRepository;
    private final ShippingPriceTableRepository shippingPriceTableRepository;
    private final ShipRepository shipRepository;
    private final DiscountTableRepository discountTableRepository;
    private final DiscountOnOrderRepository discountOnOrderRepository;
    public CommerceApplication(UserRepository userRepository,
                               RoleRepository roleRepository,
                               ProductRepository productRepository,
                               CategoryRepository categoryRepository,
                               PaymentRepository paymentRepository,
                               OrderRepository orderRepository,
                               OrderItemRepository orderItemRepository,
                               AddressRepository addressRepository,
                               PhonesRepository phonesRepository,
                               ShippingPriceTableRepository shippingPriceTableRepository,
                               ShipRepository shipRepository,
                               DiscountTableRepository discountTableRepository,
                               DiscountOnOrderRepository discountOnOrderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.addressRepository = addressRepository;
        this.phonesRepository = phonesRepository;
        this.shippingPriceTableRepository = shippingPriceTableRepository;
        this.shipRepository = shipRepository;
        this.discountTableRepository = discountTableRepository;
        this.discountOnOrderRepository = discountOnOrderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> clients=new ArrayList<>();
        List<Role>roles=new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Category>categories=new ArrayList<>();
        List<Payment>payments=new ArrayList<>();
        List<Order>orders=new ArrayList<>();
        List<OrderItem>orderItems=new ArrayList<>();
        List<Address>addresses=new ArrayList<>();
        List<Phones>phones=new ArrayList<>();
        List<ShippingPriceTable>shippingPriceTables=new ArrayList<>();
        List<Ship>ships=new ArrayList<>();
        List<DiscountTable>discountTables=new ArrayList<>();
        List<DiscountOnOrder>discountOnOrders=new ArrayList<>();


        Role role1=new Role(1L,"ROLE_ADMIN");
        Role role2=new Role(2L,"ROLE_CLIENT");
        roles.addAll(Arrays.asList(role1,role2));
        roleRepository.saveAll(roles);
        User cl1=new User(1L,"Luiza Bradão",Instant.parse("2015-02-23T08:00:00Z"),null,"8177906788","307.460.850-10","luiza@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl2=new User(2L,"Mara Vascon",Instant.parse("2019-02-23T08:00:00Z"),null,"8177906788","488.298.100-96","maria@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl3=new User(3L,"Lucas Marcone Silva",Instant.parse("2015-05-22T08:00:00Z"),null,"8177906788","598.566.190-33","mara@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl4=new User(4L,"Ana Bragalha",Instant.parse("2019-09-22T08:00:00Z"),null,"1236644475","407.242.380-77","bragalha@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl5=new User(5L,"Mari Ferreira",Instant.parse("2011-02-12T08:00:00Z"),null,"3598866458","499.367.000-15","mapris@gmaill.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl6=new User(6L,"Sandra Magal Simão",Instant.parse("2017-01-20T08:00:00Z"),null,"6293344685","515.504.430-89","saira@gmaill.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl7=new User(7L,"Helena Saldanha Filipa",Instant.parse("2018-02-21T08:00:00Z"),null,"6199658574","353.586.090-32","helena@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl8=new User(8L,"Mariana Prado",Instant.parse("2011-10-18T08:00:00Z"),null,"8799943555","918.324.580-40","mariana@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl9=new User(9L,"Socorro Ribeiro",Instant.parse("2019-01-23T08:00:00Z"),null,"6186938921","564.677.060-21","socorro@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl10=new User(10L,"Ana Prado Santana",Instant.parse("2017-06-02T08:00:00Z"),null,"1223655478","948.320.260-46","anaprado@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl11=new User(11L,"Sandra Marcodes",Instant.parse("2013-02-28T08:00:00Z"),null,"7888965421","861.322.570-55","saidra@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl12=new User(12L,"Ana Matias",Instant.parse("2018-09-20T08:00:00Z"),null,"1293655478","371.032.700-82","anamartins@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl13=new User(13L,"Mari Samaria",Instant.parse("2000-09-20T08:00:00Z"),null,"4598698712","653.812.100-43","mari@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl14=new User(14L,"Sandra Osca Sintra", Instant.parse("2017-10-21T08:00:00Z"),null,"7878965421","779.187.500-47","sanfraosca@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        clients.addAll(Arrays.asList(cl1, cl2, cl3, cl4,cl5,cl6,cl7,cl8,cl9,cl10,cl11,cl12,cl13,cl14));
        userRepository.saveAll(clients);
        cl1.getRoles().addAll(Arrays.asList(role1,role2));
        cl2.getRoles().add(role1);
        cl1.getRoles().add(role2);
        cl2.getRoles().add(role2);
        cl3.getRoles().add(role2);
        cl4.getRoles().add(role2);
        cl5.getRoles().add(role2);
        cl6.getRoles().add(role2);
        cl7.getRoles().add(role2);
        cl8.getRoles().add(role2);
        cl10.getRoles().add(role2);
        cl11.getRoles().add(role2);
        cl12.getRoles().add(role2);
        cl13.getRoles().add(role2);
        cl14.getRoles().add(role2);
        clients.addAll(Arrays.asList(cl1,cl2,cl3,cl4,cl5,cl6,cl7,cl8,cl9,
                cl10,cl11,cl12,cl13,cl14));
        userRepository.saveAll(clients);

        Category cat1=new Category(null,"Eletronic",Instant.parse("2000-03-21T08:00:00Z"),null);
        Category cat2=new Category(null,"Book",Instant.parse("2000-03-21T08:00:00Z"),null);
        Category cat3=new Category(null,"computer",Instant.parse("2000-03-21T08:00:00Z"),null);
        Category cat4=new Category(null,"home appliances",Instant.parse("2000-03-21T08:00:00Z"),null);
        categories.addAll(Arrays.asList(cat1,cat2,cat3,cat4));
        categoryRepository.saveAll(categories);
        Product p1=new Product(1L,Instant.parse("2022-03-21T08:00:00Z"),Instant.now(),"Fone","Fone de ouvido sem fio preto com estojo de carregamento",5.,50.,"https://img.freepik.com/fotos-gratis/fone-de-ouvido-sem-fio-preto-com-estojo-de-carregamento_1268-14371.jpg?w=900&t=st=1687996874~exp=1687997474~hmac=41b2e4f8f26503607a4b27704ce406a7569c8474d2c81b969cf454068fbba2f8");
        Product p2=new Product(2L,Instant.parse("2023-02-25T08:00:00Z"),Instant.now(),"Relógio","Relógio inteligente digital isolado renderização 3d ilustração",5.,50.,"https://img.freepik.com/psd-gratuitas/icone-de-relogio-inteligente-digital-isolado-renderizacao-3d-ilustracao_439185-11924.jpg?w=740&t=st=1687997059~exp=1687997659~hmac=b67b5b68e4d10704821355704349e63611605e4efa0419af6951152e0f7b801b");
        Product p3=new Product(3L,Instant.parse("2023-04-20T08:00:00Z"),Instant.now(),"Fone"," Fone de ouvido preto dispositivo digital",5.,50.,"https://img.freepik.com/fotos-gratis/fone-de-ouvido-preto-dispositivo-digital_53876-97302.jpg?w=740&t=st=1687997194~exp=1687997794~hmac=f4a25bbe0429f34805d1f3f6ec954b2102cc875aade1e5e90111e20576bc1de7");
        Product p4=new Product(4L,Instant.parse("2023-05-21T08:00:00Z"),Instant.now(),"Iphone","Iphone 13 pro prata",5.,50.,"https://img.freepik.com/psd-premium/maquete-do-iphone-13-pro-prata_106244-2064.jpg?w=900");
        Product p5=new Product(5L,Instant.parse("2022-03-21T08:00:00Z"),Instant.now(),"Computadores Gamer","Computadores Gamer EasyPC Play.Equipado com processador Intel da família Core i7 e memória de 16GB, além de placa de vídeo Nvidia Geforce da série GT com 2GB de memóriao.",1.9, 2.241,"https://images.kabum.com.br/produtos/fotos/sync_mirakl/418698/PC-Gamer-Enifler-Completo-Intel-Core-I7-16GB-RAM-NVIDIA-GeForce-GTX-1050-TI-1TB-Windows-10-Monitor-21-5-Polegadas-Kit-Gamer-Hayom_1686749295_gg.jpg");
        Product p6=new Product(6L,Instant.parse("2023-02-25T08:00:00Z"),Instant.now(),"Computadores Gamer","PC Gamer Concórdia i7-10700F, Geforce RTX 3060 12GB, 16GB RAM,",5.,6.699,"https://images.kabum.com.br/produtos/fotos/331108/pc-gamer-concordia-i7-10700f-geforce-rtx-3060-12gb-16gb-ram-ssd-500-avalanche-preto-33292_1651693508_gg.jpg");
        Product p7=new Product(7L,Instant.parse("2023-04-20T08:00:00Z"),Instant.now(),"Macbook Pro","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg");
        Product p8=new Product(8L,Instant.parse("2023-05-21T08:00:00Z"),Instant.now(),"Smart TV","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",0.,0.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg");
        Product p9=new Product(9L,Instant.parse("2022-03-21T08:00:00Z"),Instant.now(),"PC Gamer","PC Gamer Concórdia i7-10700F, Geforce RTX 3060 12GB, 16GB RAM",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg");
        Product p10=new Product(10L,Instant.parse("2023-02-25T08:00:00Z"),Instant.now(),"PC Gamer Ex","PC Gamer Ex Concórdia i7-10700F, Geforce RTX 3060 12GB, 16GB RAM",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg");
        Product p11=new Product(11L,Instant.parse("2023-04-20T08:00:00Z"),Instant.now(),"PC Gamer X","PC Gamer XConcórdia i7-10700F, Geforce RTX 3060 12GB, 16GB RAM",5.,50.,"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/6-big.jpg");
        Product p12=new Product(12L,Instant.parse("2023-02-25T08:00:00Z"),Instant.now(),"A Pequena Sereia","A Pequena Sereia e o Reino das Ilusões Capa dura – Edição especial, 21 março 2019",5.,50.,"https://m.media-amazon.com/images/I/513BbcB3JML._SX358_BO1,204,203,200_.jpg");
        Product p13=new Product(13L,Instant.parse("2023-04-20T08:00:00Z"),Instant.now(),"A Bela e a Fera","A Bela e a Fera em mangá: A história da Fera: 2 Capa comum – 20 março 2023",5.,50.,"https://m.media-amazon.com/images/I/51Gvv4cvv2L._SX327_BO1,204,203,200_.jpg");
        Product p14=new Product(14L,Instant.parse("2022-03-21T08:00:00Z"),Instant.now(),"Peter Pan","Peter Pan / Peter Pan: Meu Primeiro Livro Bilíngue Capa comum – Livro de fotos, 8 abril 2021",5.,50.,"https://a-static.mlcdn.com.br/1500x1500/livro-peter-pan/livrariauniversodolivro/131p/90759b2fdda8da399fc54f71aa366f0e.jpg");
        Product p15=new Product(15L,Instant.parse("2023-02-25T08:00:00Z"),Instant.now(),"Geladeira Samsung","Geladeira Samsung Frost Free RF27T5501SG Inverter Door Family Hub Com Spacemax e Soundbar Black Inox – 614 L",5.,50.,"https://imgs.casasbahia.com.br/55011901/1xg.jpg");
        Product p16=new Product(16L,Instant.parse("2023-04-20T08:00:00Z"),Instant.now(),"Refrigerador Smart LG","Refrigerador Smart LG 598 Litros Side by Side InstaView Craft Ice Uvnano Aço Escovado GC-X257CSHS - 127 Volts",5.,50.,"https://i.zst.com.br/thumbs/1/b/e/-734174825.jpg");
        Product p17=new Product(17L,Instant.parse("2023-05-21T08:00:00Z"),Instant.now(),"Lava e Seca Samsung","Lava e Seca Samsung WD18T Black Inox Smart (Wi-Fi) com Digital Inverter e Ecobubble WD18T6500GV - 18/10 kg",5.,50.,"https://imgs.casasbahia.com.br/55061459/1g.jpg");
        products.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17));
        productRepository.saveAll(products);
        p1.getCategories().addAll(Arrays.asList(cat1,cat3));
        p2.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p3.getCategories().addAll(Arrays.asList(cat1,cat2));
        p4.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p5.getCategories().addAll(Arrays.asList(cat1,cat3));
        p6.getCategories().addAll(Arrays.asList(cat1,cat3));
        p7.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p8.getCategories().addAll(Arrays.asList(cat1,cat2));
        p9.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p10.getCategories().addAll(Arrays.asList(cat1,cat3));
        p11.getCategories().addAll(Arrays.asList(cat1,cat3));
        p12.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p13.getCategories().addAll(Arrays.asList(cat1,cat2));
        p14.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p15.getCategories().addAll(Arrays.asList(cat1,cat3));
        p16.getCategories().addAll(Arrays.asList(cat1,cat3,cat2));
        p17.getCategories().addAll(Arrays.asList(cat1,cat3));
        products.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17));
        productRepository.saveAll(products);

        Order o1=new Order(1L,Instant.parse("2021-10-01T08:00:00Z"),LocalDate.parse("2021-10-01"),OrderStatus.PAID,null,null,null,cl1);
        Order o2=new Order(2L,Instant.parse("2020-11-09T08:00:00Z"),LocalDate.parse("2020-11-09"),OrderStatus.SHIPPED,null,null,null,cl4);
        Order o3=new Order(3L,Instant.parse("2022-01-09T08:00:00Z"),LocalDate.parse("2022-01-09"),OrderStatus.PAID,null,null,null,cl5);
        Order o4=new Order(4L,Instant.parse("2023-05-25T08:00:00Z"),LocalDate.parse("2023-05-25"),OrderStatus.PAID,null,null,null,cl6);
        Order o5=new Order(5L,Instant.parse("2020-11-01T08:00:00Z"),LocalDate.parse("2020-11-01"),OrderStatus.PAID,null,null,null,cl10);
        Order o6=new Order(6L,Instant.parse("2020-11-16T08:00:00Z"),LocalDate.parse("2020-11-16"),OrderStatus.PAID,null,null,null,cl8);
        Order o7=new Order(7L,Instant.parse("2022-11-01T08:00:00Z"),LocalDate.parse("2022-11-01"), OrderStatus.PAID,null,null,null,cl11);
        Order o8=new Order(8L,Instant.parse("2022-11-18T08:00:00Z"),LocalDate.parse("2022-11-18"),OrderStatus.PAID,null,null,null,cl1);
        Order o9=new Order(9L,Instant.parse("2022-11-01T08:00:00Z"),LocalDate.parse("2022-11-01"),OrderStatus.PAID,null,null,null,cl3);
        Order o10 =new Order(10L,Instant.parse("2021-11-01T08:00:00Z"),LocalDate.parse("2021-11-01"),OrderStatus.PAID,null,null,null,cl10);
        Order o12=new Order(12L,Instant.parse("2022-11-01T08:00:00Z"),LocalDate.parse("2022-11-01"),OrderStatus.PAID,null,null,null,cl2);
        Order o13=new Order(13L,Instant.parse("2021-10-21T08:00:00Z"),LocalDate.parse("2021-10-21"),OrderStatus.PAID,null,null,null,cl9);
        Order o14=new Order(14L,Instant.parse("2023-03-05T08:00:00Z"),LocalDate.parse("2023-03-05"),OrderStatus.PAID,null,null,null,cl9);
        Order o15=new Order(15L,Instant.parse("2023-04-10T08:00:00Z"),LocalDate.parse("2023-04-10"),OrderStatus.PAID,null,null,null,cl1);
        Order o16=new Order(16L,Instant.parse("2021-12-22T08:00:00Z"),LocalDate.parse("2021-12-22"),OrderStatus.PAID,null,null,null,cl11);
        Order o17=new Order(17L,Instant.parse("2022-01-07T08:00:00Z"),LocalDate.parse("2022-01-07"),OrderStatus.PAID,null,null,null,cl9);
        Order o18=new Order(18L,Instant.parse("2019-11-09T08:00:00Z"),LocalDate.parse("2019-11-09"),OrderStatus.PAID,null,null,null,cl1);
        Order o19=new Order(19L,Instant.parse("2018-12-01T08:00:00Z"),LocalDate.parse("2018-12-01"),OrderStatus.WAITING_PAYMENT,null,null,null,cl4);
        Order o20=new Order(20L,Instant.parse("2023-05-01T08:00:00Z"),LocalDate.parse("2023-05-01"),OrderStatus.WAITING_PAYMENT,null,null,null,cl6);
        Order o21=new Order(21L,Instant.parse("2023-01-01T08:00:00Z"),LocalDate.parse("2023-01-01"),OrderStatus.WAITING_PAYMENT,null,null,null,cl1);
        Order o22=new Order(22L,Instant.parse("2015-11-01T08:00:00Z"),LocalDate.parse("2012-11-01"),OrderStatus.WAITING_PAYMENT,null,null,null,cl1);
        Order o23=new Order(23L,Instant.parse("2012-11-01T08:00:00Z"),LocalDate.parse("2000-11-01"),OrderStatus.WAITING_PAYMENT,null,null,null,cl1);
        Order o24=new Order(24L,Instant.parse("2011-11-01T08:00:00Z"),LocalDate.parse("2011-11-01"),OrderStatus.WAITING_PAYMENT,null,null,null,cl7);
        orders.addAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o12,o13,o14,o15,o16,o17,o18,o19,o20,o21,o22,o22,o23,o24));
        orderRepository.saveAll(orders);

        OrderItem ot1 = new OrderItem(o1,p1,3, p1.getInitialPrice());
        OrderItem ot2 = new OrderItem(o1,p2,3, p2.getInitialPrice());
        OrderItem ot3 = new OrderItem(o1,p3,5, p3.getInitialPrice());
        OrderItem ot4 = new OrderItem(o1,p4,2, p4.getInitialPrice());
        orderItems.addAll(Arrays.asList(ot1,ot2,ot3,ot4));

        orderItemRepository.saveAll(orderItems);
        OrderItem ot5 = new OrderItem(o2,p1,1, p1.getInitialPrice());
        OrderItem ot6 = new OrderItem(o2,p2,2, p2.getInitialPrice());
        OrderItem ot7 = new OrderItem(o2,p3,1, p3.getInitialPrice());
        OrderItem ot8 = new OrderItem(o2,p4,2, p4.getInitialPrice());

        OrderItem ot9 = new OrderItem(o3,p1,1, p1.getInitialPrice());
        OrderItem ot10 = new OrderItem(o3,p2,2, p2.getInitialPrice());
        OrderItem ot11 = new OrderItem(o3,p3,5, p3.getInitialPrice());
        OrderItem ot12 = new OrderItem(o3,p4,1, p4.getInitialPrice());

        OrderItem ot13 = new OrderItem(o4,p2,1, p2.getInitialPrice());
        OrderItem ot14 = new OrderItem(o4,p4,1, p3.getInitialPrice());

        OrderItem ot15 = new OrderItem(o5,p2,10, p2.getInitialPrice());
        OrderItem ot16 = new OrderItem(o5,p4,5, p4.getInitialPrice());
        OrderItem ot17 = new OrderItem(o5,p1,20, p1.getInitialPrice());
        OrderItem ot18 = new OrderItem(o5,p3,10, p3.getInitialPrice());
        OrderItem ot19 = new OrderItem(o5,p5,10, p5.getInitialPrice());
        OrderItem ot20 = new OrderItem(o5,p15,10, p15.getInitialPrice());
        OrderItem ot21 = new OrderItem(o5,p10,10, p10.getInitialPrice());
        OrderItem ot22 = new OrderItem(o5,p7,20, p7.getInitialPrice());
        OrderItem ot23 = new OrderItem(o5,p6,10, p6.getInitialPrice());
        OrderItem ot24 = new OrderItem(o5,p11,10, p11.getInitialPrice());
        OrderItem ot25 = new OrderItem(o5,p17,10, p17.getInitialPrice());
        OrderItem ot26 = new OrderItem(o5,p8,10, p8.getInitialPrice());

        OrderItem ot27 = new OrderItem(o6,p2,10, p2.getInitialPrice());
        OrderItem ot28 = new OrderItem(o6,p4,5, p4.getInitialPrice());
        OrderItem ot29 = new OrderItem(o6,p1,20, p1.getInitialPrice());
        OrderItem ot30 = new OrderItem(o6,p3,10, p3.getInitialPrice());
        OrderItem ot31 = new OrderItem(o6,p5,10, p5.getInitialPrice());
        OrderItem ot32 = new OrderItem(o6,p15,10, p15.getInitialPrice());
        OrderItem ot33 = new OrderItem(o6,p10,10, p10.getInitialPrice());

        OrderItem ot34 = new OrderItem(o7,p1,20, p1.getInitialPrice());
        OrderItem ot35 = new OrderItem(o7,p3,10, p3.getInitialPrice());
        OrderItem ot36 = new OrderItem(o7,p5,10, p5.getInitialPrice());
        OrderItem ot37 = new OrderItem(o7,p15,10, p15.getInitialPrice());
        OrderItem ot38 = new OrderItem(o7,p10,10, p10.getInitialPrice());
        OrderItem ot39 = new OrderItem(o7,p7,20, p7.getInitialPrice());
        OrderItem ot40 = new OrderItem(o7,p6,10, p6.getInitialPrice());
        OrderItem ot41 = new OrderItem(o7,p11,10, p11.getInitialPrice());
        OrderItem ot42 = new OrderItem(o7,p17,10, p17.getInitialPrice());

        OrderItem ot43 = new OrderItem(o8,p4,5, p4.getInitialPrice());
        OrderItem ot44 = new OrderItem(o8,p1,20, p1.getInitialPrice());
        OrderItem ot45 = new OrderItem(o8,p3,10, p3.getInitialPrice());

        OrderItem ot46 = new OrderItem(o9,p5,10, p5.getInitialPrice());
        OrderItem ot47 = new OrderItem(o9,p15,10, p15.getInitialPrice());
        OrderItem ot48 = new OrderItem(o9,p10,10, p10.getInitialPrice());

        OrderItem ot49 = new OrderItem(o10,p7,20, p7.getInitialPrice());
        OrderItem ot50 = new OrderItem(o10,p6,10, p6.getInitialPrice());
        OrderItem ot51 = new OrderItem(o10,p11,10, p11.getInitialPrice());
        OrderItem ot52 = new OrderItem(o10,p17,10, p17.getInitialPrice());

        OrderItem ot53 = new OrderItem(o12,p7,20, p7.getInitialPrice());
        OrderItem ot54 = new OrderItem(o12,p6,10, p6.getInitialPrice());

        OrderItem ot55 = new OrderItem(o13,p10,10, p10.getInitialPrice());
        OrderItem ot56 = new OrderItem(o13,p11,10, p11.getInitialPrice());

        OrderItem ot57 = new OrderItem(o14,p5,10, p5.getInitialPrice());
        OrderItem ot58 = new OrderItem(o14,p15,10, p15.getInitialPrice());

        OrderItem ot59 = new OrderItem(o15,p17,10, p17.getInitialPrice());
        OrderItem ot60 = new OrderItem(o15,p8,10, p8.getInitialPrice());

        OrderItem ot61 = new OrderItem(o16,p2,10, p2.getInitialPrice());
        OrderItem ot62 = new OrderItem(o16,p4,5, p4.getInitialPrice());
        OrderItem ot63 = new OrderItem(o16,p1,20, p1.getInitialPrice());
        OrderItem ot64 = new OrderItem(o16,p3,10, p3.getInitialPrice());

        OrderItem ot65 = new OrderItem(o17,p1,3, p1.getInitialPrice());
        OrderItem ot66 = new OrderItem(o17,p2,3, p2.getInitialPrice());
        OrderItem ot67 = new OrderItem(o17,p3,5, p3.getInitialPrice());
        OrderItem ot68 = new OrderItem(o17,p4,2, p4.getInitialPrice());

        OrderItem ot69 = new OrderItem(o18,p1,1, p1.getInitialPrice());
        OrderItem ot70 = new OrderItem(o18,p2,2, p2.getInitialPrice());
        OrderItem ot71 = new OrderItem(o18,p3,1, p3.getInitialPrice());
        OrderItem ot72 = new OrderItem(o18,p4,2, p4.getInitialPrice());

        OrderItem ot73 = new OrderItem(o19,p1,1, p1.getInitialPrice());
        OrderItem ot74 = new OrderItem(o19,p2,2, p2.getInitialPrice());
        OrderItem ot75 = new OrderItem(o19,p3,5, p3.getInitialPrice());
        OrderItem ot76 = new OrderItem(o19,p4,1, p4.getInitialPrice());

        OrderItem ot77 = new OrderItem(o20,p2,1, p2.getInitialPrice());
        OrderItem ot78 = new OrderItem(o20,p4,1, p3.getInitialPrice());

        OrderItem ot79 = new OrderItem(o21,p15,10, p15.getInitialPrice());
        OrderItem ot80 = new OrderItem(o21,p10,10, p10.getInitialPrice());
        OrderItem ot81 = new OrderItem(o21,p7,20, p7.getInitialPrice());
        OrderItem ot82 = new OrderItem(o21,p6,10, p6.getInitialPrice());

        OrderItem ot83 = new OrderItem(o22,p2,10, p2.getInitialPrice());
        OrderItem ot84 = new OrderItem(o22,p4,5, p4.getInitialPrice());

        OrderItem ot85 = new OrderItem(o23,p11,10, p11.getInitialPrice());
        OrderItem ot86 = new OrderItem(o23,p17,10, p17.getInitialPrice());
        OrderItem ot87 = new OrderItem(o23,p8,10, p8.getInitialPrice());

        OrderItem ot88 = new OrderItem(o24,p1,20, p1.getInitialPrice());
        OrderItem ot89 = new OrderItem(o24,p3,10, p3.getInitialPrice());
        OrderItem ot90 = new OrderItem(o24,p5,10, p5.getInitialPrice());

                orderItems.addAll(Arrays.asList(ot1,ot2,ot3,ot4,ot5,ot6,ot7,ot8,ot9,ot10,ot11,ot12,
                ot13,ot14,ot15,ot16,ot17,ot18,ot19,ot20,ot21,ot22,ot23,ot24,ot25,ot26,
                ot27,ot28,ot29,ot30,ot31,ot32,ot34,ot35,ot36,ot36,ot37,ot39,
                ot40,ot41,ot42,ot43,ot44,ot4,ot46,ot47,ot48,ot49,ot50,ot51,ot52,ot53,ot54,ot55,
                ot56,ot57,ot58,ot59,ot60,ot61,ot62,ot63,ot64,ot65,ot66,ot67,ot68,ot69,ot70,ot71,ot72,
                ot73,ot74,ot75,ot76,ot77,ot78,ot7,ot80,ot81,ot82,ot83,
                ot84,ot85,ot86,ot87,ot88,ot89,ot90));
        orderItemRepository.saveAll(orderItems);
        orderItems.addAll(Arrays.asList(ot1,ot2,ot3,ot4,ot5,ot6,ot7,ot8,ot9,ot10,ot11,ot12,ot13,ot14));
        orderItemRepository.saveAll(orderItems);
        orders.addAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o12,o13,o14,o15,o16,o17,o18,o19,o20,o21,o22,o22,o23,o24));
        orderRepository.saveAll(orders);


        Payment pay1=new Payment(1L,Instant.parse("2021-10-02T08:00:00Z"),o1, PaymentType.PIX);
        Payment pay2=new Payment(2L,Instant.parse("2020-11-12T08:00:00Z"),o2,PaymentType.PIX);
        Payment pay3=new Payment(3L,Instant.parse("2022-01-09T12:00:00Z"),o3,PaymentType.DEBIT_CARD);
        Payment pay4=new Payment(4L,Instant.parse("2021-10-02T08:00:00Z"),o4,PaymentType.PIX);
        Payment pay5=new Payment(5L,Instant.parse("2020-11-12T08:00:00Z"),o5,PaymentType.PIX);
        Payment pay6=new Payment(6L,Instant.parse("2022-01-09T12:00:00Z"),o6,PaymentType.PIX);
        Payment pay7=new Payment(7L,Instant.parse("2021-10-02T08:00:00Z"),o7,PaymentType.PIX);
        Payment pay8=new Payment(8L,Instant.parse("2020-11-12T08:00:00Z"),o8,PaymentType.PIX);
        Payment pay9=new Payment(9L,Instant.parse("2022-01-09T12:00:00Z"),o9,PaymentType.PIX);
        Payment pay10=new Payment(10L,Instant.parse("2021-10-02T08:00:00Z"),o10,PaymentType.PIX);
        Payment pay12=new Payment(12L,Instant.parse("2022-01-09T12:00:00Z"),o12,PaymentType.PIX);
        Payment pay13=new Payment(13L,Instant.parse("2021-10-02T08:00:00Z"),o13,PaymentType.PIX);
        Payment pay14=new Payment(14L,Instant.parse("2020-11-12T08:00:00Z"),o14,PaymentType.PIX);
        Payment pay15=new Payment(15L,Instant.parse("2022-01-09T12:00:00Z"),o15,PaymentType.PIX);
        Payment pay16=new Payment(16L,Instant.parse("2021-10-02T08:00:00Z"),o16,PaymentType.PIX);
        Payment pay17=new Payment(17L,Instant.parse("2020-11-12T08:00:00Z"),o17,PaymentType.PIX);
        Payment pay18=new Payment(17L,Instant.parse("2022-01-09T12:00:00Z"),o18,PaymentType.PIX);
        Payment pay19=new Payment(19L,Instant.parse("2021-10-02T08:00:00Z"),o19,PaymentType.PIX);
        payments.addAll(Arrays.asList(pay1,pay2,pay3,pay4,pay5,pay6,pay7,pay8,pay9,pay10,
                pay12,pay13,pay14,pay15,pay16,pay17,pay18,pay19));
        paymentRepository.saveAll(payments);


        Address add1=new Address(1L, AddressType.SHIPPING_ADDRESS,"Rua San Maria",25,"000346","São Mateus","São paulo","SP","BR","Proximo ao terminal de ônibos",cl1);
        Address add2=new Address(2L, AddressType.SHIPPING_ADDRESS,"Rua Caíno Vilella",20,"000346","W3 Sul","Brasilia","DF","BR","Proximo ao terminal de ônibos",cl2);
        Address add3=new Address(3L, AddressType.SHIPPING_ADDRESS,"Rua Maria da Paz",05,"000346","Asa Norte","Brasilia","DF","BR","Proximo ao terminal de ônibos",cl3);
        Address add4=new Address(4L, AddressType.SHIPPING_ADDRESS,"Rua Das Flores",22,"000346","Pranoá","Brasilia","DF","BR","Proximo ao terminal de ônibos",cl4);
        Address add5=new Address(5L, AddressType.SHIPPING_ADDRESS,"Rua De Cima",275,"000346","Tairú","Vera Cruz","BA","BR","Proximo ao terminal de ônibos",cl5);
        Address add6=new Address(6L, AddressType.SHIPPING_ADDRESS,"Rua Beira Mar",295,"000346","Mar Grande","Vera Cruz","BA","BR","Proximo ao terminal de ônibos",cl6);
        Address add7=new Address(7L, AddressType.SHIPPING_ADDRESS,"Rua Coronel Diotônio Mendes",205,"000346","Ilha Bela","Vera Cruz","BA","BR","Proximo ao terminal de ônibos",cl7);
        Address add8=new Address(8L, AddressType.SHIPPING_ADDRESS,"Rua Beira Rio",2056,"000346","Giribatuba","Vera Cruz","BA","BR","Proximo ao terminal de ônibos",cl8);
        Address add9=new Address(9L, AddressType.SHIPPING_ADDRESS,"Rua da alegria",2105,"000346","Aratuba","Vera Cruz","BA","BR","Proximo ao terminal de ônibos",cl9);
        Address add10=new Address(10L, AddressType.SHIPPING_ADDRESS,"Rua do povo",275,"000346","Barra do Gil","Vera Cruz","BA","BR","Proximo ao terminal de ônibos",cl10);
        Address add11=new Address(11L, AddressType.SHIPPING_ADDRESS,"Avenida Gonsaga Melodia",285,"000346","Canoa quebrada","Itaparica","BA","BR","Proximo ao terminal de ônibos",cl11);
        Address add12=new Address(12L, AddressType.SHIPPING_ADDRESS,"Rua das cigarras",201,"000346","Berlinque","Itaparica","BA","BR","Proximo ao terminal de ônibos",cl12);
        Address add13=new Address(13L, AddressType.SHIPPING_ADDRESS,"Rua Amélia de Sá",2063,"000346","Pituba","Salvador","BA","BR","Proximo ao terminal de ônibos",cl13);
        Address add14=new Address(14L, AddressType.SHIPPING_ADDRESS,"Rua das cores",2059,"000346","Sambambaia","Brasilia","DF","BR","Proximo ao terminal de ônibos",cl14);
        Address add15=new Address(15L, AddressType.BELLING_ADDRESS,"Avenida Martins do Taborin",2055,"000346","Plano piloto","Brasilia","DF","BR","Proximo ao terminal de ônibos",cl1);
        Address add16=new Address(16L, AddressType.HOME_ADDRESS,"Avenida Anita Garibalde",20135,"000346","Coroa","Itaparica","BA","BR","Proximo ao terminal de ônibos",cl2);
        Address add17=new Address(17L, AddressType.BELLING_ADDRESS,"Avenida Dodo e Osma",2045,"000346","Jardim do Sul","Itaparica","BA","BR","Proximo ao terminal de ônibos",cl1);
        addresses.addAll(Arrays.asList(add1,add2,add3,add4,add5,add6,add7,add8,add9,add10,add11,add12,add13,add14,add15,add16,add17));
        addressRepository.saveAll(addresses);

        Phones ph1=new Phones(1L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl1);
        Phones ph2=new Phones(2L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONE_WHATSAPP,cl1);
        Phones ph3=new Phones(3L,"55","61","99588879","Horário comercial", PhoneType.WHATSAPP,cl1);
        Phones ph4=new Phones(4L,"55","61","99588879","Horário comercial", PhoneType.WORK_PHONE,cl1);
        Phones ph5=new Phones(5L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl2);
        Phones ph6=new Phones(6L,"55","61","99588879","Horário comercial", PhoneType.HPME_PHONE,cl2);
        Phones ph7=new Phones(7L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl3);
        Phones ph8=new Phones(8L,"55","61","99588879","Horário comercial", PhoneType.WHATSAPP,cl3);
        Phones ph9=new Phones(9L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl4);
        Phones ph10=new Phones(10L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl5);
        Phones ph11=new Phones(11L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl6);
        Phones ph12=new Phones(12L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl7);
        Phones ph13=new Phones(13L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl8);
        Phones ph14=new Phones(14L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl9);
        Phones ph15=new Phones(15L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl10);
        Phones ph16=new Phones(16L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl11);
        Phones ph17=new Phones(17L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl12);
        Phones ph18=new Phones(18L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl13);
        Phones ph19=new Phones(19L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl14);
        Phones ph20=new Phones(20L,"55","61","99588879","Horário comercial", PhoneType.HPME_PHONE,cl14);
        Phones ph21=new Phones(21L,"55","61","99588879","Horário comercial", PhoneType.WHATSAPP,cl11);
        Phones ph22=new Phones(22L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONE_WHATSAPP,cl12);
        Phones ph23=new Phones(23L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONE_WHATSAPP,cl10);
        Phones ph24=new Phones(24L,"55","61","99588879","Horário comercial", PhoneType.HPME_PHONE,cl9);
        Phones ph25=new Phones(25L,"55","61","99588879","Horário comercial", PhoneType.HPME_PHONE,cl6);
        Phones ph26=new Phones(26L,"55","61","99588879","Horário comercial", PhoneType.WORK_PHONE,cl13);
        Phones ph27=new Phones(27L,"55","61","99588879","Horário comercial", PhoneType.WORK_PHONE,cl7);
        Phones ph28=new Phones(28L,"55","61","99588879","Horário comercial", PhoneType.WORK_PHONE,cl8);
        Phones ph29=new Phones(29L,"55","61","99588879","Horário comercial", PhoneType.HPME_PHONE,cl4);
        Phones ph30=new Phones(30L,"55","61","99588879","Horário comercial", PhoneType.WORK_PHONE,cl4);
        Phones ph31=new Phones(31L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl6);
        Phones ph32=new Phones(32L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl8);
        Phones ph33=new Phones(33L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl11);
        Phones ph34=new Phones(34L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl10);
        Phones ph35=new Phones(35L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl12);
        Phones ph36=new Phones(36L,"55","61","99588879","Horário comercial", PhoneType.MOBILE_PHONEY,cl12);
        phones.addAll(Arrays.asList(ph1,ph2,ph3,ph4,ph5,ph6,ph7,ph8,ph9,ph10,ph11,ph12,ph13,ph14,ph15,ph16,ph17,ph18,ph19,ph20,ph21,ph22,ph23,ph24,
                ph25,ph26,ph27,ph28,ph29,ph30,ph31,ph32,ph33,ph34,ph35,ph36 ));
        phonesRepository.saveAll(phones);

        ShippingPriceTable tbr=new ShippingPriceTable(1L,"Tabela de preço minimo de entrga, dentro do Brasil",0.02,0.04);
        ShippingPriceTable tex=new ShippingPriceTable(2L,"Tabela de preços para fora do Brasil,valor á ser calculado pela administração",null,null);
        shippingPriceTables.addAll(Arrays.asList(tbr,tex));
        shippingPriceTableRepository.saveAll(shippingPriceTables);
        Ship sp1=new Ship(1L,o1,tbr);
        Ship sp2=new Ship(2L,o2,tbr);
        Ship sp3=new Ship(3L,o3,tbr);
        Ship sp4=new Ship(4L,o4,tbr);
        Ship sp5=new Ship(5L,o5,tbr);
        Ship sp6=new Ship(6L,o6,tbr);
        Ship sp7=new Ship(7L,o7,tbr);
        Ship sp8=new Ship(81L,o8,tbr);
        Ship sp9=new Ship(9L,o9,tbr);
        Ship sp10=new Ship(10L,o10,tbr);
        Ship sp12=new Ship(12L,o12,tbr);
        Ship sp13=new Ship(13L,o13,tbr);
        Ship sp14=new Ship(14L,o14,tbr);
        Ship sp15=new Ship(15L,o15,tbr);
        Ship sp16=new Ship(16L,o16,tbr);
        Ship sp17=new Ship(17L,o17,tbr);
        Ship sp18=new Ship(18L,o18,tbr);
        Ship sp19=new Ship(19L,o19,tbr);
        Ship sp20=new Ship(20L,o20,tbr);
        Ship sp21=new Ship(21L,o21,tbr);
        Ship sp22=new Ship(22L,o22,tbr);
        Ship sp23=new Ship(23L,o23,tbr);
        Ship sp24=new Ship(24L,o24,tbr);
        ships.addAll(Arrays.asList(sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8,sp9,sp10,sp12,
                sp13,sp14,sp15,sp16,sp17,sp18,sp19,sp20,sp21,sp22,sp23,sp24));
        shipRepository.saveAll(ships);

        DiscountTable discountTableOrder=new DiscountTable(1L,"Diconto sobre o total da order",null,null,0.005,0.01);
        DiscountTable discountTableProduct=new DiscountTable(2L,"Disconto sobre oferta de produto",null,null,0.01,0.03);
        discountTables.addAll(Arrays.asList(discountTableOrder,discountTableProduct));
        discountTableRepository.saveAll(discountTables);
        DiscountOnOrder dis1=new DiscountOnOrder(1L,o1,discountTableOrder);
        DiscountOnOrder dis2=new DiscountOnOrder(2L,o2,discountTableOrder);
        DiscountOnOrder dis3=new DiscountOnOrder(3L,o3,discountTableOrder);
        DiscountOnOrder dis4=new DiscountOnOrder(4L,o4,discountTableOrder);
        DiscountOnOrder dis5=new DiscountOnOrder(5L,o5,discountTableOrder);
        DiscountOnOrder dis6=new DiscountOnOrder(6L,o6,discountTableOrder);
        DiscountOnOrder dis7=new DiscountOnOrder(7L,o7,discountTableOrder);
        DiscountOnOrder dis8=new DiscountOnOrder(8L,o8,discountTableOrder);
        DiscountOnOrder dis9=new DiscountOnOrder(9L,o9,discountTableOrder);
        DiscountOnOrder dis10=new DiscountOnOrder(10L,o10,discountTableOrder);
        DiscountOnOrder dis12=new DiscountOnOrder(12L,o12,discountTableOrder);
        DiscountOnOrder dis13=new DiscountOnOrder(13L,o13,discountTableOrder);
        DiscountOnOrder dis14=new DiscountOnOrder(14L,o14,discountTableOrder);
        DiscountOnOrder dis15=new DiscountOnOrder(15L,o15,discountTableOrder);
        DiscountOnOrder dis16=new DiscountOnOrder(16L,o16,discountTableOrder);
        DiscountOnOrder dis17=new DiscountOnOrder(17L,o17,discountTableOrder);
        DiscountOnOrder dis18=new DiscountOnOrder(18L,o18,discountTableOrder);
        DiscountOnOrder dis19=new DiscountOnOrder(19L,o19,discountTableOrder);
        DiscountOnOrder dis20=new DiscountOnOrder(20L,o20,discountTableOrder);
        DiscountOnOrder dis21=new DiscountOnOrder(21L,o21,discountTableOrder);
        DiscountOnOrder dis22=new DiscountOnOrder(22L,o22,discountTableOrder);
        DiscountOnOrder dis23=new DiscountOnOrder(23L,o23,discountTableOrder);
        DiscountOnOrder dis24=new DiscountOnOrder(24L,o24,discountTableOrder);
        discountOnOrders.addAll(Arrays.asList(dis1,dis2,dis3,dis4,dis5,dis6,dis7,dis8,dis10,
                dis12,dis13,dis14,dis16,dis17,dis18,dis19,dis20,dis22,dis23,dis24,dis15,dis9));
        discountOnOrderRepository.saveAll(discountOnOrders);








    }
}

