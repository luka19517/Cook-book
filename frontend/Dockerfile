FROM node:lts-alpine
LABEL maintainer="luka.djorovic3010@gmail.com"
RUN npm install -g http-server
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
EXPOSE 3000
ENTRYPOINT ["npm", "run", "serve"]