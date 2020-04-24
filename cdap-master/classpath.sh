#!/bin/bash
hbase_cp=$(hbase classpath)


fix_slf4j_classpath() {
  local __hbase_cp=$1
  # remove log4j*.jar and phoenix*.jar from hbase cp as they are not really used by cdap (as of 5.1.2)
  # and have conflicting slf4j binders

  local__fixed_hbase_cp=''
  for _f in $(echo ${__hbase_cp}|sed 's/:/ /g')
  do
    for _ff in $(echo ${_f})
    do
      #echo ${_ff}
      __matched=$(echo ${_ff}|egrep -q "jul-to-slf4j|slf4j-log4j12|phoenix"  && echo "OK" || echo "KO")
      [ "${__matched}"  =  "KO" ] && __fixed_hbase_cp=${__fixed_hbase_cp}:${_ff}
    done
  done

  echo ${__fixed_hbase_cp}
}

fix_slf4j_classpath ${hbase_cp}|sed 's/:/\n/g'

#echo $(fix_slf4j_classpath $hbase_cp)|sed 's/:/\n/g'|grep /usr/hdp/3.1.4.0-315/hadoop/lib
