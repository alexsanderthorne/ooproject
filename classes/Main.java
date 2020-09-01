import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String nomeCliente, cpf, email, telefone, rua, bairro, cidade, uf, cep, complemento;
        double soma = 0, saldo = 0;
        int numeroCasa = 0;
        int quant = 1;

        ArrayList<Caixa> caixa = new ArrayList<Caixa>();
        ArrayList<Estoque> estoque = new ArrayList<Estoque>();
        ArrayList<Produtos> p = new ArrayList<Produtos>();
        ArrayList<Clientes> c = new ArrayList<Clientes>();
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        Clientes newCliente = new Clientes();

        Gerente gerente = new Gerente();

        boolean yes = true;
        boolean continua = true;

        while (yes) {

            System.out.println("\nStudio EncanARTE" + "\n1. Realizar Vendas " + "\n2. Cadastrar Clientes "

                    + "\n3. Acessar Estoque " + "\n4. Cancelar Venda" + "\n5. Listar Clientes"
                    + "\n6. Buscar cliente(pelo cpf)" + "\n7. Aquisição de Produtos" + "\n8. Excluir Clientes"
                    + "\n9. Ver Saldo Caixa" + "\n0. Sair");

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

                            Clientes client = new Clientes();

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
                            Endereco adress = new Endereco();

                            System.out.println("Digite o nome da rua : ");
                            rua = scan.next();
                            // e.setRua(rua);
                            System.out.println("Digite o nome do bairro : ");
                            bairro = scan.next();
                            System.out.println("Digite o número da residencia : ");
                            numeroCasa = scan.nextInt();

                            System.out.println("Digite a cidade : ");
                            cidade = scan.next();
                            System.out.println("Digite o estado : ");
                            uf = scan.next();
                            System.out.println("Digite o cep : ");
                            cep = scan.next();
                            System.out.println("Digite o complemento : ");
                            complemento = scan.next();

                            newCliente.cadastrarCliente(client, adress, nomeCliente, cpf, email, telefone, rua, bairro,
                                    numeroCasa, cidade, uf, cep, complemento);

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

                    System.out.println("Lista de clientes");
                    System.out.println("*****************");
                    newCliente.listarClientes();

                    break;

                case 6:

                    System.out.println("Digite o numero do cpf o qual deseja consultar : ");
                    cpf = scan.next();
                    newCliente.buscarCliente(cpf);
                    scan.nextLine();
                    System.out.println("... ...");
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
                    cpf = scan.next();
                    newCliente.removerClientes(cpf);
                    scan.nextLine();

                    break;

                case 9:

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

        scan.close();

    }
}