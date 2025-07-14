# 🍽️ Dining Review Restaurant

Aplicação completa para avaliação de restaurantes por usuários. Este repositório é um **monorepo** contendo:

- 🎯 Backend em [Spring Boot](https://spring.io/projects/spring-boot)
- 💻 Frontend em [React](https://react.dev/) com [Vite](https://vitejs.dev/)
- ⚙️ Provisionamento com [Vagrant](https://www.vagrantup.com/) e [Ansible](https://docs.ansible.com/)
- ☸️ Orquestração de cluster Kubernetes com [Kind](https://kind.sigs.k8s.io/)
- 🚀 Deploy GitOps com [Argo CD](https://argo-cd.readthedocs.io/)
- 📦 Manifests separados em [DiningReviewRestaurantK8sConfig](https://github.com/paulorolinski/DiningReviewRestaurantK8sConfig)

---

## 📁 Estrutura do Projeto

```bash
DiningReviewRestaurantSpring/
├── DiningReviewRestaurantReact/     # Frontend em React
├── DiningReviewRestaurantSpring/    # Backend em Spring Boot
├── provisioning/                    # Infraestrutura e automação DevOps
│   ├── ansible/                     # Playbooks Ansible
│   ├── kind-cluster.yaml           # Cluster Kubernetes via Kind
│   └── Vagrantfile                 # Máquina de desenvolvimento
└── docker-compose.yaml             # Execução local via containers
```

### Manifests Kubernetes ficam no repositório [DiningReviewRestaurantK8sConfig](https://github.com/seu-usuario/DiningReviewRestaurantK8sConfig) (separado):
```bash
DiningReviewRestaurantK8sConfig/
├── backend/
├── base/
├── database/
├── frontend/
└── kustomization.yaml              # Agrupamento via Kustomize
```

## 🛠️ Provisionamento DevOps
## 🔧 Vagrant + Ansible
### Cria uma máquina virtual e provisiona dependências para o ambiente de desenvolvimento:

```bash
cd provisioning
vagrant up
```

>O Vagrant usa uma box com Ubuntu e executa o playbook.yml via Ansible para instalar Docker, PostgreSQL, Java e outras dependências.

## ☸️ Orquestração com Kubernetes + Kind
### Cria um cluster local Kubernetes usando Kind e os manifests versionados no outro repositório:

```bash
kind create cluster --name dev --config provisioning/kind-cluster.yaml
```

>É necessário ter o Docker instalado.

## 🐳 Rodar Localmente com Docker
### Clonar os repositórios

```bash
git clone https://github.com/seu-usuario/DiningReviewRestaurantSpring.git
git clone https://github.com/seu-usuario/DiningReviewRestaurantK8sConfig.git
cd DiningReviewRestaurantSpring
```

### Executar com Docker Compose
```bash
docker-compose up
```

>Isso sobe o backend, frontend e banco PostgreSQL integrados.

## 🚀 Deploy com Argo CD
### 1. Instalar Argo CD no cluster Kind

```bash
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
kubectl port-forward svc/argocd-server -n argocd 8080:443
```


Acesse o painel: https://localhost:8080

### 2. Adicionar repositório de manifests
Via Argo CD Web:

- Vá em Settings → Repositories

- Adicione https://github.com/seu-usuario/DiningReviewRestaurantK8sConfig.git

- Use token pessoal se for privado

### 3. Criar aplicação
```yaml
apiVersion: argoproj.io/v1alpha1
kind: Application
metadata:
  name: dining-review
  namespace: argocd
spec:
  project: default
  source:
    repoURL: https://github.com/paulorolinski/DiningReviewRestaurantK8sConfig.git
    targetRevision: HEAD
    path: .
  destination:
    server: https://kubernetes.default.svc
    namespace: default
  syncPolicy:
    automated:
      prune: true
      selfHeal: true
```

Aplicar via ```kubectl```:
```bash
kubectl apply -f app.yaml
```

📌 Tecnologias Utilizadas
- Spring Boot 3 + Maven
- React 18 + Vite
- PostgreSQL + Flyway 
- Docker + Docker Compose
- Kubernetes + Kind
- JWT + Spring Security
- Zustand + React Query
- Ansible + Vagrant
- Argo CD

## Motivos das escolhas tecnológicas:

A arquitetura e as ferramentas foram definidas com foco em escalabilidade, modularidade e boas práticas DevOps. Cada tecnologia escolhida atende a requisitos específicos de desenvolvimento, provisionamento e operação contínua:
Frontend 

### React + Vite

React é uma biblioteca consolidada no mercado, com ampla comunidade e recursos voltados para aplicações interativas.

Vite foi adotado por sua performance superior em ambientes de desenvolvimento e por seu suporte nativo a ESModules, simplificando configurações e acelerando o ciclo de desenvolvimento.

### Backend – Spring Boot

Spring Boot 3 fornece estrutura sólida para APIs REST, com integração nativa a autenticação, segurança e persistência.

Suporte a JWT, ferramentas de migração como Flyway e fácil acoplamento ao PostgreSQL foram diferenciais importantes.

### Docker e Docker Compose

Permitem empacotamento completo da aplicação em ambientes isolados.

Facilitam a execução de backend, frontend e banco de dados localmente, sem dependências externas.

### Kubernetes com Kind

Kind (Kubernetes in Docker) permite simular um cluster real em ambiente local.

Útil para testar recursos de orquestração, deploy e políticas de rede em um ambiente controlado e leve.

### Argo CD

Facilita implementações usando a abordagem GitOps, garantindo rastreabilidade, reversão de mudanças e sincronização entre repositório e cluster.

Oferece painel de monitoramento visual, suporte a múltiplas fontes e controle de versões de recursos Kubernetes.

## Provisionamento com Vagrant + Ansible

Vagrant gerencia máquinas de desenvolvimento de forma previsível, com isolamento e reprodutibilidade.

Ansible automatiza instalações e configurações de ambiente usando uma abordagem declarativa e idempotente.

## Separação entre código-fonte e infraestrutura

O repositório principal contém o código-fonte e os artefatos DevOps.

Um repositório separado foi dedicado aos manifests Kubernetes, simplificando o ciclo de deploy com Argo CD e promovendo organização entre infraestrutura e lógica de negócios.

## Dificuldades Enfrentadas

Durante a implementação, diversas adversidades foram enfrentadas e solucionadas com ajustes pontuais e estratégicos:
Autenticação no Argo CD

O Argo CD apresentou erro de acesso ao repositório Git por estar configurado como privado.

A solução foi utilizar um Personal Access Token (PAT) do GitHub para autenticação via interface do Argo CD.

### Pods em estado Pending

Os pods do Argo CD não eram iniciados corretamente, impedindo o uso do kubectl port-forward.

A análise com kubectl describe pod identificou limitações de recursos e atrasos no pull de imagens, resolvidos com alocação adequada no cluster Kind.

### Volume corrompido no PostgreSQL

Durante a execução via Docker Compose, o banco apresentou erro de inicialização devido a arquivos corrompidos no volume persistente.

A solução foi remover o volume com docker compose down -v e reiniciar os containers.

### Conflito na porta 80

A porta padrão 80 já estava em uso, impedindo a publicação do frontend.

Foi feita alteração para 8083, liberando acesso sem conflitos.

### Erro ao usar HTTPS no frontend

O frontend estava configurado para servir HTTP, mas o navegador tentou acessar via HTTPS, resultando em erro de handshake.

A URL foi ajustada para uso com HTTP, resolvendo o problema.

### Falhas com vagrant ssh e provisão via Ansible

O vagrant ssh não funcionou devido ao uso do provider Docker, que não habilita acesso SSH por padrão.
## 📬 Contato
Desenvolvido por [Paulo Rolinski](https://www.linkedin.com/in/paulo-rolinski/)