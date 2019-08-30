# nhtDetection
##Non Human Traffic Detection.
This is a Spring Boot project, aiming to create a service which can detect the traffic of web access from an ip as a NHT(Non Human Traffic).
##How to use.
* git clone this project
* using a Java develop IDE to import this project
* in IDE, run nhtDetection-web\src\main\java\cn\org\spark\web\NhtDectionWebApplication.java 
* open a browser, goto http://yourIPorHostName:YourPort/NhtCheck/checkIpV4Str?ipV4Str=112.80.35.2 (i.e: http://localhost:8080/NhtCheck/checkIpV4Str?ipV4Str=192.168.0.2)
* if response like:
>{
    "ipv4Str": "192.168.0.2",
    "isNHT": false,
    "nhtScore": 60
}
* Enjoy :)
## Core Data Source
This project will using a api product by RTBasia.com, for more information, please check: https://ip.rtbasia.com/
 
