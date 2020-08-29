import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nomeCliente, cpf, email, telefone;
        ArrayList<Caixa> caixa = new ArrayList<Caixa>();
        ArrayList<Estoque> estoque = new ArrayList<Estoque>();
        ArrayList<Produtos> p = new ArrayList<Produtos>();
        ArrayList<Clientes> c = new ArrayList<Clientes>();
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        double saldo = 0;
        Gerente gerente = new Gerente();
        double soma = 0;
        int quant = 1;

        boolean yes = true;
        while (yes) {
            System.out.println("\nAteliê EncanARTE" + "\n1. Realizar Vendas " + "\n2. Cadastrar Clientes "

                    + "\n3. Acessar Estoque " + "\n4. Cancelar Venda" + "\n5. Listar Clientes"
                    + "\n6. Aquisição de Produtos" + "\n7. Excluir Clientes" + "\n8. Ver Saldo Caixa" + "\n0. Sair");

            int op = scan.nextInt();
            switch (op) {
                case 1:

                    System.out.println("Digite o código do produto: ");
                    int codigo1 = scan.nextInt();
                    for (Produtos p1 : p) {
                        if (p1.getCodigo() == codigo1) {
                            soma += 1;
                            saldo += p1.getPreco();

                            caixa.add(new Caixa(soma, saldo));
                            System.out.println("Compra realizado com sucesso !");
                        } else if (codigo1 == 0) {
                            System.out.println("Operação inválida");
                        }
                    }

                    break;
                case 2:
                    System.out.println("Cadastrar clientes");
                    System.out.println("Cadastrar clientes");
                    System.out.println("Dados pessoais");
                    System.out.println("*** *** ***");
                    System.out.println("Digite o nome do cliente : ");
                    nomeCliente = scan.next();
                    System.out.println("Digite o cpf do cliente : ");
                    cpf = scan.next();
                    System.out.println("Digite o email do cliente : ");
                    email = scan.next();
                    System.out.println("Digite o telefone do cliente : ");
                    telefone = scan.next();
                    System.out.println("*** *** ***");
                    System.out.println("Endereço");
                    // Endereco e = new Endereco();

                    System.out.println("Digite o nome da rua : ");
                    String rua = scan.next();
                    // e.setRua(rua);
                    System.out.println("Digite o nome do bairro : ");
                    String bairro = scan.next();
                    // e.setBairro(bairro);
                    System.out.println("Digite o número da residencia : ");
                    int numeroCasa = scan.nextInt();
                    System.out.println("Digite a cidade : ");
                    String cidade = scan.next();
                    // e.setCidade(cidade);
                    System.out.println("Digite o estado : ");
                    String uf = scan.next();
                    // e.UF(uf);
                    System.out.println("Digite o cep : ");
                    String cep = scan.next();
                    // e.cep(cep);
                    System.out.println("Digite o complemento : ");
                    String complemento = scan.next();
                    // e.complemento(complemento);
                    c.add(new Clientes(nomeCliente, cpf, email, telefone, endereco));
                    endereco.add(new Endereco(rua, bairro, numeroCasa, cidade, uf, cep, complemento));

                    System.out.println("Cliente cadastrado com sucesso!");

                    break;
                case 3:
                    // Acesso ao estoque
                    System.out.println("Digite o usuário: ");
                    String login = scan.next();
                    System.out.println("Digite a senha: ");
                    String senha = scan.next();

                    if (gerente.getLOGIN().equals(login) & gerente.getSENHA().equals(senha)) {
                        System.out
                                .println("Acessar estoque: 1-Ver todos os produtos 2-pesquisar por código do produto");

                        int o = scan.nextInt();
                        if (o == 1) {
                            System.out.println(estoque.toString());

                        } else if (o == 2) {
                            System.out.println("Digite o Código");
                            int testar = scan.nextInt();
                            for (Produtos pro : p) {
                                if (pro.getCodigo() == testar) {
                                    System.out.println("Está na lista");
                                    System.out.println(pro.toString());
                                } else if (pro.getQuantidade() == 0) {
                                    System.out.println("Operação inválida");
                                }

                            }
                        }

                    } else {
                        System.out.println("Login ou senha inválidos");
                    }

                    break;
                case 4:
                    System.out.println("Cancelar vendas: ");
                    int cod4 = scan.nextInt();
                    for (Produtos produtos4 : p) {
                        if (produtos4.getCodigo() == cod4) {
                            // ArrayList<Caixa> caixa4 = new ArrayList<>();
                            // caixa4.add(caixa.get(caixa.size() - 2));
                            double preco = 0;
                            preco -= produtos4.getPreco();
                            double vendas4 = 1;
                            vendas4 -= 1;
                            caixa.add(new Caixa(vendas4, preco));
                            System.out.println("Saldo atual: " + caixa.get(caixa.size() - 1));

                        } else if (produtos4.getCodigo() != cod4) {
                            System.out.println("Código inválido!");

                        }

                    }

                    break;
                case 5:

                    System.out.println("Digite 1-Para listar todos os clientes. 2-Para buscar um cliente ");
                    op = scan.nextInt();

                    if (op == 1) {

                        System.out.println("Listar Clientes");
                        System.out.println(c.toString());

                    } else if (op == 2) {

                        System.out.println("Digite o cpf do cliente o qual deseja consultar : ");
                        cpf = scan.next();

                        for (Clientes clientes : c) {

                            if (clientes.getCpf().equals(cpf)) {

                                System.out.println(clientes.toString());

                            }
                        }
                    }

                    break;
                case 6:
                    System.out.println(" Aquisição de produtos" + "\nDigite o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Nome do produto:");
                    String nome = scan.next();
                    System.out.println("Preço do produto:");
                    double preco = scan.nextDouble();
                    System.out.println("Quantidade de produtos:");
                    int quantidade = scan.nextInt();
                    p.add(new Produtos(cod, nome, preco, quantidade));
                    estoque.add(new Estoque(p));
                    System.out.println("Compra efetuada com sucesso!");
                    break;
                case 7:

                    System.out.println("Digite o cpf do cliente : ");
                    cpf = scan.next();

                    for (int i = 0; i < c.size(); i++) {

                        if (c.get(i).getCpf().equals(cpf)) {

                            c.remove(c.get(i));
                            System.out.println("teste");

                        } else {
                            System.out.println("Cliente não encontrado!");
                        }

                    }

                    System.out.println("Cliente apagado do banco de dados!");
                case 8:

                    if (caixa.isEmpty()) {
                        System.out.println("Seu saldo está zerado, precisa realizar vendas");
                        break;

                    } else {
                        System.out.println("Total de vendas e saldo: " + caixa.get(caixa.size() - 1));

                    }

                    break;
                case 0:
                    System.out.println("Saiu!");
                    yes = false;
                default:
                    break;
            }

        }

    }
}