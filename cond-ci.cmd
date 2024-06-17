docker stack rm kodominio
docker build -t cheloakachelo/kodominio-api .
docker push cheloakachelo/kodominio-api
docker pull cheloakachelo/kodominio-api
docker stack deploy --compose-file stack.yml kodominio
docker stack ps kodominio

