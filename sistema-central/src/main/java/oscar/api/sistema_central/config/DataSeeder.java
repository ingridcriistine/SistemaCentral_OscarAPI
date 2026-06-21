package oscar.api.sistema_central.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oscar.api.sistema_central.model.Usuario;
import oscar.api.sistema_central.model.Voto;
import oscar.api.sistema_central.repository.UsuarioRepository;
import oscar.api.sistema_central.repository.VotoRepository;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(UsuarioRepository usuarioRepository, VotoRepository votoRepository) {
        return args -> {
            if (usuarioRepository.count() > 0) return;

            usuarioRepository.save(new Usuario("ana", "1234"));
            usuarioRepository.save(new Usuario("bruno", "1234"));
            usuarioRepository.save(new Usuario("carla", "1234"));
            usuarioRepository.save(new Usuario("diego", "1234"));

            Usuario comVoto = new Usuario("eduardo", "1234");
            comVoto.setToken(42);
            comVoto.setJaVotou(true);
            comVoto = usuarioRepository.save(comVoto);

            votoRepository.save(new Voto(comVoto.getId(), "1", "1"));

            System.out.println(">>> Usuarios de teste criados: ana, bruno, carla, diego, eduardo (senha: 1234)");
        };
    }
}