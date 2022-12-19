# Cook-book
Spring boot + VueJS project - demo

    npm install
	npm run serve

## Docker commands:

### Frontend

Create image:

	docker image build -t cookbook:latest .

Run container:

	docker container run -d --name coookbook -p 3000:3000 cookbook:latest
