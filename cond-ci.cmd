docker stack rm kodominio
docker build -t rbasstos/kodominio-api .
docker push rbasstos/kodominio-api
docker pull rbasstos/kodominio-api
docker stack deploy --compose-file stack.yml kodominio
docker stack ps kodominio

