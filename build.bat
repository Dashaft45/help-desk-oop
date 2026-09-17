@echo off
chcp 65001 >nul
javac -encoding UTF-8 src/helpdesk/*java
java -Dfile.encoding=UTF-8 -cp src helpdesk.Main