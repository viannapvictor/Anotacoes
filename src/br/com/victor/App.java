package br.com.victor;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {

        TabelaAtividade novaTabela = new TabelaAtividade("Tabela de excel");
        TabelaAtividade novaTabela2 = new TabelaAtividade("Tabela google sheets");
        System.out.println(getTabelaName(novaTabela));
        System.out.println(getTabelaName(novaTabela2));

    }

    public static String getTabelaName(TabelaAtividade tabelaAtividade){
        Field[] fields = tabelaAtividade.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Tabela.class)) {
                Tabela tabela = field.getAnnotation(Tabela.class);
                String nomeMetodo = tabela.value();
                try {
                    Method method = tabelaAtividade.getClass().getMethod(nomeMetodo);
                    String nome = (String) method.invoke(tabelaAtividade);
                    return nome;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
