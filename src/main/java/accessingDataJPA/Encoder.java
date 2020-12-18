package accessingDataJPA;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("$2a$10$S1C6EpoFsEjL1ixbmpxn5u2tbPG5D/HyHLdN0t.X5LEUCN9Ac8Yu6"));

    }
}
