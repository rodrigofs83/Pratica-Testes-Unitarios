package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void NaoInserirAlunoComMatriculaJaExistente(){
        Aluno aluno1 = new Aluno(1, "Ro", 40, "12345678901", "123456789");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("12345678901");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));

    }


    @Test
    public void NaoDeveInserirAlunoComCPFJaExistente(){
        Aluno aluno1 = new Aluno(1, "Ro", 40, "12345678901", "12356789");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("123456789");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

    @Test void NaoDeveInserirAlunoComIdadeMenorQ18Anos(){
        Aluno aluno1 = new Aluno(1, "Ro", 12, "12345678901", "123456789");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

}
