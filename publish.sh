echo "Publishing Mapper"
chmod +x gradlew || exit
./gradlew :publish || exit
echo "Finished Publishing Mapper"