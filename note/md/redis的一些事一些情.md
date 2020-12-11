### redis 集群启动/关闭脚本

```shell
#!/bin/bash
echo "redis is starting......"
cd /etc/redis
for port in {6380..6385}
do
redis-server ./$port.conf
done
## 首次启动才需要这句
#redis-cli --cluster create  192.168.34.63:6381 192.168.34.63:6382 192.168.34.63:6383 192.168.34.63:6384 192.168.34.63:6385  --cluster-replicas 1
echo "redis started......"

#!/bin/bash
echo "redis cluster is stopping......"
for port in {6380..6385}
do
redis-cli -a 1q2w3e  -p $port shutdown
done
echo "redis cluster stopped......"
```

