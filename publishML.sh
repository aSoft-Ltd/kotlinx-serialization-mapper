echo "Publishing Mapper"
chmod +x gradlew || exit
./gradlew :publishToMavenLocal || exit
echo "Finished Publishing Mapper"