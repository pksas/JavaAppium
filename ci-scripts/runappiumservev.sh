cd /Users/eugeneulyanov
appium --address 127.0.0.1 --port 4723 &
sleep 10
cd ~/IdeaProjects/JavaAppium
export PLATFORM=ios;
mvn -Dtest=SearchTests test