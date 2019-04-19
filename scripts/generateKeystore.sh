#!/usr/bin/env bash
cd ../
keytool -genkeypair -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048  -keystore keystore.p12 -validity 9999 -dname "EMAILADDRESS=rent@di.uoa.gr, CN=Rent, O=UOA, OU=TL, L=Athens, S=Greece, C=GR" -ext san=dns:localhost
