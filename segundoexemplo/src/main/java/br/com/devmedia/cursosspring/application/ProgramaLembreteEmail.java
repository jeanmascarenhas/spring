package br.com.devmedia.cursosspring.application;

import br.com.devmedia.cursosspring.domain.Usuario;
import br.com.devmedia.cursosspring.service.UsuarioServico;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("br.com.devmedia.cursosspring")
public class ProgramaLembreteEmail {

    public static void main(String[] args) {
        Scanner lerDados = new Scanner(System.in);

        System.out.println("Deseja recuperar a senha (S/N)?");
        String resposta = lerDados.nextLine();
        if (resposta.equalsIgnoreCase("S")) {

            System.out.println("Digite seu nome");
            String nome = lerDados.nextLine();

            System.out.println("Digite seu email");
            String email = lerDados.nextLine();

            System.out.println("Digite seu login");
            String login = lerDados.nextLine();

            Usuario usuario = new Usuario(nome, email, login);

            ApplicationContext context = new AnnotationConfigApplicationContext(ProgramaLembreteEmail.class);
            UsuarioServico usuarioServico = context.getBean(UsuarioServico.class);

            usuarioServico.setUsuario(usuario);
            usuarioServico.lembrarSenhaPorEmail();
        } else {
            System.out.println("Até a proxima");
        }
    }

}
