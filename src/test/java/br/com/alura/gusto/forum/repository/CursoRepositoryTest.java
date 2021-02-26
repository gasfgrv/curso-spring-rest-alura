package br.com.alura.gusto.forum.repository;

import br.com.alura.gusto.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
/*
* Por padrão, o Spring considera que será usado um banco de dados em memória (e.g. H2) para executar os testes, logo
* bancos remotos (ex. mysql, mssql, oracle) irião falhar.
* Para isso existe a anotação @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) que serve
* para que não seja alterada a configuração do seu banco de dados (caso seja um remoto).
*/
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

    @Autowired
    CursoRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void voiddeveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "HTML 5";

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programação");
        entityManager.persist(html5);

        Curso curso = repository.findByNome(nomeCurso);
        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    void naoDeveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);

        assertNull(curso);
    }
}