## PARA FAZER DEPLOY DESSE PROJETO

1. Acesse a pasta do projeto da api em sua maquina
```
cd \Users\{seu_usuario}\Kodominio-API
```
2. Atualize o projeto local
```
git checkout teste
git pull
```
3. Copie o arquivo stack.yml para o servidor de destino
```
scp stack.yml root@77.37.43.21:/root
```
4. Acesse ao terminal da maquina remota
```
ssh root@77.37.43.21
{Digite a senha}
```
5. Inicie o docker swarm e crie a rede web (se for a primeira vez)
```
docker swarm init
docker network create --driver overlay web
```
6. Faca o deploy do stack
```
docker stack deploy --compose-file stack.yml kodominio
```
7. Verifique se os 3 servicos estao funcionando
```
docker service ls
```


