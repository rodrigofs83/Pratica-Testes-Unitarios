package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    public void NaoInserirAlunoComMatriculaComTamanhoMenor11() {
        Aluno aluno = new Aluno(1, "Ro", 40, "12345678901", "123456789");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("1234567"));
    }
    @Test
    public void NaoInserirAlunoComMatriculaComTamanhoMaior11() {
        Aluno aluno = new Aluno(1, "Ro", 40, "12345678901", "123456789");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("123456789123"));
    }

    @Test
    public void NaoDeveAlterarMatriculaSeConterCaracterEspecial(){
        Aluno aluno = new Aluno(1, "Ro", 12, "12345678901", "123456789");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("123456789!@"));
    }
    @Test
    public void NaoDeveAlterarMatriculaSeConterLetrasl(){
        Aluno aluno = new Aluno(1, "Ro", 40, "12345678901", "123456789");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("abc12345678"));
    }


}
