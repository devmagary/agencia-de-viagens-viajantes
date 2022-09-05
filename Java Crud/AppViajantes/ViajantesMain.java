package AppViajantes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Crud_Viajantes.Viajante;
import ViajantesMolde.ViajantesMolde;

public class ViajantesMain {
	static int id_viajante = 1;
	static int menu = 0;
	static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner entrarRegistro = new Scanner(System.in);
	static Scanner entrarUpdate = new Scanner(System.in);
	static Scanner entrarMenu = new Scanner(System.in);
	static Scanner entrarDelete = new Scanner(System.in);
	static void registro() throws Exception {
		ViajantesMolde viajanteMolde = new ViajantesMolde();
		Viajante viajante1 = new Viajante();		
		System.out.println("Informe o seu Nome: ");
		String nome = entrarRegistro.nextLine();
		viajante1.setNome(nome);
		System.out.println("Informe Local de Destino - (1) Rio de Janeiro | R$ 500 - (2) São Paulo | R$ 532 - (3) Salvador | R$ 1232 - (4) Recife | R$ 5343 : ");
		int id_local = entrarRegistro.nextInt();
		switch (id_local) {
		case 1:
			System.out.println("Rio de Janeiro Selecionado");
			viajante1.setId_local(id_local);
			break;
		case 2:
			System.out.println("São Paulo Selecionado");
			viajante1.setId_local(id_local);
			break;
		case 3:
			System.out.println("Salvador Selecionado");
			viajante1.setId_local(id_local);
			break;
		case 4:
			System.out.println("Recife Selecionado");
			viajante1.setId_local(id_local);
			break;
			
		}
		
		System.out.println("Informe a Data de Ida: (ex: 22/12/2023)");
		Date dataIda = df.parse(entrarRegistro.next());
		viajante1.setData_viagem_ida(dataIda);
		System.out.println("Informe a Data de Volta: (ex: 01/02/2024)");
		Date dataVolta = df.parse(entrarRegistro.next());
		viajante1.setData_viagem_volta(dataVolta);
		viajante1.setId_viajante(id_viajante);
		viajanteMolde.salvar(viajante1);
		System.out.println("Quer cadastrar outro? 1 - Para sim e 2 - Para voltar ao menu");
		int menu = entrarRegistro.nextInt();
		switch (menu) {
		case 1:
			++id_viajante;
			registro();
			break;
		case 2:
			menu();
			break;
		}
		
		
	}
	static void listar() throws Exception {
		ViajantesMolde viajanteMolde = new ViajantesMolde();
		
		
		for (Viajante v : viajanteMolde.getViajante()) {
			System.out.println("________________________________________");
			System.out.println("Id do Viajante: " + v.getId_viajante());
			System.out.println("Nome do Viajante: " + v.getNome());
			System.out.println("Destino: " + v.getNome_local());
			System.out.println("Data Ida da Viagem: " + v.getData_viagem_ida());
			System.out.println("Data da Volta da Viagem: " + v.getData_viagem_volta());
			System.out.println("________________________________________");
			
		}
		menu();
	}
	static void update() throws Exception {
		Viajante viajanteUpdate = new Viajante();
		ViajantesMolde atualizacao = new ViajantesMolde();
		System.out.println("Informe o seu Nome: ");
		viajanteUpdate.setNome(entrarUpdate.nextLine());
		System.out.println("Informe a Data de Ida: (ex: 22/12/2023)");
		Date dataNova_ida = df.parse(entrarUpdate.next());
		viajanteUpdate.setData_viagem_ida(dataNova_ida);
		System.out.println("Informe a Data de Volta: (ex: 22/12/2023)");
		Date dataNova_volta = df.parse(entrarUpdate.next());
		viajanteUpdate.setData_viagem_volta(dataNova_volta);
		System.out.println("Informe Local de Destino - (1) Rio de Janeiro | R$ 500 - (2) São Paulo | R$ 532 - (3) Salvador | R$ 1232 - (4) Recife | R$ 5343 : ");
		int id_local = entrarUpdate.nextInt();
		switch (id_local) {
		case 1:
			System.out.println("Rio de Janeiro Selecionado");
			viajanteUpdate.setId_local(id_local);
			break;
		case 2:
			System.out.println("São Paulo Selecionado");
			viajanteUpdate.setId_local(id_local);
			break;
		case 3:
			System.out.println("Salvador Selecionado");
			viajanteUpdate.setId_local(id_local);
			break;
		case 4:
			System.out.println("Recife Selecionado");
			viajanteUpdate.setId_local(id_local);
			break;
		}
		System.out.println("Informe o seu ID: ");
		int id_novo = entrarUpdate.nextInt();
		viajanteUpdate.setId_viajante(id_novo);
		atualizacao.update(viajanteUpdate);
		System.out.println("Atualizado com Sucesso");
		menu();
	}
	static void delete() throws Exception {
		ViajantesMolde delete = new ViajantesMolde();
		System.out.println("Qual usuario você quer deleta? Selecione o Id do Viajante");
		int id_viajante_id = entrarDelete.nextInt();
		delete.delete(id_viajante_id);
		System.out.println("Usuario "+ id_viajante_id + " deletado com sucesso");
		menu();
	}
	static void menu() throws Exception {
		System.out.println("============= Bem vindo(a) a Agencia de Viagens =============");
		System.out.println("Selecione uma das opções:");
		System.out.println("1) Para fazer um Registro");
		System.out.println("2) Atualizar Cadastro");
		System.out.println("3) Para visualisar nossos Cadastros");
		System.out.println("4) Para Deletar um Cadastro");
		int menu = entrarMenu.nextInt();
		switch (menu) {
		case 1:
			System.out.println("Registro Selecionado");
			registro();
			break;
		case 2:
			System.out.println("Atualizar Cadastro Selecionado");
			update();
			break;
		case 3:
			System.out.println("Visualizar cadastros Selecionado");
			listar();
			break;
		case 4:
			System.out.println("Deletar Cadastro Selecionado");
			delete();
			break;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		menu();

	}
	


}
