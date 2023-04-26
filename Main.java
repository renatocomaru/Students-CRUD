import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    String email;
    int matricula;
    double a1, a2, a3;

    public Aluno(String nome, String email, int matricula, double a1, double a2, double a3) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public double mediaFinal() {
        return a1 * 0.2 + a2 * 0.3 + a3 * 0.5;
    }

    public boolean isAprovado() {
        return mediaFinal() >= 7;
    }
}

class CadastroAlunos {
    private ArrayList<Aluno> alunos;

    public CadastroAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int matricula) {
        alunos.removeIf(aluno -> aluno.matricula == matricula);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Aluno> getAlunosAprovados() {
        ArrayList<Aluno> aprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.isAprovado()) {
                aprovados.add(aluno);
            }
        }
        return aprovados;
    }

    public ArrayList<Aluno> getAlunosReprovados() {
        ArrayList<Aluno> reprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (!aluno.isAprovado()) {
                reprovados.add(aluno);
            }
        }
        return reprovados;
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            CadastroAlunos cadastro = new CadastroAlunos();

            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Adicionar aluno");
                System.out.println("2. Remover aluno");
                System.out.println("3. Listar alunos");
                System.out.println("4. Listar alunos com notas e média");
                System.out.println("5. Listar alunos aprovados");
                System.out.println("6. Listar alunos reprovados");
                System.out.println("7. Sair");
                System.out.print("Opção: ");
            
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.print("Nome: ");
                    scanner.nextLine(); // Limpa o buffer
                    String nome = scanner.nextLine();
                    System.out.print("Email (opcional, pressione ENTER para pular): ");
                    String email = scanner.nextLine();
                
                    if (email.trim().isEmpty()) {
                        email = null;
                    }
                
                    System.out.print("Matrícula: ");
                    int matricula = scanner.nextInt();
                    System.out.print("Nota A1: ");
                    double a1 = scanner.nextDouble();
                    System.out.print("Nota A2: ");
                    double a2 = scanner.nextDouble();
                    System.out.print("Nota A3: ");
                    double a3 = scanner.nextDouble();
                    cadastro.adicionarAluno(new Aluno(nome, email, matricula, a1, a2, a3));
                    System.out.println("Aluno adicionado com sucesso!");
                } else if (opcao == 2) {
                    System.out.print("Matrícula do aluno a ser removido: ");
                    int matricula = scanner.nextInt();
                    cadastro.removerAluno(matricula);
                    System.out.println("Aluno removido com sucesso!");
                } else if (opcao == 3) {
                    for (Aluno aluno : cadastro.getAlunos()) {
                        System.out.printf("Matrícula: %d, Nome: %s, Email: %s%n", aluno.matricula, aluno.nome, aluno.email);
                    }
                } else if (opcao == 4) {
                    for (Aluno aluno : cadastro.getAlunos()) {
                        double media = aluno.mediaFinal();
                        System.out.printf("Matrícula: %d, Nome: %s, A1: %.2f, A2: %.2f, A3: %.2f, Média: %.2f%n", aluno.matricula, aluno.nome, aluno.a1, aluno.a2, aluno.a3, media);
                    }
                } else if (opcao == 5) {
                    for (Aluno aluno : cadastro.getAlunosAprovados()) {
                        double media = aluno.mediaFinal();
                        System.out.printf("Matrícula: %d, Nome: %s, Média: %.2f%n", aluno.matricula, aluno.nome, media);
                    }
                } else if (opcao == 6) {
                    for (Aluno aluno : cadastro.getAlunosReprovados()) {
                        double media = aluno.mediaFinal();
                        System.out.printf("Matrícula: %d, Nome: %s, Média: %.2f%n", aluno.matricula, aluno.nome, media);
                    }
                } else if (opcao == 7) {
                    break;
                } else {
                System.out.println("Opção inválida!");
                }
            }
        }
    }
}