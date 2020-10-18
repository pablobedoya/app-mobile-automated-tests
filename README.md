# app-mobile-automated-tests

Este projeto contém testes automatizados para  [aplicativo móvel](https://github.com/pablobedoya/app-mobile-automated-tests/blob/main/src/main/resources/app/cadastro_clientes_teste.apk), cujo objetivo é realizar operações de CRUD em cima da entidade Cliente.
 
  ### Tecnologias utilizadas:
  * Java
  * Maven
  * Appium
  * Junit
  * Cucumber
  * Cluecumber Report
  * Java Faker

  ### Destaques:
  * Uso de Page Objects para criar um repositório de objetos para elementos de UI do aplicativo.
  * Uso de Test Data Factory para criação de dados aleatórios utilizados para os testes.
  * Cenários concebidos seguindo os princípios [BRIEF](https://cucumber.io/blog/bdd/keep-your-scenarios-brief/) como um boa prática.
 
## Execução

### Pré-requisitos
* Clonar o repositório do projeto: `$ git clone https://github.com/pablobedoya/app-mobile-automated-tests.git`
* Rodar o comando Maven para resolver as dependências: `$ mvn clean install -DskipTests`
* Instalar o [JDK 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
* Instalar o [Android Studio](https://developer.android.com/studio) (a instalação do Android Studio traz consigo o Android SDK e possibilita a execução de um emulador de Android)
* Configurar a variável de ambiente JAVA_HOME, apontando para o diretório em que o JDK 8 foi instalado
* Adicionar referência a JAVA_HOME/bin na variável de ambiente PATH
* Configurar a variável de ambiente ANDROID_HOME, apontando para o diretório em que Android SDK foi instalado (é possível visualizar o local em que se encontra a instalação do Android SDK por meio das configurações do Android Studio)
* Adicionar referências de ANDROID_HOME/tools e ANDROID_HOME/platform-tools na variável de ambiente PATH
* Instalar o [Appium Desktop](https://github.com/appium/appium-desktop/releases/)
* Abrir o Android Studio, acessar o *AVD Manager* para criar e executar um emulador
* Após executar o emulador, rodar o comando `$ adb devices` para obter o nome do device do emulador
* Abrir o Appium Desktop e iniciar uma sessão configurando o Desired Capabilities com o nome do device do emulador obtido: `{ 'platformName': 'Android', 'deviceName': '<NomeDeviceEmulador>' }`

### Rodar os testes
* Rodar o comando Maven: `$ mvn test`
