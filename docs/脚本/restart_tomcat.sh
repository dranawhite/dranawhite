#!/bin/sh

## java env
export JAVA_HOME=/usr/local/jdk
#export JRE_HOME=$JAVA_HOME/jre
## service name
APP_NAME=tomcat
SERVICE_DIR=$HOME/$APP_NAME
RETVAL=0

#cd $SERVICE_DIR/bin
case "$1" in
    start)
        $SERVICE_DIR/bin/startup.sh
         echo "start $APP_NAME 。。。 "
        ;;
    stop)
        $SERVICE_DIR/bin/shutdown.sh
        echo " stop $APP_NAME 。。。 "
        sleep 3
       ##grep -w表示全部匹配，grep -v表示取反，就是去掉grep，awk表示分割，
       ##默认是空  格分割，print $2表示输出第2个  数值
        P_ID=`ps -ef | grep -w "$SERVICE_DIR" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "===> $SERVICE_DIR process not exists or stop success"
        else
            echo "===> $SERVICE_DIR process pid is:$P_ID"
            echo " begin kill $SERVICE_DIR process, pid is:$P_ID 。。。 "
            kill -9 $P_ID
        fi
        ;;
    restart)
        ## $0表示Shell本身的文件名，也就是当前脚本的文件名
        $0 stop
        sleep 2
        $0 start
        echo " restart $SERVICE_DIR 。。。 "
        ;;
    *)
        echo $"Usage: $0 {start|stop|restart}"
        RETVAL=1
        ## restart
        #$0 stop
        #sleep 2
        #$0 start
       # ;;注意(;)和#的含义差不多，都是注释的意思
esac
exit $RETVAL
#exit 0 注意0表示正常退出
