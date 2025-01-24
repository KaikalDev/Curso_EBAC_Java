package Kaique.luan.dev;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    @Test
    public void testListFem() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Ana", "feminino"));
        pessoas.add(new Pessoa("João", "masculino"));
        pessoas.add(new Pessoa("Maria", "feminino"));
        pessoas.add(new Pessoa("Carlos", "masculino"));

        List<Pessoa> result = Main.FiltraFem(pessoas);

        result.forEach(p -> Assert.assertEquals("feminino", p.getSexo()));
    }
}
