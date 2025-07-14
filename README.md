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

## 📬 Contato
Desenvolvido por [Paulo Rolinski](https://www.linkedin.com/in/paulo-rolinski/)