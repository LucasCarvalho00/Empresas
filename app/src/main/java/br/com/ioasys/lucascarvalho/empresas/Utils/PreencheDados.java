package br.com.ioasys.lucascarvalho.empresas.Utils;

import java.util.ArrayList;

import br.com.ioasys.lucascarvalho.empresas.Models.Enterprise;
import br.com.ioasys.lucascarvalho.empresas.Models.EnterpriseType;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

/**
 * Criei e mapei o serviço dentro das classes Models serializando os objetos, porém quando se trata da conexao ao servidor utilizando o Oauth2.0
 * ao tentar conectar Recebo o código 401 "Usuário não autorizado" acredito ser algum erro ao gerar e passar o Token para o WebService,
 * sendo assim para não ficar sem construir o restante das funcionalidades,criei esta classe que mapeia o Objeto Enterprise manualmente,
 * para que possa ajudar a entender o codigo e entender o porque desta classe.
 */

public class PreencheDados {


    public static ArrayList<Enterprise> arrayEmpresa;

    public static void setDadosObjetos(){

        arrayEmpresa = new ArrayList();

        Enterprise enterp = new Enterprise();
        enterp.setId(1);
        enterp.setEnterpriseName("Empresa 1");
        enterp.setCountry("Brasil");
        enterp.setDescription("Descrição da empresa 1 a ser exibida Descrição da empresa 1 a ser exibida para demonstração. ");
        enterp.setEnterpriseType(new EnterpriseType("Varejista"));
        arrayEmpresa.add(enterp);

        Enterprise enterp2 = new Enterprise();
        enterp2.setId(2);
        enterp2.setEnterpriseName("E-Comerce 2");
        enterp2.setCountry("Brasil");
        enterp2.setDescription("Descrição da empresa 2 a ser exibida para demonstração. Descrição da empresa 2 a ser exibida para demonstração. ");
        enterp2.setEnterpriseType(new EnterpriseType("Comercio"));
        arrayEmpresa.add(enterp2);
    }
}
