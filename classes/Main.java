import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        double soma = 0, saldo = 0;

        ArrayList<Caixa> caixa = new ArrayList<Caixa>();
        ArrayList<Estoque> estoque = new ArrayList<Estoque>();
        ArrayList<Produtos> p = new ArrayList<Produtos>();
        ArrayList<Pessoas> pessoas = new ArrayList<Pessoas>();

        boolean yes = true;
        boolean continua = true;

        while (yes) {

            System.out.println("\nStudio EncanARTE" + "\n1. Realizar Vendas " + "\n2. Cadastrar Clientes "

                    + "\n3. Acessar Estoque " + "\n4. Cancelar Venda" + "\n5. Listar Clientes"
                    + "\n6. Buscar cliente(pelo cpf)" + "\n7. Aquisição de Produtos" + "\n8. Excluir Clientes"
                    + "\n9. Ver Saldo Caixa" + "\n10 Editar clientes" + "\n11 Cadastrar Funcionario"
                    + "\n12 Remover funcionario" + "\n0. Sair");

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

                    do {

                        try {

                            System.out.println("Cadastrar clientes");
                            System.out.println("Dados pessoais");
                            System.out.println("*** *** ***");
                            System.out.println("Digite o nome do cliente : ");
                            String nomeCliente = scan.next();
                            System.out.println("Digite o cpf do cliente : ");
                            String cpf = scan.next();
                            System.out.println("Digite o email do cliente : ");
                            String email = scan.next();
                            System.out.println("Digite o telefone do cliente : ");
                            String telefone = scan.next();
                            System.out.println("*** *** ***");

                            System.out.println("Endereço");

                            System.out.println("Digite o nome da rua : ");
                            String rua = scan.next();
                            System.out.println("Digite o nome do bairro : ");
                            String bairro = scan.next();
                            System.out.println("Digite o número da residencia : ");
                            int numeroCasa = scan.nextInt();

                            System.out.println("Digite a cidade : ");
                            String cidade = scan.next();
                            System.out.println("Digite o estado : ");
                            String uf = scan.next();
                            System.out.println("Digite o cep : ");
                            String cep = scan.next();
                            System.out.println("Digite o complemento : ");
                            String complemento = scan.next();

                            Endereco adress = new Endereco(rua, bairro, numeroCasa, cidade, uf, cep, complemento);
                            pessoas.add(new Clientes(nomeCliente, cpf, email, telefone, adress));

                            System.out.println("Cliente cadastrado com sucesso!");

                            continua = false;

                        } catch (InputMismatchException inputMismatchException) {

                            System.err.println("\nException : %s\n" + inputMismatchException);
                            scan.nextLine();
                            System.out.println("Digite apenas números inteiros para o n° da casa");

                        }

                    } while (continua);

                    break;

                case 3:

                    System.out.println("Digite o usuário: ");
                    String login = scan.next();
                    System.out.println("Digite a senha: ");
                    String senha = scan.next();

                    Gerente gerente = new Gerente();

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

                                } else {

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

                    System.out.println("Lista de clientes");
                    System.out.println("*****************");

                    try {

                        for (Pessoas person : pessoas) {

                            if (person != null && (person instanceof Clientes)) {

                                System.out.println("Nome : " + person.getNome());
                                System.out.println("Telefone : " + person.getTelefone());

                            }
                        }

                    } catch (NullPointerException nullPointerException) {

                        System.err.println("\nException : %s\n" + nullPointerException);
                        scan.nextLine();
                        System.out.println("Nenhum cliente cadastrado até o momento!");

                    }

                    break;

                case 6:

                    if (pessoas.size() > 0) {

                        System.out.println("Digite o numero do Cpf :");
                        String Cpf = scan.next();

                        for (Pessoas person : pessoas) {

                            if (person != null && (person instanceof Clientes)) {

                                if (person.getCpf().equals(Cpf)) {

                                    System.out.println("Nome: " + person.getNome());
                                    System.out.println("Email: " + person.getEmail());

                                } else {

                                    System.out.println("Cpf não encontrado!");
                                }

                            } else {

                                System.out.println("Nenhuma pessoa cadastrada até o momento!");
                            }

                        }

                    }

                    break;

                case 7:

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

                case 8:

                    System.out.println("Digite o cpf do cliente : ");
                    String cpf = scan.next();

                    for (int i = 0; i < pessoas.size(); i++) {

                        if (pessoas.get(i) != null && (pessoas.get(i) instanceof Clientes)) {

                            if (pessoas.get(i).getCpf().equals(cpf)) {

                                // scan.nextLine();
                                pessoas.remove(pessoas.get(i));
                                System.out.println("Cliente apagado do banco de dados!");

                            } else {

                                System.out.println("Cpf não encontrado!");
                            }

                        } else {

                            System.out.println("Nenhum cliente cadastrado até o momento!");
                        }
                    }

                    break;

                case 9:

                    if (caixa.isEmpty()) {

                        System.out.println("Seu saldo está zerado, precisa realizar vendas");

                        break;

                    } else {

                        System.out.println("Total de vendas e saldo: " + caixa.get(caixa.size() - 1));

                    }

                case 10:

                    if (pessoas.size() > 0) {

                        System.out.println("Digite o numero do CPF (somente números):");
                        String Cpf = scan.next();

                        for (int i = 0; i < pessoas.size(); i++) {

                            if (pessoas.get(i) != null && (pessoas.get(i) instanceof Clientes)) {

                                if (pessoas.get(i).getCpf().equals(Cpf)) {

                                    System.out.println("Digite o novo telefone : ");
                                    String telefone = scan.next();
                                    System.out.println("Digite o novo email : ");
                                    String email = scan.next();
                                    pessoas.get(i).setTelefone(telefone);
                                    pessoas.get(i).setEmail(email);

                                    System.out.println("Novo Telefone : " + pessoas.get(i).getTelefone());
                                    ;
                                    System.out.println("Novo email : " + pessoas.get(i).getEmail());

                                } else {

                                    System.out.println("Cpf não encontrado!");

                                }

                            } else {

                                System.out.println("Não há clientes cadastrados!");
                            }
                        }
                    }

                    break;

                case 11:

                    System.out.println("Digite o usuário: ");
                    login = scan.next();
                    System.out.println("Digite a senha: ");
                    senha = scan.next();

                    gerente = new Gerente();

                    if (gerente.getLOGIN().equals(login) & gerente.getSENHA().equals(senha)) {

                        System.out.println("Cadastrar funcionarios");
                        System.out.println("Dados pessoais");
                        System.out.println("*** *** ***");
                        System.out.println("Digite o nome do Funcionario : ");
                        String nomeFunc = scan.next();
                        System.out.println("Digite o cpf : ");
                        String cpfFuncionario = scan.next();
                        System.out.println("Digite o email : ");
                        String email = scan.next();
                        System.out.println("Digite o telefone : ");
                        String telefone = scan.next();
                        System.out.println("Digite o id do funcionario : ");
                        String id = scan.next();

                        pessoas.add(new Funcionario(nomeFunc, cpfFuncionario, email, telefone, id));
                        System.out.println("Funcionário cadastrado com sucesso");

                    } else {

                        System.out.println("Login ou senha inválidos");

                    }

                    break;

                case 12:

                    System.out.println("Digite o usuário: ");
                    login = scan.next();
                    System.out.println("Digite a senha: ");
                    senha = scan.next();

                    gerente = new Gerente();

                    if (gerente.getLOGIN().equals(login) & gerente.getSENHA().equals(senha)) {

                        System.out.println("Digite o id do funcionário : ");
                        String idFunc = scan.next();

                        for (int i = 0; i < pessoas.size(); i++) {

                            if (pessoas.get(i) != null && (pessoas.get(i) instanceof Funcionario)) {

                                if (pessoas.get(i).getCpf().equals(idFunc)) {

                                    // scan.nextLine();
                                    pessoas.remove(pessoas.get(i));
                                    System.out.println("Funcionario apagado do banco de dados!");

                                } else {

                                    System.out.println("Cpf não encontrado!");
                                }

                            } else {

                                System.out.println("Nenhum Empregado cadastrado até o momento!");
                            }
                        }

                    } else {

                        System.out.println("Login ou senha inválidos");

                    }

                    break;

                case 0:

                    System.out.println("Saiu!");
                    yes = false;

                default:

                    break;

            }
        }

        scan.close();

    }

}
