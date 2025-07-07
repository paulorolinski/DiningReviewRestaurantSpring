# Etapa de build
FROM node:18 AS build
WORKDIR /app
COPY . .
RUN npm install && npm run build

# Etapa de produção com nginx
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html

# Remover a configuração padrão do Nginx e adicionar a nossa (opcional)
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
