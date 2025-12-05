FROM eclipse-temurin:22-jdk

# Set environment variables
ENV CATALINA_HOME=/usr/local/tomcat
ENV PATH="$CATALINA_HOME/bin:$PATH"

# Download & install Tomcat 10.1.x
RUN mkdir -p $CATALINA_HOME
RUN apt-get update && apt-get install -y wget unzip && \
    wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.49/bin/apache-tomcat-10.1.49.tar.gz -O /tmp/tomcat.tar.gz && \
    tar -xzf /tmp/tomcat.tar.gz -C /usr/local/tomcat --strip-components=1 && \
    rm /tmp/tomcat.tar.gz

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR
COPY EAuthenticator.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
