Algoritmo "Viajantes"
//Aluno: Thauan Silva
//RECODEPRO 2022


Var
   nome_um: caractere
   idades_um: inteiro
   consulta,i,j:inteiro //consulta utilizado para verificação de dados no menu "2"
   nome:caractere
   idade:inteiro

   //Definindo os vetores de destino/origem
   aux,o,d:inteiro
   destino: vetor [1..4] de caractere
   origem: vetor [1..4] de caractere

   //Vetores de usuario

   nome_dois: vetor [1..2] de caractere
   idades_dois: vetor [1..2] de inteiro
   nome_tres: vetor [1..3] de caractere
   idades_tres: vetor [1..3] de inteiro

   //Procedimento para Cadastro de UM Viajante

Inicio
   //Agilizar pequenos argumentos pra limpar o codigo
procedimento erro
inicio
   escreval("*****************ERRO*****************")
   escreval("*****************ERRO*****************")
   escreval("*****************ERRO*****************")
fimprocedimento

procedimento espaco
inicio
   escreval(" ")
fimprocedimento

procedimento erro_arg
inicio
   escreval("Escolha uma Opção Valida!")
   escreval("Re-insira os dados")
fimprocedimento

procedimento dados_check
inicio
   escreval(" ")
   escreval("---> Os dados estão Corretos? <---")
   escreval(" ")
   escreval("Digite (1) para (SIM)")
   escreval("Digite (2) para (NÃO) e altere os dados")
fimprocedimento
//
//Procedimentos para cada numero de viajante solicitado
procedimento de_um
var dados:inteiro
inicio
   //usando variaveis para percorrer dados
   escreval("Digite seu nome: ",nome)
   leia(nome_um)
   escreval("Digite sua idade: ",idade)
   leia(idades_um)
   destino_origem()
   escreval("Aqui está seus dados:")
   escreval("-----------------------------------------------")
   escreval("Seu nome: ",nome_um, "; Sua idade: ",idades_um, "; Origem: ", origem[o], "; Destino: ", destino[d])
   escreval("-----------------------------------------------")
   dados_check()
   leia (dados)
   escolha dados
   caso 1
      consulta<-1
      g()
   caso 2
      de_um()
   outrocaso
      erro()
      espaco()
      erro_arg()
      de_um()
   fimescolha
fimprocedimento


//Procedimento para Cadastro de Dois Viajantes
procedimento de_dois
var dados:inteiro
inicio
   //usando loop para percorrer dados nos vetores
   para i de 1 ate 2 faca
      escreval("Digite o nome do viajante", i,": ",nome)
      leia(nome_dois[i])
      escreval("Digite a idade: ",idade)
      leia(idades_dois[i])
   fimpara
   destino_origem()
   escreval("Aqui está seus dados:")
   //utilizando loop para verificar os vetores no cadastro
   para j de 1 ate 2 faca
      escreval("-----------------------------------------------")
      escreval("Nome: ",nome_dois[j],"; Idade: ",idades_dois[j], "; Origem: ", origem[o], "; Destino: ", destino[d])
      escreval("-----------------------------------------------")
   fimpara
   dados_check()
   leia (dados)
   escolha dados
   caso 1
      consulta<-2
      g()
   caso 2
      de_dois()
   outrocaso
      erro()
      espaco()
      erro_arg()
      de_dois()
   fimescolha
fimprocedimento

//Procedimento para Cadastro de Tres Viajantes

procedimento de_tres
var dados:inteiro
inicio
   para i de 1 ate 3 faca
      escreval("Digite o nome do viajante", i,": ",nome)
      leia(nome_tres[i])
      escreval("Digite a idade: ",idade)
      leia(idades_tres[i])
   fimpara
   escreval("Aqui está seus dados:")
   destino_origem()
   para j de 1 ate 3 faca
      escreval("-----------------------------------------------")
      escreval("Nome: ",nome_tres[j],"; Idade: ",idades_tres[j], "; Origem: ", origem[o], "; Destino: ", destino[d])
      escreval("-----------------------------------------------")
   fimpara
   dados_check()
   leia (dados)
   escolha dados
   caso 1
      consulta<-3
      g()
   caso 2
      de_tres()
   outrocaso
      erro()
      espaco()
      erro_arg()
      de_tres()
   fimescolha
fimprocedimento

//Procedimento para Chamada de Menu Principal

procedimento g
var opcao,outra,dados:inteiro

inicio
   escreval("*|*|*| Bem Vindo a Agencia de Viagens |*|*|*")
   escreval(" ")
   escreval("---> Selecione uma das Opções Abaixo <---")
   escreval(" ")
   escreval("|----------------------------------------------------|")
   escreval("| Digite (1) para se Cadastrar                       |")
   escreval("| Digite (2) para consultar um cliente já cadastrado |")
   escreval("|----------------------------------------------------|")
   leia(opcao)
   escolha opcao
   caso 1
      escreval("Quantas Pessoas irão viajar? (1, 2 ou 3)")
      leia(outra)
      escolha outra
      caso 1
         de_um()
      caso 2
         de_dois()
      caso 3
         de_tres()
      fimescolha
      //verificação de dados cadastrados(!!!!!)
   caso 2
      escreval("Os dados do(a) Cliente:")
      escolha consulta
      caso 1
         escreval("Nome: ",nome_um,"; Idade: ",idades_um, "; Origem: ", origem[o], "; Destino: ", destino[d]," | ")
         escreval
      caso 2
         para i de 1 ate 2 faca
            escreval("Nome: ",nome_dois[i],"; Idade: ",idades_dois[i], "; Origem: ", origem[o], "; Destino: ", destino[d]," | ")
         fimpara
      caso 3
         para i de 1 ate 3 faca
            escreval("Nome: ",nome_tres[i],"; Idade: ",idades_tres[i], "; Origem: ", origem[o], "; Destino: ", destino[d]," | ")
         fimpara
      outrocaso
         erro()
         espaco()
         escreval("Nenhum usuario cadastrado no momento")
         espaco()
         espaco()
         g()

      fimescolha
   fimescolha

fimprocedimento

//Procedimento de Origem e destino de viagem

procedimento destino_origem
inicio
   escreval("Qual a origem da sua viagem?")
   escreval("(1) - Salvador")
   escreval("(2) - São Paulo")
   escreval("(3) - Rio de Janeiro")
   escreval("(4) - Recife")
   leia (o)
   escolha o
   caso 1
      origem[1]<-"Salvador"
   caso 2
      origem[2]<-"São Paulo"
   caso 3
      origem[3]<-"Rio de Janeiro"
   caso 4
      origem[4]<-"Recife"
   outrocaso
      erro()
      espaco()
      escreval("Selecione uma ORIGEM Valida")
      destino_origem()
   fimescolha
   escreval("Qual o destino da sua viagem?")
   escreval("(1) - Salvador")
   escreval("(2) - São Paulo")
   escreval("(3) - Rio de Janeiro")
   escreval("(4) - Recife")
   leia (d)
   escolha d
   caso 1
      destino[1]<-"Salvador"
   caso 2
      destino[2]<-"São Paulo"
   caso 3
      destino[3]<-"Rio de Janeiro"
   caso 4
      destino[4]<-"Recife"
   outrocaso
      erro()
      espaco()
      escreval("Selecione uma Destino Valido")
      destino_origem()
   fimescolha
   se d = o entao
      erro()
      espaco()
      escreval("Selecione DESTINO e ORIGEM diferentes")
      destino_origem()
   fimse
fimprocedimento


//Chamando Menu para Iniciar o Programa
g()
FIMALGORITMO