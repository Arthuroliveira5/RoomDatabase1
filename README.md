🗂️ Room Database Android App
Este é um aplicativo Android que demonstra o uso do Room Database, uma poderosa biblioteca de persistência local fornecida pelo Android Jetpack. O projeto segue os princípios da arquitetura MVVM, com foco em organização, reatividade e boas práticas de desenvolvimento Android moderno.

🚀 Tecnologias Utilizadas
Kotlin – Linguagem principal usada no projeto.

Android Jetpack Components:

Room – Para persistência de dados local com SQLite.

ViewModel – Para gerenciar dados da interface de forma resiliente.

LiveData – Para observar mudanças nos dados e atualizar a UI automaticamente.

Lifecycle Components – Para integrar o ciclo de vida da UI com os dados.

Coroutines – Para executar tarefas assíncronas sem bloquear a thread principal.

ViewBinding – Para vinculação segura e direta com elementos de layout.

Material Design – Interface moderna com componentes visuais intuitivos.

🏗 Arquitetura MVVM
O projeto adota o padrão MVVM (Model–View–ViewModel), promovendo uma separação clara de responsabilidades:

🔸 Camadas do Projeto
Data Layer

Room Database

DAO (Data Access Object)

Entities (Modelos de dados)

Domain Layer

ViewModel

Repository (Padrão de repositório para acesso e abstração de dados)

Presentation Layer

Activities / Fragments

Componentes de interface com o usuário (UI)

🔹 Principais Componentes
📦 Database – Implementação do Room para persistência local.

📄 DAO – Interfaces que definem as operações de acesso ao banco de dados.

🧩 Entities – Classes que representam as tabelas do banco.

🧠 ViewModel – Camada intermediária entre UI e dados.

🔌 Repository – Responsável por fornecer dados ao ViewModel, de forma isolada da origem (local ou remota).

⚙️ Configuração do Projeto
Configuração	Valor
SDK Mínimo	25
SDK Alvo	34
Gradle	8.3.0
Kotlin	1.9.22

📦 Dependências Principais
gradle
Copiar
Editar
// Room
implementation "androidx.room:room-ktx:2.6.1"
kapt "androidx.room:room-compiler:2.6.1"

// Lifecycle
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.7.0"

// Coroutines
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
✅ Funcionalidades
Persistência local eficiente com Room Database.

Operações CRUD completas: Criar, Ler, Atualizar e Deletar registros.

Interface de usuário elegante utilizando Material Design.

Arquitetura desacoplada e fácil de testar com MVVM e Repository Pattern.

Gerenciamento reativo e eficiente de estado com LiveData e ViewModel.
