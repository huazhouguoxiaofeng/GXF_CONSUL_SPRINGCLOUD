### 启动/关闭脚本

-jar -Drmbasic.conf.path=/home/richmail/web/monitor/config/：指定配置文件启动

 /home/richmail/logs/webapp/RichMonitorCore/RichMonitorCore.log  2>&1：把nohup.out 追加的指定目录

```shell
#!/bin/bash
echo starting richMonitor......
nohup java -jar -Drmbasic.conf.path=/home/richmail/web/monitor/config/ /home/richmail/web/monitor/rich.monitor-0.0.1-SNAPSHOT.jar >>  /home/richmail/logs/webapp/RichMonitorCore/RichMonitorCore.log  2>&1  &
echo richMonitor started!!!

#!/bin/bash
PID=$(ps -ef | grep rich.monitor-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{ print $2 }')
if [ ${PID} ]; 
then
    echo 'Application is stpping...'
    echo kill $PID DONE
    kill $PID
else
    echo 'Application is already stopped...'
fi
```

