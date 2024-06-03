docker stack rm kodominio
docker build -t kodominio-api .
docker push kodominio-api
docker pull kodominio-api
docker stack deploy --compose-file stack.yml kodominio
docker stack ps kodominio