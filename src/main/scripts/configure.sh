#!/bin/bash 

function replaceLine() {
    FILENAME=$1
    STARTSWITH=$2
    NEWVALUE=$3
    sed -i "s/$STARTSWITH=.*/$STARTSWITH=$NEWVALUE/g" $FILENAME
}

LOG="/root/launch/configure.log" 

echo "*** Configuration Started ***" > $LOG 

TYPE=$1 
echo Type: $TYPE >> $LOG
PROP_HOME=/usr/share/tomcat6/webapps/CABRules/WEB-INF/classes
echo "Properties Dir:" $PROP_HOME >> $LOG

service tomcat6 stop

cd $PROP_HOME
if [ "$TYPE" == "db" ]; then
    echo "Configure for database" >> $LOG
        LIVE_CAB_URL=${2//\//\\\/}
        PENDING_CAB_URL=${3//\//\\\/}
        echo Live CAB URL: $LIVE_CAB_URL >> $LOG
        echo Pending CAB URL: $PENDING_CAB_URL >> $LOG
        LIVE_CAB_URL_LABEL=cab\.live\.url
        PENDING_CAB_URL_LABEL=cab\.pending\.url
    cp ./RulesSource.properties.database ./RulesSource.properties
    replaceLine ./RulesSource.properties $LIVE_CAB_URL_LABEL $LIVE_CAB_URL
    replaceLine ./RulesSource.properties $PENDING_CAB_URL_LABEL $PENDING_CAB_URL
fi

service tomcat6 start

echo "*** Configuration Complete ***" >> $LOG
exit 0;
