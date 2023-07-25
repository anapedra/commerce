package com.anapedra.commerce;

import com.anapedra.commerce.entities.*;
import com.anapedra.commerce.entities.enums.OrderStatus;
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
    public CommerceApplication(UserRepository userRepository,
                               RoleRepository roleRepository,
                               ProductRepository productRepository,
                               CategoryRepository categoryRepository,
                               PaymentRepository paymentRepository,
                               OrderRepository orderRepository,
                               OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
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


        Role role1=new Role(1L,"ROLE_ADMIN");
        Role role2=new Role(2L,"ROLE_CLIENT");
        roles.addAll(Arrays.asList(role1,role2));
        roleRepository.saveAll(roles);
        User cl1=new User(1L,"Luiza Bradão",Instant.parse("2015-02-23T08:00:00Z"),null,"8177906788","786840083","luiza@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl2=new User(2L,"Mara Vascon",Instant.parse("2019-02-23T08:00:00Z"),null,"8177906788","14052973011","maraa@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl3=new User(3L,"Lucas Marcone Silva",Instant.parse("2015-05-22T08:00:00Z"),null,"8177906788","11518336060","maraa@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl4=new User(4L,"Ana Bragalha",Instant.parse("2019-09-22T08:00:00Z"),null,"1236644475","76680878004","bragalha@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl5=new User(5L,"Mari Ferreira",Instant.parse("2011-02-12T08:00:00Z"),null,"3598866458","36609066035","mapris@gmaill.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl6=new User(6L,"Sandra Magal Simão",Instant.parse("2017-01-20T08:00:00Z"),null,"6293344685","54931213014","saira@gmaill.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl7=new User(7L,"Helena Saldanha Filipa",Instant.parse("2018-02-21T08:00:00Z"),null,"6199658574","99442161008","helena@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl8=new User(8L,"Mariana Prado",Instant.parse("2011-10-18T08:00:00Z"),null,"8799943555","43659217034","mariana@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl9=new User(9L,"Socorro Ribeiro",Instant.parse("2019-01-23T08:00:00Z"),null,"6186938921","58266489025","socorro@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl10=new User(10L,"Ana Prado Santana",Instant.parse("2017-06-02T08:00:00Z"),null,"1223655478","82594025054","anaprado@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl11=new User(11L,"Sandra Marcodes",Instant.parse("2013-02-28T08:00:00Z"),null,"7888965421","16546720094","saidra@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl12=new User(12L,"Ana Matias",Instant.parse("2018-09-20T08:00:00Z"),null,"1293655478","26868448090","anamartins@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl13=new User(13L,"Mari Samaria",Instant.parse("2000-09-20T08:00:00Z"),null,"4598698712","20667557024","mari@gmail.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        User cl14=new User(14L,"Sandra Osca Sintra", Instant.parse("2017-10-21T08:00:00Z"),null,"7878965421","90216069092","sanfraosca@gmaol.com","$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        clients.addAll(Arrays.asList(cl1, cl2, cl3, cl4,cl5,cl6,cl7,cl8,cl9,cl10,cl11,cl12,cl13,cl14));
        userRepository.saveAll(clients);
        cl1.getRoles().add(role1);
        cl2.getRoles().add(role1);
        cl1.getRoles().add(role2);
        cl2.getRoles().add(role2);
        cl3.getRoles().add(role2);
        cl4.getRoles().add(role2);
        clients.addAll(Arrays.asList(cl1,cl2,cl3,cl4));
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
        products.addAll(Arrays.asList(p1,p2,p3,p4));
        productRepository.saveAll(products);

        Order o1=new Order(1L,Instant.parse("2021-10-01T08:00:00Z"),LocalDate.parse("2021-10-01"),OrderStatus.PAID,null,cl1);
        Order o2=new Order(2L,Instant.parse("2020-11-09T08:00:00Z"),LocalDate.parse("2020-11-09"),OrderStatus.SHIPPED,null,cl2);
        Order o3=new Order(3L,Instant.parse("2022-01-09T08:00:00Z"),LocalDate.parse("2022-01-09"),OrderStatus.PAID,null,cl5);
        Order o4=new Order(4L,Instant.parse("2023-05-25T08:00:00Z"),LocalDate.parse("2023-05-25"),OrderStatus.PAID,null,cl6);
        Order o5=new Order(5L,Instant.parse("2020-11-01T08:00:00Z"),LocalDate.parse("2020-11-01"),OrderStatus.PAID,null,cl10);
        Order o6=new Order(6L,Instant.parse("2020-11-16T08:00:00Z"),LocalDate.parse("2020-11-16"),OrderStatus.PAID,null,cl8);
        Order o7=new Order(7L,Instant.parse("2022-11-01T08:00:00Z"),LocalDate.parse("2022-11-01"), OrderStatus.PAID,null,cl11);
        Order o8=new Order(8L,Instant.parse("2022-11-18T08:00:00Z"),LocalDate.parse("2022-11-18"),OrderStatus.PAID,null,cl1);
        Order o9=new Order(9L,Instant.parse("2022-11-01T08:00:00Z"),LocalDate.parse("2022-11-01"),OrderStatus.PAID,null,cl3);
        Order o10 =new Order(10L,Instant.parse("2021-11-01T08:00:00Z"),LocalDate.parse("2021-11-01"),OrderStatus.PAID,null,cl10);
        Order o12=new Order(12L,Instant.parse("2022-11-01T08:00:00Z"),LocalDate.parse("2022-11-01"),OrderStatus.PAID,null,cl2);
        Order o13=new Order(13L,Instant.parse("2021-10-21T08:00:00Z"),LocalDate.parse("2021-10-21"),OrderStatus.PAID,null,cl9);
        Order o14=new Order(14L,Instant.parse("2023-03-05T08:00:00Z"),LocalDate.parse("2023-03-05"),OrderStatus.PAID,null,cl9);
        Order o15=new Order(15L,Instant.parse("2023-04-10T08:00:00Z"),LocalDate.parse("2023-04-10"),OrderStatus.PAID,null,cl1);
        Order o16=new Order(16L,Instant.parse("2021-12-22T08:00:00Z"),LocalDate.parse("2021-12-22"),OrderStatus.PAID,null,cl11);
        Order o17=new Order(17L,Instant.parse("2022-01-07T08:00:00Z"),LocalDate.parse("2022-01-07"),OrderStatus.PAID,null,cl9);
        Order o18=new Order(18L,Instant.parse("2019-11-09T08:00:00Z"),LocalDate.parse("2019-11-09"),OrderStatus.PAID,null,cl1);
        Order o19=new Order(19L,Instant.parse("2018-12-01T08:00:00Z"),LocalDate.parse("2018-12-01"),OrderStatus.WAITING_PAYMENT,null,cl4);
        Order o20=new Order(20L,Instant.parse("2023-05-01T08:00:00Z"),LocalDate.parse("2023-05-01"),OrderStatus.WAITING_PAYMENT,null,cl6);
        Order o21=new Order(21L,Instant.parse("2023-01-01T08:00:00Z"),LocalDate.parse("2023-01-01"),OrderStatus.WAITING_PAYMENT,null,cl1);
        Order o22=new Order(22L,Instant.parse("2015-11-01T08:00:00Z"),LocalDate.parse("2012-11-01"),OrderStatus.WAITING_PAYMENT,null,cl1);
        Order o23=new Order(23L,Instant.parse("2012-11-01T08:00:00Z"),LocalDate.parse("2000-11-01"),OrderStatus.WAITING_PAYMENT,null,cl1);
        Order o24=new Order(24L,Instant.parse("2011-11-01T08:00:00Z"),LocalDate.parse("2011-11-01"),OrderStatus.WAITING_PAYMENT,null,cl7);
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


        Payment pay1=new Payment(1L,Instant.parse("2021-10-02T08:00:00Z"),o1);
        Payment pay2=new Payment(2L,Instant.parse("2020-11-12T08:00:00Z"),o2);
        Payment pay3=new Payment(3L,Instant.parse("2022-01-09T12:00:00Z"),o3);
        Payment pay4=new Payment(4L,Instant.parse("2021-10-02T08:00:00Z"),o4);
        Payment pay5=new Payment(5L,Instant.parse("2020-11-12T08:00:00Z"),o5);
        Payment pay6=new Payment(6L,Instant.parse("2022-01-09T12:00:00Z"),o6);
        Payment pay7=new Payment(7L,Instant.parse("2021-10-02T08:00:00Z"),o7);
        Payment pay8=new Payment(8L,Instant.parse("2020-11-12T08:00:00Z"),o8);
        Payment pay9=new Payment(9L,Instant.parse("2022-01-09T12:00:00Z"),o9);
        Payment pay10=new Payment(10L,Instant.parse("2021-10-02T08:00:00Z"),o10);
        Payment pay11=new Payment(11L,Instant.parse("2020-11-12T08:00:00Z"),o12);
        Payment pay12=new Payment(12L,Instant.parse("2022-01-09T12:00:00Z"),o13);
        Payment pay13=new Payment(13L,Instant.parse("2021-10-02T08:00:00Z"),o14);
        Payment pay14=new Payment(14L,Instant.parse("2020-11-12T08:00:00Z"),o15);
        Payment pay15=new Payment(15L,Instant.parse("2022-01-09T12:00:00Z"),o16);
        Payment pay16=new Payment(16L,Instant.parse("2021-10-02T08:00:00Z"),o17);
        Payment pay17=new Payment(17L,Instant.parse("2020-11-12T08:00:00Z"),o18);
        Payment pay18=new Payment(17L,Instant.parse("2022-01-09T12:00:00Z"),o19);
        Payment pay19=new Payment(19L,Instant.parse("2021-10-02T08:00:00Z"),o20);
        payments.addAll(Arrays.asList(pay1,pay2,pay3,pay4,pay5,pay6,pay7,pay8,pay8,pay10,pay11,
                pay12,pay13,pay14,pay15,pay16,pay17,pay18,pay19));
        paymentRepository.saveAll(payments);





    }
}

