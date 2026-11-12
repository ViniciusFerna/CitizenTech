# Territory Predictive Insights (CitizenTech)

Plataforma de monitoramento territorial em Java (console) que lê sensores, gera previsões simples e emite alertas explicados. Projeto da Global Solution 2º/2026 de Programação Orientada a Objetos.

## Recorte escolhido: Clima local

Chuva intensa e risco de alagamento em pontos vulneráveis do território. O sistema monitora três variáveis:

| Sensor | Variável | Faixa |
|---|---|---|
| `SensorChuva` | Intensidade da chuva | 0 a 100 |
| `SensorNivelDoRio` | Nível do rio | 0 ou mais |
| `SensorUmidade` | Umidade | 0 a 100 |

As leituras são **simuladas** com `Math.random()`.

## Público beneficiado e decisão apoiada

**Quem sofre o problema:** moradores de áreas sujeitas a alagamento e as organizações comunitárias, associações de bairro ou equipes de Defesa Civil que cuidam delas.

**Decisão que o sistema apoia:** se vale a pena agir hoje, por exemplo avisar moradores, preparar abrigos ou monitorar mais de perto um ponto de risco. O sistema indica o nível de atenção e explica o motivo, mas quem decide é a pessoa responsável.

## Como executar

### Pré-requisitos

- JDK instalado e configurado.
- Uma IDE Java, como o **Eclipse**.

### Passo a passo no Eclipse

1. Clone o repositório:

   ```bash
   git clone https://github.com/ViniciusFerna/CitizenTech.git
   ```

2. Abra o Eclipse e selecione **File → Import → General → Existing Projects into Workspace**.
3. Selecione a pasta `CitizenTech` clonada e conclua a importação.
4. Verifique se o projeto está associado a um JDK compatível com sua configuração.
5. Localize a classe `Main.java` e execute-a usando **Run As → Java Application**.

## Como usar o menu

Siga esta ordem na primeira execução:

1. **Criar território** (opção 1): informe um código, a população e um código de acesso (guarde-o, ele será pedido para alterar os limiares).
2. **Definir limiares** (opções 2 e 3): exemplo de valores coerentes (chuva, rio, umidade):
   - Atenção: `50`, `50`, `40`
   - Crítico: `80`, `80`, `20`
3. **Criar estação** (opção 4) e **ativá-la** (opção 5).
4. **Configurar sensores** (opção 6) e **ativá-los** (opção 7).
5. **Gerar leituras aleatórias** (opção 8) e **armazená-las** (opção 9). Repita as duas várias vezes para formar histórico.
6. Use as opções 10 a 14 para ver as leituras, verificar alertas, rodar previsões e exibir o status completo.

## Como funcionam as previsões

- **Média móvel:** média das últimas *N* leituras. Exige `N <= quantidade de leituras`.
- **Comparação:** divide as leituras mais recentes em dois blocos de *N* leituras, o anterior e o atual. A previsão é `mediaAtual + (mediaAtual - mediaAnterior)`, nunca abaixo de zero. Exige pelo menos `2 × N` leituras.

## Como funcionam os alertas

A opção 11 calcula a previsão (média móvel das últimas 3 leituras ou menos) de cada sensor e compara com os limiares do território. Cada alerta explica **qual sensor**, o **valor previsto** e o **limite estourado**. Exemplo:

```
CRITICO - Chuva: valor previsto 85,30 esta acima do limiar critico (80,00)
```

A umidade é tratada como variável **inversa**: o risco aumenta quando o valor fica *abaixo* do limiar.

## Decisões da equipe

- Escolhemos o recorte de **clima local** por ser fácil de simular e de explicar ao público.
- Mantivemos duas previsões simples (média móvel e comparação), como o enunciado sugere, para focar na modelagem em POO.

## Reflexão crítica

**O que os dados não representam?** Uma estação com três sensores descreve um ponto, não o território inteiro. A chuva pode ser forte em um bairro e fraca em outro, e o nível do rio num ponto não mostra a situação onde o alagamento realmente acontece. Além disso, nossas leituras são simuladas, então os resultados demonstram a lógica do sistema, não o clima real. As previsões (média e tendência) também ignoram fatores como o tipo de solo, a drenagem e a previsão meteorológica.

**Por que o alerta apoia a decisão, em vez de decidir?** Quem conhece o território, como moradores e equipes locais, sabe coisas que os sensores não mostram, como um bueiro entupido ou uma obra recente. Por isso o sistema informa o nível de atenção e o motivo, e a pessoa decide se vale agir, com sua experiência e responsabilidade. Explicar o porquê de cada alerta permite que ela confie no sistema ou o questione quando algo parecer estranho.

## Limitações conhecidas

- Não há histórico salvo em arquivo, então toda vez que o sistema for fechado, nenhum dado ficará salvo.

Como continuaríamos: criar sistema de armazenamento das leituras, para que o sistema tenha um histórico robusto.

## Divisão de tarefas

| Integrante | Responsabilidade |
|---|---|
| Vinícius Fernandes Silva Souza | Menu da main, previsões, dados territoriais |
| Matheus Guedes Grigorio | Sensores, Componente territorial|

## Integrantes

- Vinícius Fernandes Silva Souza - RM: 567977
- Matheus Guedes Grigorio - RM: 568086
