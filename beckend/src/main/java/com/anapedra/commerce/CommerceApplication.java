package com.anapedra.commerce;

import com.anapedra.commerce.entities.Role;
import com.anapedra.commerce.entities.User;
import com.anapedra.commerce.repositories.RoleRepository;
import com.anapedra.commerce.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CommerceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CommerceApplication(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> clients=new ArrayList<>();
        List<Role>roles=new ArrayList<>();


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

    }
}


