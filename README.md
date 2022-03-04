# WRA

## General info
This project is a simple console application that allows you to call Wolfram Alpha API<br />
You're free to modify it however you'd like, as long as you respect Wolfram Alpha policies

## Setup
To run this project, you'll need to get a (free) Wolfram Alpha API key on their website<br />
https://products.wolframalpha.com/api/<br />
Then :

```
git clone https://github.com/Selenba/wra.git
```
Edit "APICaller.java and replace "DEMO" with your own API key, then :

```
cd wra
sudo apt install maven
mvn clean install
mv wra/target/wra-1.0-SNAPSHOT-shaded.jar
echo '#!/usr/bin/java -jar' > wra
cat wra-1.0-SNAPSHOT-shaded.jar >> wra
chmod +x wra
```
You can now place "wra" wherever you want. <br />
Add the path to wra to your $PATH, then verify your installation by running : <br />
```
wra what is the meaning of life
```
